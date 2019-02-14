package OpenEVV.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;

//To validate the Account field formats/values under Client Phone & ClientAddress

public class TC90114_Client_Account extends BaseTest{


	// Case-1 Testing Account field with null
	@Test(priority=1)
	public void TC90114_OpenEVV_invalid_Account_field_with_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90114_OpenEVV_invalid_Account_field_with_null"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		//js.put("Account",CommonMethods.generateRandomAlphaNumeric(8));
		js.put("Account", null);

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString1.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}
	// Case-2 Testing with invalid Account field with >10 digit number 
	@Test(priority=2)
	public void TC90114_OpenEVV_invalid_Account_more_than_10digit() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90114_OpenEVV_invalid_Account_more_than_10digit"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomStringOfFixLength(11));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString1.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}
	// Case-3 Testing with invalid Account with alphanumeric.
	@Test(priority=3)
	public void TC90114_OpenEVV_invalid_Account_with_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90114_OpenEVV_invalid_Account_with_Alphanumeric"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString1.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}
	// Case-4 Testing with invalid Account field with Non numeric
	@Test(priority=4)
	public void TC90114_OpenEVV_valid_Account_with_Non_numeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90114_OpenEVV_valid_Account_with_Non_numeric"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString1.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}
	// Case-5 Testing with invalid Account field with trailing space
	@Test(priority=5)
	public void TC90114_OpenEVV_valid_Account_with_trailing_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90114_OpenEVV_valid_Account_with_trailing_space"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", " " + CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString1.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}

}
