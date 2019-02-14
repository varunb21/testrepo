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

public class TC88335_EmpPhone extends BaseTest {

	//To validate the valid numeric EmployeePhone length
	@Test
	public void TC88335_OpenEVV_valid_numeric_EmployeePhone() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88335_OpenEVV_valid_numeric_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid EmployeePhone length more than 10
	@Test
	public void TC88335_OpenEVV_invalid_EmployeePhone_exceeding_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88335_OpenEVV_invalid_EmployeePhone_exceeding_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(12));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));
	}

	//To validate the invalid EmployeePhone length less than 10
	@Test
	public void TC88335_OpenEVV_EmployeePhone_less_than_min_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88335_OpenEVV_EmployeePhone_less_than_min_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));
	}

	//To validate the EmployeePhone with alphanumeric value
	@Test
	public void TC88335_OpenEVV_alphanumeric_EmployeePhone() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88335_OpenEVV_alphanumeric_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));
	}

	//To validate the EmployeePhone with non numeric value
	@Test
	public void TC88335_OpenEVV_nonnumeric_EmployeePhone() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88335_OpenEVV_nonnumeric_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));
	}

	//To validate the EmployeePhone with leading space
	@Test
	public void TC88335_OpenEVV_leading_space_EmployeePhone() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88335_OpenEVV_leading_space_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", " " + CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));

	}

	//To validate the EmployeePhone with trailing space
	@Test
	public void TC88335_OpenEVV_trailing_space_EmployeePhone() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88335_OpenEVV_trailing_space_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(9) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));

	}

	//To validate the EmployeePhone with leading zero
	@Test
	public void TC88335_OpenEVV_leading_zero_EmployeePhone() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88335_OpenEVV_leading_zero_EmployeePhone");

		//Using Reusable method to load Employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", "0" + CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the EmployeePhone with special character
	@Test
	public void TC88335_OpenEVV_specialCharacter_EmployeePhone() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88335_OpenEVV_specialCharacter_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));

	}

}