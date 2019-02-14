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

public class SEVV_2205_TC96692_check_ClientStartOfCareDate_sent_optional extends BaseTest{
	
	@Test
	public void SEVV_2205_TC96692_check_ClientStartOfCareDate_sent_optional_in_api() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("SEVV_2205_TC96692_check_ClientStartOfCareDate_sent_optional_in_api"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("ClientEndOfCareDate", null);	
		jsonObjectPay.put("ClientStartOfCareDate", null);
		jsonObjectPay.put("ClientEligibilityDateBegin", null);	
		jsonObjectPay.put("ClientEligibilityDateEnd", null);
		
		
		

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);
}
	
	@Test
	public void SEVV_2205_TC96692_check_ClientEligibilityDateBegin_sent_optional_in_api() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("SEVV_2205_TC96692_check_ClientEligibilityDateBegin_sent_optional_in_api"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("ClientEligibilityDateBegin", null);	
		jsonObjectPay.put("ClientEligibilityDateEnd", null);
		

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);
}

	

}
