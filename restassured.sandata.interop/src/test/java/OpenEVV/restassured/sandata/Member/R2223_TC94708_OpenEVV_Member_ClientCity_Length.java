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

//Test Case 94708: OpenEVV Member: Validate maximum length for ClientCity (MemberCity)(30)

public class R2223_TC94708_OpenEVV_Member_ClientCity_Length extends BaseTest{


	@Test(groups = { "Databasetest"})
	public void R2223_TC94708_OpenEVV_Member_ClientCity_MaxLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94708_OpenEVV_Member_ClientCity_MaxLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(30));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress_Member(bodyAsString, jsonObject, jsonObjectProg);
	}

	@Test
	public void R2223_TC94708_OpenEVV_Member_ClientCity_minLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94708_OpenEVV_Member_ClientCity_minLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientCity,CommonMethods.generateRandomStringOfFixLength(1));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress_Member(bodyAsString, jsonObject, jsonObjectProg);
	}

	@Test
	public void R2223_TC94708_OpenEVV_Member_ClientCity_MaxLength_Exceeds() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94708_OpenEVV_Member_ClientCity_MaxLength_Exceeds"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(35));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCityLengthError);
	}

	@Test 
	public void R2223_TC94708_OpenEVV_Member_ClientCity_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94708_OpenEVV_Member_ClientCity_null"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientCity, null);	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCity_nullerror);
	}
}
