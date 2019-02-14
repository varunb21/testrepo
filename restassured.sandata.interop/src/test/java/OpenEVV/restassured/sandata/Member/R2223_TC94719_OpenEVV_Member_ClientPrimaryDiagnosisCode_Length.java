/**
 * 
 */
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

// Test Case 94719: OpenEVV Member: Validate values ClientPrimaryDiagnosisCode (MemberPrimaryDiagnosisCode)(10)

public class R2223_TC94719_OpenEVV_Member_ClientPrimaryDiagnosisCode_Length extends BaseTest{

	@Test(groups = { "Databasetest"})
	public void R2223_TC94719_OpenEVV_Member_ClientPrimaryDiagnosisCode_validLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94719_OpenEVV_Member_ClientPrimaryDiagnosisCode_validLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		
		jsonObjectProg.put(globalVariables.ClientPrimaryDiagnosisCode, "M54.2");
		jsonObjectProg.put(globalVariables.PayerID, CommonMethods.generateRandomAlphaNumeric(5));
		
		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_Authorizations(bodyAsString, jsonObject);
		
	}

	@Test 
	public void R2223_TC94719_OpenEVV_Member_ClientPrimaryDiagnosisCode_exceed_MaxLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94719_OpenEVV_Member_ClientPrimaryDiagnosisCode_exceed_MaxLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientPrimaryDiagnosisCode, CommonMethods.generateRandomAlphaNumeric(11));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientPrimaryDiagnosisCode_length);
	}
}
