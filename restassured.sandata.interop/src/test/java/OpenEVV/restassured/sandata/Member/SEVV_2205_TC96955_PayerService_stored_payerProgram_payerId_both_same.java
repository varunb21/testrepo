package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2205_TC96955_PayerService_stored_payerProgram_payerId_both_same extends BaseTest {
	
	String PayerProgram=CommonMethods.generateRandomAlphaNumeric(9);
	String PayerID=CommonMethods.generateRandomNumberOfFixLength(12);
	
	@Test
	public void SEVV_2205_TC96955_PayerService_stored_payerProgram_payerId_both_are_same() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("SEVV_2205_TC96955_PayerService_stored_payerProgram_payerId_both_are_same"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("PayerProgram", PayerProgram);	
		jsonObjectPay.put("PayerID", PayerID);
	
		
		JSONArray jsonArrPay1 = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay1 = 	(JSONObject) jsonArrPay1.get(0);
		jsonObjectPay1.put("PayerProgram", PayerProgram);
		jsonObjectPay1.put("PayerID", PayerID);
		

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);
		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject,jsonObjectPay);
		

}
	
	
	@Test
	public void SEVV_2205_TC96955_PayerService_stored_payerProgram_payerId_both_are_not_same() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("SEVV_2205_TC96955_PayerService_stored_payerProgram_payerId_both_are_not_same"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("PayerProgram", CommonMethods.generateRandomAlphaNumeric(10));	
		jsonObjectPay.put("PayerID", CommonMethods.generateRandomNumberOfFixLength(12));
	
		
		JSONArray jsonArrPay1 = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay1 = (JSONObject) jsonArrPay1.get(0);
		jsonObjectPay1.put("PayerProgram", CommonMethods.generateRandomAlphaNumeric(10));
		jsonObjectPay1.put("PayerID", CommonMethods.generateRandomNumberOfFixLength(12));
		
		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	
		

}
	


}
