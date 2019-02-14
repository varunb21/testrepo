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

//Test Case 88852:Open EVV-Worker-Validate (mix) - EmployeeSocialSecurity field formats/values

public class TC88852_EmpSSN extends BaseTest{


	//To validate the valid emp ssn length
	@Test
	public void TC88852_OpenEVV_valid_EmpSSN_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88852_OpenEVV_valid_EmpSSN_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid emp ssn length more
	@Test
	public void TC88852_OpenEVV_invalid_exceeding_EmpSSN_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88852_OpenEVV_invalid_exceeding_EmpSSN_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

				logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity value exceeds the maximum length of 9 characters.  The record is being rejected. The length should be between 0 and 9."));
	}

	//To validate the invalid emp ssn length less
	@Test
	public void TC88852_OpenEVV_invalid_less_EmpSSN_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88852_OpenEVV_invalid_less_EmpSSN_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

				logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the ssn with alphanumeric value
	@Test
	public void TC88852_OpenEVV_invalid_alphanumeric_EmpSSN() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88852_OpenEVV_invalid_alphanumeric_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomAlphaNumeric(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

			logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the emp ssn with non numeric value
	@Test
	public void TC88852_OpenEVV_invalid_nonnumeric_EmpSSN() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88852_OpenEVV_invalid_nonnumeric_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomStringOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

			logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the emp ssn with leading whitespace
	@Test
	public void TC88852_OpenEVV_invalid_leading_space_EmpSSN() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88852_OpenEVV_invalid_leading_space_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", " " + CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the emp ssn with trailing whitespace
	@Test
	public void TC88852_OpenEVV_invalid_trailing_space_EmpSSN() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88852_OpenEVV_invalid_trailing_space_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(8) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the emp ssn with leading whitespace
	@Test
	public void TC88852_OpenEVV_valid_leading_zero_EmpSSN() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88852_OpenEVV_valid_leading_zero_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", "0" + CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the emp ssn with special character
	@Test
	public void TC88852_OpenEVV_invalid_specialCharacter_EmpSSN() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88852_OpenEVV_invalid_specialCharacter_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(8) + CommonMethods.generateSpecialChar(1));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the emp ssn with dash character
	@Test
	public void TC88852_OpenEVV_dashCharacter_EmpSSN() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88852_OpenEVV_dashCharacter_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(4) + "-" + CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

}