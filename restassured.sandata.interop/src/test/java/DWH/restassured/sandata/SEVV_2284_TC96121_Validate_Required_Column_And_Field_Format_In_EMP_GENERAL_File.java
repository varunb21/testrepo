package DWH.restassured.sandata;

import Utills_ExtentReport_Log4j.BaseTest;
import com.DWExtractModels.Employee.EmployeeGeneralModel;
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
import java.util.Collections;
import java.util.List;

import static com.constant.Constant.CONS_UTC_DATE_TIME_FORMAT;
import static com.sftp.utils.SftpUtils.DEVSWARMEXPORTDWH;
import static com.sql.SQL.sql_getEmployeeGeneral;
import static com.utilities.DbUtilsCon.getListForASpecificName;

public class SEVV_2284_TC96121_Validate_Required_Column_And_Field_Format_In_EMP_GENERAL_File extends BaseTest {
    private String employeeFName;
    private String employeeLName;
    private String secondEmployeeFName;
    private String secondEmployeeLName;
    private String altEmployeeFName;
    private String altEmployeeLName;
    private String employeeUrl;
    private JSONArray jsonArray;
    private JSONObject jsonObject;

    @BeforeClass
    public void PreCondition() throws IOException, ParseException {
        employeeUrl = environment.getCreate_employee();
        jsonArray= generateDataEntities.GenerateEmployeeData_OpenEVV(globalVariables.emp_openevv_Json, testData.getAccId());
        jsonObject = (JSONObject) jsonArray.get(0);
        jsonObject.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(30));
        jsonObject.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(30));
        jsonObject.put("PayRate", "4.284");
        jsonObject.put("EmployeePrimaryLocation", CommonMethods.generateRandomStringOfFixLength(15));
        jsonObject.put("EmployeeHireDate", testData.getValue("MinDate"));
        jsonObject.put("EmployeeBirthDate", testData.getValue("MinDate"));

        employeeFName = jsonObject.get(globalVariables.EmployeeFirstName).toString();
        employeeLName = jsonObject.get(globalVariables.EmployeeLastName).toString();
        webServicesBase.sendPOSTEmployeeEVV(
                employeeUrl,
                jsonArray,
                environment,
                testData);

        jsonArray = generateDataEntities.GenerateEmployeeData_OpenEVV(globalVariables.emp_openevv_Json, testData.getAccId());
        jsonObject = (JSONObject) jsonArray.get(0);
        jsonObject.put("EmployeeEndDate", testData.getValue("MaxHireDate"));
        jsonObject.put("EmployeeHireDate", testData.getValue("MaxHireDate"));
        secondEmployeeFName = jsonObject.get(globalVariables.EmployeeFirstName).toString();
        secondEmployeeLName = jsonObject.get(globalVariables.EmployeeLastName).toString();

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
        altEmployeeFName = jsonAltEmployeeObject.get(globalVariables.EmployeeFirstName).toString();
        altEmployeeLName = jsonAltEmployeeObject.get(globalVariables.EmployeeLastName).toString();

        employeeUrl = environment.getAlt_evv_emp();
        webServicesBase.sendPOSTEmployeeAtlEVV(
                employeeUrl,
                jsonAltEmployeeArray,
                environment,
                testData,
                testData.getValue("AccProMaxLength"));
    }

    @Test
    public void SEVV_2284_TC96121_Validate_Required_column_and_field_format_in_EMP_GENERAL_file() throws Exception {
        logger = extent.startTest("SEVV_2284_TC96121_Validate_Required_Column_And_Field_Format_In_EMP_GENERAL_File");
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

        logger.log(LogStatus.INFO,"Step 4: Get EMP_GENERAL file name");
        List<String> fileNames = dWHServices.getFileNamesInExportEVV(bodyAsString,"ODM", null); // file will be exported with txt format
        String empGeneralName = dWHServices.getFileNameContain(fileNames, testData.getContainText());

        logger.log(LogStatus.INFO,"Step 5: Waiting for EMP_GENERAL file name displays in SFTP");
        boolean result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + empGeneralName);
        Assert.assertTrue(result);
        File filename = SftpUtils.getFile(DEVSWARMEXPORTDWH, "download", empGeneralName);

        logger.log(LogStatus.INFO,"Step 6: Parse EMP_GENERAL file to model");
        CSVParser clientParser = CsvUtil.readCSVRecords(filename, ',', false);
        CsvAnnotationMapper<EmployeeGeneralModel> employeeMapper = new CsvAnnotationMapper<>(EmployeeGeneralModel.class);
        List<EmployeeGeneralModel> employeeCsvData = employeeMapper.map(clientParser);
        clientParser.close();

        logger.log(LogStatus.INFO,"Step 7: Query database");
        String sqlStatement = String.format(sql_getEmployeeGeneral, employeeFName, employeeLName, account);
        ResultSet resultSetFromQuery = DbUtilsCon.getResultSetFromQuery(
                DbUtilsCon.createConnection(environment.getOracleUrl(), environment), sqlStatement);
        ColumnAnnotationMapper<EmployeeGeneralModel> mapper = new ColumnAnnotationMapper<>(EmployeeGeneralModel.class);
        List<EmployeeGeneralModel> employeeDbRecords = mapper.map(resultSetFromQuery);

        logger.log(LogStatus.INFO,"Step 8: Compare data in csv and db");
        List<EmployeeGeneralModel> altEmployeeCsvData = getListForASpecificName(altEmployeeFName, altEmployeeLName, employeeCsvData);
        List<EmployeeGeneralModel> secondEmployeeCsvData = getListForASpecificName(secondEmployeeFName, secondEmployeeLName, employeeCsvData);
        Assert.assertEquals(secondEmployeeCsvData.size(), 1);
        Assert.assertEquals(secondEmployeeCsvData.size(), 1);
        employeeCsvData = getListForASpecificName(employeeFName, employeeLName, employeeCsvData);
        EmployeeGeneralModel.formatDataInDb(employeeDbRecords);
        Assert.assertEquals(employeeCsvData.size(), 1);
        Assert.assertEquals(employeeDbRecords.size(), 1);

        List<String> ignoreField = Collections.singletonList("employeeHireDate");
        Assert.assertTrue(CompareUtil.dataCompareWithExclusionOfFields(employeeCsvData, employeeDbRecords, ignoreField));
        Assert.assertEquals(employeeCsvData.get(0).getEmployeeHireDate(), "1900-01-01");
        Assert.assertEquals(secondEmployeeCsvData.get(0).getEmployeeHireDate(), "2079-06-06");

        logger.log(LogStatus.INFO,"Step 9: Verify CSV format");
        EmployeeGeneralModel.verifyFormatFieldOfData(employeeCsvData);

        logger.log(LogStatus.INFO,"Step 10: Verify provider id max length");
        Assert.assertEquals(altEmployeeCsvData.get(0).getProviderID(), testData.getValue("ProviderIdMaxLength"));
    }
}
