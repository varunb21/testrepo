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

public class R679_TC95744_AltEVV_with_payers_Field extends BaseTest {


	//validating valid altEVV client  having PayerID_valid of Max Length i.e 64 char
	@Test (priority=0)
	public void R2267_TC91096_AltEVV_with_PayerIDs_info() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91096_AltEVV_with_PayerIDs_info"); 
		logger.log(LogStatus.INFO, "R2267_TC91096_AltEVV_with_PayerIDs_info");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerProgram, CommonMethods.generateRandomStringOfFixLength(9));
		jsonObject1.put(globalVariables.PayerID, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject1.put(globalVariables.ClientPayerID, CommonMethods.generateRandomNumberOfFixLength(10));
		
		JSONObject jsonObject2 = (JSONObject) jsonArray1.get(1);
		jsonObject2.put(globalVariables.PayerProgram, CommonMethods.generateRandomStringOfFixLength(9));
		jsonObject2.put(globalVariables.PayerID, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject2.put(globalVariables.ClientPayerID, CommonMethods.generateRandomNumberOfFixLength(10));
				
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject2);


	}

}