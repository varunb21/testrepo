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

//Test Case 89302:Open EVV - Employee - Validate EmployeeGender field/format

public class TC89302_EmpGender extends BaseTest{

	//To validate the 'M' Employee gender
	@Test(groups = {"functest"})
	public void TC89302_OpenEVV_valid_EmpGender_M() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89302_OpenEVV_valid_EmpGender_M"); 
		 
		logger.log(LogStatus.INFO, "To validate the 'M' Employee gender");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);


		logger.log(LogStatus.INFO, "Passing EmployeeGender as Male ");
        logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		js.put("EmployeeGender", DataGeneratorEmployee.gender[0]);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the 'F' Employee gender
	@Test(groups = {"functest"})
	public void TC89302_OpenEVV_valid_EmpGender_F() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89302_OpenEVV_valid_EmpGender_F"); 
		 
		logger.log(LogStatus.INFO, "To validate the 'F' Employee gender");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);

		logger.log(LogStatus.INFO, "Passing EmployeeGender as F ");
        logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		js.put("EmployeeGender", DataGeneratorEmployee.gender[1]);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the 'O' Employee gender
	@Test(groups = {"functest"})
	public void TC89302_OpenEVV_valid_EmpGender_O() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89302_OpenEVV_valid_EmpGender_O"); 
		 
		logger.log(LogStatus.INFO, "To validate the 'O' Employee gender");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);

		logger.log(LogStatus.INFO, "Passing EmployeeGender as 0");
        logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		js.put("EmployeeGender", DataGeneratorEmployee.gender[2]);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the numeric Employee gender
	@Test(groups = {"functest"})
	public void TC89302_OpenEVV_invalid_numeric_Gender() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89302_OpenEVV_invalid_numeric_Gender"); 
		 
		logger.log(LogStatus.INFO, "To validate the numeric Employee gender");// adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeGender",CommonMethods.generateRandomNumberOfFixLength(1));
		logger.log(LogStatus.INFO, "Passing EmployeeGender as number ");
  
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeGender expected format is not correct."));
	}

	//To validate the special char Employee gender
	@Test(groups = {"functest"})
	public void TC89302_OpenEVV_invalid_special_char_EmpGender() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89302_OpenEVV_invalid_special_char_EmpGender"); 
		 
		logger.log(LogStatus.INFO, "To validate the special char Employee gender");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeGender", CommonMethods.generateSpecialChar(1));
		logger.log(LogStatus.INFO, "Passing EmployeeGender as special character");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeGender expected format is not correct."));
	}


}