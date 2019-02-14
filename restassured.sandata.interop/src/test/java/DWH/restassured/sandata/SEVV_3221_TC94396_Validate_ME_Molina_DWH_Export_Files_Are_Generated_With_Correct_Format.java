package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.constant.Constant;
import com.entity.exportDWH.FullExportWithDateRange;
import com.relevantcodes.extentreports.LogStatus;
import com.sftp.utils.SftpUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SEVV_3221_TC94396_Validate_ME_Molina_DWH_Export_Files_Are_Generated_With_Correct_Format extends BaseTest {

    /**
     * Summary: The test script is to check ME Molina DWH Exported files with correct format
     */
    @Test(groups = {"94396", "94404", "94408", "96427", "96428",
            "96447", "96448", "96449", "96450", "96451",
            "96454", "96457", "96458", "96461", "96462",
            "96446", "94419", "96442", "96443", "96445",
            "96452", "96453", "96459",  "96463"})
    public void SEVV_3221_TC94396_Validate_ME_Molina_DWH_Export_Files_Are_Generated_With_Correct_Format() throws Exception {

        logger = extent.startTest("SEVV_3221_TC94396_Validate_ME_Molina_DWH_Export_Files_Are_Generated_With_Correct_Format");
        String account = testData.getAccId();
        String startDate = testData.getStartDate();
        String endDate = testData.getEndDate();
        String groupKey = testData.getGroupKey();
        String contract = testData.getContract();
        String spv = testData.getSpv();
        String username = testData.getUsername();
        int exportMode = testData.getExportMode();

        logger.log(LogStatus.INFO, "Step 1: Prepare export DWH files request");
        String url = environment.getDwh();
        FullExportWithDateRange fullExportWithDateRange = new FullExportWithDateRange();
        fullExportWithDateRange.setAccount(account);
        fullExportWithDateRange.setStartDate(startDate);
        fullExportWithDateRange.setEndDate(endDate);
        fullExportWithDateRange.setGroupKey(groupKey);
        fullExportWithDateRange.setContract(contract);
        fullExportWithDateRange.setSpv(spv);
        fullExportWithDateRange.setUsername(username);
        fullExportWithDateRange.setExportMode(exportMode);

        logger.log(LogStatus.INFO, "Step 1: Send export DWH files request");
        String bodyAsString = dWHServices.captureGetResponseEXPORTEVV(url, fullExportWithDateRange, environment);
        //Temporary get const for body & test
        //String bodyAsString = "Trigger full export successfully! Please wait until the file \\u0027MEDHHS_EVV_DWExtract_PROVIDER_GENERAL_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_PROVIDER_LOC_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_CLIENT_GENERAL_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_CLIENT_PROG_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_CLIENT_ELIG_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_CLIENT_DIAG_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_CLIENT_ADDR_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_CLIENT_PHONE_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_CLIENT_SCHEDULE_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_EMP_GENERAL_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_EMP_DISC_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_VISIT_GENERAL_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_VISIT_CALLS_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_VISIT_TASKS_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_VISIT_EXCP_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_VISIT_CHANGES_121718_04_54_52.csv\\u0027, \\u0027MEDHHS_EVV_DWExtract_VISIT_CLAIMST_121718_04_54_52.csv\\u0027 is completely written. Returned SID: \\u002738735363\\u0027. TraceId: \\u0027\\u0027";

        logger.log(LogStatus.INFO, "Step 2: Validate response \"Trigger full export successfully\"");
        Assert.assertTrue(bodyAsString.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO, "Step 3: Get CLIENT_PHONE file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(bodyAsString, getTestData().getContract(), null);

        Assert.assertTrue(fileNames.size() == 17, "Expected files is generated must be 17 files csv");

        logger.log(LogStatus.INFO, "Step 4: Waiting for all files name displays in SFTP with format: MEDHHS_EVV_DWExtract_SEGMENT_mmddyy_HH_mm_ss");
        Assert.assertTrue(SftpUtils.isSftpListFileExisted(environment.getSwarm_export_dwh(), fileNames));

        logger.log(LogStatus.INFO, "Step 5: File control with correct format MEDHHS_EVV_DWExtract_Control_mmddyy_HH_mm_ss.dat");
        Assert.assertTrue(SftpUtils.isSftpFileExisted(environment.getSwarm_export_dwh() + GetControlFileIsGenerated(fileNames)),
                "Control file is not generated in the path : " + environment.getSwarm_export_dwh());

        logger.log(LogStatus.INFO, "Step 6: Generated files as expected result");
        Assert.assertTrue(IsGenerateFilesIsExpectedResult(fileNames),"Exist a file is not generated as expected result");
    }

    public String GetControlFileIsGenerated(List<String> fileNames) {
        return dWHServices.getFileNameContain(fileNames, Constant.CLIENT_GENERAL)
                .replace(Constant.CLIENT_GENERAL, "Control").replace(".csv", ".dat");
    }

    public boolean IsGenerateFilesIsExpectedResult(List<String> fileNames)
    {
        String[] subGeneratedFiles = testData.getSubGeneratedFiles();
        for(String subGeneratedFile: subGeneratedFiles){
            String expectedFile = dWHServices.getFileNameContain(fileNames, subGeneratedFile)
                    .replace(Constant.CLIENT_GENERAL, subGeneratedFile);
            if(!fileNames.contains(expectedFile))
                return false;
        }
        return true;
    }

}
