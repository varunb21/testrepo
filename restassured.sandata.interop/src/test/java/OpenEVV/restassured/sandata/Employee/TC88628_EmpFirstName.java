package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class TC88628_EmpFirstName extends BaseTest{

	//To validate the valid EmployeeFirstName length
	@Test
	public void TC88628_OpenEVV_valid_EmployeeFirstName() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88628_OpenEVV_valid_EmployeeFirstName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid EmployeeFirstName length more than 30
	@Test
	public void TC88628_OpenEVV_invalid_EmployeeFirstName_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88628_OpenEVV_invalid_EmployeeFirstName_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(32));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName value exceeds the maximum length of 30 characters.  The record is being rejected. The length should be between 1 and 30."));
	}

	//To validate the EmployeeFirstName with alphanumeric value
	@Test
	public void TC88628_OpenEVV_invalid_alphanumeric_EmployeeFirstName() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88628_OpenEVV_invalid_alphanumeric_EmployeeFirstName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName expected format is not correct."));
	}

	//To validate the EmployeeFirstName with numeric value
	@Test
	public void TC88628_OpenEVV_invalid_numeric_EmployeeFirstName() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88628_OpenEVV_invalid_numeric_EmployeeFirstName");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName expected format is not correct."));
	}

	//To validate the EmployeeFirstName with leading space
	@Test
	public void TC88628_OpenEVV_valid_leading_space_EmployeeFirstName() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88628_OpenEVV_valid_leading_space_EmployeeFirstName");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", " " + CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the EmployeeFirstName with trailing space
	@Test
	public void TC88628_OpenEVV_valid_trailing_space_EmployeeFirstName() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88628_OpenEVV_valid_trailing_space_EmployeeFirstName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the EmployeeFirstName with special character
	@Test
	public void TC88628_OpenEVV_valid_specialCharacter_EmployeeFirstName() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88628_OpenEVV_valid_specialCharacter_EmployeeFirstName");

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10) + "." + "-" +"'");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the EmployeeFirstName with special character other than dot,quote and dash
	@Test
	public void TC88628_OpenEVV_invalid_specialCharacter_EmployeeFirstName() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88628_OpenEVV_invalid_specialCharacter_EmployeeFirstName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName expected format is not correct."));

	}

}