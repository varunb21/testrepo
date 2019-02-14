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

//Test Case 89893:Open EVV-Client-Validate (mix) - ClientState field/format
public class TC89893_ClientState extends BaseTest{

	//To validate the valid ClientState
	@Test
	public void TC89893_OpenEVV_ClientState_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89893_OpenEVV_ClientState_valid"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject jsonObject = (JSONObject) j.get(0);
		jsonObject.put("ClientState", DataGeneratorClient.generateClientState());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		logger.log(LogStatus.INFO, "Validating Json response ");

	Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);
	}

	//To validate the invalid ClientState
	@Test
	public void TC89893_OpenEVV_ClientState_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89893_OpenEVV_ClientState_invalid"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", "AP");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState format is incorrect."));

	}

	//To validate the invalid ClientState length
	@Test
	public void TC89893_OpenEVV_ClientState_invalid_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89893_OpenEVV_ClientState_invalid_length"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", "ALM");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState length is invalid. The length should be between 2 and 2."));
	}

	//To validate the numeric value in ClientState
	@Test
	public void TC89893_OpenEVV_ClientState_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89893_OpenEVV_ClientState_Alphanumeric"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", "N1");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState format is incorrect."));
	}

	//To validate the ClientState with trailing spaces
	@Test
	public void TC89893_OpenEVV_ClientState_trailing_spaces() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89893_OpenEVV_ClientState_trailing_spaces"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", "NY ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState length is invalid. The length should be between 2 and 2."));
	}

	//To validate the ClientState with leading spaces
	@Test
	public void TC89893_OpenEVV_ClientState_leading_spaces() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89893_OpenEVV_ClientState_leading_spaces"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", " NY");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState length is invalid. The length should be between 2 and 2."));
	}

	//To validate the missing ClientState 
	@Test
	public void TC89893_OpenEVV_ClientState_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89893_OpenEVV_ClientState_null"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", "");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState length is invalid. The length should be between 2 and 2."));
	}

}