package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.client.ClientPhoneModel;
import com.config.TestData;
import com.entity.exportDWH.AccountInterfaceParamInformation;
import com.entity.exportDWH.ExportWithConfigurationModel;
import com.globalMethods.core.globalVariables;
import com.google.gson.Gson;
import com.mapper.ColumnAnnotationMapper;
import com.mapper.TextUtil;
import com.relevantcodes.extentreports.LogStatus;
import com.sftp.utils.SftpUtils;
import com.utilities.CompareUtil;
import com.utilities.DbUtilsCon;
import com.ws.WebServicesBase;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;

import static com.constant.Constant.CONS_UTC_DATE_TIME_FORMAT;
import static com.sftp.utils.SftpUtils.DEVSWARMEXPORTDWH;
import static com.sql.SQL.sql_getClientPhone;
import static com.utilities.DbUtilsCon.getListForASpecificClientPhone;

public class SEVV_5838_TC97022_Validate_Required_Field_And_Column_In_Client_Phone_File_For_ALT_EVV_Client extends BaseTest {
    private static final Logger LOGGER = Logger
            .getLogger(SEVV_5838_TC97022_Validate_Required_Field_And_Column_In_Client_Phone_File_For_ALT_EVV_Client.class);

    private String clientFirstName, clientLastName, clientPhone;
    private TestData currTestData;

    @BeforeClass
    public void prepareTestData() throws IOException, ParseException {
        currTestData = getTestData();
        JSONArray jsonArray = generateUniqueParam.createClient(globalVariables.client_intake_v1, "Prod011");
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        clientFirstName = jsonObject.get(globalVariables.ClientFirstName).toString();
        clientLastName = jsonObject.get(globalVariables.ClientLastName).toString();

        //get newly created unique phone number in ClientPhone Segment
        String clientUrl = environment.getAlt_evv_clients_v1();
        JSONArray clientPhones = (JSONArray) jsonObject.get(globalVariables.ClientPhone);
        JSONObject clientPhoneObj = (JSONObject) clientPhones.get(0);
        clientPhone = clientPhoneObj.get("ClientPhone").toString();

        webServicesBase.sendPOSTClient(
                clientUrl,
                jsonArray,
                environment,
                currTestData);
    }

    @Test
    public void SEVV_5838_TC97022_Verify_required_field_and_column_in_Client_Phone_file_for_ALT_EVV_client() throws Exception {
        logger = extent.startTest("SEVV_5838_TC97022_Validate_Required_Field_And_Column_In_Client_Phone_File_For_ALT_EVV_Client");
        String account = currTestData.getAccId();
        List<String> ignoreField = Collections.singletonList("payerID");
        String baseDate = dateTimeUtil.getCurrentTimeWithFormat(CONS_UTC_DATE_TIME_FORMAT);
        String startDate = dateTimeUtil.addDaysToStringDate(baseDate, CONS_UTC_DATE_TIME_FORMAT, -15);
        String endDate = dateTimeUtil.addDaysToStringDate(baseDate, CONS_UTC_DATE_TIME_FORMAT, 1);

        logger.log(LogStatus.INFO,"Step 1: Prepare export DWH files request");
        String url = environment.getDwh();
        Gson gson = new Gson();
        WebServicesBase ws = new WebServicesBase();
        ExportWithConfigurationModel[] exportWithConfiRequests = ws
                .toJsonModel("DWHExportWithConfiguration.json", ExportWithConfigurationModel[].class);

        ExportWithConfigurationModel exportWithConfigRequest = exportWithConfiRequests[0];

        AccountInterfaceParamInformation accountInterfaceParamInformation =
                exportWithConfigRequest.getAccountInterfaceParamInformation();
        accountInterfaceParamInformation.setContract("_ALL");
        accountInterfaceParamInformation.setStartDate(startDate);
        accountInterfaceParamInformation.setEndDate(endDate);
        accountInterfaceParamInformation.setGroupKey("231");
        accountInterfaceParamInformation.setAccount("");

        exportWithConfigRequest.setAccountInterfaceParamInformation(accountInterfaceParamInformation);

        logger.log(LogStatus.INFO,"Step 2: Send export DWH files request");
        String bodyAsString = dWHServices.capturePostResponseEXPORTEVV(url, gson.toJson(exportWithConfigRequest), environment);

        logger.log(LogStatus.INFO,"Step 3: Validate response \"Trigger full export successfully\"");
        Assert.assertTrue(bodyAsString.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO,"Step 4: Get CLIENT_PHONE file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(bodyAsString,"MEDHHS", ".txt"); // file will be exported with txt format
        String clientPhoneName = dWHServices.getFileNameContain(fileNames, "CLIENT_PHONE");

        logger.log(LogStatus.INFO,"Step 5: Waiting for CLIENT_PHONE file name displays in SFTP");
        boolean result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + clientPhoneName);
        Assert.assertTrue(result);
        File filename = SftpUtils.getFile(DEVSWARMEXPORTDWH, "download", clientPhoneName);
        String fileName = filename.getName();

        logger.log(LogStatus.INFO,"Step 6: Parse CLIENT_PHONE file to model");
        List<String> csvRecords = TextUtil.readTextFileRecords("download/" + fileName);
        TextUtil<ClientPhoneModel> textClientPhone = new TextUtil<> (ClientPhoneModel.class);
        List<ClientPhoneModel> clientPhoneData = textClientPhone.mapTxtToModel(csvRecords);

        logger.log(LogStatus.INFO,"Step 7: Query database");
        String sqlStatement = String.format(sql_getClientPhone, clientFirstName, clientLastName, account);
        ResultSet resultSetFromQuery = DbUtilsCon.getResultSetFromQuery(
                DbUtilsCon.createConnection(environment.getOracleUrl(), environment), sqlStatement);
        ColumnAnnotationMapper<ClientPhoneModel> mapper = new ColumnAnnotationMapper<>(ClientPhoneModel.class);
        List<ClientPhoneModel> dbRecords = mapper.map(resultSetFromQuery);

        LOGGER.info("Step 8: Compare data in csv and db");
        logger.log(LogStatus.INFO,"");
        List<ClientPhoneModel> specificClientName = getListForASpecificClientPhone(clientPhone, clientPhoneData);
        Assert.assertTrue(CompareUtil.dataCompareWithExclusionOfFields(dbRecords, specificClientName, ignoreField));
        Assert.assertEquals(specificClientName.get(0).getPayerID(), "MEDHHS");
    }
}