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

//Ravi

public class R2223_TC94923_OpenEVV_Member_ClientEligibilityDateEnd_fields_YYYY_MM_DD extends BaseTest{

	@Test
	public void R2223_TC94923_ClientEligibilityDateEnd_fields_accept_YYYY_MM_DD() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_will_accept_YYYY-MM-DD"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArrayElig = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectElig = (JSONObject) jsonArrayElig.get(0);
		jsonObjectElig.put("ClientEligibilityDateEnd", "2023-12-12");	
		
		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_Authorizations(bodyAsString,jsonObject);

	}

	@Test
	public void TC94923_ClientEligibilityDateEnd_fields_invalid_YYYYMMDD() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_invalid_YYYYMMDD"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "20181213");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);

	}

	@Test
	public void TC94923_ClientEligibilityDateEnd_fields_invalid_DDMMYYYY() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_invalid_DDMMYYYY"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "12122018");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);

	}

	@Test
	public void TC94923_ClientEligibilityDateEnd_fields_invalid_MMDDYYYY() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_invalid_MMDDYYYY"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "11282019");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);

	}

	@Test
	public void TC94923_ClientEligibilityDateEnd_fields_invalid_dateascaharcter() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_invalid_dateascaharcter"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "aaaa-bb-ccc");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);

	}

	@Test
	public void TC94923_ClientEligibilityDateEnd_fields__invalid_hiphen() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_invalid_(-20181912)"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "-20181912");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);

	}

	@Test
	public void TC94923_ClientEligibilityDateEnd_fields__invalid_slash() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94923_ClientEligibilityDateEnd_invalid(2018/19/12)"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "2018/19/12");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);

	}

}
