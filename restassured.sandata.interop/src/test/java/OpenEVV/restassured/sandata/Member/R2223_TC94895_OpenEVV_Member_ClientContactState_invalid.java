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

public class R2223_TC94895_OpenEVV_Member_ClientContactState_invalid extends BaseTest {
	
	@Test
	public void TC94895_OpenEVV_Member_Validate_invalid_value_for_ClientContactState_numeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94895_OpenEVV_Member_Validate_invalid_value_for_ClientContactState_invalid_value_numeric("); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactState", "12");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactStateerror);

	}

	@Test
	public void TC94895_OpenEVV_Member_Validate_invalid_value_for_ClientContactState_withtnvalidchar() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94895_OpenEVV_Member_Validate_invalid_value_for_ClientContactState_withtnvalidchar"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactState", "II");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactStateerror);

	}
	
	@Test
	public void TC94895_OpenEVV_Member_Validate_invalid_value_for_ClientContactState_morethanmaxlength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94895_OpenEVV_Member_Validate_invalid_value_for_ClientContactState_morethanmaxlength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientContactState", "AWSDERT");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactStateerror1);

	}
	

}
