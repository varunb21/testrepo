package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95418_Verify_AuthorizationWeekStart_field_for_Invalid extends BaseTest{

	@Test
	public void TC95418_Verify_AuthorizationWeekStart_field_for_Invalid_character() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95418_Verify_AuthorizationWeekStart_field_for_Invalid_character"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "W");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("AuthorizationLimits");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("AuthorizationWeekStart", CommonMethods.generateRandomStringOfFixLength(4));	
		
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Authorizationweekstarterror);
		

}
	
	@Test
	public void TC95418_Verify_AuthorizationWeekStart_field_for_Invalid_specialcharacter() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95418_Verify_AuthorizationWeekStart_field_for_Invalid_specialcharacter"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "W");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("AuthorizationLimits");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("AuthorizationWeekStart", CommonMethods.generateSpecialChar(4));	
		
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Authorizationweekstarterror);
		

}
	
	@Test
	public void TC95418_Verify_AuthorizationWeekStart_field_for_Invalid_null() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95418_Verify_AuthorizationWeekStart_field_for_Invalid_null"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "W");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("AuthorizationLimits");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("AuthorizationWeekStart", null);	
		
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Authorizationweekstartinvaliderror);
		

}
	
	
}
