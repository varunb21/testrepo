package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.client.ClientProgModel;
import com.entity.exportDWH.FullExportWithDateRange;
import com.mapper.ColumnAnnotationMapper;
import com.mapper.CsvAnnotationMapper;
import com.mapper.CsvUtil;
import com.relevantcodes.extentreports.LogStatus;
import com.sftp.utils.SftpUtils;
import com.utilities.CompareUtil;
import com.utilities.DbUtilsCon;
import org.apache.commons.csv.CSVParser;

import org.testng.Assert;

import org.testng.annotations.Test;

import java.io.File;
import java.sql.ResultSet;
import java.util.List;

import static com.sftp.utils.SftpUtils.DEVSWARMEXPORTDWH;
import static com.sql.SQL.sql_getClientProgram;

public class SEVV_2284_TC95972_Validate_Required_Column_And_Field_Format_In_CLIENT_PROG_File extends BaseTest {

    @Test
    public void SEVV_2284_TC95972_Validate_Required_column_and_field_format_in_CLIENT_PROG_file() throws Exception{
        logger = extent.startTest("SEVV_2284_TC95972_Validate_Required_Column_And_Field_Format_In_CLIENT_PROG_File");
        String startDate = testData.getValue("StartDate");
        String endDate = testData.getValue("EndDate");
        String account = testData.getAccId();
        String clientFName = testData.getValue("clientFName");
        String clientLName = testData.getValue("clientLName");

        logger.log(LogStatus.INFO,"Step 1: Prepare export DWH files request");
        FullExportWithDateRange fullExportWithDateRange = new FullExportWithDateRange();
        fullExportWithDateRange.setAccount(account);
        fullExportWithDateRange.setStartDate(startDate);
        fullExportWithDateRange.setEndDate(endDate);
        fullExportWithDateRange.setGroupKey("");
        fullExportWithDateRange.setContract("_ALL");

        logger.log(LogStatus.INFO,"Step 2: Send export DWH files request");
        String bodyAsString = dWHServices.captureGetResponseEXPORTEVV(environment.getDwh(), fullExportWithDateRange, environment);

        logger.log(LogStatus.INFO,"Step 3: Validate response \"Trigger full export successfully\"");
        Assert.assertTrue(bodyAsString.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO,"Step 4: Get CLIENT_PROG file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(bodyAsString, "MEDHHS", null);
        String clientProgName = dWHServices.getFileNameContain(fileNames, "CLIENT_PROG");

        logger.log(LogStatus.INFO,"Step 5: Waiting for CLIENT_PROG file name displays in SFTP");
        boolean result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + clientProgName);
        Assert.assertTrue(result);
        File filename = SftpUtils.getFile(DEVSWARMEXPORTDWH, "download", clientProgName);

        logger.log(LogStatus.INFO,"Step 6: Parse CLIENT_PROG file to model");
        CSVParser clientParser = CsvUtil.readCSVRecords(filename, ',', false);
        CsvAnnotationMapper<ClientProgModel> clientMapper = new CsvAnnotationMapper<>(ClientProgModel.class);
        List<ClientProgModel> clientGeneralModelCsv = clientMapper.map(clientParser);
        clientParser.close();

        logger.log(LogStatus.INFO,"Step 7: Query database");
        String sqlStatement = String.format(sql_getClientProgram, account, clientFName, clientLName);
        ResultSet resultSetFromQuery = DbUtilsCon.getResultSetFromQuery(DbUtilsCon
                .createConnection(environment.getOracleUrl(), environment), sqlStatement);
        ColumnAnnotationMapper<ClientProgModel> rsMapper = new ColumnAnnotationMapper<>(ClientProgModel.class);
        List<ClientProgModel> dbData = rsMapper.map(resultSetFromQuery);

        logger.log(LogStatus.INFO,"Step 8: Compare data in csv and db");
        String payerId = testData.getValue("PayerId");
        String providerId = testData.getValue("ProviderId");
        String clientId = testData.getValue("ClientId");
        String payerProgram = testData.getValue("PayerProgram");
        clientGeneralModelCsv = DbUtilsCon.getListForASpecificClientProg(payerId, providerId, clientId,
                payerProgram, clientGeneralModelCsv);
        dbData = DbUtilsCon.getListForASpecificClientProg(payerId, providerId, clientId,
                payerProgram, dbData);
        ClientProgModel.verifyFormatFieldOfData(clientGeneralModelCsv);
        Assert.assertTrue(CompareUtil.dataContains(clientGeneralModelCsv, dbData));
    }
}
