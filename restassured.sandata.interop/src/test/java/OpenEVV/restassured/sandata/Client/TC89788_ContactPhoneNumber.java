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
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.io.IOException;

//Test Case 89788:Open EVV -Client-Validate (mix) - ContactPhoneNumber field formats/values

public class TC89788_ContactPhoneNumber extends BaseTest{

	@Test(priority=1)
	public void OpenEVV_Client_ContactPhoneNumber_with_maxlength() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("OpenEVV_Client_ContactPhoneNumber_with_maxlength");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactPhoneNumber","1234567890");

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	@Test(priority=2)
	public void TC89788_OpenEVV_Client_ContactPhoneNumber_with_9() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89788_OpenEVV_Client_ContactPhoneNumber_with_9");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactPhoneNumber","234567890");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 


		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		//
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ContactPhoneNumber format is incorrect."));

	}

	@Test(priority=3)
	public void TC89788_OpenEVV_Client_ContactPhoneNumber_with_chars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89788_OpenEVV_Client_ContactPhoneNumber_with_chars");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactPhoneNumber","2345678a0");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 


		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ContactPhoneNumber format is incorrect."));
		//Assert.assertTrue(bodyAsString1.contains("\"statuscode\": \"200\","));
		//Assert.assertTrue(bodyAsString1.contains("\"ClientLastName\": \"Absjdsshfsfhsfkh\","));
	}

	@Test(priority=4)
	public void TC89788_OpenEVV_Client_ContactPhoneNumber_with_starting_0() throws IOException, ParseException, ConfigurationException
	{ 
		logger = extent.startTest("TC89788_OpenEVV_Client_ContactPhoneNumber_with_starting_0");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactPhoneNumber","0005697890");
		//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
		//	js.put("ClientLastName", "Null");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	@Test(priority=5)
	public void TC89788_OpenEVV_Client_ContactPhoneNumber_with_headingspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89788_OpenEVV_Client_ContactPhoneNumber_with_headingspace");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactPhoneNumber","  95697890");
		//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
		//	js.put("ClientLastName", "Null");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		

		//Assert.assertTrue(bodyAsString1.contains("\"ClientLastName\": \"Absjdsshfsfhsfkh\","));
	}

	@Test(priority=6)
	public void TC89788_OpenEVV_Client_ContactPhoneNumber_with_leadingspace() throws IOException, ParseException, ConfigurationException
	{

		logger = extent.startTest("TC89788_OpenEVV_Client_ContactPhoneNumber_with_leadingspace");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactPhoneNumber","95697890  ");
		//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
		//	js.put("ClientLastName", "Null");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		

		//Assert.assertTrue(bodyAsString1.contains("\"ClientLastName\": \"Absjdsshfsfhsfkh\","));
	}

	@Test(priority=7)
	public void TC89788_OpenEVV_Client_ContactPhoneNumber_with_specialchar() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89788_OpenEVV_Client_ContactPhoneNumber_with_specialchar");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactPhoneNumber","9#@5697890");
		//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
		//	js.put("ClientLastName", "Null");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Assert.assertTrue(bodyAsString1.contains("\"ClientLastName\": \"Absjdsshfsfhsfkh\","));
	}

	@Test(priority=8)
	public void TC89788_OpenEVV_Client_ContactPhoneNumber_with_10char() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89788_OpenEVV_Client_ContactPhoneNumber_with_10char");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactPhoneNumber","T435697890");
		//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
		//	js.put("ClientLastName", "Null");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		

		//Assert.assertTrue(bodyAsString1.contains("\"ClientLastName\": \"Absjdsshfsfhsfkh\","));
	}

	@Test(priority=9)
	public void TC89788_OpenEVV_Client_ContactPhoneNumber_with_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89788_OpenEVV_Client_ContactPhoneNumber_with_10char");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactPhoneNumber",null);
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ContactPhoneNumber cannot be null."));
	}
}
