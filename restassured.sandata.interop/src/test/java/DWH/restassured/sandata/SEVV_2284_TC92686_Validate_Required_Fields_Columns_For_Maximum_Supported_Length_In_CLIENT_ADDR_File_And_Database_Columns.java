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
import java.util.List;

import static com.sql.SQL.sql_getClientAddress;
import static com.utilities.DbUtilsCon.getListForASpecificUniqueKey;

public class SEVV_2284_TC92686_Validate_Required_Fields_Columns_For_Maximum_Supported_Length_In_CLIENT_ADDR_File_And_Database_Columns
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
    private String clientZip;
    private String responseBody;

    @BeforeClass
    public void Precondition() {
        clientFName = testData.getValue("ClientFName");
        clientLName = testData.getValue("ClientLName");
        startDate = testData.getValue("StartTime");
        endDate = testData.getValue("EndTime");
        prefix = testData.getValue("PrefixName");
        formatFile = testData.getValue("CsvFormatFile");
        account = testData.getValue("AccId");
        groupKey = testData.getValue("GroupKey");
        contract = testData.getValue("Contract");
        clientZip = testData.getValue("ClientZip");
    }

    @Test(groups = {"92686"})
    public void Verify_required_fields_Columns_for_maximum_supported_length_in_CLIENT_ADDR_file_and_database_Columns() throws Exception{
        logger.log(LogStatus.INFO,"Step 1: Send export DWH files request");
        responseBody = dWHServices.PrepareGetRequestDWHExportData("", startDate, endDate, groupKey, contract, environment);
        Assert.assertTrue(responseBody.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO,"Step 2: Get CLIENT_ADDR file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(responseBody, prefix, formatFile);
        String clientAddressName = dWHServices.getFileNameContain(fileNames, Constant.CLIENT_ADDR);

        logger.log(LogStatus.INFO,"Step 3: Waiting for CLIENT_ADDR file name displays in SFTP");
        boolean result = SftpUtils.isSftpFileExisted(environment.getSwarm_export_dwh() + clientAddressName);
        Assert.assertTrue(result);
        File filename = SftpUtils.getFile(environment.getSwarm_export_dwh(), "download", clientAddressName);

        logger.log(LogStatus.INFO,"Step 4: Parse CLIENT_GENERAL file to model");
        List<ClientAddressModel> clientAddressFile = CsvAnnotationMapper.mapDataToModel(ClientAddressModel.class, filename, ',');

        logger.log(LogStatus.INFO,"Step 5: Query database");
        String sqlStatement = String.format(sql_getClientAddress, account, clientFName, clientLName);

        List<ClientAddressModel> clientAddressDb = ColumnAnnotationMapper.mapDataToModel(ClientAddressModel.class,
                sqlStatement, environment.getOracleUrl(), environment);

        logger.log(LogStatus.INFO,"Step 6: Verify data format in file");
        clientAddressFile = getListForASpecificUniqueKey(clientZip, clientAddressFile);
        ClientAddressModel.verifyDataInDbAndCsvCorrectly(clientAddressFile);

        logger.log(LogStatus.INFO,"Step 7: Compare data in csv and db");
        clientAddressFile = getListForASpecificUniqueKey(clientZip, clientAddressFile);
        Assert.assertNotEquals(clientAddressFile.size(), 0);
        Assert.assertTrue(CompareUtil.dataContains(clientAddressFile, clientAddressDb));
    }
}