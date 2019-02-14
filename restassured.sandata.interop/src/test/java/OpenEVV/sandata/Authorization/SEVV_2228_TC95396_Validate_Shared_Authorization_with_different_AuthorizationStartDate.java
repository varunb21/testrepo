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

public class SEVV_2228_TC95396_Validate_Shared_Authorization_with_different_AuthorizationStartDate extends BaseTest{

	@Test
	public void TC95396_Validate_Shared_Authorization_with_different_AuthorizationStartDate() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{

		logger = extent.startTest("TC95396_Validate_Shared_Authorization_with_different_AuthorizationStartDate"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyAsString, jsonObject);

		jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AuthorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(4));

		jsonObject.put("AuthorizationStartDate", CommonMethods.generatePastDate_YYYY_MM_dd());
		
		String Auth_beg_date= jsonObject.get(CommonMethods.generatePastDate_YYYY_MM_dd()).toString();
		
		System.out.println(Auth_beg_date);

		String bodyAsStringnew = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		Assertion_DbVerifier.jsonAssert_Authorizationpass(bodyAsStringnew, jsonObject);
		//CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.auth_start_date, Auth_beg_date ); 
		Assert.assertNotEquals(DataBaseVerifier_Client.auth_start_date, Auth_beg_date);



	}

}
