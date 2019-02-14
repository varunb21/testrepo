package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.client.ClientGeneralModel;
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

import static com.constant.Constant.CONS_UTC_DATE_TIME_FORMAT;
import static com.sql.SQLString.sql_getClientGeneral;
import static com.utilities.DbUtilsCon.getListForASpecificName;

public class SEVV_5832_TC96340_Validate_Required_Column_And_Field_Format_In_CLIENT_GENERAL_File extends BaseTest {

    private String clientFirstName, clientLastName;

    @BeforeClass
    public void Precondition(){

        String jsonFileName = testData.getJsonFileName();
        String providerId  = testData.getProviderId();
        String clientUrl = environment.getAlt_evv_clients_v1();
        JSONArray jsonArray = generateDataEntities.generateClientData(jsonFileName,providerId);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        clientFirstName = jsonObject.get(globalVariables.ClientFirstName).toString();
        clientLastName = jsonObject.get(globalVariables.ClientLastName).toString();

        webServicesBase.sendPOSTClient(
                clientUrl,
                jsonArray,
                environment,
                testData);
        //NOTE: TODO : should assert data in db, sometime client couldn't create when clientId is duplicated.
    }

    /**
     * TFS location: http://tfsprod:8080/tfs/Santrax/SDLC/_workitems#_a=edit&id=92490
     * Use Post request with configuration to export files
     * */
    @Test
    public void SEVV_5832_TC96340_Validate_Required_column_and_field_format_in_CLIENT_GENERAL_file() throws Exception {
        logger.log(LogStatus.INFO,"Step 1: Prepare export DWH files request");
        FullExportWithDateRange fullExportWithDateRange = PrepareRequestDWHExportData();

        logger.log(LogStatus.INFO,"Step 2: Send export DWH files request");
        String bodyAsString = dWHServices.captureGetResponseEXPORTEVV(environment.getDwh(), fullExportWithDateRange, environment);

        logger.log(LogStatus.INFO,"Step 3: Validate response \"Trigger full export successfully\"");
        Assert.assertTrue(bodyAsString.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO,"Step 4: Get CLIENT_GENERAL file name");
        String clientGeneralName = dWHServices.getFileNameContain(dWHServices.getFileNamesInExportEVV(bodyAsString, "MEDHHS", null),
                testData.getContainText());

        logger.log(LogStatus.INFO,"Step 5: Waiting for CLIENT_GENERAL file name displays in SFTP");
        Assert.assertTrue(SftpUtils.isSftpFileExisted(environment.getSwarm_export_dwh() + clientGeneralName));

        logger.log(LogStatus.INFO,"Step 6: Parse CLIENT_GENERAL file to model");
        List<ClientGeneralModel> clientGeneralModelCsv = GetListOfClientGeneral(clientGeneralName);

        logger.log(LogStatus.INFO,"Step 7: Query database");
        String sqlStatement = String.format(sql_getClientGeneral, testData.getAccId(), clientFirstName, clientLastName);

        System.out.println("sql client info " + sqlStatement);
        ResultSet resultSetFromQuery = DbUtilsCon.getResultSetFromQuery(
                DbUtilsCon.createConnection(environment.getOracleUrl(), environment), sqlStatement);

        ColumnAnnotationMapper<ClientGeneralModel> rsMapper = new ColumnAnnotationMapper<>(ClientGeneralModel.class);
        List<ClientGeneralModel> dbData = rsMapper.map(resultSetFromQuery);

        logger.log(LogStatus.INFO,"Step 8: Compare data in csv and db");
        clientGeneralModelCsv = getListForASpecificName(clientFirstName, clientLastName, clientGeneralModelCsv);
        dbData = getListForASpecificName(clientFirstName, clientLastName, dbData);

        Assert.assertTrue(CompareUtil.dataContains(dbData, clientGeneralModelCsv));

    }

    public FullExportWithDateRange PrepareRequestDWHExportData() throws Exception{

        String baseDate = dateTimeUtil.getCurrentTimeWithFormat(CONS_UTC_DATE_TIME_FORMAT);
        String startDate = dateTimeUtil.addDaysToStringDate(baseDate, CONS_UTC_DATE_TIME_FORMAT, -15);
        String endDate = dateTimeUtil.addDaysToStringDate(baseDate, CONS_UTC_DATE_TIME_FORMAT, 1);

        logger.log(LogStatus.INFO,"Prepare export DWH files request");
        FullExportWithDateRange fullExportWithDateRange = new FullExportWithDateRange();
        fullExportWithDateRange.setAccount("28591");
        fullExportWithDateRange.setStartDate(startDate);
        fullExportWithDateRange.setEndDate(endDate);
        fullExportWithDateRange.setGroupKey("");
        fullExportWithDateRange.setContract("_ALL");

        return fullExportWithDateRange;
    }

    public List<ClientGeneralModel> GetListOfClientGeneral(String clientGeneralName) throws Exception{
        File filename = SftpUtils.getFile(environment.getSwarm_export_dwh(), testData.getLocalDir(), clientGeneralName);
        List<ClientGeneralModel> clientGeneralModelCsv = CsvAnnotationMapper.mapDataToModel(ClientGeneralModel.class, filename, ',');
//        CSVParser clientParser = CsvUtil.readCSVRecords(filename, ',', false);
//        CsvAnnotationMapper<ClientGeneralModel> clientMapper = new CsvAnnotationMapper<>(ClientGeneralModel.class);
//        List<ClientGeneralModel> clientGeneralModelCsv = clientMapper.map(clientParser);
//        clientParser.close();
        return clientGeneralModelCsv;
    }
}
