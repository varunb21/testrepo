package OpenEVV.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;

//Test Case 92433: Open EVV-Client-Validate ClientPhoneType with valid values Business, Home, Mobile, Other

public class EVV8152_91701_TC92433_ClientContactPhoneType_valid_values extends BaseTest{


	//Case-1 Testing with valid ClientContactPhoneType values and format (Business)
	@Test 
	public void TC92433_OpenEVV_ClientContactPhoneType_validvalue() throws IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		logger = extent.startTest("TC92433_OpenEVV_ClientContactPhoneType_validvalue");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating the valid value Business for ClientContactPhoneType"); 

		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); //loading the Json dynamically with unique value set to check how its working go to the load json and understand the concept
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "Business");

		logger.log(LogStatus.INFO, "Passing ClientContactPhoneType = Business");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//Case-2 Testing with valid ClientContactPhoneType "Home"
	@Test 
	public void TC92433_OpenEVV_ClientContactPhoneType_Home_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC92433_OpenEVV_ClientContactPhoneType_Home_valid"); // adding method name info via logger

		logger.log(LogStatus.INFO, "Validating the valid value for ClientContactPhoneType Home"); // adding what you are verifying

		//json_parser("client") used to load the json file
		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); //loading the Json dynamically with unique value set to check how its working go to the load json and understand the concept

		JSONObject js = (JSONObject) j.get(0);	
		js.put("ClientContactPhoneType", "Home");


		logger.log(LogStatus.INFO, "Passing ClientContactPhoneType = Home");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}
	//Case-3 Testing with valid ClientContactPhoneType "Mobile"
	@Test 
	public void TC92433_OpenEVV_ClientContactPhoneType_Mobile() throws IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		logger = extent.startTest("TC92433_OpenEVV_ClientContactPhoneType_Mobile"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating the valid value for ClientContactPhoneType Mobile"); 

		//json_parser("client") used to load the json file
		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); //loading the Json dynamically with unique value set to check how its working go to the load json and understand the concept

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "Mobile");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}
	//Case-4 Testing with valid ClientContactPhoneType with Other
	@Test 
	public void TC92433_OpenEVV_ClientContactPhoneType_with_Other() throws IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		logger = extent.startTest("TC92433_OpenEVV_ClientContactPhoneType_with_Other"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating the ClientContactPhoneType with Other"); 

		//loading the Json dynamically with unique value set

		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); 
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "Other");

		logger.log(LogStatus.INFO, "Passing ClientContactPhoneType = Other");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}


}
