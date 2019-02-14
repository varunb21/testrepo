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

//TC88359:Open EVV- Verify error messages on uploading client with invalid input of ClientID

public class TC88359_ClientID_Invalid extends BaseTest{

	//case 0 checking with correct ClientID with JSOn and Db as well 
	@Test ()
	public void TC88359_OpenEVV_ClientID_Valid_json_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88359_OpenEVV_ClientID_Max_NV"); 

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	


	}

	//case 1 checking with incorrect ClientID: "56781" (>5) populated with a correct value except the ClientID given field. 
	@Test 
	public void TC88359_OpenEVV_ClientID_Max_NV() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88359_OpenEVV_ClientID_Max_NV"); 
		String uniqueClientId= CommonMethods.generateRandomNumberOfFixLength(6);

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);
		
		JSONArray jsonArrAdd = (JSONArray) js.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientID", uniqueClientId);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);

	}

	//case 2 checking with incorrect ClientID: "56781" (<5) populated with a correct value except the ClientID given field. 
	@Test
	public void TC88359_OpenEVV_ClientID_Min_NV() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88359_OpenEVV_ClientID_Min_NV"); 
		String uniqueClientId= CommonMethods.generateRandomNumberOfFixLength(4);

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);
		
		JSONArray jsonArrAdd = (JSONArray) js.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientID", uniqueClientId);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);

	}

	//case 3 each tag, where every tag is included and is populated with a correct value except the below given field. ClientID: "5678hdhe11" (Alpha numeric)  
	@Test
	public void TC88359_OpenEVV_ClientID_Max_Alphanum() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88359_OpenEVV_ClientID_Max_Alphanum"); 

		String uniqueClientId= CommonMethods.generateRandomAlphaNumeric(5);

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			

	}

	//Case 4 --- populated with a correct value except the below given field. ClientID: "dfhdheww" (Non numeric)  
	@Test
	public void TC88359_OpenEVV_ClientID_Nonnum() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88359_OpenEVV_ClientID_Nonnum"); 
		String uniqueClientId= CommonMethods.generateRandomStringOfFixLength(5);

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			

	}

	//Case 5 --- populated with a correct value except the below given field. ClientID: "   8373738" (starting with space)
	@Test
	public void TC88359_OpenEVV_ClientID_LeadingSpace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88359_OpenEVV_ClientID_LeadingSpace"); 

		String uniqueClientId=  " " + CommonMethods.generateRandomNumberOfFixLength(5);

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			
	}

	//Case 6 --- populated with a correct value except the below given field. ClientID: "12@373738" (With special character) 
	@Test
	public void TC88359_OpenEVV_clientID_Special_character() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88359_OpenEVV_clientID_Special_character"); 

		String uniqueClientId= CommonMethods.generateSpecialChar(5);

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			

	}

	//Case 7 --- populated with a correct value except the below given field. ClientID: "12-373738" (dashes, any combination) 
	@Test
	public void TC88359_OpenEVV_ClientID_Dash_anycombination() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88359_OpenEVV_ClientID_Dash_anycombination"); 

		String uniqueClientId= CommonMethods.generateSpecialChar(5);

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			


	}

	//Case 8 --- populated with a correct value except the below given field. ClientID: "8373738 " (ending with space)
	@Test
	public void TC88359_OpenEVV_ClientID_TrailingSpace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88359_OpenEVV_ClientID_LeadingSpace"); 

		String uniqueClientId= CommonMethods.generateRandomNumberOfFixLength(5) + " ";

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			
	}

}