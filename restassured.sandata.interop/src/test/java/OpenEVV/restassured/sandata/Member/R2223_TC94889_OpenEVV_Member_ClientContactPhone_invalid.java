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

public class R2223_TC94889_OpenEVV_Member_ClientContactPhone_invalid extends BaseTest{
	
	@Test
	public void TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_special_character() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_special_character"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactPhone", "123456789@");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneerror);

	}

	@Test
	public void TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_space() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_space"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactPhone", "12345 567890");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneerror);

	}
	
	@Test
	public void TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_character() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_character"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactPhone", "123456789a");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneerror);

	}
	
	@Test
	public void TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_lessthan_allowed() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_lessthan_allowed"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactPhone", "1234567");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneerror);

	}
	

	

}
