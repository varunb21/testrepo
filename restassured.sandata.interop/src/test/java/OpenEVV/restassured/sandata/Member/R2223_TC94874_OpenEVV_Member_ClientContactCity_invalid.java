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

public class R2223_TC94874_OpenEVV_Member_ClientContactCity_invalid extends BaseTest{

	
	@Test
	public void TC94874_OpenEVV_Member_Validate_invalid_value_for_ClientContactCity_special_character() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94874_OpenEVV_Member_Validate_invalid_value_for_ClientContactCity_special_character"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactCity", "City@");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactCityerror);

	}

	@Test
	public void TC94874_OpenEVV_Member_Validate_invalid_value_for_ClientContactCity_with_numeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94874_OpenEVV_Member_Validate_invalid_value_for_ClientContactCity_with_numeric"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactCity", "city1234");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactCityerror);

	}
	
	@Test
	public void TC94874_OpenEVV_Member_Validate_invalid_value_for_ClientContactCity_with_morethan_max_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94874_OpenEVV_Member_Validate_invalid_value_for_ClientContactCity_with_morethan_max_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactCity", "sadgjdgsajdgsajhdgsajkdgsakjdgsajkdgsajkgdsjagdsjagdsakjgdsajhdgsajdgsajgdsajgdsajkgdjsagdsjadgasjgdjasgdjsagdjsagdjsagdjsagdjsagdjsagdjsagdjasgdjsagdj");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactCitylengtherror);

	}
}
