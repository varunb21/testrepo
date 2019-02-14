package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.client.ClientGeneralModel;
import com.entity.exportDWH.FullExportWithDateRange;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.mapper.ColumnAnnotationMapper;
import com.mapper.CsvAnnotationMapper;
import com.mapper.CsvUtil;
import com.relevantcodes.extentreports.LogStatus;
import com.sftp.utils.SftpUtils;
import com.utilities.CompareUtil;
import com.utilities.DbUtilsCon;
import org.apache.commons.csv.CSVParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import static com.sql.SQL.sql_getClientGeneral;
import static com.constant.Constant.CONS_UTC_DATE_TIME_FORMAT;
import static com.sftp.utils.SftpUtils.DEVSWARMEXPORTDWH;
import static com.utilities.DbUtilsCon.getListForASpecificName;

public class SEVV_5832_TC96343_Validate_Required_Fields_And_Columns_For_Maximum_Supported_Length_In_File_And_Database_Columns extends BaseTest {
    private String clientFName;
    private String clientLName;
    @BeforeClass
    public void Precondition() throws IOException, ParseException {
        String clientUrl = environment.getAlt_evv_clients_v1();
        JSONArray jsonArray = generateUniqueParam.createClient(globalVariables.client_intake_v1, "Prod011");
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        jsonObject.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(10));
        jsonObject.put("ClientLastName", "KMSAUTO" + CommonMethods.generateRandomStringOfFixLength(3));
        jsonObject.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(10));
        jsonObject.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(5));
        jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
        jsonObject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(8));
        jsonObject.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(12));
        clientFName = jsonObject.get(globalVariables.ClientFirstName).toString();
        clientLName = jsonObject.get(globalVariables.ClientLastName).toString();
        String clientMedicateID = jsonObject.get(globalVariables.ClientMedicaidID).toString();
        String clientSSN = jsonObject.get(globalVariables.ClientSSN).toString();
        String clientID = jsonObject.get(globalVariables.ClientID).toString();
        String clientOtherID = jsonObject.get(globalVariables.ClientOtherID).toString();
        System.out.println("client First name: " + clientFName);
        System.out.println("client Last name: " + clientLName);
        System.out.println("client ID: " + clientID);
        System.out.println("client SSN: " + clientSSN);
        System.out.println("client MedicateID: " + clientMedicateID);
        System.out.println("client OtherID: " + clientOtherID);
        System.out.println("Full body :    " + jsonObject);
        webServicesBase.sendPOSTClient(
                clientUrl,
                jsonArray,
                environment,
                testData);
    }

    /**
     * TFS location: http://tfsprod:8080/tfs/Santrax/SDLC/_workitems#_a=edit&id=96343
     * Use Get request to export files
     */
    @Test
    public void Verify_required_fields_And_Columns_for_maximum_supported_length_in_File_And_database_Columns() throws Exception {
        logger = extent.startTest("SEVV_5832_TC96343_Verify_required_fields_And_Columns_for_maximum_supported_length_in_File_And_database_Columns");
        String baseDate = dateTimeUtil.getCurrentTimeWithFormat(CONS_UTC_DATE_TIME_FORMAT);
        String startDate = dateTimeUtil.addDaysToStringDate(baseDate, CONS_UTC_DATE_TIME_FORMAT, -15);
        String endDate = dateTimeUtil.addDaysToStringDate(baseDate, CONS_UTC_DATE_TIME_FORMAT, 1);
        String account = testData.getAccId();

        logger.log(LogStatus.INFO,"Step 1: Prepare export DWH files request");
        String url = environment.getDwh();
        FullExportWithDateRange fullExportWithDateRange = new FullExportWithDateRange();
        fullExportWithDateRange.setAccount(account);
        fullExportWithDateRange.setStartDate(startDate);
        fullExportWithDateRange.setEndDate(endDate);
        fullExportWithDateRange.setGroupKey("");
        fullExportWithDateRange.setContract("_ALL");

        logger.log(LogStatus.INFO,"Step 2: Send export DWH files request");
        String bodyAsString = dWHServices.captureGetResponseEXPORTEVV(url, fullExportWithDateRange, environment);

        logger.log(LogStatus.INFO,"Step 3: Validate response \"Trigger full export successfully\"");
        Assert.assertTrue(bodyAsString.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO,"Step 4: Get CLIENT_GENERAL file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(bodyAsString, "MEDHHS", null);
        String clientGeneralName = dWHServices.getFileNameContain(fileNames,
                "CLIENT_GENERAL");

        logger.log(LogStatus.INFO,"Step 5: Waiting for CLIENT_GENERAL file name displays in SFTP");
        boolean result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + clientGeneralName);
        Assert.assertTrue(result);
        File filename = SftpUtils.getFile(DEVSWARMEXPORTDWH, "download", clientGeneralName);

        logger.log(LogStatus.INFO,"Step 6: Parse CLIENT_GENERAL file to model");
        CSVParser clientParser = CsvUtil.readCSVRecords(filename, ',', false);
        CsvAnnotationMapper<ClientGeneralModel> clientMapper = new CsvAnnotationMapper<>(ClientGeneralModel.class);
        List<ClientGeneralModel> clientGeneralModelCsv = clientMapper.map(clientParser);
        clientParser.close();
        ClientGeneralModel.verifyDataInDbAndCsvCorrectly(clientGeneralModelCsv);

        logger.log(LogStatus.INFO,"Step 7: Query database");
        String sqlStatement = String.format(sql_getClientGeneral, account, clientFName, clientLName);
        System.out.println("sql client info " + sqlStatement);
        ResultSet resultSetFromQuery = DbUtilsCon.getResultSetFromQuery(
                DbUtilsCon.createConnection(environment.getOracleUrl(), environment), sqlStatement);
        ColumnAnnotationMapper<ClientGeneralModel> rsMapper = new ColumnAnnotationMapper<>(ClientGeneralModel.class);
        List<ClientGeneralModel> dbData = rsMapper.map(resultSetFromQuery);
        System.out.println("dbData " + dbData.size());

        logger.log(LogStatus.INFO,"Step 8: Compare data in csv and db");
        clientGeneralModelCsv = getListForASpecificName(clientFName, clientLName, clientGeneralModelCsv);
        dbData = getListForASpecificName(clientFName, clientLName, dbData);
        Assert.assertTrue(CompareUtil.dataContains(dbData, clientGeneralModelCsv));
    }
}
