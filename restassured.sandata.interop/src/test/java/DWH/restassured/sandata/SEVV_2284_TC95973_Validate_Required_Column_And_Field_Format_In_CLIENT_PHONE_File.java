package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.client.ClientPhoneModel;
import com.entity.exportDWH.FullExportWithDateRange;
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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.ResultSet;
import java.util.List;

import static com.sql.SQL.sql_getClientPhone;
import static com.constant.Constant.CONS_UTC_DATE_TIME_FORMAT;
import static com.sftp.utils.SftpUtils.DEVSWARMEXPORTDWH;

import static com.utilities.DbUtilsCon.getListForASpecificClientPhone;

public class SEVV_2284_TC95973_Validate_Required_Column_And_Field_Format_In_CLIENT_PHONE_File extends BaseTest {
    private String clientFirstName, clientLastName, clientPhone;

    @BeforeClass
    public void Precondition(){
        JSONObject jsonObject;
        String jsonFileName = testData.getJsonFileName();
        String providerId  = testData.getProviderId();
        String clientUrl = environment.getAlt_evv_clients_v1();

        JSONArray jsonArray = generateDataEntities.generateClientData(jsonFileName, providerId);
        jsonObject = (JSONObject) jsonArray.get(0);
        clientFirstName = jsonObject.get(globalVariables.ClientFirstName).toString();
        clientLastName = jsonObject.get(globalVariables.ClientLastName).toString();

        JSONArray clientPhones = (JSONArray) jsonObject.get(globalVariables.ClientPhone);
        JSONObject clientPhoneObj = (JSONObject) clientPhones.get(0);
        clientPhone = clientPhoneObj.get("ClientPhone").toString();

        webServicesBase.sendPOSTClient(
                clientUrl,
                jsonArray,
                environment,
                testData);
    }

    @Test
    public void SEVV_2284_TC95973_Validate_Required_column_and_field_format_in_CLIENT_PHONE_file() throws Exception{
        logger = extent.startTest("SEVV_2284_TC95973_Validate_Required_Column_And_Field_Format_In_CLIENT_PHONE_File");
        String account = "28591";
        String baseDate = dateTimeUtil.getCurrentTimeWithFormat(CONS_UTC_DATE_TIME_FORMAT);
        String startDate = dateTimeUtil.addDaysToStringDate(baseDate, CONS_UTC_DATE_TIME_FORMAT, -15);
        String endDate = dateTimeUtil.addDaysToStringDate(baseDate, CONS_UTC_DATE_TIME_FORMAT, 1);
        logger.log(LogStatus.INFO,"Step 1: Prepare export DWH files request");

        String url = environment.getDwh();
        FullExportWithDateRange fullExportWithDateRange = new FullExportWithDateRange();
        fullExportWithDateRange.setAccount(account);
        fullExportWithDateRange.setStartDate(startDate);
        fullExportWithDateRange.setEndDate(endDate);
        fullExportWithDateRange.setGroupKey("");
        fullExportWithDateRange.setContract("MEDHHS");

        logger.log(LogStatus.INFO,"Step 2: Send export DWH files request");
        String bodyAsString = dWHServices.captureGetResponseEXPORTEVV(url, fullExportWithDateRange, environment);

        logger.log(LogStatus.INFO,"Step 3: Validate response \"Trigger full export successfully\"");
        Assert.assertTrue(bodyAsString.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO,"Step 4: Get CLIENT_PHONE file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(bodyAsString,"MEDHHS", null);
        String clientPhoneName = dWHServices.getFileNameContain(fileNames, "CLIENT_PHONE");

        logger.log(LogStatus.INFO,"Step 5: Waiting for CLIENT_PHONE file name displays in SFTP");
        boolean result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + clientPhoneName);
        Assert.assertTrue(result);
        File filename = SftpUtils.getFile(DEVSWARMEXPORTDWH, "download", clientPhoneName);

        logger.log(LogStatus.INFO,"Step 6: Parse CLIENT_PHONE file to model");
        CSVParser clientParser = CsvUtil.readCSVRecords(filename, ',', false);
        CsvAnnotationMapper<ClientPhoneModel> clientMapper = new CsvAnnotationMapper<>(ClientPhoneModel.class);
        List<ClientPhoneModel> clientPhoneModelCsv = clientMapper.map(clientParser);
        clientParser.close();

        logger.log(LogStatus.INFO,"Step 7: Query database");
        String sqlStatement = String.format(sql_getClientPhone, clientFirstName, clientLastName, account);
        System.out.println("sql client info " + sqlStatement);
        ResultSet resultSetFromQuery = DbUtilsCon.getResultSetFromQuery(
                DbUtilsCon.createConnection(environment.getOracleUrl(), environment), sqlStatement);
        ColumnAnnotationMapper<ClientPhoneModel> rsMapper = new ColumnAnnotationMapper<>(ClientPhoneModel.class);
        List<ClientPhoneModel> dbData = rsMapper.map(resultSetFromQuery);
        System.out.println("dbData " + dbData.size());

        logger.log(LogStatus.INFO,"Step 8: Compare data in csv and db");
        clientPhoneModelCsv = getListForASpecificClientPhone(clientPhone, clientPhoneModelCsv);
        dbData = getListForASpecificClientPhone(clientPhone, dbData);

        Assert.assertTrue(CompareUtil.dataContains(dbData, clientPhoneModelCsv));
    }
}