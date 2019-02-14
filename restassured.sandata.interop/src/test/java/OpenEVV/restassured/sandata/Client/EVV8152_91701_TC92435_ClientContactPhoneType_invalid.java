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

//Test Case 92435: Open EVV-Client-Validate  - ClientContactPhoneType field/format with Incorrect values

public class EVV8152_91701_TC92435_ClientContactPhoneType_invalid extends BaseTest{


	//Case-1 Testing with invalid ClientContactPhoneType values and format (XYZ)
	@Test 
	public void TC92435_OpenEVV_ClientContactPhoneType_Invalidvalue() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92435_OpenEVV_ClientContactPhoneType_Invalidvalue"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating the invalid value = XYZ for ClientContactPhoneType"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); 
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "XYZ");

		logger.log(LogStatus.INFO, "Passing ClientContactPhoneType = XYZ");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientContactPhoneType format is incorrect."));		
	}
	//Case-2 Testing with invalid ClientContactPhoneType Heading space
	@Test 
	public void TC92435_OpenEVV_ClientContactPhoneType_Headingspaces_invalid() throws IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		logger = extent.startTest("TC92435_OpenEVV_ClientContactPhoneType_Headingspaces_invalid"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating the invalid value for ClientContactPhoneType with heading space"); 

		//json_parser("client") used to load the json file
		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); 

		//loading the Json dynamically with unique value set to check
		JSONObject js = (JSONObject) j.get(0);	
		js.put("ClientContactPhoneType", " Home");


		logger.log(LogStatus.INFO, "Passing ClientContactPhoneType with heading spaces");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientContactPhoneType format is incorrect."));

	}
	//Case-3 Testing with invalid ClientContactPhoneType Leading space
	@Test 
	public void TC92435_OpenEVV_ClientContactPhoneType_Leading_space() throws IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		logger = extent.startTest("TC92435_OpenEVV_ClientContactPhoneType_Leading_space"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating the invalid value for ClientContactPhoneType with leading spaces"); 

		//json_parser("client") used to load the json file
		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); //loading the Json dynamically with unique value set to check how its working go to the load json and understand the concept

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "Mobile ");

		logger.log(LogStatus.INFO, "Passing ClientContactPhoneType with leading spaces");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientContactPhoneType format is incorrect."));

	}
	//Case-4 Testing with invalid ClientContactPhoneType with null
	@Test 
	public void TC92435_OpenEVV_ClientContactPhoneType_with_null() throws IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		logger = extent.startTest("TC92435_OpenEVV_ClientContactPhoneType_with_null"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating the ClientContactPhoneType with null"); 

		//json_parser("client") used to load the json file
		//loading the Json dynamically with unique value set
		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); 

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "null");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientContactPhoneType format is incorrect."));

	}


}
