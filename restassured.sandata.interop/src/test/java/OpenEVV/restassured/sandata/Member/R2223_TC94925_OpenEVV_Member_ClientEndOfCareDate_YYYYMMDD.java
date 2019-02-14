package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2223_TC94925_OpenEVV_Member_ClientEndOfCareDate_YYYYMMDD extends BaseTest{
	
	@Test
	public void R2223_TC94925_ClientEndOfCareDate_fields_accept_YYYY_MM_DD() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94925_ClientEndOfCareDate_fields_accept_YYYY_MM_DD"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayElig = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectElig = (JSONObject) jsonArrayElig.get(0);
		
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);


		jsonObjectElig.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(8));
		jsonObjectElig.put("ClientEndOfCareDate", DataGeneratorVisit.generateScheduleStartTime());

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
		
		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject, jsonObjectProg);

	}
@Test
	public void TC94926_ClientStatusDate_MemberStatusDate_fields_YYYYMMDD() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94925_ClientEndOfCareDate_fields_YYYYMMDD"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEndOfCareDate", "20181223");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEndOfCareDateerror);

	}

@Test
public void TC94925_ClientEndOfCareDate_fields_DDMMYYYY() throws IOException, ParseException, SQLException
{
	logger = extent.startTest("TC94925_ClientEndOfCareDate_fields_DDMMYYYY"); 

	JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
	JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	jsonObjectProg.put("ClientEndOfCareDate", "26112020");		

	String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEndOfCareDateerror);

}

@Test
public void TC94925_ClientEndOfCareDate_fields_MMDDYYYY() throws IOException, ParseException, SQLException
{
	logger = extent.startTest("TC94925_ClientEndOfCareDate_fields_MMDDYYYY"); 

	JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
	JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	jsonObjectProg.put("ClientEndOfCareDate", "11272021");		

	String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEndOfCareDateerror);

}
@Test
public void TC94925_ClientEndOfCareDate_fields_dateascaharcter() throws IOException, ParseException, SQLException
{
	logger = extent.startTest("TC94925_ClientEndOfCareDate_fields_dateascaharcter"); 

	JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
	JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	jsonObjectProg.put("ClientEndOfCareDate", "aaaa-bb-cc");	

	String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEndOfCareDateerror);

}
@Test
public void TC94925_ClientEndOfCareDate_fields_invalid_hiphen() throws IOException, ParseException, SQLException
{
	logger = extent.startTest("TC94925_ClientEndOfCareDate_fields_(-20181912)"); 

	JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
	JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	jsonObjectProg.put("ClientEndOfCareDate", "2018-12-12-");

	String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEndOfCareDateerror);

}

}
