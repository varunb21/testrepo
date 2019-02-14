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

public class SEVV_2228_TC98309_Verify_AuthorizationMaximum_field extends BaseTest{
	
	@Test
	public void TC98309_Verify_AuthorizationMaximum_field_valid_value_shoulnot_saved_in_DB() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{

		logger = extent.startTest("TC98309_Verify_AuthorizationMaximum_field_valid_value_shoulnot_saved_in_DB"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationMaximum", CommonMethods.generateRandomNumberOfFixLength(4));
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyAsString, jsonObject);
		
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.auth_limit_maximum, null);
		
}

}
