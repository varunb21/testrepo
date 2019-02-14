package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.Employee.EmployeeDisciplineModel;
import com.DWExtractModels.Employee.EmployeeGeneralModel;
import com.DWExtractModels.Provider.ProviderGeneralModel;
import com.DWExtractModels.Visit.*;
import com.DWExtractModels.client.*;
import com.constant.Constant;
import com.entity.exportDWH.AccountInterfaceParamInformation;
import com.entity.exportDWH.ExportWithConfigurationModel;
import com.globalMethods.core.CommonMethods;
import com.google.gson.Gson;
import com.mapper.CsvAnnotationMapper;
import com.mapper.CsvUtil;
import com.relevantcodes.extentreports.LogStatus;
import com.sftp.utils.SftpUtils;
import org.apache.commons.csv.CSVParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import static com.sftp.utils.SftpUtils.DEVSWARMEXPORTDWH;

public class SEVV_3221_TC96878_Validate_Specified_Fields_Are_Not_Null_In_Exported_Files extends BaseTest {

    /**
     * Summary: The test script is to check exported files exist in SFTP folder, then verify specific fields of each file not null
     */
    @Test(groups = { "96878","96879","96880","96883","96884","96885",
                     "96886","96887","96888","96889","96890","96891","96892" })
    public void SEVV_3221_TC96878_Validate_Specified_Fields_Are_Not_Null_In_Exported_Files() throws Exception{
        logger.log(LogStatus.INFO,"Step 1: Prepare payload and call request export DWH");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(callExportDWHRequest(), "MEDHHS", ".csv");

        logger.log(LogStatus.INFO,"Step 2: Verify exported files exist in SFTP folder");
        verifyExportedFileExistInSFTP(fileNames, Constant.PROVIDER_GENERAL);
        verifyExportedFileExistInSFTP(fileNames, Constant.CLIENT_GENERAL);
        verifyExportedFileExistInSFTP(fileNames, Constant.CLIENT_PROG);
        verifyExportedFileExistInSFTP(fileNames, Constant.CLIENT_ADDR);
        verifyExportedFileExistInSFTP(fileNames, Constant.CLIENT_PHONE);
        verifyExportedFileExistInSFTP(fileNames, Constant.CLIENT_SCHEDULE);
        verifyExportedFileExistInSFTP(fileNames, Constant.EMP_GENERAL);
        verifyExportedFileExistInSFTP(fileNames, Constant.EMP_DISC);
        verifyExportedFileExistInSFTP(fileNames, Constant.VISIT_GENERAL);
        verifyExportedFileExistInSFTP(fileNames, Constant.VISIT_CALLS);
        verifyExportedFileExistInSFTP(fileNames, Constant.VISIT_TASKS);
        verifyExportedFileExistInSFTP(fileNames, Constant.VISIT_EXCP);
        verifyExportedFileExistInSFTP(fileNames, Constant.VISIT_CHANGES);

        logger.log(LogStatus.INFO,"Step 3: Verify specific fields are not null");
        verify_specific_fields_not_null_in_exported_file(fileNames, ProviderGeneralModel.class, Constant.PROVIDER_GENERAL, providerGeneralFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, ClientGeneralModel.class, Constant.CLIENT_GENERAL, clientGeneralFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, ClientProgModel.class, Constant.CLIENT_PROG, clientProgFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, ClientAddressModel.class, Constant.CLIENT_ADDR, clientAddrFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, ClientPhoneModel.class, Constant.CLIENT_PHONE, clientPhoneFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, ClientSchedule.class, Constant.CLIENT_SCHEDULE, clientScheduleFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, EmployeeGeneralModel.class, Constant.EMP_GENERAL, empGeneralFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, EmployeeDisciplineModel.class, Constant.EMP_DISC, empDiscFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, VisitGeneralModel.class, Constant.VISIT_GENERAL, visitGeneralFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, VisitCallsModel.class, Constant.VISIT_CALLS, visitCallFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, VisitTasksModel.class, Constant.VISIT_TASKS, visitTaskFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, VisitExceptionsModel.class, Constant.VISIT_EXCP, visitExcpFields);
        verify_specific_fields_not_null_in_exported_file(fileNames, VisitChanges.class, Constant.VISIT_CHANGES, visitChangeFields);
    }

