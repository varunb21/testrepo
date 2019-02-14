package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 88854:Open EVV-Worker-Validate (mix) - Department field formats/values

public class TC88854_EmpDepartment extends BaseTest{

	//To validate the valid emp department length
	@Test
	public void TC88854_OpenEVV_valid_EmpDept_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88854_OpenEVV_valid_EmpDept_length");

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", DataGeneratorEmployee.generateEmpDept(3));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid emp department length 
	@Test
	public void TC88854_OpenEVV_invalid_more_EmpDept_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88854_OpenEVV_invalid_more_EmpDept_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", DataGeneratorEmployee.generateEmpDept(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Department value exceeds the maximum length of 3 characters.  The record is being rejected. The length should be between 0 and 3."));
	}

	//To validate the emp department with non numeric value
	@Test
	public void TC88854_OpenEVV_nonnumeric_EmpDept() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88854_OpenEVV_nonnumeric_EmpDept");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", CommonMethods.generateRandomStringOfFixLength(1));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the emp department with numeric value
	@Test
	public void TC88854_OpenEVV_numeric_EmpDept() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88854_OpenEVV_numeric_EmpDept");

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", CommonMethods.generateRandomNumberOfFixLength(2));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the emp department with leading whitespace
	@Test
	public void TC88854_OpenEVV_leading_space_EmpDept() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88854_OpenEVV_leading_space_EmpDept");
		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", " " + DataGeneratorEmployee.generateEmpDept(2));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Department expected format is not correct."));
	}

	//To validate the emp department with trailing whitespace
	@Test
	public void TC88854_OpenEVV_trailing_space_EmpDept() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88854_OpenEVV_trailing_space_EmpDept");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", DataGeneratorEmployee.generateEmpDept(2) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Department expected format is not correct."));
	}

	//To validate the emp department with leading zero
	@Test
	public void TC88854_OpenEVV_leading_zero_EmpDept() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88854_OpenEVV_leading_zero_EmpDept");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", "0" + DataGeneratorEmployee.generateEmpDept(2));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
	logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the emp department with special character
	@Test
	public void TC88854_OpenEVV_specialCharacter_EmpDept() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88854_OpenEVV_specialCharacter_EmpDept");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", DataGeneratorEmployee.generateEmpDept(1) + "@");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
	logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("The Department expected format is not correct."));
	}


}