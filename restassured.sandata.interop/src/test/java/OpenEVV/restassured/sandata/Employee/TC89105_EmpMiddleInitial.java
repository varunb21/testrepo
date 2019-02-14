/**
 * 
 */
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

//Test Case 89105:Open EVV-Worker-Validate (mix) - EmployeeMiddleInitial field formats/values

public class TC89105_EmpMiddleInitial extends BaseTest {

	//To validate the valid digit emp middle initial 
	@Test(groups = {"functest"})
	public void TC89105_OpenEVV_valid_digit_EmpMiddleInitial() throws IOException, ParseException
	{
		logger = extent.startTest("TC89105_OpenEVV_valid_digit_EmpMiddleInitial"); 
		 
		logger.log(LogStatus.INFO, "To validate the valid digit emp middle initial ");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeMiddleInitial", CommonMethods.generateRandomNumberOfFixLength(1));
	

		logger.log(LogStatus.INFO, "Passing EmployeeMiddleInitial as fixed Length ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid alpha emp middle initial 
	@Test(groups = {"functest"})
	public void TC89105_OpenEVV_valid_alpha_EmpMiddleInitial() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89105_OpenEVV_valid_alpha_EmpMiddleInitial"); 
		 
		logger.log(LogStatus.INFO, "To validate the valid alpha emp middle initial");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeMiddleInitial", CommonMethods.generateRandomStringOfFixLength(1));
		

		logger.log(LogStatus.INFO, "Passing EmployeeMiddleInitial as alphabet");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the missing emp middle initial length
	@Test(groups = {"functest"})
	public void TC89105_OpenEVV_valid_missing_EmpMiddleInitial() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89105_OpenEVV_valid_missing_EmpMiddleInitial"); 
		 
		logger.log(LogStatus.INFO, "To validate the missing emp middle initial length");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeMiddleInitial", CommonMethods.generateRandomStringOfFixLength(0));
	

		logger.log(LogStatus.INFO, "Passing EmployeeMiddleInitial as random string ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid special character emp middle initial 
	@Test(groups = {"functest"})
	public void TC89105_OpenEVV_invalid_spcl_char_EmpMiddleInitial() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89105_OpenEVV_invalid_spcl_char_EmpMiddleInitial"); 
		 
		logger.log(LogStatus.INFO, "To validate the invalid special character emp middle initial ");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeMiddleInitial", "@");
	

		logger.log(LogStatus.INFO, "Passing EmployeeMiddleInitial as @");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeMiddleInitial expected format is not correct."));
	}

	//To validate the invalid emp middle initial length
	@Test(groups = {"functest"})
	public void TC89105_OpenEVV_invalid_EmpMiddleInitial_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89105_OpenEVV_invalid_EmpMiddleInitial_length"); 
		 
		logger.log(LogStatus.INFO, "To validate the invalid emp middle initial length");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeMiddleInitial", CommonMethods.generateRandomStringOfFixLength(3));
	

		logger.log(LogStatus.INFO, "Passing EmployeeMiddleInitial as invalid ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeMiddleInitial value exceeds the maximum length of 1 characters.  The record is being rejected. The length should be between 0 and 1."));
	}

	//To validate the invalid emp middle initial length
	@Test(groups = {"functest"})
	public void TC89105_OpenEVV_invalid_whitespace_EmpMiddleInitial() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89105_OpenEVV_invalid_whitespace_EmpMiddleInitial"); 
		 
		logger.log(LogStatus.INFO, "To validate the invalid emp middle initial length");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeMiddleInitial", " ");
	

		logger.log(LogStatus.INFO, "Passing EmployeeMiddleInitial as  blank");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeMiddleInitial expected format is not correct."));
	}


}
