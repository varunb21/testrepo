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

//To validate the valid Borough field formats/values

public class TC90066_Client_Borough extends BaseTest {

	// Case-1 Testing with invalid Borough field more than one
	@Test(priority=1)
	public void TC90066_OpenEVV_Client_Borough_invalidformat() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90066_OpenEVV_Client_Borough_invalidformat"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Borough",CommonMethods.generateRandomNumberOfFixLength(2));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Borough length is invalid. The length should be between 0 and 1."));

	}

	// Case-2 Testing with valid Borough field alphabet only
	@Test(priority=2)
	public void TC90066_OpenEVV_Borough_validcombination_Alphabet_only() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90066_OpenEVV_Borough_validcombination_Alphabet_only"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Borough", CommonMethods.generateRandomStringOfFixLength(1));


		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-3 Testing with valid Borough field num only
	@Test(priority=2)
	public void TC90066_OpenEVV_Borough_validcombination_num_only() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90066_OpenEVV_Borough_validcombination_num_only"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Borough", CommonMethods.generateRandomStringOfFixLength(1));


		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-4 Testing with invalid Borough field leading space
	@Test(priority=2)
	public void TC90066_OpenEVV_Borough_invalidcombination_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90066_OpenEVV_Borough_invalidcombination_leading_space"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Borough", " " + CommonMethods.generateRandomNumberOfFixLength(1));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Borough length is invalid. The length should be between 0 and 1"));
	}

	// Case-5 Testing with invalid Area field trailing space
	@Test(priority=3)
	public void TC90066_OpenEVV_Borough_invalidcombinationswithspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90066_OpenEVV_Borough_invalidcombinationswithspace"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Borough", CommonMethods.generateRandomNumberOfFixLength(1) + " ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Borough length is invalid. The length should be between 0 and 1"));
	}

	// Case-6 Testing with special character
	@Test(priority=4)
	public void TC90066_OpenEVV_Borough_invalidformat_special_char() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90066_OpenEVV_Borough_invalidformat_special_char"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Borough", CommonMethods.generateSpecialChar(1));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result		
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Borough format is incorrect. The record should satisfy this regular expression"));
	}
}
