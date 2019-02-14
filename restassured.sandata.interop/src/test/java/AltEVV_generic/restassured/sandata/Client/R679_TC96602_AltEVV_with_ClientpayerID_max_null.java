package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91096:OpenEVV-altEVV- Client Payer: Validate (mix) - PayerID field formats/values

public class R679_TC96602_AltEVV_with_ClientpayerID_max_null extends BaseTest {


	@Test (priority=0)
	public void R679_TC96602_AltEVV_with_ClientpayerID_max_VALID() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC96602_AltEVV_with_ClientpayerID_max_VALID"); 
		logger.log(LogStatus.INFO, "R679_TC96602_AltEVV_with_ClientpayerID_max_VALID");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		
		jsonObject1.put("ClientStatus", "02");
		jsonObject1.put("ClientEligibilityDateBegin", null);
		jsonObject1.put("ClientEligibilityDateEnd", null);
		jsonObject1.put(globalVariables.PayerProgram, CommonMethods.generateRandomStringOfFixLength(5));
		jsonObject1.put(globalVariables.PayerID, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject1.put(globalVariables.ClientPayerID, CommonMethods.generateRandomNumberOfFixLength(20));
	
		
		JSONObject jsonObject2= (JSONObject) jsonArray1.get(1);
		
		jsonObject2.put("ClientStatus", "02");
		jsonObject2.put("ClientEligibilityDateBegin", null);
		jsonObject2.put("ClientEligibilityDateEnd",  null);
		jsonObject2.put(globalVariables.PayerProgram, CommonMethods.generateRandomStringOfFixLength(5));
		jsonObject2.put(globalVariables.PayerID, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject2.put(globalVariables.ClientPayerID, CommonMethods.generateRandomNumberOfFixLength(20));
				
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject2);

	}

	@Test (priority=1)
	public void R679_TC96602_AltEVV_with_ClientpayerID_NULL_INVALID() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC96602_AltEVV_with_ClientpayerID_NULL_INVALID"); 
		logger.log(LogStatus.INFO, "R679_TC96602_AltEVV_with_ClientpayerID_NULL_INVALID");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		
		jsonObject1.put("ClientStatus", "02");
		jsonObject1.put("ClientEligibilityDateBegin", null);
		jsonObject1.put("ClientEligibilityDateEnd", null);
		jsonObject1.put(globalVariables.PayerProgram, CommonMethods.generateRandomStringOfFixLength(5));
		jsonObject1.put(globalVariables.PayerID, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject1.put(globalVariables.ClientPayerID, null);
	
		
		JSONObject jsonObject2= (JSONObject) jsonArray1.get(1);
		
		jsonObject2.put("ClientStatus", "02");
		jsonObject2.put("ClientEligibilityDateBegin", null);
		jsonObject2.put("ClientEligibilityDateEnd",  null);
		jsonObject2.put(globalVariables.PayerProgram, CommonMethods.generateRandomStringOfFixLength(5));
		jsonObject2.put(globalVariables.PayerID, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject2.put(globalVariables.ClientPayerID, null);
				
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject2);

	
	}
	
}