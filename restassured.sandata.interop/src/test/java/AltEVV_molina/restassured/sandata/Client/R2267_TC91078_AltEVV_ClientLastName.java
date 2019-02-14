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
//Test Case 91078: OpenEVV-altEVV- Client:  Validate (mix) - ClientLastName field formats/values

public class R2267_TC91078_AltEVV_ClientLastName extends BaseTest {

	public static String ClientLastName, lastname= "L_name"; 

	//Case-1 ClientLastName: >30 characters 
	@Test 
	public void TC91078_AltEVV_ClientLastName_more_than_30chars() throws IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		logger = extent.startTest("TC91078_AltEVV_ClientLastName_more_than_30chars"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientLastName_with_more_than_30chars"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientLastName", CommonMethods.generateRandomStringOfFixLength(31));


		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientLastName value is incorrect. The length should be between 1 and 30.");
	}

	//Case-2 ClientLastName: 30 characters (max)
	@Test 
	public void TC91078_AltEVV_ClientLastName_with_string() throws IOException, ParseException, ConfigurationException, SQLException
	{
		// adding method name info via logger
		logger = extent.startTest("TC91078_AltEVV_ClientLastName_with_string"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientLastName_with_string"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientLastName", CommonMethods.generateRandomStringOfFixLength(30));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, js);	

	}	    

	//Case-3 ClientLastName: Null
	@Test 
	public void TC91078_AltEVV_ClientLastName_with_null() throws IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		logger = extent.startTest("TC91078_AltEVV_ClientLastName_with_null"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientLastName_with_null"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientLastName", null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientLastName cannot be null."));
	}	    

	//Case-5 ClientLastName: Special chars
	@Test 
	public void TC91078_AltEVV_ClientLastName_with_specialchars() throws IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		logger = extent.startTest("TC91078_AltEVV_ClientLastName_with_specialchars"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientLastName_with_specialchars"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientLastName", CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientLastName format is incorrect. The record should satisfy this regular expression");

	}

}
