package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2223_TC94901_OpenEVV_Member_ClientContactZip_invalid extends BaseTest{
	

	@Test
	public void TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_withspeciachracter() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_withspeciachracter"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	
		jsonObject.put("ClientContactZip", "12345678@");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientcontactZiperror);

	}
	
	@Test
	public void TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_withmorethan9() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_withmore than 9 characters"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactZip", "123456789012");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientcontactZiperror1);

	}
	
	@Test
	public void TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_withspace() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_withspace"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactZip", "12345 6789");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientcontactZiperror);

	}
	
	@Test
	public void TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_hiphen() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_withhiphen"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactZip", "12345-23@");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientcontactZiperror);

	}

	@Test
	public void TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_alphanumeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactZip", "12345789a");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientcontactZiperror);

	}
	
	@Test
	public void TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_alpha() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94901_OpenEVV_Member_Validate_invalid_value_for_ClientContactZip_withcharonly"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactZip", "bcdea");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientcontactZiperror);

	}
}
