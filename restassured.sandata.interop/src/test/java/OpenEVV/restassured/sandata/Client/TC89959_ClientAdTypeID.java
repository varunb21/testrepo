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

//Open EVV-Client-Validate (mix) - ClientAdTypeID field formats/values

public class TC89959_ClientAdTypeID extends BaseTest{

	// Case-1 Testing with valid format
	@Test(priority=1)
	public void TC89959_OpenEVV_ClientAdTypeID_validcombination() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89959_OpenEVV_ClientAdTypeID_validcombination"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAdTypeID", "796123");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}
	// Case-2 Testing with invalid format
	@Test(priority=2)
	public void TC89959_OpenEVV_ClientAdTypeID_Numeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89959_OpenEVV_ClientAdTypeID_Numeric"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAdTypeID", "79612873437");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientAdTypeID length is invalid. The length should be between 0 and 6."));
	}
	// Case-3 Testing with valid format and combinations
	@Test(priority=3)
	public void TC89959_OpenEVV_ClientAdTypeID_Alphabet() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89959_OpenEVV_ClientAdTypeID_Alphabet"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAdTypeID", "SDDSDS");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	// Case-4 Testing with invalid format and special symbols combination. 
	@Test(priority=4)
	public void TC89959_OpenEVV_ClientAdTypeID_with_specialchars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89959_OpenEVV_ClientAdTypeID_with_specialchars"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAdTypeID", "##SDDSDS@@");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientAdTypeID format is incorrect."));
	}
	// Case-5 Testing with invalid format and space combinations. 
	@Test(priority=4)
	public void TC89959_OpenEVV_ClientAdTypeID_with_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89959_OpenEVV_ClientAdTypeID_with_leading_space"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAdTypeID", "SDDSDS ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientAdTypeID format is incorrect."));
	}
	// Case-6 Testing with invalid format and with space combination. 
	@Test(priority=4)
	public void TC89959_OpenEVV_ClientAdTypeID_headingspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89959_OpenEVV_ClientAdTypeID_headingspace"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAdTypeID", " SDDSDS");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientAdTypeID format is incorrect."));
	}
}
