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
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.IOException;

//To validate the valid ClientLanguage field formats/values

public class TC90078_ClientLanguage extends BaseTest {

	// Case-1 Testing with invalid ClientLanguage field formats/values
	@Test(priority=1)
	public void TC90078_OpenEVV_invalid_ClientLanguage_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90078_OpenEVV_invalid_ClientLanguage_length"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		//js.put("Borough",CommonMethods.generateRandomNumberOfFixLength(2));
		js.put("ClientLanguage", CommonMethods.generateRandomNumberOfFixLength(33));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


				logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientLanguage length is invalid. The length should be between 0 and 32."));
	}

	// Case-2 Testing with passing valid string value in ClientLanguage field formats
	@Test(priority=2)
	public void TC90078_OpenEVV_valid_string_ClientLanguage() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90078_OpenEVV_valid_string_ClientLanguage"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientLanguage", "The list of acceptable values");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

				logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	
	// Case-3 Testing with valid space in ClientLanguage field formats/values
	@Test(priority=3)
	public void TC90078_OpenEVV_valid_tailing_space_ClientLanguage() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90078_OpenEVV_valid_tailing_space_ClientLanguage"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		//	js.put("ClientLanguage", "  English");
		js.put("ClientLanguage", CommonMethods.generateRandomStringOfFixLength(7)+ " ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


				logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	
	// Case-4 Testing with valid format with leading space in ClientLanguage formats/values
	@Test(priority=4)
	public void TC90078_OpenEVV_valid_leading_space_ClientLanguages() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90078_OpenEVV_valid_leading_space_ClientLanguages"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientLanguage",  " " + CommonMethods.generateRandomStringOfFixLength(7));
		   
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


				logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	
	// Case-5 Testing with invalid format with special chars ClientLanguage field formats/values
	@Test(priority=5)
	public void TC90078_OpenEVV_invalid_ClientLanguage_specialchar_format() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90078_OpenEVV_invalid_ClientLanguage_specialchar_format"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientLanguage", CommonMethods.generateSpecialChar(3));
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


				logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientLanguage format is incorrect."));
	}
}
