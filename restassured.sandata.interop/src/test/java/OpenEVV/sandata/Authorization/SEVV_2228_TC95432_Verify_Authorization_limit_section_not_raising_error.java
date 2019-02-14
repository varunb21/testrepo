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

public class SEVV_2228_TC95432_Verify_Authorization_limit_section_not_raising_error extends BaseTest{
	
	
	@Test
	public void TC95432_Verify_Authorization_limit_section_not_raising_error_with_null_value_of_limits() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95432_Verify_Authorization_limit_section_not_raising_error_with_null_value_of_limits"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "N");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("AuthorizationLimits");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("AuthorizationLimit", null);	
		jsonObjectPay.put("AuthorizationWeekStart", null);
		jsonObjectPay.put("AuthorizationLimitDayOfWeek", null);
		jsonObjectPay.put("AuthorizationLimitStartTime", null);
		jsonObjectPay.put("AuthorizationLimitEndTime", null);
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		String bodyget= CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader("molina_auth_get"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyget, jsonObject);

}

}