    private String callExportDWHRequest() throws IOException {
        String startDate = testData.getValue("StartDate");
        String endDate = testData.getValue("EndDate");
        logger.log(LogStatus.INFO,"Prepare payload");
        Gson gson = new Gson();
        ExportWithConfigurationModel[] exportWithConfiRequests = webServicesBase.toJsonModel("DWHExportWithConfiguration.json", ExportWithConfigurationModel[].class);
        ExportWithConfigurationModel exportWithConfigRequest = exportWithConfiRequests[0];
        AccountInterfaceParamInformation accountInterfaceParamInformation = exportWithConfigRequest.getAccountInterfaceParamInformation();
        accountInterfaceParamInformation.setAccount("");
        accountInterfaceParamInformation.setContract("MEDHHS");
        accountInterfaceParamInformation.setGroupKey("231");
        accountInterfaceParamInformation.setStartDate(startDate);
        accountInterfaceParamInformation.setEndDate(endDate);

        exportWithConfigRequest.setAccountInterfaceParamInformation(accountInterfaceParamInformation);

        logger.log(LogStatus.INFO,"Call request");
        String bodyAsString = dWHServices.capturePostResponseEXPORTEVV(environment.getDwh(), gson.toJson(exportWithConfigRequest), environment);

        logger.log(LogStatus.INFO,"Validate response \"Trigger full export successfully\"");
        if (bodyAsString.contains("Trigger full export successfully")) {
            Assert.assertTrue(bodyAsString.contains("Trigger full export successfully"));
        } else {
            logger.log(LogStatus.FAIL,"Trigger export request unsuccessfully\"");
        }

        return bodyAsString;
    }
    private <T> void verify_specific_fields_not_null_in_exported_file(List<String> fileNames, Class<T> type, String name, List<String> specificFields) throws InterruptedException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        String filename = dWHServices.getFileNameContain(fileNames, name);
        File file = SftpUtils.getFile(DEVSWARMEXPORTDWH, Constant.DOWNLOAD_FOLDER, filename);
        List<T> objects = parseCsvFileContentToObjects(type, file);
        CommonMethods.verifyObjectFieldsNotNull(objects, specificFields);
    }

    private void verifyExportedFileExistInSFTP(List<String> fileNames, String type) throws InterruptedException {
        String fileName = dWHServices.getFileNameContain(fileNames, type);
        logger.log(LogStatus.INFO,String.format("Check '%s' file exists in %s", fileName, Constant.SFTP_FOLDER));
        boolean result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + fileName);
        if (result) {
            logger.log(LogStatus.PASS,String.format("Check '%s' file exists in %s", fileName, Constant.SFTP_FOLDER));
        } else {
            logger.log(LogStatus.FAIL,String.format("Check '%s' file not exist in %s", fileName, Constant.SFTP_FOLDER));
        }
        Assert.assertTrue(result, String.format("%s does not exist in SFTP", fileName));
    }

    private <T> List<T> parseCsvFileContentToObjects(Class<T> objectClass, File file) throws IOException {
        logger.log(LogStatus.INFO,String.format("Parse '%s' file to model", file.getName()));
        CSVParser clientParser = CsvUtil.readCSVRecords(file, ',', false);
        CsvAnnotationMapper<T> clientMapper = new CsvAnnotationMapper<>(objectClass);
        List<T> objects = clientMapper.map(clientParser);
        clientParser.close();
        return objects;
    }

    /**
     * Declare test script properties
     */
    List<String> providerGeneralFields = Arrays.asList("ProviderId", "PayerId", "ProviderName", "ProviderRequireAuth", "ProviderDateBegin");
    List<String> clientGeneralFields = Arrays.asList("ProviderId", "PayerId", "ClientId", "ClientFirstName", "ClientLastName", "ClientMedicaidId");
    List<String> clientProgFields = Arrays.asList("ProviderId", "PayerId", "ClientId");
    List<String> clientAddrFields = Arrays.asList("ProviderId", "PayerId", "ClientId", "ProviderRequireAuth", "ProviderDateBegin");
    List<String> clientPhoneFields = Arrays.asList("ProviderId", "PayerId", "ClientId", "ClientPhone");
    List<String> clientScheduleFields = Arrays.asList("ProviderId", "PayerId", "ClientId", "ScheduleId", "ScheduleStartDate");
    List<String> empGeneralFields = Arrays.asList("ProviderId", "EmployeeId", "EmployeeLastName", "EmployeeFirstName");
    List<String> empDiscFields = Arrays.asList("ProviderId", "EmployeeId", "EmployeeDiscipline");
    List<String> visitGeneralFields = Arrays.asList("ProviderId", "PayerId", "ClientId", "VisitKey", "TimeZone");
    List<String> visitCallFields = Arrays.asList("Visitkey", "CallKey", "CallAssignment", "CallType", "TimeZone");
    List<String> visitTaskFields = Arrays.asList("Visitkey", "TaskId", "CallKey");
    List<String> visitExcpFields = Arrays.asList("Visitkey", "ExceptionId");
    List<String> visitChangeFields = Arrays.asList("Visitkey", "ChangeId", "ChangeType", "ChangeMadeby", "RecordUpdateDateTime");
}
