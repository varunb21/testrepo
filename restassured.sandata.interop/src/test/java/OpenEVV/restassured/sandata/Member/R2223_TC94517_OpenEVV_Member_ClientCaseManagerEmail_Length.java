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

//OpenEVV Member: Validate maximum length for ClientCaseManagerEmail(64)

public class R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_Length extends BaseTest {

	@Test
	public void R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_Length_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_Length_max"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientCaseManagerEmail", CommonMethods.generateEmailAddress_string(49));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}

	@Test
	public void R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_Length_min() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_Length_min"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientCaseManagerEmail",CommonMethods.generateEmailAddress_string(1));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}

	@Test
	public void R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_Length_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_Length_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientCaseManagerEmail", CommonMethods.generateEmailAddress_string(65));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCaseManagerEmailLengthError);;

	}

	@Test
	public void R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_Length_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_Length_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientCaseManagerEmail", "");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCaseManagerEmailFormatError);;

	}

	@Test
	public void R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94517_OpenEVV_Member_ClientCaseManagerEmail_Length_max"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientCaseManagerEmail", null);	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", jsonObject.get(globalVariables.ClientID).toString(),
		"f_name",jsonObject.get(globalVariables.ClientFirstName).toString());

		Assert.assertEquals(DataBaseVerifier_Client.ncode_inClient, "0");
	}


}