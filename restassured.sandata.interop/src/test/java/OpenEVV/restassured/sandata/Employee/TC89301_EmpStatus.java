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

//Test Case 89301:Open EVV - Employee - Validate Status field Format

public class TC89301_EmpStatus extends BaseTest{

	//To validate the valid Employee status
	@Test(groups = {"functest"})
	public void TC89301_OpenEVV_valid_EmpStatus() throws IOException, ParseException, ConfigurationException
	{

		logger = extent.startTest("TC89301_OpenEVV_valid_EmpStatus"); 
		 
		logger.log(LogStatus.INFO, "To validate the valid Employee status");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", "");
		

		logger.log(LogStatus.INFO, "Passing status as no value ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the null Employee status
	@Test(groups = {"functest"})
	public void TC89301_OpenEVV_null_EmpStatus() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89301_OpenEVV_null_EmpStatus"); 
		 
		logger.log(LogStatus.INFO, "To validate the null Employee status");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", null);
		logger.log(LogStatus.INFO, "Passing Status as  null");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));


		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the missing Employee status
	@Test(groups = {"functest"})
	public void TC89301_OpenEVV_missing_EmpStatus() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89301_OpenEVV_missing_EmpStatus"); 
		 
		logger.log(LogStatus.INFO, "To validate the missing Employee status");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status"," ");
		logger.log(LogStatus.INFO, "Passing Status as blank ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Status expected format is not correct."));
	}


}