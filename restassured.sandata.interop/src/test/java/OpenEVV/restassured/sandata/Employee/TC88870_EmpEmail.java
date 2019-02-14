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

//Test Case 88870:Open EVV-Employee-Validate (mix) - EmployeeEmailAddress field formats/values

public class TC88870_EmpEmail extends BaseTest{

	//To validate the valid emp email 
	@Test
	public void TC88870_OpenEVV_valid_alphanumeric_EmpEmail() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88870_OpenEVV_valid_alphanumeric_EmpEmail"); 
		logger.log(LogStatus.INFO, "To validate the valid emp email");
		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmailAddress", DataGeneratorEmployee.generateEmpEmail(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		
		//Using Assert to validate the expected result
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid emp email length 
	@Test
	public void TC88870_OpenEVV_invalid_EmpEmail_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88870_OpenEVV_invalid_EmpEmail_length");
		logger.log(LogStatus.INFO, "To validate the invalid emp email length");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmailAddress", DataGeneratorEmployee.generateEmpEmail(52));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		//Using Assert to validate the expected result
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeEmailAddress value exceeds the maximum length of 50 characters.  The record is being rejected. The length should be between 0 and 50."));
	}

	//To validate the valid numeric emp email 
	@Test
	public void TC88870_OpenEVV_valid_numeric_EmpEmail() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88870_OpenEVV_valid_numeric_EmpEmail");
		logger.log(LogStatus.INFO, "To validate the valid numeric emp email");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmailAddress", CommonMethods.generateRandomNumberOfFixLength(10)+ "@sandata.com");
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		//Using Assert to validate the expected result
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid nonnumeric emp email 
	@Test
	public void TC88870_OpenEVV_valid_nonnumeric_EmpEmail() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88870_OpenEVV_valid_nonnumeric_EmpEmail");
		logger.log(LogStatus.INFO, "To validate the valid nonnumeric emp email");
		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmailAddress", CommonMethods.generateRandomStringOfFixLength(10) + "@sandata.com");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid emp email 
	@Test
	public void TC88870_OpenEVV_invalid_EmpEmail() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88870_OpenEVV_invalid_EmpEmail");
		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmailAddress", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeEmailAddress expected format is not correct."));
	}

	//To validate the invalid domain emp email 
	@Test
	public void TC88870_OpenEVV_invalid_domain_EmpEmail() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88870_OpenEVV_invalid_domain_EmpEmail");
		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmailAddress", CommonMethods.generateRandomStringOfFixLength(10) +"@sandata");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeEmailAddress expected format is not correct."));
	}


}