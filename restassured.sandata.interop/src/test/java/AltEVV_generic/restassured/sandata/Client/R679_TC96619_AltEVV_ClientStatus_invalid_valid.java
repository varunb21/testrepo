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

public class R679_TC96619_AltEVV_ClientStatus_invalid_valid extends BaseTest {

	
	@Test (priority=0)
	public void R679_TC96619_AltEVV_ClientStatus_valid_01() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC96619_AltEVV_ClientStatus_valid_01"); 
		logger.log(LogStatus.INFO, "R679_TC96619_AltEVV_ClientStatus_valid_01");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientStatus", "01");
		jsonObject1.put("ClientEligibilityDateBegin", null);
		jsonObject1.put("ClientEligibilityDateEnd", null);

		JSONObject jsonObject2= (JSONObject) jsonArray1.get(1);
		jsonObject2.put("ClientStatus", "01");
		jsonObject2.put("ClientEligibilityDateBegin", null);
		jsonObject2.put("ClientEligibilityDateEnd",  null);

		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject2);

	}
	
	@Test (priority=0)
	public void R679_TC96619_AltEVV_ClientStatus_valid_02() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC96619_AltEVV_ClientStatus_valid_02"); 
		logger.log(LogStatus.INFO, "R679_TC96619_AltEVV_ClientStatus_valid_02");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientStatus", "02");
		jsonObject1.put("ClientEligibilityDateBegin", null);
		jsonObject1.put("ClientEligibilityDateEnd", null);
		
		JSONObject jsonObject2 = (JSONObject) jsonArray1.get(1);
		jsonObject2.put("ClientStatus", "02");
		jsonObject2.put("ClientEligibilityDateBegin", null);
		jsonObject2.put("ClientEligibilityDateEnd", null);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
	
	}
	
	@Test (priority=0)
	public void R679_TC96619_AltEVV_ClientStatus_valid_03() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC96619_AltEVV_ClientStatus_valid_03"); 
		logger.log(LogStatus.INFO, "R679_TC96619_AltEVV_ClientStatus_valid_03");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientStatus", "03");
		jsonObject1.put("ClientEligibilityDateBegin", null);
		jsonObject1.put("ClientEligibilityDateEnd", null);
		
		JSONObject jsonObject2 = (JSONObject) jsonArray1.get(1);
		jsonObject2.put("ClientStatus", "03");
		jsonObject2.put("ClientEligibilityDateBegin", null);
		jsonObject2.put("ClientEligibilityDateEnd", null);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
	
	}
	@Test (priority=0)
	public void R679_TC96619_AltEVV_ClientStatus_valid_04() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC96619_AltEVV_ClientStatus_valid_04"); 
		logger.log(LogStatus.INFO, "R679_TC96619_AltEVV_ClientStatus_valid_04");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientStatus", "04");
		jsonObject1.put("ClientEligibilityDateBegin", null);
		jsonObject1.put("ClientEligibilityDateEnd", null);
		
		JSONObject jsonObject2 = (JSONObject) jsonArray1.get(1);
		jsonObject2.put("ClientStatus", "04");
		jsonObject2.put("ClientEligibilityDateBegin", null);
		jsonObject2.put("ClientEligibilityDateEnd", null);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
	
	}
	
}