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

// Test Case 94710:OpenEVV Member: Validate maximum length for ClientZip (MemberZip)(9)

public class R2223_TC94710_OpenEVV_Member_ClientZip_Length extends BaseTest{

	//Case-1: Validate maximum length for ClientZip (MemberZip) 9chars and type String
	@Test(groups = { "Databasetest"})
	public void R2223_TC94710_OpenEVV_Member_ClientZip_MaxLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94710_OpenEVV_Member_ClientZip_MaxLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientZip, CommonMethods.generateRandomNumberOfFixLength(9));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress_Member(bodyAsString, jsonObject, jsonObjectProg);
	}

	//Case-2: Validate maximum length for ClientZip (MemberZip) less than 9chars and type String
	@Test(groups = { "Databasetest"})
	public void R2223_TC94710_OpenEVV_Member_ClientZip_validLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94710_OpenEVV_Member_ClientZip_validLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientZip, CommonMethods.generateRandomNumberOfFixLength(9));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress_Member(bodyAsString, jsonObject, jsonObjectProg);
	}

	//Case-3: Validate maximum length for ClientZip (MemberZip) more than 9chars and type String			
	@Test 
	public void R2223_TC94710_OpenEVV_Member_ClientZip_invalidLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94710_OpenEVV_Member_ClientZip_invalidLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientZip, CommonMethods.generateRandomNumberOfFixLength(10));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipSizeError);
	}

}
