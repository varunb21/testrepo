package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;
import Utills_ExtentReport_Log4j.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

// Test Case 94489:OpenEVV Member: Validate maximum length for PayerProgram(9)

public class R2223_TC94489_OpenEVV_Member_PayerProgram_Length extends BaseTest {

	@Test
	public void R2223_TC94489_OpenEVV_Member_PayerProgram_Length_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94489_OpenEVV_Member_PayerProgram_Length_max"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String payerProgram = CommonMethods.generateRandomAlphaNumeric(9);
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("PayerProgram", payerProgram);
		
		JSONArray jsonArrElig = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectElig = 	(JSONObject) jsonArrElig.get(0);
		jsonObjectElig.put("PayerProgram", payerProgram);
		
		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject, jsonObjectPay);

	}

	@Test
	public void R2223_TC94489_OpenEVV_Member_PayerProgram_Length_min() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94489_OpenEVV_Member_PayerProgram_Length_min"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String payerProgram = CommonMethods.generateRandomAlphaNumeric(1);
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("PayerProgram", payerProgram);
		
		JSONArray jsonArrElig = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectElig = 	(JSONObject) jsonArrElig.get(0);
		jsonObjectElig.put("PayerProgram", payerProgram);
		
		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject, jsonObjectPay);

	}

	@Test
	public void R2223_TC94489_OpenEVV_Member_PayerProgram_Length_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94489_OpenEVV_Member_PayerProgram_Length_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("PayerProgram", CommonMethods.generateRandomStringOfFixLength(10));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerProgramLengthError);;

	}

}

