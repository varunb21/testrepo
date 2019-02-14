package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.client.ClientAddressModel;
import com.constant.Constant;
import com.mapper.ColumnAnnotationMapper;
import com.mapper.CsvAnnotationMapper;
import com.relevantcodes.extentreports.LogStatus;
import com.sftp.utils.SftpUtils;
import com.utilities.CompareUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.sql.SQL.sql_getClientAddress;
import static com.sql.SQL.sql_getClientSuppAddress;
import static com.utilities.DbUtilsCon.getListForASpecificUniqueKey;

public class SEVV_3221_TC96295_Validate_Required_Field_And_Column_In_Client_Address_File
        extends BaseTest {
    private String clientFName;
    private String clientLName;
    private String startDate;
    private String endDate;
    private String prefix;
    private String formatFile;
    private String account;
    private String groupKey;
    private String contract;
    private String clientZip1;
    private String responseBody;

    private List<ClientAddressModel> clientAddressDb;
    private List<ClientAddressModel> clientAddressFile;

    @BeforeClass
    public void Precondition() throws Exception {
        clientFName = testData.getValue("ClientFName");
        clientLName = testData.getValue("ClientLName");
        startDate = testData.getValue("StartTime");
        endDate = testData.getValue("EndTime");
        prefix = testData.getValue("MolinaPrefixName");
        formatFile = testData.getValue("TXTFormatFile");
        account = testData.getValue("AccId");
        groupKey = testData.getValue("MolinaGroupKey");
        contract = testData.getValue("Contract");
        clientZip1 = testData.getValue("ClientZip1");

        logger.log(LogStatus.INFO,"Step 1: Send export DWH files request");
        responseBody = dWHServices.PreparePostRequestDWHExportData("", startDate, endDate, groupKey, contract, environment);
        Assert.assertTrue(responseBody.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO,"Step 2: Get CLIENT_ADDR file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(responseBody, prefix, formatFile);
        String clientAddressName = dWHServices.getFileNameContain(fileNames, Constant.CLIENT_ADDR);

        logger.log(LogStatus.INFO,"Step 3: Waiting for CLIENT_ADDR file name displays in SFTP");
        boolean result = SftpUtils.isSftpFileExisted(environment.getSwarm_export_dwh() + clientAddressName);
        Assert.assertTrue(result);
        File filename = SftpUtils.getFile(environment.getSwarm_export_dwh(), "download", clientAddressName);

        logger.log(LogStatus.INFO,"Step 4: Parse CLIENT_GENERAL file to model");
        clientAddressFile = CsvAnnotationMapper.mapDataToModel(ClientAddressModel.class, filename, ',');

        logger.log(LogStatus.INFO,"Step 5: Query database");
        String sqlStatement = String.format(sql_getClientAddress, account, clientFName, clientLName);

        clientAddressDb = ColumnAnnotationMapper.mapDataToModel(ClientAddressModel.class,
                sqlStatement, environment.getOracleUrl(), environment);
    }

    @Test(groups = {"96295"})
    public void Verify_maximum_supported_length_in_Client_Address_file() {
        logger = extent.startTest("Verify_maximum_supported_length_in_Client_Address_file");

        logger.log(LogStatus.INFO,"Step 6: Verify data format in file");
        List<ClientAddressModel> specificClientAddressFile = getListForASpecificUniqueKey(clientZip1, clientAddressFile);
        ClientAddressModel.verifyDataInDbAndCsvCorrectly(specificClientAddressFile);
    }

    @Test(groups = {"96456"})
    public void Verify_data_between_database_and_file() {
        logger = extent.startTest("Verify_data_between_database_and_file");

        logger.log(LogStatus.INFO,"Step 6: Compare data in csv and db");
        List<ClientAddressModel> specificClientAddressFile = getListForASpecificUniqueKey(clientZip1, clientAddressFile);
        Assert.assertEquals(specificClientAddressFile.size(), 1);
        Assert.assertEquals(clientAddressDb.size(), 1);

        List<String> ignoreField = new ArrayList<>(Collections.singletonList("payerID"));
        Assert.assertTrue(CompareUtil.dataCompareWithExclusionOfFields(clientAddressDb, specificClientAddressFile, ignoreField));
        Assert.assertEquals(specificClientAddressFile.get(0).getPayerID(), prefix);
    }

    @Test(groups = "97019")
    public void Verify_required_field_and_column_with_Multiple_Address() throws Exception{
        logger = extent.startTest("Verify_required_field_and_column_with_Multiple_Address");

        logger.log(LogStatus.INFO,"Step 6: Query database");
        String sqlStatement = String.format(sql_getClientSuppAddress, account, clientFName, clientLName);

        List<ClientAddressModel> clientSuppAddressDb = ColumnAnnotationMapper.mapDataToModel(ClientAddressModel.class,
                sqlStatement, environment.getOracleUrl(), environment);

        logger.log(LogStatus.INFO,"Step 7: Compare data in csv and db");
        String clientLOC = testData.getValue("ClientLOC");
        List<ClientAddressModel> specificClientAddressFile = getListForASpecificUniqueKey(clientLOC, clientAddressFile);
        Assert.assertEquals(specificClientAddressFile.size(), 2);
        Assert.assertEquals(clientSuppAddressDb.size(), 1);

        Assert.assertEquals(specificClientAddressFile.get(0).getPayerID(), prefix);
        Assert.assertEquals(specificClientAddressFile.get(1).getPayerID(), prefix);
        clientSuppAddressDb.get(0).setPayerID(prefix);
        Assert.assertTrue(CompareUtil.dataContains(specificClientAddressFile, clientSuppAddressDb));
    }
}
