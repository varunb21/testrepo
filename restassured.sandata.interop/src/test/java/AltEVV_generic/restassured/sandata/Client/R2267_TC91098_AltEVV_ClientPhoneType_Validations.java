
package AltEVV_generic.restassured.sandata.Client;

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
import java.io.IOException;
import java.sql.SQLException;

//Test Case 91098: OpenEVV-altEVV- Client: Validate (mix)- ClientPhoneType field format/values

public class R2267_TC91098_AltEVV_ClientPhoneType_Validations extends BaseTest{

	//Case-1 Testing with ClientPhoneType: >12 characters 
	@Test 
	public void TC91098_AltEVV_CreateClient_with_ClientPhoneType_more_than_12chars() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhoneType_more_than_12chars"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson ClientPhoneType with more than 12chars"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhoneType", CommonMethods.generateRandomAlphaNumeric(13));

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientPhoneType value is incorrect. The length should be between 1 and 12.");

	}

	//Case-2 Testing with ClientPhoneType: Home
	@Test(groups = { "Databasetest"})
	public void TC91098_AltEVV_CreateClient_with_ClientPhoneType_Home() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhoneType_Home"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson ClientPhoneType with Home"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhoneType", "Home");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//		Assertion_DbVerifier.jsonAssert_InboxAni(bodyAsString, js, js3);
	}

	//Case-3 Testing with ClientPhoneType: Business
	@Test(groups = { "Databasetest"})
	public void TC91098_AltEVV_CreateClient_with_ClientPhoneType_Business() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhoneType_Business"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson ClientPhoneType with Business"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);

		js3.put("ClientPhoneType", "Business");
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//	Assertion_DbVerifier.jsonAssert_InboxAni(bodyAsString, js, js3);

	}	

	//Case-4 Testing with ClientPhoneType: Mobile
	@Test(groups = { "Databasetest"})
	public void TC91098_AltEVV_CreateClient_with_ClientPhoneType_Mobile() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhoneType_Mobile"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson ClientPhoneType with Mobile"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhoneType", "Mobile");
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//	Assertion_DbVerifier.jsonAssert_InboxAni(bodyAsString, js, js3);
	}	

	//Case-5 Testing with ClientPhoneType: Other
	@Test(groups = { "Databasetest"})
	public void TC91098_AltEVV_CreateClient_with_ClientPhoneType_Other() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhoneType_Other"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson ClientPhoneType with Other"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhoneType", "Other");
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//	Assertion_DbVerifier.jsonAssert_InboxAni(bodyAsString, js, js3);
	}

	//Case-6 Testing with ClientPhoneType: Invalid
	@Test 
	public void TC91098_AltEVV_CreateClient_with_ClientPhoneType_other_than_valid() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhoneType_other_than_valid"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson ClientPhoneType with invalid"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhoneType", CommonMethods.generateRandomAlphaNumeric(5));

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientPhoneType format is incorrect.");
	}
}
