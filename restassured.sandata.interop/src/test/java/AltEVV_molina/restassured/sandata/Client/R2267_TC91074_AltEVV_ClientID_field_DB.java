package AltEVV_molina.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;
import java.sql.SQLException;

//Test Case 91074: OpenEVV-altEVV- Client: Validate (mix) - ClientID field formats/values

public class R2267_TC91074_AltEVV_ClientID_field_DB extends BaseTest{

	public static String ClientID, id= "loc";

	//Case-1 Testing with ClientID_more_than_10chars
	@Test 
	public void TC91074_AltEVV_ClientID_more_than_10chars() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91074_AltEVV_ClientID_more_than_10chars"); 

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", "92292345789");   // ---------->Case-1 (ClientID: >10 characters)

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientID value is incorrect. The length should be between 1 and 10.");

	}
	//Case-2 Testing with ClientID_String
	@Test 
	public void TC91074_AltEVV_ClientID_with_String() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91074_AltEVV_ClientID_with_String"); 

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", "AN9S7");   

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	//Validating the expected Result
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, js);	

	}
	//Case-3 Testing with ClientID_null
	@Test 
	public void TC91074_AltEVV_ClientID_with_null() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91074_AltEVV_ClientID_with_null"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientID_with_null"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", null);  

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerification_STXClient("l_name", js.get(globalVariables.ClientLastName).toString(),
				"f_name",js.get(globalVariables.ClientFirstName).toString());
	
	}

	//Case-4 Testing with ClientID and DB verification
	@Test(groups = {"Databasetest"})
	public void TC91074_AltEVV_ClientID_DB_verification() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91074_AltEVV_ClientID_DB_verification"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientID_DB_verify"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);

		ClientID=js.get("ClientID").toString();
		System.out.println(ClientID);

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, js);	


	}
}