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
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 94709:OpenEVV Member: Validate maximum length for ClientState (MemberState)(2)

public class R2223_TC94709_OpenEVV_Member_ClientState_Length extends BaseTest{

	//Case-1: Validate maximum length for ClientState 2chars and type String
	@Test(groups = { "Databasetest"})
	public void R2223_TC94709_OpenEVV_Member_ClientState_MaxLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94709_OpenEVV_Member_ClientState_MaxLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientState, DataGeneratorClient.generateClientState());	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress_Member(bodyAsString, jsonObject, jsonObjectProg);
	}

	//Case-2: Validate ClientState length less than 2chars and type String
	@Test 
	public void R2223_TC94709_OpenEVV_Member_ClientState_InvalidLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94709_OpenEVV_Member_ClientState_MaxLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientState, CommonMethods.generateRandomStringOfFixLength(1));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateLengthError);
	}

	//Case-3: Validate ClientState length more than 2chars and type String
	@Test 
	public void R2223_TC94709_OpenEVV_Member_ClientState_LengthExceeds() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94709_OpenEVV_Member_ClientState_LengthExceeds"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientState, CommonMethods.generateRandomStringOfFixLength(5));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateLengthError);
	}

	//Case-4: Validate ClientState with null
	@Test 
	public void R2223_TC94709_OpenEVV_Member_ClientState_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94709_OpenEVV_Member_ClientState_null"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientState, null);	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateNullError);
	}
}
