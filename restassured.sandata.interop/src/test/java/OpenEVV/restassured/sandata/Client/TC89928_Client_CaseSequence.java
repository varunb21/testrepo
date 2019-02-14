package OpenEVV.restassured.sandata.Client;

import static io.restassured.RestAssured.given;
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
import io.restassured.response.Response;

//Test Case 89928:Open EVV-Client-Validate (mix) - CaseSequence field formats/values
public class TC89928_Client_CaseSequence extends BaseTest
{	

	//case 1---- - valid value and format:- CaseSequence= "1234"   (invalid Case)
	@Test
	public void TC89928_OpenEVV_CaseSequence_valid_case_1() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89928_OpenEVV_CaseSequence_valid_case_1"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", "1234");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		//	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//	
		//	Assert.assertTrue(bodyAsString.contains( "The ClientMedicalRecordNumber length is invalid. The length should be between 0 and 12."));
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 2---- - valid value and format:- CaseSequence= "1e23"   (valid Case)
	@Test
	public void TC89928_OpenEVV_CaseSequence_valid_case_2() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89928_OpenEVV_CaseSequence_valid_case_2"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", "1234");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		//	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//	
		//	Assert.assertTrue(bodyAsString.contains( "The ClientMedicalRecordNumber length is invalid. The length should be between 0 and 12."));
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 3---- - valid value and format:- - CaseSequence= ">4 digits"  (invalid Case)
	@Test
	public void TC89928_OpenEVV_CaseSequence_invalid_case_1() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89928_OpenEVV_CaseSequence_invalid_case_1"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", "121223");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The CaseSequence length is invalid. The length should be between 0 and 4."));
		//	Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		//	Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 4---- - valid value and format:- - CaseSequence= "121##"   (Any Combination)  (invalid Case)
	@Test
	public void TC89928_OpenEVV_CaseSequence_invalid_case_2() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89928_OpenEVV_CaseSequence_invalid_case_2"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", "12@@##1223");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The CaseSequence length is invalid. The length should be between 0 and 4."));
		//	Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		//	Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 5---- - leading spaces:- CaseSequence = "  1234"    (invalid Case)
	@Test
	public void TC89928_OpenEVV_CaseSequence_invalid_case_3() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89928_OpenEVV_CaseSequence_invalid_case_2"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", " 1234");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The CaseSequence length is invalid. The length should be between 0 and 4."));
		//	Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		//	Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 6---- - trailing spaces:- CaseSequence = "1234 "    (invalid Case)
	@Test
	public void TC89928_OpenEVV_CaseSequence_invalid_case_4() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89928_OpenEVV_CaseSequence_invalid_case_4"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", "1234 ");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The CaseSequence length is invalid. The length should be between 0 and 4."));
		//	Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		//	Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}
}
