/**
 * 
 */
package AltEVV_molina.restassured.sandata.Client;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

/**
 * @author Anupam
 *
 */
public class R2267_TC91108_AltEVV_ClientCustomID_Validations extends BaseTest 
{

	//Case-1 Testing with ClientCustomID: >24 characters 
	@Test 
	public void TC91108_AltEVV_CreateClient_with_ClientCustomID_more_than_24charslength() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91108_AltEVV_CreateClient_with_ClientCustomID_more_than_24charslength"); 

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientCustomID", CommonMethods.generateRandomAlphaNumeric(25));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assert.assertTrue(bodyAsString.contains( "The ClientCustomID value is incorrect. The length should be between 1 and 24."));

	}

	@Test(groups = { "Databasetest"})
	public void TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_alphanum_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientCustomID", CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	


	}

	@Test(groups = { "Databasetest"})
	public void TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_num_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientCustomID", CommonMethods.generateRandomNumberOfFixLength(13));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	


	}

	@Test(groups = { "Databasetest"})
	public void TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientCustomID", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	


	}

}
