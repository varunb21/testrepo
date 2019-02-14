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

//To validate the valid ClientPriority field formats/values

public class TC90072_ClientPriority extends BaseTest {


	// Case-1 Testing with invalid Team field formats/values
	@Test(priority=1)
	public void TC90072_OpenEVV_ClientPriority_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90072_OpenEVV_ClientPriority_invalid"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		//js.put("Borough",CommonMethods.generateRandomNumberOfFixLength(2));
		js.put("ClientPriority", "AA");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));	
	}
	// Case-2 Testing with invalid ClientPriority field formats/values
	@Test(priority=2)
	public void TC90072_OpenEVV_ClientPriority_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90072_OpenEVV_ClientPriority_Alphanumeric"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPriority", "11A");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientPriority length is invalid. The length should be between 0 and 2."));
	}
	// Case-3 Testing with valid numeric ClientPriority field formats/values
	@Test(priority=3)
	public void TC90072_OpenEVV_ClientPriority_Numeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90072_OpenEVV_ClientPriority_Numeric"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPriority", "11");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	// Case-4 Testing with invalid format with space and numeric ClientPriority formats/values
	@Test(priority=4)
	public void TC90072_OpenEVV_ClientPriority_Heading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90072_OpenEVV_ClientPriority_Heading_space"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPriority", " 4A");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientPriority length is invalid. The length should be between 0 and 2."));
	}
	// Case-5 Testing with invalid format with space and numeric ClientPriority field formats/values
	@Test(priority=5)
	public void TC90072_OpenEVV_ClientPriority_leadingspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90072_OpenEVV_ClientPriority_leadingspace"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPriority", "4A ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientPriority length is invalid. The length should be between 0 and 2."));
	}
	// Case-6 Testing with invalid format with space and numeric ClientPriority field formats/values
	@Test(priority=6)
	public void TC90072_OpenEVV_invalidformatwithClientPriorityspecialchar() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90072_OpenEVV_invalidformatwithClientPriorityspecialchar"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPriority", "4@");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientPriority format is incorrect."));
	}
}
