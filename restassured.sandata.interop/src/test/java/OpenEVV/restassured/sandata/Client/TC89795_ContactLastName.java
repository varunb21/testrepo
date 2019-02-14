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

//Test Case 89795:Open EVV-Client-Validate (mix) - ContactLastName field formats/values

public class TC89795_ContactLastName extends BaseTest {

	// Case-1 Testing with valid combination of alphabets
	@Test(priority=1)
	public void TC89795_OpenEVV_Client_ContactLastName_Alphabet() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89795_OpenEVV_Client_ContactLastName_Alphabet");  
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactLastName", "Clientlname");
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}
	// Case-2 Testing with alphabets starting with a space
	@Test(priority=2)
	public void TC89795_OpenEVV_Client_ContactLastName_heading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89795_OpenEVV_Client_ContactLastName_heading_space");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactLastName", " Clientlname");
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	// Case-3 Testing with alphabets ending with a space
	@Test(priority=3)
	public void TC89795_OpenEVV_Client_ContactLastName_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89795_OpenEVV_Client_ContactLastName_leading_space");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactLastName", "Clientlname ");
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	// Case-4 Testing with valid special characters ("." or " '  " or  "-" ) 
	@Test(priority=4)
	public void TC89795_OpenEVV_Client_ContactLastName_pecialchar() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89795_OpenEVV_Client_ContactLastName_pecialchar");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactLastName", "Fnu.Anupamor-kam");
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	// Case-5 Testing with special characters other than few special characters ("." or " '  " or  "-" ) 
	@Test(priority=5)
	public void TC89795_OpenEVV_Client_ContactLastName_specialchars_dashes() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89795_OpenEVV_Client_ContactLastName_specialchars_dashes");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactLastName", "F@n$u-Anupamor_kam");
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ContactLastName format is incorrect."));
	}
	// Case-6 Testing with combination of alphanumeric, starting with an alpha
	@Test(priority=6)
	public void TC89795_OpenEVV_Client_ContactLastName_number_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89795_OpenEVV_Client_ContactLastName_number_invalid");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactLastName", "ClientLoginFN12");
		//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
		//	js.put("ClientLastName", "Null");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ContactLastName format is incorrect."));
	}
	// Case-7 Testing with combination of alphanumeric, starting with a number
	@Test(priority=7)
	public void TC89795_OpenEVV_Client_ContactLastName_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89795_OpenEVV_Client_ContactLastName_Alphanumeric");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactLastName", "9F9821a");
		//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
		//	js.put("ClientLastName", "Null");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ContactLastName format is incorrect."));
	}
	// Case-8 Testing with >30 characters  
	@Test(priority=8)
	public void TC89795_OpenEVV_Client_ContactLastName_charlength() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89795_OpenEVV_Client_ContactLastName_charlength");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactLastName", "asfakfksafkafkafasfakfksafkafkafasfakfksafkafka");
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("The ContactLastName length is invalid. The length should be between 0 and 30."));
	}

}
