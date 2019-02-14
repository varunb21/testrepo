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

/**
 * @author MayankM
 *
 */

//Test Case 88333:Open EVV-Worker-Validate (mix) - EmployeeZipCode field formats/values

public class TC88333_EmpZipCode extends BaseTest{

	//To validate the valid numeric EmployeeZipCode 
	@Test
	public void TC88333_OpenEVV_Emp_valid_numeric_ZipCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88333_OpenEVV_Emp_valid_numeric_ZipCode");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid dash EmployeeZipCode 
	@Test
	public void TC88333_OpenEVV_Emp_valid_dash_ZipCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88333_OpenEVV_Emp_valid_dash_ZipCode");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomNumberOfFixLength(5)+ "-" + CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
	logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid EmployeeZipCode length
	@Test
	public void TC88333_OpenEVV_Emp_invalid_ZipCode_length() throws IOException, ParseException, ConfigurationException
	{	
		logger = extent.startTest("TC88333_OpenEVV_Emp_invalid_ZipCode_length");
	
		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomNumberOfFixLength(7));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));
	}

	//To validate the EmployeeZipCode with alphanumeric value
	@Test
	public void TC88333_OpenEVV_Emp_invalid_alphanumeric_ZipCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88333_OpenEVV_Emp_invalid_alphanumeric_ZipCode");

		//Using Reusable method to load Employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomAlphaNumeric(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));
	}

	//To validate the EmployeeZipCode with non numeric value
	@Test
	public void TC88333_OpenEVV_Emp_invalid_nonnumeric_ZipCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88333_OpenEVV_Emp_invalid_nonnumeric_ZipCode");

		//Using Reusable method to load Employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomStringOfFixLength(5));

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));
	}

	//To validate the EmployeeZipCode with leading space
	@Test
	public void TC88333_OpenEVV_Emp_invalid_leading_space_ZipCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88333_OpenEVV_Emp_invalid_leading_space_ZipCode");

		//Using Reusable method to load Employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", " " + CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));

	}

	//To validate the EmployeeZipCode with leading zero
	@Test
	public void TC88333_OpenEVV_Emp_valid_leading_zero_ZipCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88333_OpenEVV_Emp_valid_leading_zero_ZipCode");

		//Using Reusable method to load Employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", "0" + CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the EmployeeZipCode with trailing space
	@Test
	public void TC88333_OpenEVV_Emp_invalid_trailing_space_ZipCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88333_OpenEVV_Emp_invalid_trailing_space_ZipCode");

		//Using Reusable method to load Employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomNumberOfFixLength(4) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));

	}

	//To validate the EmployeeZipCode with special character
	@Test
	public void TC88333_OpenEVV_Emp_specialCharacter_ZipCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88333_OpenEVV_Emp_specialCharacter_ZipCode");

		//Using Reusable method to load Employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode","99999-33" );

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));

	}

}