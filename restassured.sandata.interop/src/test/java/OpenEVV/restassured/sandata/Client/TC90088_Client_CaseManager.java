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

//To validate the valid CaseManager field formats/values

public class TC90088_Client_CaseManager extends BaseTest {


	// Case-1 Testing with invalid CaseManager field formats/values
	@Test(priority=1)
	public void TC90088_OpenEVV_invalid_CaseManager_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90088_OpenEVV_invalid_CaseManager_length"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		//js.put("Borough",CommonMethods.generateRandomNumberOfFixLength(2));
		js.put("CaseManager", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-2 Testing with passing valid string value in CaseManager field formats
	@Test(priority=2)
	public void TC90088_OpenEVV_valid_string_CaseManager() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90088_OpenEVV_valid_string_CaseManager"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		//js.put("CaseManager", "The list of acceptable values");
		js.put("CaseManager", " " + CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-3 Testing with valid space in CaseManager field formats/values
	@Test(priority=3)
	public void TC90088_OpenEVV_valid_tailing_space_CaseManager() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90088_OpenEVV_valid_tailing_space_CaseManager"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		//	js.put("CaseManager", "  English");
		js.put("CaseManager", CommonMethods.generateRandomStringOfFixLength(7)+ " ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-4 Testing with valid format with leading space in CaseManager formats/values
	@Test(priority=4)
	public void TC90088_OpenEVV_valid_leading_space_CaseManagers() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90088_OpenEVV_valid_leading_space_CaseManagers"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseManager",  " " + CommonMethods.generateRandomStringOfFixLength(7));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-5 Testing with valid format with special chars CaseManager field formats/values
	@Test(priority=5)
	public void TC90088_OpenEVV_invalid_CaseManager_specialchar_format() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90088_OpenEVV_invalid_CaseManager_specialchar_format"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		//js.put("CaseManager", CommonMethods.generateSpecialChar(6));
		js.put("CaseManager", "AS.Aor-ADKD");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The CaseManager format is incorrect."));
	}

	// Case-6 Testing with valid format with special chars CaseManager field formats/values
	@Test(priority=6)
	public void TC90088_OpenEVV_invalid_CaseManager_specialchar_combination() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90088_OpenEVV_invalid_CaseManager_specialchar_combination"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		//js.put("CaseManager", CommonMethods.generateSpecialChar(6));
		js.put("CaseManager", "AS%A#ADKD");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The CaseManager format is incorrect."));
	}

	// Case-7 Testing with invalid format with combination of alphanumeric, starting with an alpha in CaseManager field formats/values
	@Test(priority=7)
	public void TC90088_OpenEVV_invalid_CaseManager_alphanumeric_starting_alpha() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90088_OpenEVV_invalid_CaseManager_alphanumeric_starting_alpha"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		//js.put("CaseManager", CommonMethods.generateSpecialChar(6));
		js.put("CaseManager","A" + CommonMethods.generateRandomAlphaNumeric(6));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-7 Testing with invalid format with combination of alphanumeric, starting with number in CaseManager field formats/values
	@Test(priority=8)
	public void TC90088_OpenEVV_valid_CaseManager_alphanumeric_starting_number() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90088_OpenEVV_valid_CaseManager_alphanumeric_starting_number"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		//js.put("CaseManager", CommonMethods.generateSpecialChar(6));
		js.put("CaseManager","15" + CommonMethods.generateRandomAlphaNumeric(6));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-7 Testing with invalid format with combination of alphanumeric, starting with number in CaseManager field formats/values
	@Test(priority=8)
	public void TC90088_OpenEVV_invalid_CaseManager_starting_with_char25() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90088_OpenEVV_invalid_CaseManager_starting_with_char25"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		//js.put("CaseManager", CommonMethods.generateSpecialChar(6));
		js.put("CaseManager",CommonMethods.generateRandomStringOfFixLength(26));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The CaseManager length is invalid. The length should be between 0 and 25."));
	}
}
