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
import com.globalMethods.core.DataGeneratorClient;

// Test Case 94704: OpenEVV Member: Validate maximum length for ClientAddressType (MemberAddressType)(12)

public class R2223_TC94704_OpenEVV_Member_ClientAddressType extends BaseTest{

	@Test(groups = { "Databasetest"})
	public void R2223_TC94705_OpenEVV_Member_ClientAddressType_validvalue_Randomly() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94705_OpenEVV_Member_ClientAddressType_validvalue_Randomly"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientAddressType, DataGeneratorClient.clientAddressType());	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObjectProg);
	}

	@Test 
	public void R2223_TC94705_OpenEVV_Member_ClientAddressType_with_invalidvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94705_OpenEVV_Member_ClientAddressType_with_invalidvalue"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientAddressType, CommonMethods.generateRandomStringOfFixLength(12));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientAddressTypeFormat);

	}

	@Test 
	public void R2223_TC94705_OpenEVV_Member_ClientAddressType_with_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94705_OpenEVV_Member_ClientAddressType_with_null"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientAddressType, "null");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientAddressTypeFormat);

	}
}
