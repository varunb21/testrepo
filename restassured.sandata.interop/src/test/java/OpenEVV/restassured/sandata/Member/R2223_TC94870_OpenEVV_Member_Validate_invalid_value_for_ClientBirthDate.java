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

public class R2223_TC94870_OpenEVV_Member_Validate_invalid_value_for_ClientBirthDate extends BaseTest{
	
	@Test
	public void TC94870_OpenEVV_Member_Validate_invalid_value_for_ClientBirthDate_Invalid_format1() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94870_OpenEVV_Member_Validate_invalid_value_for_ClientBirthDate_Invalid_DDMMYYYY");
		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientBirthDate", "28111998");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror);

	}
	@Test
	public void TC94870_OpenEVV_Member_Validate_invalid_value_for_ClientBirthDate_Invalid_format2() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94870_OpenEVV_Member_Validate_invalid_value_for_ClientBirthDate_Invalid_format_YYYYDDMM"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientBirthDate", "19962710");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror);

	}

}
