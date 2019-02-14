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

public class TC88337_EmpCity_EmpLoc extends BaseTest {

	//To validate the valid EmployeeCity and Location length
	@Test
	public void TC88337_OpenEVV_valid_EmployeeCity_Loc() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88337_OpenEVV_valid_EmployeeCity_Loc");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeCity", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("EmployeePrimaryLocation", DataGeneratorEmployee.generateEmpPrimaryLoc(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid EmployeeCity and Location length
	@Test
	public void TC88337_OpenEVV_valid_space_EmployeeCity_Loc() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88337_OpenEVV_valid_space_EmployeeCity_Loc");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeCity", CommonMethods.generateRandomStringOfFixLength(4) + " " + CommonMethods.generateRandomStringOfFixLength(4));
		js.put("EmployeePrimaryLocation", DataGeneratorEmployee.generateEmpPrimaryLoc(4) + " " + DataGeneratorEmployee.generateEmpPrimaryLoc(4) );

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid EmployeeCity and Location length
	@Test
	public void TC88337_OpenEVV_invalid_EmployeeCity_Loclength() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88337_OpenEVV_invalid_EmployeeCity_Loclength");

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeCity", CommonMethods.generateRandomStringOfFixLength(32));
		js.put("EmployeePrimaryLocation", DataGeneratorEmployee.generateEmpPrimaryLoc(18));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
	logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeCity value exceeds the maximum length of 30 characters.  The record is being rejected. The length should be between 0 and 30."));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePrimaryLocation value exceeds the maximum length of 15 characters.  The record is being rejected. The length should be between 0 and 15"));
	}

	//To validate the EmployeeCity and Location with alphanumeric value
	@Test
	public void TC88337_OpenEVV_valid_alphanumeric_EmployeeCity_Loc() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88337_OpenEVV_valid_alphanumeric_EmployeeCity_Loc");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeCity", CommonMethods.generateRandomAlphaNumeric(10));
		js.put("EmployeePrimaryLocation", CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
	logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The EmployeeCity expected format is not correct."));
	}

	//To validate the EmployeeCity and Location with numeric value
	@Test
	public void TC88337_OpenEVV_valid_numeric_EmployeeCity_Loc() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88337_OpenEVV_valid_numeric_EmployeeCity_Loc");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeCity", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("EmployeePrimaryLocation", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The EmployeeCity expected format is not correct."));
	}

	//To validate the EmployeeCity and Location with leading space
	@Test
	public void TC88337_OpenEVV_valid_leading_space_EmployeeCity_Loc() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88337_OpenEVV_valid_leading_space_EmployeeCity_Loc");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeCity", " " + CommonMethods.generateRandomStringOfFixLength(10));
		js.put("EmployeePrimaryLocation", " " + DataGeneratorEmployee.generateEmpPrimaryLoc(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the EmployeeCity and Location with trailing space
	@Test
	public void TC88337_OpenEVV_valid_trailing_space_EmployeeCity_Loc() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88337_OpenEVV_valid_trailing_space_EmployeeCity_Loc");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeCity", CommonMethods.generateRandomStringOfFixLength(10) + " ");
		js.put("EmployeePrimaryLocation", DataGeneratorEmployee.generateEmpPrimaryLoc(10) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the EmployeeCity with # character
	@Test
	public void TC88337_OpenEVV_invalid_specialCharacter_EmployeeCity() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88337_OpenEVV_invalid_specialCharacter_EmployeeCity");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeCity", "#" + CommonMethods.generateRandomStringOfFixLength(10));
		js.put("EmployeePrimaryLocation", "#" + DataGeneratorEmployee.generateEmpPrimaryLoc(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeCity expected format is not correct."));

	}

}