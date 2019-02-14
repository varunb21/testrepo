package OpenEVV.sandata.Authorization;

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

public class SEVV_2228_TC95384_Verify_AuthorizationLimitType_for_Invalid extends BaseTest {
	
	@Test
	public void TC95384_Verify_AuthorizationLimitType_for_Invalid_values() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95384_Verify_AuthorizationLimitType_for_Invalid_values"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", CommonMethods.generateRandomAlphaNumeric(3));
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Authorizationlimittypeerror);
		
	
	
	}
	
	@Test
	public void TC95384_Verify_AuthorizationLimitType_for_Invalid_values_specialcharacter() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95384_Verify_AuthorizationLimitType_for_Invalid_values_specialcharacter"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", CommonMethods.generateSpecialChar(1));
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Authorizationlimittypeerror);
		
	
	
	}
	
	@Test
	public void TC95384_Verify_AuthorizationLimitType_for_Invalid_values_character_morethan_allowed() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95384_Verify_AuthorizationLimitType_for_Invalid_values_character_morethan_allowed"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", CommonMethods.generateRandomStringOfFixLength(2));
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Authorizationlimittypeerror);
		
	
	
	}

}
