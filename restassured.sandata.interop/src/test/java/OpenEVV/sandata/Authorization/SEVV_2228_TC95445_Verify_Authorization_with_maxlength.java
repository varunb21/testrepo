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

public class SEVV_2228_TC95445_Verify_Authorization_with_maxlength extends BaseTest{
	
	@Test
	public void TC95445_Verify_Authorization_with_maxlengths_of_fields() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95445_Verify_Authorization_with_maxlengths_of_fields"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_max_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		String bodyget= CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader("molina_auth_get"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyget, jsonObject);
		

}

}
