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

//OpenEVV Member: Validate maximum length for PayerRegion(2)

public class R2223_TC94496_OpenEVV_Member_PayerRegion_Length extends BaseTest {

	@Test
	public void R2223_TC94496_OpenEVV_Member_PayerRegion_Length_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94496_OpenEVV_Member_PayerRegion_Length_max"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PayerRegion", CommonMethods.generateRandomNumberOfFixLength(2));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);
	}

	@Test
	public void R2223_TC94496_OpenEVV_Member_PayerRegion_Length_min() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94496_OpenEVV_Member_PayerRegion_Length_min"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PayerRegion", CommonMethods.generateRandomNumberOfFixLength(1));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}

	@Test
	public void R2223_TC94496_OpenEVV_Member_PayerRegion_Length_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94496_OpenEVV_Member_PayerRegion_Length_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PayerRegion", CommonMethods.generateRandomNumberOfFixLength(3));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerRegionLengthError);

	}

	@Test
	public void R2223_TC94496_OpenEVV_Member_PayerRegion_Length_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94496_OpenEVV_Member_PayerRegion_Length_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PayerRegion", "");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerRegionLengthError);;

	}

	@Test
	public void R2223_TC94496_OpenEVV_Member_PayerRegion_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94496_OpenEVV_Member_PayerRegion_Length_max"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PayerRegion",null);	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", jsonObject.get(globalVariables.ClientID).toString(),
				"f_name",jsonObject.get(globalVariables.ClientFirstName).toString());

		Assert.assertEquals(DataBaseVerifier_Client.ncode_inClient, "0");
	}


}