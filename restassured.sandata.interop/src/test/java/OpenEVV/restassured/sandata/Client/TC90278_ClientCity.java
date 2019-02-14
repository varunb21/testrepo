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
import java.sql.SQLException;

// Test Case 90278:Open EVV-Client-Validate (mix) - ClientCity field formats/values under ClientAddress

public class TC90278_ClientCity extends BaseTest{

	//case-1 To validate the valid ClientCity format with chars and spaces
	@Test
	public void TC90278_OpenEVV_Valid_ClientCity_with_chars_and_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90278_OpenEVV_Valid_ClientCity_with_chars_and_space");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		JSONArray j2 = (JSONArray) js.get("ClientAddress");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);

	}

	//case-3 To validate the invalid ClientCity with leading spaces
	@Test
	public void TC90278_OpenEVV_invalid_ClientCity_with_leading_spaces() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90278_OpenEVV_invalid_ClientCity_with_leading_spaces");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientCity", " " +CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		//		CommonMethods.verifyjsonassertsuccess4value_inbox_client_address(bodyAsString, globalVariables.dbclientid, js.get(globalVariables.ClientID).toString(), 
		//			globalVariables.dbClientCity, js2.get(globalVariables.ClientCity).toString());
	}

	//case-4 To validate the invalid ClientCity with tailing spaces
	@Test
	public void TC90278_OpenEVV_invalid_ClientCity_with_tailing_spaces() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90278_OpenEVV_invalid_ClientCity_with_tailing_spaces");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(5) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		//		CommonMethods.verifyjsonassertsuccess4value_inbox_client_address(bodyAsString, globalVariables.dbclientid, js.get(globalVariables.ClientID).toString(), 
		//			globalVariables.dbClientCity, js2.get(globalVariables.ClientCity).toString());
	}

	//case-5 To validate the invalid ClientCity with space combination
	@Test
	public void TC90278_OpenEVV_invalid_ClientCity_with_string() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90278_OpenEVV_invalid_ClientCity_with_string");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(3) + " " +
				CommonMethods.generateRandomStringOfFixLength(2) + " " +
				CommonMethods.generateRandomStringOfFixLength(4)); 


		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		//		CommonMethods.verifyjsonassertsuccess4value_inbox_client_address(bodyAsString, globalVariables.dbclientid, js.get(globalVariables.ClientID).toString(), 
		//			globalVariables.dbClientCity, js2.get(globalVariables.ClientCity).toString());
	}

	//case-7 To validate the invalid ClientCity having alphabet more than 30
	@Test
	public void TC90278_OpenEVV_invalid_ClientCity_alphabet_more_than_30chars() throws IOException, ParseException, ConfigurationException
	{

		logger = extent.startTest("TC90278_OpenEVV_invalid_ClientCity_alphabet_more_than_30chars");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(31)); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The ClientCity length is invalid. The length should be between 1 and 30."));
	}

	//case-8 To validate the valid ClientCity having embedded alphas
	@Test
	public void TC90278_OpenEVV_valid_ClientCity_embedded_num() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90278_OpenEVV_valid_ClientCity_embedded_num");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(3) + "123" + CommonMethods.generateRandomStringOfFixLength(4)); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientCity format is incorrect."));
	}

	//case-9 To validate the invalid ClientCity with special chars
	@Test
	public void TC90278_OpenEVV_invalid_ClientCity_with_specialchars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90278_OpenEVV_invalid_ClientCity_with_specialchars");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientCity", CommonMethods.generateSpecialChar(10)); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientCity format is incorrect."));
	}

	//Case-10 To validate the invalid ClientCity with null
	@Test
	public void TC90278_OpenEVV_invalid_ClientCity_with_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90278_OpenEVV_invalid_ClientCity_with_null");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientCity", null); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientCity cannot be null."));
	}

}