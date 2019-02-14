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

//OpenEVV Member: Validate maximum length for ClientContactAddressLine2(30)

public class R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length extends BaseTest {

	@Test
	public void R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_max"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactAddressLine2", CommonMethods.generateRandomStringOfFixLength(30));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientContact_Member(bodyAsString, jsonObject);
		
	}

	@Test
	public void R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_min() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_min"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactAddressLine2", CommonMethods.generateRandomStringOfFixLength(1));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientContact_Member(bodyAsString, jsonObject);
	}

	@Test
	public void R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactAddressLine2", CommonMethods.generateRandomStringOfFixLength(31));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactAddressLine2LengthError);

	}

	@Test
	public void R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactAddressLine2", "");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactAddressLine2FormatError);

	}
	
	@Test
	public void R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactAddressLine2", null);	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		DataBaseVerifier_Client.DataBaseVerification_InboxClientContact("LOC", jsonObject.get(globalVariables.ClientID).toString(),
		"f_name",jsonObject.get(globalVariables.ClientFirstName).toString());

		Assert.assertEquals(DataBaseVerifier_Client.ncode_ClientContact, "0");

	}

}