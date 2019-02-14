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

public class SEVV_2228_TC95383_AuthorizationComments_field_for_Invalid_values extends BaseTest {
	
	@Test
	public void TC95383_AuthorizationComments_field_for_Invalid_values() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95383_AuthorizationComments_field_for_Invalid_values"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		 jsonObject.put("AuthorizationComments", CommonMethods.generateRandomStringOfFixLength(1000));
		 String passtsring=jsonObject.get("AuthorizationComments").toString();
		 
				 String result = passtsring.substring(0, 200);
				 System.out.println(result);
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyAsString, jsonObject);
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.memo, result); 

	
	
	}

	@Test
	public void TC95383_AuthorizationComments_field_for_Invalid_null() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95383_AuthorizationComments_field_for_Invalid_null"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationComments", null);
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
	
	    Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	    Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	    
	    String bodyget=CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader("molina_auth_get"));
}
}
