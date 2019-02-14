package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

 
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 89895:Open EVV-Client-Validate (mix) - ClientCity field formats/values

public class TC89895_ClientCity extends BaseTest {

	//To validate the valid ClientCity
	@Test(priority=0)
	public void TC89895_OpenEVV_ClientCity_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89895_OpenEVV_ClientCity_valid"); 
	
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(5));
	
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);	

	}

	//To validate the invalid ClientCity length
	@Test(priority=1)
	public void TC89895_OpenEVV_ClientCity_invalid_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89895_OpenEVV_ClientCity_length"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientCity length is invalid. The length should be between 1 and 30."));
	}

	//To validate the ClientCity with white space
	@Test(priority=2)
	public void TC89895_OpenEVV_ClientCity_white_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89895_OpenEVV_ClientCity_mid_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		
		js.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(5) + " " + CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	

	}

	//To validate the numeric value in ClientCity
	@Test(priority=3)
	public void TC89895_OpenEVV_ClientCity_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89895_OpenEVV_ClientCity_Alphanumeric"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientCity", CommonMethods.generateRandomAlphaNumeric(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("The ClientCity format is incorrect."));
	}

	//To validate the ClientCity with leading space
	@Test
	public void TC89895_OpenEVV_ClientCity_leading_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89895_OpenEVV_ClientCity_leading_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientCity", " " +CommonMethods.generateRandomStringOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	


	}

	//To validate the ClientCity with trailing space
	@Test(priority=5)
	public void TC89895_OpenEVV_ClientCity_trailing_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89895_OpenEVV_ClientCity_trailing_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(8)+" ");
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	

	}

	//To validate the ClientCity with special char
	@Test
	public void TC89895_OpenEVV_ClientCity_special_char() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89895_OpenEVV_ClientCity_special_char"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientCity", CommonMethods.generateSpecialChar(16));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientCity format is incorrect."));
	}

}
