/**
 * 
 */
package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

//Test Case 94707: OpenEVV Member: Validate maximum length for ClientCounty (MemberCounty)(25)

public class R2223_TC94707_OpenEVV_Member_ClientCounty_Length extends BaseTest {

	//Case-1: Validate maximum length for ClientCounty (MemberCounty)(25)
	@Test(groups = { "Databasetest"})
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_MaxLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_MaxLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientCounty, CommonMethods.generateRandomStringOfFixLength(25));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress_Member(bodyAsString, jsonObject, jsonObjectProg);
	}

	//Case-2: Validate valid length(5) for ClientCounty (MemberCounty)(25)
	@Test(groups = { "Databasetest"})
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_validLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_validLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientCounty, CommonMethods.generateRandomStringOfFixLength(5));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress_Member(bodyAsString, jsonObject, jsonObjectProg);
	}

	//Case-3: Validate ClientCounty (MemberCounty)(25) exceed max length(27)
	@Test 
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_invalidLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_validLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientCounty, CommonMethods.generateRandomStringOfFixLength(28));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCountyLength);

		//Assert.assertEquals(DataBaseVerifier_Client.ncode, "0");
	}

	//Case-4: Validate ClientCounty (MemberCounty)(25) with null
	@Test 
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_with_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_with_null"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientCounty, null);	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

	}

	//Case-5: Validate ClientCounty (MemberCounty)(25) with Alphanumeric
	@Test 
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_with_alphanumeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_with_alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientCounty, CommonMethods.generateRandomAlphaNumeric(10));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCountyFormatError);
	}

	//Case-6: Validate ClientCounty (MemberCounty)(25) with special chars
	@Test 
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_with_specialchars() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_with_specialchars"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientCounty, CommonMethods.generateSpecialChar(8));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCountyFormatError);
	}
}
