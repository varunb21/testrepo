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

public class R2223_TC94718_Validate_invalid_value_for_ClientEndOfCareDate extends BaseTest{
	
	@Test
	public void R2223_TC94718_Validate_ClientEndOfCareDate_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94718_Validate_ClientEndOfCareDate_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("ClientEndOfCareDate", "18-12-31");

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEndOfCareDateerror);
	
	}

	@Test
	public void R2223_TC94718_Validate_invalid_value_for_ClientEndOfCareDate_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94718_Validate_invalid_value_for_ClientEndOfCareDate_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		JSONArray jsonArrayElig = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectElig = 	(JSONObject) jsonArrayElig.get(0);
		jsonObjectElig.put("ClientEndOfCareDate", CommonMethods.generatePastDate_YYYY_MM_dd());
	
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject, jsonObjectProg);
	}


}
