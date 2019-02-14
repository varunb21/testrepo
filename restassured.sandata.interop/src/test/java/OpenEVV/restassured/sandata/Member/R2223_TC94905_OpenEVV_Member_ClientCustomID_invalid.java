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

public class R2223_TC94905_OpenEVV_Member_ClientCustomID_invalid extends BaseTest {
	
	@Test
	public void TC94905_OpenEVV_Member_Validate_invalid_value_for_ClientCustomID_alphanumeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94905_OpenEVV_Member_Validate_invalid_value_for_ClientCustomID_alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		jsonObject.put("ClientCustomID", CommonMethods.generateRandomAlphaNumeric(10));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);
	}
	
	@Test
	public void TC94905_OpenEVV_Member_Validate_invalid_value_for_ClientCustomID_withspecialcharacter() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94905_OpenEVV_Member_Validate_invalid_value_for_ClientCustomID_withspecialcharacter"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientCustomID", "abcd123@");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Clientcustomiderror);

	}
	
	@Test
	public void TC94905_OpenEVV_Member_Validate_invalid_value_for_ClientCustomID_withspace() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94905_OpenEVV_Member_Validate_invalid_value_for_ClientCustomID_withspace"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientCustomID", "abcd 123");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Clientcustomiderror);

	}
	

}
