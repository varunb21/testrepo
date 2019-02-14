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
import com.globalMethods.core.DataBaseVerifier_Client;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95387_Verify_AuthorizationLimitType_as_N extends BaseTest{
	
	
	@Test
	public void TC95387_Verify_AuthorizationLimitType_as_N_is_being_ignored() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95384_Verify_AuthorizationLimitType_for_Invalid_values_character_morethan_allowed"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "N");
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		Assertion_DbVerifier.jsonAssert_Authsuccess(bodyAsString, jsonObject);
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.day_number, "0"); 
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.auth_limits, "0");
	
		
	}

}
