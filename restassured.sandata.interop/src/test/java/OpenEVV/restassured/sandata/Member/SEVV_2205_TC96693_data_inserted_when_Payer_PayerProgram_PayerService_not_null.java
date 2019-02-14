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

public class SEVV_2205_TC96693_data_inserted_when_Payer_PayerProgram_PayerService_not_null extends BaseTest{
	
	@Test
	public void SEVV_2205_TC96693_validate__data_inserted_when_Payer_PayerProgram_PayerService_not_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("SEVV_2205_TC96692_check_ClientEligibilityDateBegin_sent_optional_in_api"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("PayerProgram", "ABC9957");	
	
		
		JSONArray jsonArrPay1 = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay1 = 	(JSONObject) jsonArrPay1.get(0);
		jsonObjectPay1.put("PayerProgram", "ABC9957");	
		

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);
		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject,jsonObjectPay);
		

}
}
