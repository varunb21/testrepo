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

// Test Case 90102:Open EVV-Client-Validate (mix) - RecipientIDCustom2 field formats/values

public class TC90102_Client_RecipientIDCustom2 extends BaseTest{


	public static String val1, val2="client_id_custom2";
	// Case-1 To validate the valid RecipientIDCustom2 with Alphanumeric
	@Test
	public void TC90102_OpenEVV_Valid_RecipientIDCustom2_with_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90102_OpenEVV_Valid_RecipientIDCustom2_with_Alphanumeric"); 
		//Using Reusable method to load client json
		//JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom2", CommonMethods.generateRandomStringOfFixLength(8));


		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	// Case-2 To validate the invalid RecipientIDCustom2 with space combinations
	@Test
	public void TC90102_OpenEVV_invalid_RecipientIDCustom2_with_space_combinations() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90102_OpenEVV_invalid_RecipientIDCustom2_with_space_combinations"); 
		//Using Reusable method to load client json
		//JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom2", CommonMethods.generateRandomStringOfFixLength(3) +" " +CommonMethods.generateRandomStringOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The RecipientIDCustom2 format is incorrect."));
	}

	// Case-3 To validate the invalid RecipientIDCustom2 with >24 digits
	@Test
	public void TC90102_OpenEVV_invalid_RecipientIDCustom2_with_more_than_24digits() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90102_OpenEVV_invalid_RecipientIDCustom2_with_more_than_24digits"); 
		//Using Reusable method to load client json
		//JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom2", CommonMethods.generateRandomStringOfFixLength(25));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The RecipientIDCustom2 format is incorrect."));
	}

	//case-4 To validate the invalid RecipientIDCustom2 format with special chars
	@Test
	public void TC90102_OpenEVV_invalid_RecipientIDCustom2_specialchar() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90102_OpenEVV_invalid_RecipientIDCustom2_specialchar"); 
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom2", "19@Z" +CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The RecipientIDCustom2 format is incorrect."));
	}

	//case-5 To validate the invalid RecipientIDCustom2 DB verification 
	@Test
	public void TC90102_OpenEVV_valid_RecipientIDCustom2_in_database() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90102_OpenEVV_valid_RecipientIDCustom2_in_database"); 
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom2", CommonMethods.generateRandomStringOfFixLength(8));
		val1=  js.get("RecipientIDCustom2").toString();
		System.out.println(val1);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	


	}

}