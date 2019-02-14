package OpenEVV.sandata.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95430_Verify_AuthorizationLimitStartTime_field_Invalid extends BaseTest{
	
	
	@Test
	public void TC95430_Verify_AuthorizationLimitStartTime_field_Invalid_time() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95430_Verify_AuthorizationLimitStartTime_field_Invalid_time"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "D");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("AuthorizationLimits");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("AuthorizationLimitStartTime", CommonMethods.generateRandomNumberOfFixLength(4));	
		
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AuthorizationLimitStartTimeerror);
		

}
	
	
	
	@Test
	public void TC95430_Verify_AuthorizationLimitStartTime_field_Invalid_null() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95430_Verify_AuthorizationLimitStartTime_field_Invalid_null"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "D");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("AuthorizationLimits");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("AuthorizationLimitStartTime", null);	
		
		
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		String bodyget= CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader("molina_auth_get"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyget, jsonObject);
}

	@Test
	public void TC95430_Verify_AuthorizationLimitStartTime_field_Invalid_otherthanD_with_null() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95430_Verify_AuthorizationLimitStartTime_field_Invalid_otherthanD_with_null"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "M");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("AuthorizationLimits");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("AuthorizationLimitStartTime", null);	
		
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		String bodyget= CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader("molina_auth_get"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyget, jsonObject);

}

}
