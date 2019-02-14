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

//To validate the valid Branch field formats/values

public class TC90068_Client_Branch extends BaseTest {

	// Case-1 Testing with invalid Branch field formats/values
	@Test(priority=1)
	public void TC90068_OpeneEVV_Client_Branch_invalidformat() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90068_OpeneEVV_Client_Branch_invalidformat");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		//js.put("Borough",CommonMethods.generateRandomNumberOfFixLength(2));
		js.put("Branch", "14A");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Branch length is invalid. The length should be between 0 and 2."));

	}

	// Case-2 Testing with valid Branch field formats/values
	@Test(priority=2)
	public void TC90068_OpeneEVV_Client_Branch_validfieldcombination() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90068_OpeneEVV_Client_Branch_validfieldcombination");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("Branch", "AB");
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-3 Testing with valid numeric Branch field formats/values
	@Test(priority=3)
	public void TC90068_OpeneEVV_Client_Branch_validcombinationswithnumber() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90068_OpeneEVV_Client_Branch_validcombinationswithnumber");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("Branch", "41");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-4 Testing with invalid format with space and numeric Branch field formats/values
	@Test(priority=4)
	public void TC90068_OpeneEVV_Client_Branch_invalidformatwithspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90068_OpeneEVV_Client_Branch_invalidformatwithspace");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("Branch", " 4A");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Branch length is invalid. The length should be between 0 and 2."));
	}

	// Case-5 Testing with invalid format with space and numeric Branch field formats/values
	@Test(priority=5)
	public void TC90068_OpeneEVV_Client_Branch_leadingspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90068_OpeneEVV_Client_Branch_leadingspace");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("Branch", "4B ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Branch length is invalid. The length should be between 0 and 2."));
	}

	// Case-6 Testing with invalid format with space and numeric Branch field formats/values
	@Test(priority=6)
	public void TC90068_OpeneEVV_Client_Branch_invalidformatwithspecialcharcombination() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90068_OpeneEVV_Client_Branch_invalidformatwithspecialcharcombination");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("Branch", "4#");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Branch format is incorrect."));
	}

	// Case-6 Testing with invalid format with space and numeric Branch field formats/values
	@Test(priority=7)
	public void TC90068_OpeneEVV_Client_Branch_invalidformatwithspecialchars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90068_OpeneEVV_Client_Branch_invalidformatwithspecialchars");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("Branch", "@A");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Branch format is incorrect."));
	}
}
