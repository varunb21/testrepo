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

public class SEVV_2228_TC95395_Validate_Shared_Authorization_Different_data_Set extends BaseTest{
	
	@Test
	public void TC95395_Validate_Shared_Authorization_Different_data_Set() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{

		logger = extent.startTest("TC95395_Validate_Shared_Authorization_Different_data_Set"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyAsString, jsonObject);
		
		jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("AuthorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(4));
		jsonObject.put("PayerID", CommonMethods.generateRandomAlphaNumeric(8));
		jsonObject.put("ClientIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject.put("AuthorizationStartDate", CommonMethods.generatePastDate_YYYY_MM_dd());
		
		String bodyAsStringnew = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyAsStringnew, jsonObject);

		
}

}
