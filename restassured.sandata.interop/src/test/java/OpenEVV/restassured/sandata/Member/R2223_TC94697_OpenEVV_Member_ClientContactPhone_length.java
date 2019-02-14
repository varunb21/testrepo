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
import com.globalMethods.core.DataBaseVerifier_Client;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 94697: OpenEVV Member: Validate maximum length for ClientContactPhone (MemberContactPhone)(10)

public class R2223_TC94697_OpenEVV_Member_ClientContactPhone_length extends BaseTest{

	//Case-1: Validate  ClientContactPhone with max length(10)

	@Test(groups = { "Databasetest"})
	public void R2223_TC94697_OpenEVV_Member_ClientContactPhone_Max_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94697_OpenEVV_Member_ClientContactPhone_Max_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(10));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientContact_Member(bodyAsString, jsonObject);

	}

	//Case-2: Validate  ClientContactPhone with invalid length(<10)

	@Test 
	public void R2223_TC94697_OpenEVV_Member_ClientContactPhone_invalid_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94697_OpenEVV_Member_ClientContactPhone_invalid_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(7));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhone_error);
		//CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhone_length);


	}

	//Case-3: Validate  ClientContactPhone Exceed Max length(12)

	@Test 
	public void R2223_TC94697_OpenEVV_Member_ClientContactPhone_exceed_Max_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94697_OpenEVV_Member_ClientContactPhone_exceed_Max_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(12));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhone_error);
		//CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhone_format);

	}

	//Case-4: Validate  ClientContactPhone with null

	@Test 
	public void R2223_TC94697_OpenEVV_Member_ClientContactPhone_with_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94697_OpenEVV_Member_ClientContactPhone_with_null"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientContactPhone, null);	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		DataBaseVerifier_Client.DataBaseVerification_InboxClientContact("LOC", jsonObject.get(globalVariables.ClientID).toString(),
		"f_name",jsonObject.get(globalVariables.ClientFirstName).toString());

		Assert.assertEquals(DataBaseVerifier_Client.ncode_ClientContact, "0");
	}

}
