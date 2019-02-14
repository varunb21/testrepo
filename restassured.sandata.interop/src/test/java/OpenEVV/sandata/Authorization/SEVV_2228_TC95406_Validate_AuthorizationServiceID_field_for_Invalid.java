package OpenEVV.sandata.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95406_Validate_AuthorizationServiceID_field_for_Invalid extends BaseTest{
	
	@Test
	public void TC95406_Validate_AuthorizationServiceID_field_for_Invalid_null() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95406_Validate_AuthorizationServiceID_field_for_Invalid_null"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationServiceID", null);
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AuthorizationServiceIDerror);
	
	
	}
	
	@Test
	public void TC95406_Validate_AuthorizationServiceID_field_for_Invalid_other_than_valid() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95406_Validate_AuthorizationServiceID_field_for_Invalid_other_than_valid"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationServiceID", CommonMethods.generateRandomNumberOfFixLength(4) +'@');
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AuthorizationServiceIDformateerror);
		
	
	
	}
	
	@Test
	public void TC95406_Validate_AuthorizationServiceID_field_for_Invalid_blank() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95406_Validate_AuthorizationServiceID_field_for_Invalid_blank"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationServiceID", "");
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		String bodyget= CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader("molina_auth_get"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyget, jsonObject);
	
	}
	
	@Test
	public void TC95406_Validate_AuthorizationServiceID_field_for_Invalid_more_than_allowed_length() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95406_Validate_AuthorizationServiceID_field_for_Invalid_more_than_allowed_length"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationServiceID", CommonMethods.generateRandomNumberOfFixLength(6));
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		String bodyget= CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader("molina_auth_get"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyget, jsonObject);
		
	
	
	}
	
	
	

}
