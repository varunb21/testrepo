package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//OpenEVV Member: Validate maximum length for ClientMaritalStatus(1)

public class R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_Length extends BaseTest {

	@Test
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", "M");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}

	@Test
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_S() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", "S");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}

	@Test
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_W() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", "W");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}

	@Test
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_O() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", "O");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}

	@Test
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_invalid_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", CommonMethods.generateRandomStringOfFixLength(2));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMaritalStatusLengthError);;
	}

	@Test
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_invalid_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_invalid_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", "");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMaritalStatusFormatError);;
	}

	@Test
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_null"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", null);	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", jsonObject.get(globalVariables.ClientID).toString(),
				"f_name",jsonObject.get(globalVariables.ClientFirstName).toString());

		Assert.assertEquals(DataBaseVerifier_Client.ncode_inClient, "0");

	}



}

