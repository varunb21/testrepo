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

public class SEVV_2228_TC95402_Validate_EmployeeID_field_for_Invalid extends BaseTest{
	
	@Test
	public void TC95402_Validate_EmployeeID_field_for_Invalid_null() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95402_Validate_EmployeeID_field_for_Invalid_null"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeID", null);
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		
		String bodyget= CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader("molina_auth_get"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyget, jsonObject);
				
	
	
	}
	
	
	
	@Test
	public void TC95402_Validate_EmployeeID_field_for_Invalid_blank() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95402_Validate_EmployeeID_field_for_Invalid_blank"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeID", "");
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDformaterror);
		
	
	
	}
	
	@Test
	public void TC95402_Validate_EmployeeID_field_for_Invalid_more_than_allowed_length() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95402_Validate_EmployeeID_field_for_Invalid_more_than_allowed_length"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(25));
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDerror);
		
	
	
	}

}
