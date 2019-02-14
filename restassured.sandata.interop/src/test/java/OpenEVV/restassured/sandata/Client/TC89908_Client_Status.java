package OpenEVV.restassured.sandata.Client;

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

//Test Case 89908:Open EVV-Client-Validate (mix) - Status field/format
public class TC89908_Client_Status extends BaseTest

{	
	//case 1---- - valid value and format:- Status= D (valid Case)
	@Test
	public void TC89908_OpenEVV_Status_valid_case_1() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89908_OpenEVV_Status_valid_case_1"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", "D");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 2---- - valid value and format- Status other than D  (invalid Case)
	@Test
	public void TC89908_OpenEVV_Status_invalid_case_1() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89908_OpenEVV_Status_invalid_case_1"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", "K");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The Status format is incorrect. The record should satisfy this regular expression"));

	}	

	//case 3---- - dashes not allowed:- Status = ">1 digits"   (invalid Case)
	@Test
	public void TC89908_OpenEVV_Status_invalid_case_2() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89908_OpenEVV_Status_invalid_case_2"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", "Dq");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"FAILED\","));
		//	
		Assert.assertTrue(bodyAsString.contains("ERROR: The Status format is incorrect. The record should satisfy this regular expression"));
	}

	//case 4---- - valid value and format:- Status= " D" (invalid Case)
	@Test
	public void TC89908_OpenEVV_Status_invalid_case_3() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89908_OpenEVV_Status_invalid_case_3"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", " D");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The Status format is incorrect. The record should satisfy this regular expression"));
	}

	//case 5---- - valid value and format:- Status= "D " (invalid Case)
	@Test
	public void TC89908_OpenEVV_Status_invalid_case_4() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89908_OpenEVV_Status_invalid_case_4"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", "D ");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The Status format is incorrect. The record should satisfy this regular expression"));

	}
}