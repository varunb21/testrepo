package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.client.ClientGeneralModel;
import com.constant.Constant;
import com.mapper.ColumnAnnotationMapper;
import com.mapper.CsvAnnotationMapper;
import com.relevantcodes.extentreports.LogStatus;
import com.sftp.utils.SftpUtils;
import com.utilities.CompareUtil;
import com.utilities.DbUtilsCon;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.constant.Constant.MOLINA_ACCOUNT;
import static com.sql.SQL.sql_getClientGeneral;
import static com.sql.SQL.sql_getClientGeneralMolina;
import static com.utilities.DbUtilsCon.getListForASpecificName;

public class SEVV_3221_TC97018_Validate_Required_Field_And_Column_In_Client_General_File extends BaseTest {

    /**
     * Test data is created for account 28625
     * */
    @Test(groups = {"96460", "97018"})
    public void Verify_required_field_and_column_in_Client_General_file() throws Exception {
        logger = extent.startTest("Verify_required_field_and_column_in_Client_General_file");
        String clientFName = testData.getValue("ClientFName");
        String clientLName = testData.getValue("ClientLName");
        String startDate = testData.getValue("StartTime");
        String endDate = testData.getValue("EndTime");
        String prefix = testData.getValue("MolinaPrefixName");
        String formatFile = testData.getValue("TXTFormatFile");
        String account = testData.getValue("AccId");
        String groupKey = testData.getValue("MolinaGroupKey");
        String contract = testData.getValue("Contract");
        String sql = sql_getClientGeneralMolina;

        logger.log(LogStatus.INFO,"Step 1: Send export DWH files request");
        String responseBody = dWHServices.PreparePostRequestDWHExportData("", startDate, endDate, groupKey, contract, environment);

        logger.log(LogStatus.INFO,"Step 2: Validate response \"Trigger full export successfully\"");
        Assert.assertTrue(responseBody.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO,"Step 3: Get CLIENT_GENERAL file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(responseBody, prefix, formatFile);
        String clientGeneralName = dWHServices.getFileNameContain(fileNames, Constant.CLIENT_GENERAL);
        System.out.println("clientGN " + clientGeneralName);

        logger.log(LogStatus.INFO,"Step 4: Waiting for CLIENT_GENERAL file name displays in SFTP");
        boolean result = SftpUtils.isSftpFileExisted(environment.getSwarm_export_dwh() + clientGeneralName);
        Assert.assertTrue(result);
        File filename = SftpUtils.getFile(environment.getSwarm_export_dwh(), "download", clientGeneralName);

        logger.log(LogStatus.INFO,"Step 5: Parse CLIENT_GENERAL file to model");
        List<ClientGeneralModel> clientGeneralFile = CsvAnnotationMapper.mapDataToModel(ClientGeneralModel.class, filename, ',');

        logger.log(LogStatus.INFO,"Step 6: Query database");
        String sqlStatement = String.format(sql, account, clientFName, clientLName);

        System.out.println("sql client info " + sqlStatement);
        List<ClientGeneralModel> clientGeneralDb = ColumnAnnotationMapper.mapDataToModel(ClientGeneralModel.class,
                sqlStatement, environment.getOracleUrl(), environment);

        logger.log(LogStatus.INFO,"Step 7: Verify data format in file");
        clientGeneralFile = getListForASpecificName(clientFName, clientLName, clientGeneralFile);
        ClientGeneralModel.verifyDataInDbAndCsvCorrectly(clientGeneralFile);

        logger.log(LogStatus.INFO,"Step 8: Compare data in csv and db");
        if(clientGeneralDb.size() > 1) clientGeneralDb.remove(1);

        Assert.assertEquals(clientGeneralFile.size(), 1);
        Assert.assertEquals(clientGeneralDb.size(), 1);

        List<String> ignoreField = new ArrayList<>(Collections.singletonList("payerID"));
        Assert.assertTrue(CompareUtil.dataCompareWithExclusionOfFields(clientGeneralDb, clientGeneralFile, ignoreField));
        Assert.assertEquals(clientGeneralFile.get(0).getPayerID(), prefix);
    }
}
