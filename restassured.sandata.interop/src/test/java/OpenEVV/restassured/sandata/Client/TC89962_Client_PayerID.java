package OpenEVV.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;

//Open EVV-Client-Validate (mix) - PayerID field formats/values

public class TC89962_Client_PayerID extends BaseTest{

	// Case-1 Testing with valid PayerID format
	@Test(priority=1)
	public void TC89962_OpenEVV_Client_PayerID_validcombination() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89962_OpenEVV_Client_PayerID_validcombination"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("PayerID", "Y812182O");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}
	// Case-2 Testing with PayerID null
	@Test(priority=2)
	public void TC89962_OpenEVV_Client_PayerID_NULL() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89962_OpenEVV_Client_PayerID_NULL"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("PayerID", null);

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The PayerID cannot be null."));
	}
	// Case-3 Testing with invalid format
	@Test(priority=3)
	public void TC89962_OpenEVV_Client_PayerID_Headingspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89962_OpenEVV_Client_PayerID_Headingspace"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("PayerID", " 12212UE");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The PayerID format is incorrect."));
	}
	// Case-4 Testing with invalid format >64 chars 
	@Test(priority=4)
	public void TC89962_OpenEVV_Client_PayerID_charlength() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89962_OpenEVV_Client_PayerID_charlength"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("PayerID", "95395953959753975395397539753975597397975843257325325732753753275297532975422759329752975327952");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The PayerID length is invalid. The length should be between 1 and 64."));
	}
	// Case-5 Testing with invalid format and space combinations. 
	@Test(priority=4)
	public void TC89962_OpenEVV_Client_PayerID_Leadingspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89962_OpenEVV_Client_PayerID_Leadingspace"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("PayerID", "12212UE ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The PayerID format is incorrect."));
	}
	// Case-6 Testing with invalid format and with special symbols. 
	@Test(priority=4)
	public void TC89962_OpenEVV_Client_PayerID_with_dashes() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89962_OpenEVV_Client_PayerID_with_dashes"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("PayerID", "1-2212UE");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The PayerID format is incorrect."));
	}
}
