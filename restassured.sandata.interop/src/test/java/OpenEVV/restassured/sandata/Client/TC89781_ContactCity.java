package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
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
//Test Case 89895:Open EVV-Client-Validate (mix) - ContactCity field formats/values
public class TC89781_ContactCity extends BaseTest {

	//To validate the valid ContactCity
	@Test(priority=0)
	public void TC89895_OpenEVV_ContactCity_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89895_OpenEVV_ContactCity_valid"); 
	
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactCity", CommonMethods.generateRandomStringOfFixLength(5));
	
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

//		CommonMethods.verifyjsonassertsuccess4value_inboxclient_contact(bodyAsString, globalVariables.dbclientid, js.get(globalVariables.ClientID).toString(), 
//				globalVariables.dbContactCity, js.get(globalVariables.ContactCity).toString());
	}

	//To validate the invalid ContactCity length
	@Test(priority=1)
	public void TC89895_OpenEVV_ContactCity_invalid_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89895_OpenEVV_ContactCity_length"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactCity", CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactCity length is invalid. The length should be between 0 and 30."));
	}

	//To validate the ContactCity with white space
	@Test(priority=2)
	public void TC89895_OpenEVV_ContactCity_white_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89895_OpenEVV_ContactCity_mid_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		
		js.put("ContactCity", CommonMethods.generateRandomStringOfFixLength(5) + " " + CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
//		CommonMethods.verifyjsonassertsuccess4value_inboxclient_contact(bodyAsString, globalVariables.dbclientid, js.get(globalVariables.ClientID).toString(), 
//		globalVariables.dbContactCity, js.get(globalVariables.ContactCity).toString());
	}

	//To validate the numeric value in ContactCity
	@Test(priority=3)
	public void TC89895_OpenEVV_ContactCity_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89895_OpenEVV_ContactCity_Alphanumeric"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactCity", CommonMethods.generateRandomAlphaNumeric(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("The ContactCity format is incorrect."));
	}

	//To validate the ContactCity with leading space
	@Test
	public void TC89895_OpenEVV_ContactCity_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89895_OpenEVV_ContactCity_leading_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactCity", " " +CommonMethods.generateRandomStringOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

//		CommonMethods.verifyjsonassertsuccess4value_inboxclient_contact(bodyAsString, globalVariables.dbclientid, js.get(globalVariables.ClientID).toString(), 
//		globalVariables.dbContactCity, js.get(globalVariables.ContactCity).toString());

	}

	//To validate the ContactCity with trailing space
	@Test(priority=5)
	public void TC89895_OpenEVV_ContactCity_trailing_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89895_OpenEVV_ContactCity_trailing_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactCity", CommonMethods.generateRandomStringOfFixLength(8)+" ");
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

//		CommonMethods.verifyjsonassertsuccess4value_inboxclient_contact(bodyAsString, globalVariables.dbclientid, js.get(globalVariables.ClientID).toString(), 
//		globalVariables.dbContactCity, js.get(globalVariables.ContactCity).toString());
	}

	//To validate the ContactCity with special char
	@Test
	public void TC89895_OpenEVV_ContactCity_special_char() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89895_OpenEVV_ContactCity_special_char"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactCity", CommonMethods.generateSpecialChar(16));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactCity format is incorrect."));
	}

}
