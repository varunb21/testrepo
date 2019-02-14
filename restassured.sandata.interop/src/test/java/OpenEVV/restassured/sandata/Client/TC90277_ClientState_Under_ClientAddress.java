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
//Test Case 90277:Open EVV-Client-Validate (mix) - ClientState field/format under ClientAddress

public class TC90277_ClientState_Under_ClientAddress extends BaseTest{

	//To validate the valid ClientState
	@Test
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_valid");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", DataClient.generateClientState()); 

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid ClientState
	@Test
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_invalid");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", "XY");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState format is incorrect."));
// The record should satisfy this regular expression ['AL|AK|AZ|AR|CA|CO|CT|DE|FL|GA|HI|ID|IL|IN|IA|KS|KY|LA|ME|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI|WY']. Invalid Value='XY'
	}

	//To validate the invalid ClientState length
	@Test
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_invalid_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_invalid_length");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", "ALM"); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState length is invalid. The length should be between 2 and 2."));
	}

	//To validate the numeric value in ClientState
	@Test
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_Alphanumeric");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


        JSONObject js = (JSONObject) j.get(0);
		
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", "N1"); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	//	
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState format is incorrect."));
	}

	//To validate the ClientState with trailing spaces
	@Test
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_trailing_spaces() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_trailing_spaces");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


        JSONObject js = (JSONObject) j.get(0);
		
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", "NY "); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState length is invalid. The length should be between 2 and 2."));
	}

	//To validate the ClientState with leading spaces
	@Test
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_leading_spaces() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_leading_spaces");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", " NY"); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	//	
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState length is invalid. The length should be between 2 and 2."));
	}

	//To validate the missing ClientState 
	@Test
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_null");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", null); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	//	
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState cannot be null."));
	}

}