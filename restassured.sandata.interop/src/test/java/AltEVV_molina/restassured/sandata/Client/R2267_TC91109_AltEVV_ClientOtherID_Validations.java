/**
 * 
 */
package AltEVV_molina.restassured.sandata.Client;

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
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
// Test Case 91109: OpenEVV-altEVV- Client: Validate (mix) - ClientOtherID field formats/values
public class R2267_TC91109_AltEVV_ClientOtherID_Validations extends BaseTest{

	@Test 
	public void TC91109_AltEVV_CreateClient_with_invalid_ClientOtherID_more_than_24chars() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91109_AltEVV_CreateClient_with_invalid_ClientOtherID_more_than_24chars"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomAlphaNumeric(25));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientOtherID value is incorrect. The length should be between 1 and 24.");
	}

	@Test(groups = { "Databasetest"})
	public void TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.getSaltString(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	

	}

	@Test(groups = { "Databasetest"})
	public void TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_alpha_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(20));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	

	}

	@Test(groups = { "Databasetest"})
	public void TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_alphanum_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomAlphaNumeric(24));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	

	}


}
