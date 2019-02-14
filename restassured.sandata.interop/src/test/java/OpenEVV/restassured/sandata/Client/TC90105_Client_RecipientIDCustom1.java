package OpenEVV.restassured.sandata.Client;

import static io.restassured.RestAssured.given;
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
import io.restassured.response.Response;

/**
 * @author MayankM
 *
 */

// Test Case 90105:Open EVV-Client-Validate (mix) - RecipientIDCustom2 field formats/values

public class TC90105_Client_RecipientIDCustom1 extends BaseTest{

	public static String val2="client_id_custom1";

	// Case-1 To validate the valid RecipientIDCustom1 with Alphanumeric
	@Test
	public void TC90105_OpenEVV_Valid_RecipientIDCustom1_Alphanumeric() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90105_OpenEVV_Valid_RecipientIDCustom1_Alphanumeric");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom1", CommonMethods.generateRandomStringOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);

	}

	// Case-2 To validate the invalid RecipientIDCustom1 with space combinations
	@Test
	public void TC90105_OpenEVV_invalid_RecipientIDCustom1_with_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90105_OpenEVV_invalid_RecipientIDCustom1_with_space");
		//Using Reusable method to load client json
		//JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom1", CommonMethods.generateRandomStringOfFixLength(3) +" " +CommonMethods.generateRandomStringOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The RecipientIDCustom1 format is incorrect."));
	}

	// Case-3 To validate the invalid RecipientIDCustom1 with >24 digits
	@Test
	public void TC90105_OpenEVV_invalid_RecipientIDCustom1_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90105_OpenEVV_invalid_RecipientIDCustom1_length");
		//Using Reusable method to load client json
		//JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom1", CommonMethods.generateRandomStringOfFixLength(25));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The RecipientIDCustom1 format is incorrect."));
	}

	//case-4 To validate the invalid RecipientIDCustom1 format with special chars
	@Test
	public void TC90105_OpenEVV_invalid_RecipientIDCustom1_specialchar() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90105_OpenEVV_invalid_RecipientIDCustom1_specialchar");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom1", "19@Z" +CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The RecipientIDCustom1 format is incorrect."));
	}

	//case-5 To validate the invalid RecipientIDCustom1 DB verification 
	@Test
	public void TC90105_OpenEVV_valid_RecipientIDCustom1_DB_Validation() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90105_OpenEVV_valid_RecipientIDCustom1_DB_Validation");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		String rcpntidcustom1 = CommonMethods.generateRandomStringOfFixLength(8);
		js.put("RecipientIDCustom1", rcpntidcustom1);

		System.out.println(rcpntidcustom1);

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);

	}

}