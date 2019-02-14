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

// To validate the valid ClientAddressLine2 field formats/values under ClientAddress

public class TC90279_ClientAddressLine2 extends BaseTest{

	// Case-1 To validate the valid ClientAddressLine2 with string
	@Test
	public void TC90279_OpenEVV_Valid_ClientAddressLine2_with_string() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90279_OpenEVV_Valid_ClientAddressLine2_with_string");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", CommonMethods.generateRandomStringOfFixLength(3) + " " +CommonMethods.generateRandomStringOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	
	}

	//case-2 To validate the ClientAddressLine2 having numeric value equal to 9 heading 0
	@Test
	public void TC90279_OpenEVV_Valid_ClientAddressLine2_without_spaces() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90279_OpenEVV_Valid_ClientAddressLine2_without_spaces");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", CommonMethods.generateRandomStringOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	
	}

	//case-3 To validate the valid ClientAddressLine2 heading space
	@Test
	public void TC90279_OpenEVV_Valid_ClientAddressLine2_heading_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90279_OpenEVV_Valid_ClientAddressLine2_heading_space");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", " " + CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	

	}

	//case-4 To validate the valid ClientAddressLine2 leading space
	@Test
	public void TC90279_OpenEVV_Valid_ClientAddressLine2_TRAILING_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90279_OpenEVV_Valid_ClientAddressLine2_leading_space");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", CommonMethods.generateRandomStringOfFixLength(4) +" ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	
	}

	//Case-5 To validate the invalid ClientAddressLine2 length exceeds
	@Test
	public void TC90279_OpenEVV_invalid_ClientAddressLine2_length_mid_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90279_OpenEVV_invalid_ClientAddressLine2_length_exceeds");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", CommonMethods.generateRandomStringOfFixLength(9) +" " +CommonMethods.generateRandomStringOfFixLength(6));

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	

	}

	//Case-6 To validate the invalid ClientAddressLine2 length WITH MID SPACE
	@Test
	public void TC90279_OpenEVV_invalid_ClientAddressLine2_length_Mid_Space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90279_OpenEVV_invalid_ClientAddressLine2_length_exceeds");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", CommonMethods.generateRandomStringOfFixLength(31) +" " +CommonMethods.generateRandomStringOfFixLength(6));

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressLine2 length is invalid. The length should be between 1 and 30."));
	}

	//case-7 To validate the invalid ClientAddressLine2 with specialchars
	@Test
	public void TC90279_OpenEVV_invalid_ClientAddressLine2_with_specialchars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90279_OpenEVV_invalid_ClientAddressLine2_with_specialchars");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", CommonMethods.generateSpecialChar(24));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressLine2 format is incorrect."));
	}



}