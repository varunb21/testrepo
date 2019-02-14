package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.Employee.EmployeeDisciplineModel;
import com.entity.exportDWH.FullExportWithDateRange;
import com.globalMethods.core.CommonMethods;
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
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import static com.constant.Constant.CONS_UTC_DATE_TIME_FORMAT;
import static com.sftp.utils.SftpUtils.DEVSWARMEXPORTDWH;
import static com.sql.SQL.sql_getEmployeeDisc;
import static com.utilities.DbUtilsCon.getListForASpecificUniqueKey;

public class SEVV_2284_TC96122_Validate_Required_Fields_And_Columns_In_EMP_DISC_For_Maximum_Supported_Length_In_JSON_File_And_Database_Columns
        extends BaseTest {
    private String employeeFName;
    private String employeeLName;
    private JSONArray jsonArray;
    private JSONObject jsonObject;

    @BeforeClass
    public void PreCondition() throws IOException, ParseException {
        String employeeUrl = environment.getCreate_employee();
        jsonArray= generateDataEntities.GenerateEmployeeData_OpenEVV(globalVariables.emp_openevv_Json, testData.getAccId());
        jsonObject = (JSONObject) jsonArray.get(0);

        employeeFName = jsonObject.get(globalVariables.EmployeeFirstName).toString();
        employeeLName = jsonObject.get(globalVariables.EmployeeLastName).toString();
        System.out.println("employeeFName " + employeeFName);
        System.out.println("employeeLName " + employeeLName);
        webServicesBase.sendPOSTEmployeeEVV(
                employeeUrl,
                jsonArray,
                environment,
                testData);

        //create alt employee under max length provider
        JSONArray jsonAltEmployeeArray = generateDataEntities
                .GenerateEmployeeData_AltEVV(testData.getValue("Staff_intake"),
                        testData.getValue("ProviderIdMaxLength"));

        JSONObject jsonAltEmployeeObject = (JSONObject) jsonAltEmployeeArray.get(0);

        jsonAltEmployeeObject.put("EmployeeQualifier", "EmployeeSSN");
        jsonObject.put("EmployeeIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
        System.out.println("employeeFName " + jsonAltEmployeeObject.get(globalVariables.EmployeeFirstName).toString());
        System.out.println("employeeLName " + jsonAltEmployeeObject.get(globalVariables.EmployeeLastName).toString());

        employeeUrl = environment.getAlt_evv_emp();
        webServicesBase.sendPOSTEmployeeAtlEVV(
                employeeUrl,
                jsonAltEmployeeArray,
                environment,
                testData,
                testData.getValue("AccProMaxLength"));
    }

    @Test(groups = { "96122", "96474", "96472", "95976"})
    public void SEVV_2284_TC96122_Verify_required_fields_and_Columns_in_EMP_DISC_for_maximum_supported_length_in_JSON_File_and_database_Columns()
            throws Exception {
        logger = extent.startTest("SEVV_2284_TC96122_Verify_required_fields_and_Columns_in_EMP_DISC_for_maximum_supported_length_in_JSON_File_and_database_Columns");
        String account = testData.getAccId();

        String currentDate = dateTimeUtil.getCurrentTimeWithFormat(CONS_UTC_DATE_TIME_FORMAT);
        String startDate = dateTimeUtil.addDaysToStringDate(currentDate, CONS_UTC_DATE_TIME_FORMAT, -15);
        String endDate = dateTimeUtil.addDaysToStringDate(currentDate, CONS_UTC_DATE_TIME_FORMAT, 1);

        logger.log(LogStatus.INFO,"Step 1: Prepare export DWH files request");
        FullExportWithDateRange fullExportWithDateRange = new FullExportWithDateRange();
        fullExportWithDateRange.setAccount("");
        fullExportWithDateRange.setStartDate(startDate);
        fullExportWithDateRange.setEndDate(endDate);
        fullExportWithDateRange.setGroupKey("93");
        fullExportWithDateRange.setContract("_ALL");

        logger.log(LogStatus.INFO,"Step 2: Send export DWH files request");
        String bodyAsString = dWHServices.captureGetResponseEXPORTEVV(environment.getDwh(), fullExportWithDateRange, environment);

        logger.log(LogStatus.INFO,"Step 3: Validate response \"Trigger full export successfully\"");
        Assert.assertTrue(bodyAsString.contains("Trigger full export successfully"));

        logger.log(LogStatus.INFO,"Step 4: Get EMP_DISC file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(bodyAsString,"ODM", null); // file will be exported with txt format
        String empDiscName = dWHServices.getFileNameContain(fileNames, testData.getContainText());
        System.out.println("filename " + empDiscName);

        logger.log(LogStatus.INFO,"Step 5: Waiting for EMP_DISC file name displays in SFTP");
        boolean result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + empDiscName);
        Assert.assertTrue(result);
        File filename = SftpUtils.getFile(DEVSWARMEXPORTDWH, "download", empDiscName);

        logger.log(LogStatus.INFO,"Step 6: Parse EMP_DISC file to model");
        CSVParser clientParser = CsvUtil.readCSVRecords(filename, ',', false);
        CsvAnnotationMapper<EmployeeDisciplineModel> employeeMapper = new CsvAnnotationMapper<>(EmployeeDisciplineModel.class);
        List<EmployeeDisciplineModel> employeeCsvData = employeeMapper.map(clientParser);
        clientParser.close();

        logger.log(LogStatus.INFO,"Step 7: Query database");
        String sqlStatement = String.format(sql_getEmployeeDisc, employeeFName, employeeLName, account);
        ResultSet resultSetFromQuery = DbUtilsCon.getResultSetFromQuery(
                DbUtilsCon.createConnection(environment.getOracleUrl(), environment), sqlStatement);
        ColumnAnnotationMapper<EmployeeDisciplineModel> mapper = new ColumnAnnotationMapper<>(EmployeeDisciplineModel.class);
        List<EmployeeDisciplineModel> employeeDbRecords = mapper.map(resultSetFromQuery);

        logger.log(LogStatus.INFO,"Step 8: Compare data in csv and db");
        Assert.assertEquals(employeeDbRecords.size(), 1);
        Assert.assertTrue(CompareUtil.dataContains(employeeCsvData, employeeDbRecords));

        logger.log(LogStatus.INFO,"Step 9: Verify CSV format");
        EmployeeDisciplineModel.verifyFormatFieldOfData(employeeDbRecords);

        logger.log(LogStatus.INFO,"Step 10: Verify provider id max length");
        List <EmployeeDisciplineModel> altEmployeeCsvData = getListForASpecificUniqueKey(testData.getValue("ProviderIdMaxLength"), employeeCsvData);
        Assert.assertNotEquals(altEmployeeCsvData.size(), 0);
    }
}
