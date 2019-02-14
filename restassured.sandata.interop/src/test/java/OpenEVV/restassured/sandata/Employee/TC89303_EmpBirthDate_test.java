/**
 * 
 */
package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

// Test Case 89303:Open EVV-Worker-Validate (mix) - EmployeeBirthDate field formats/values

public class TC89303_EmpBirthDate_test extends BaseTest{

	
	//To validate the invalid Emp birth date- mm-dd-yyyy
	@Test
	public void TC89303_OpenEVV_invalid_EmpBirthDate_dash() throws IOException, ParseException
	{
		logger = extent.startTest("TC89303_OpenEVV_invalid_EmpBirthDate_dash"); 

		logger.log(LogStatus.INFO, "To validate the invalid Emp birth date- mm-dd-yyyy");// adding what you are verifing

		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeBirthDate","08-22-2018");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeBirthDate expected format is not correct."));
	}

	//To validate the invalid Emp birth date- mm/dd/yyyy
	@Test
	public void TC89303_OpenEVV_invalid_EmpBirthDate_slash() throws IOException, ParseException
	{
		logger = extent.startTest("TC89303_OpenEVV_invalid_EmpBirthDate_slash"); 

		logger.log(LogStatus.INFO, "To validate the invalid Emp birth date- mm/dd/yyyy");// adding what you are verifing


		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeBirthDate","08/22/2018");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeBirthDate expected format is not correct."));
	}

	//To validate the invalid Emp birth date- ddmmyyyy
	@Test
	public void TC89303_OpenEVV_invalid_EmpBirthDate_date() throws IOException, ParseException
	{
		logger = extent.startTest("TC89303_OpenEVV_invalid_EmpBirthDate_date"); 

		logger.log(LogStatus.INFO, "To validate the invalid Emp birth date- ddmmyyyy");// adding what you are verifing

		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeBirthDate","22082018");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeBirthDate expected format is not correct."));
	}

	//To validate the invalid Emp birth date- dd-mm-yyyy
	@Test
	public void TC89303_OpenEVV_invalid_EmpBirthDate_date_dash() throws IOException, ParseException
	{
		logger = extent.startTest("TC89303_OpenEVV_invalid_EmpBirthDate_date_dash"); 

		logger.log(LogStatus.INFO, "To validate the invalid Emp birth date- dd-mm-yyyy");// adding what you are verifing

		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeBirthDate","22-08-2018");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeBirthDate expected format is not correct."));
	}

	//To validate the invalid Emp birth date- dd/mm/yyyy
	@Test
	public void TC89303_OpenEVV_invalid_EmpBirthDate_date_slash() throws IOException, ParseException
	{
		logger = extent.startTest("TC89303_OpenEVV_invalid_EmpBirthDate_date_slash"); 

		logger.log(LogStatus.INFO, "To validate the invalid Emp birth date- dd/mm/yyyy");// adding what you are verifing


		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeBirthDate","22/08/2018");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeBirthDate expected format is not correct."));
	}

	//To validate the invalid Emp birth date- yyyymmdd
	@Test
	public void TC89303_OpenEVV_invalid_EmpBirthDate_year() throws IOException, ParseException
	{
		logger = extent.startTest("TC89303_OpenEVV_invalid_EmpBirthDate_year"); 

		logger.log(LogStatus.INFO, "To validate the invalid Emp birth date- yyyymmdd");// adding what you are verifing


		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeBirthDate","20180822");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeBirthDate expected format is not correct."));
	}

	//To validate the invalid Emp birth date- yyyy-mm-dd
	@Test
	public void TC89303_OpenEVV_invalid_EmpBirthDate_year_dash() throws IOException, ParseException
	{
		logger = extent.startTest("TC89303_OpenEVV_invalid_EmpBirthDate_year_dash"); 

		logger.log(LogStatus.INFO, "To validate the invalid Emp birth date- yyyy-mm-dd");

		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeBirthDate","2018-08-22");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeBirthDate expected format is not correct."));
	}

	//To validate the invalid Emp birth date- yyyy/mm/dd
	@Test
	public void TC89303_OpenEVV_invalid_EmpBirthDate_year_slash() throws IOException, ParseException
	{
		logger = extent.startTest("TC89303_OpenEVV_invalid_EmpBirthDate_year_slash"); 

		logger.log(LogStatus.INFO, "To validate the invalid Emp birth date- yyyy/mm/dd");

		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeBirthDate","2018/08/22");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeBirthDate expected format is not correct."));
	}

	//To validate the null Emp birth date
	@Test
	public void TC89303_OpenEVV_null_EmpBirthDate_invalid() throws IOException, ParseException
	{
		logger = extent.startTest("TC89303_OpenEVV_null_EmpBirthDate_invalid"); 

		logger.log(LogStatus.INFO, "To validate the null Emp birth date");// adding what you are verifing

		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeBirthDate","null");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeBirthDate expected format is not correct."));
	}

}