package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.client.ClientGeneralModel;
import com.entity.exportDWH.AccountInterfaceParamInformation;
import com.entity.exportDWH.ExportWithConfigurationModel;
import com.google.gson.Gson;
import com.mapper.CsvAnnotationMapper;
import com.mapper.TextUtil;
import com.relevantcodes.extentreports.LogStatus;
import com.sftp.utils.SftpUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sftp.utils.SftpUtils.DEVSWARMEXPORTDWH;

public class SEVV_3221_TC96879_Validate_Specified_Fields_Are_Not_Null_In_Client_General_File extends BaseTest {

    @Test
    public void SEVV_2284_TC96879_Verify_Specified_Fields_are_not_null_in_Client_General_File() throws Exception{
        logger = extent.startTest("SEVV_3221_TC96879_Validate_Specified_Fields_Are_Not_Null_In_Client_General_File");
        String startDate = testData.getValue("StartDate");
        String endDate = testData.getValue("EndDate");

        logger.log(LogStatus.INFO,"Step 1: Prepare export DWH files request");
        String url = environment.getDwh();
        Gson gson = new Gson();
        ExportWithConfigurationModel[] exportWithConfiRequests = webServicesBase
                .toJsonModel("DWHExportWithConfiguration.json", ExportWithConfigurationModel[].class);

        ExportWithConfigurationModel exportWithConfigRequest = exportWithConfiRequests[0];
        AccountInterfaceParamInformation accountInterfaceParamInformation =
                exportWithConfigRequest.getAccountInterfaceParamInformation();
        accountInterfaceParamInformation.setAccount("");
        accountInterfaceParamInformation.setContract("MEDHHS");
        accountInterfaceParamInformation.setGroupKey("231");
        accountInterfaceParamInformation.setStartDate(startDate);
        accountInterfaceParamInformation.setEndDate(endDate);

        exportWithConfigRequest.setAccountInterfaceParamInformation(accountInterfaceParamInformation);

        logger.log(LogStatus.INFO,"Step 2: Send export DWH files request");
        String bodyAsString = dWHServices.capturePostResponseEXPORTEVV(url, gson.toJson(exportWithConfigRequest), environment);

        logger.log(LogStatus.INFO,"Step 3: Validate response \"Trigger full export successfully\"");
        Assert.assertTrue(bodyAsString.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO,"Step 4: Get CLIENT_GENERAL file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(bodyAsString, "MEDHHS", ".txt");
        String clientGeneralName = dWHServices.getFileNameContain(fileNames, "CLIENT_GENERAL");

        logger.log(LogStatus.INFO,"Step 5: Waiting for CLIENT_GENERAL file name displays in SFTP");
        boolean result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + clientGeneralName);
        Assert.assertTrue(result);
        File filename = SftpUtils.getFile(DEVSWARMEXPORTDWH, "download", clientGeneralName);

        logger.log(LogStatus.INFO,"Step 6: Parse CLIENT_GENERAL file to model");
//        List<String> txtRecords = TextUtil.readTextFileRecords(filename.getPath());
//        TextUtil<ClientGeneralModel> textClientGeneral = new TextUtil<> (ClientGeneralModel.class);
//        List<ClientGeneralModel> clientGeneralData = textClientGeneral.mapTxtToModel(txtRecords);
        List<ClientGeneralModel> clientGeneralData = CsvAnnotationMapper.mapDataToModel(ClientGeneralModel.class, filename, ',');

        logger.log(LogStatus.INFO,"Step 7: Verify specific fields are not null");
        List<String> definedField = new ArrayList<>(Arrays.asList("payerID", "providerID", "clientID",
                "clientFirstName", "clientLastName", "clientMedicaidID"));
        ClientGeneralModel.verifyRandomRecordsFieldNotNull(clientGeneralData, definedField);
    }
}
