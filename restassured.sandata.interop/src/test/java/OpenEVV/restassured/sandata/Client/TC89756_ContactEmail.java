package OpenEVV.restassured.sandata.Client;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

//Test Case 89756:Open EVV-Client-Validate (mix) - ContactEmail field formats/values
public class TC89756_ContactEmail extends BaseTest
{	
		
	//case 1---- - ContactEmail = "ClientLoginFN@mailinator.com"  (valid Case)
	@Test
	public void TC89756_OpenEVV_ContactEmail_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89756_OpenEVV_ContactEmail_valid");  
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ContactEmail", "ClientLoginFN@mailinator.com");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains( "\"reason\": \"Transaction Received.\","));
		
	}
	
	//case 2 ---- - ContactEmail = "ClientLoginFN12@mailinator.com"   (valid Case)
	@Test
	public void TC89756_OpenEVV_ContactEmail_with_Aplhanumric_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89756_OpenEVV_ContactEmail_with_Aplhanumric_valid");  
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ContactEmail", "ClientLoginFN12@mailinator.com");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains( "\"reason\": \"Transaction Received.\","));
		
	}
	
	//case 3 ---- - - ContactEmail  = "ClientLoginFN12"    (invalid Case)
	@Test
	public void TC89756_OpenEVV_ContactEmail_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89756_OpenEVV_ContactEmail_invalid");  
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ContactEmail", "ClientLoginFN12");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
	Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactEmail format is incorrect. The record should satisfy this regular expression [\\u0027(?:[a-zA-Z0-9!#$%\\u0026\\u0027*+\\\\\\u003d?^_`{|}~-]+(?:\\\\.[a-zA-Z0-9!#$%\\u0026\\u0027*+\\\\\\u003d?^_`{|}~-]+)*|\\\"(?:[\\\\x01-\\\\x08\\\\x0b\\\\x0c\\\\x0e-\\\\x1f\\\\x21\\\\x23-\\\\x5b\\\\x5d-\\\\x7f]|\\\\\\\\[\\\\x01-\\\\x09\\\\x0b\\\\x0c\\\\x0e-\\\\x7f])*\\\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\\\\x01-\\\\x08\\\\x0b\\\\x0c\\\\x0e-\\\\x1f\\\\x21-\\\\x5a\\\\x53-\\\\x7f]|\\\\\\\\[\\\\x01-\\\\x09\\\\x0b\\\\x0c\\\\x0e-\\\\x7f])+)\\\\])\\u0027]."));
	
	}
	
	//case 4 ---- -- ContactEmail  = "ClientLoginFN12@mailinator"   (invalid Case)
	@Test
	public void TC89756_OpenEVV_ContactEmail_with_number_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89756_OpenEVV_ContactEmail_with_number_invalid");  
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ContactEmail", "ClientLoginFN12@mailinator");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
	Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactEmail format is incorrect. The record should satisfy this regular expression [\\u0027(?:[a-zA-Z0-9!#$%\\u0026\\u0027*+\\\\\\u003d?^_`{|}~-]+(?:\\\\.[a-zA-Z0-9!#$%\\u0026\\u0027*+\\\\\\u003d?^_`{|}~-]+)*|\\\"(?:[\\\\x01-\\\\x08\\\\x0b\\\\x0c\\\\x0e-\\\\x1f\\\\x21\\\\x23-\\\\x5b\\\\x5d-\\\\x7f]|\\\\\\\\[\\\\x01-\\\\x09\\\\x0b\\\\x0c\\\\x0e-\\\\x7f])*\\\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\\\\x01-\\\\x08\\\\x0b\\\\x0c\\\\x0e-\\\\x1f\\\\x21-\\\\x5a\\\\x53-\\\\x7f]|\\\\\\\\[\\\\x01-\\\\x09\\\\x0b\\\\x0c\\\\x0e-\\\\x7f])+)\\\\])\\u0027]."));
	
	}
	
	//case 5 ---- -- - ContactEmail  = ">64 digits"   (invalid Case)
	@Test
	public void TC89756_OpenEVV_ContactEmail_with_string_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89756_OpenEVV_ContactEmail_with_string_invalid");  
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ContactEmail", "ClientLoginlfdkfdkfdalfhd32ewrwrwrewrfdsfdsgdftertet4534534543dfdsf43ewrwer432434dsrsdfsfdsfsfeFN@mailinator.com");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
	Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactEmail length is invalid. The length should be between 0 and 64."));
	
	}
	
}