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

//Open EVV-Client-Validate (mix) - Area field formats/values

public class TC89964_Client_Area extends BaseTest{

	// Case-1 Testing with invalid Area field formats/values
	@Test(priority=1)
	public void TC89964_OpenEVV_Area_morecharlength() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89964_OpenEVV_Area_morecharlength"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Area","1234");



		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Area length is invalid. The length should be between 0 and 3."));

	}
	// Case-2 Testing with invalid Area field formats/values using spaces
	@Test(priority=2)
	public void TC89964_OpenEVV_Area_Leadingspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89964_OpenEVV_Area_Leadingspace"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Area", "123 ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Area format is incorrect."));
	}
	// Case-3 Testing with invalid Area field formats/values using spaces at End
	@Test(priority=3)
	public void TC89964_OpenEVV_Area_invalidcombinations_with_headingspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89964_OpenEVV_Area_invalidcombinations_with_headingspace"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Area", " 123");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Area format is incorrect."));
	}
	// Case-4 Testing with valid format 
	@Test(priority=4)
	public void TC89964_OpenEVV_Area_validformat() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89964_OpenEVV_Area_validformat"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Area", "12A");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
}
