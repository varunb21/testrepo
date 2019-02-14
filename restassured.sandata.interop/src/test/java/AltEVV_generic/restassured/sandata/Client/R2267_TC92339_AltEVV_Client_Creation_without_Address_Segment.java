package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 92339: Open EVV - Alt EVV - Validate client creation without Address Segment
/**
 * @author Anupam
 *
 */

public class R2267_TC92339_AltEVV_Client_Creation_without_Address_Segment extends BaseTest{

	//Case-1 Testing Client json without Address Segment
	@Test 
	public void TC92339_Alt_EVV_Client_Creation_without_Address_Segment() throws IOException, ParseException, ConfigurationException
	{   
		logger = extent.startTest("TC92339_Alt_EVV_Client_Creation_without_Address_Segment"); 
		logger.log(LogStatus.INFO, "Validating Client_Creation_without_Address_Segment"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonarray_sub= (JSONArray) jsonObject.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientState");
		js_s.remove("ClientCounty");
		js_s.remove("ClientAddressLatitude");
		js_s.remove("ClientAddressLongitude");
		js_s.remove("ClientZip");
		js_s.remove("ClientAddressLine2");
		js_s.remove("ClientAddressLine1");
		js_s.remove("ClientAddressType");
		js_s.remove("ClientCity");
		js_s.remove("ClientAddressIsPrimary");
		
		

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState cannot be null.");
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientZip cannot be null.");
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientCity cannot be null.");
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine1 cannot be null.");
	}
	
	@Test 
	public void TC92339_Alt_EVV_Client_Creation_without_Address_Segment_add() throws IOException, ParseException, ConfigurationException
	{   
		logger = extent.startTest("TC92339_Alt_EVV_Client_Creation_without_Address_Segment"); 
		logger.log(LogStatus.INFO, "Validating Client_Creation_without_Address_Segment"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonarray_sub= (JSONArray) jsonObject.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientState");
		js_s.remove("ClientCounty");
		js_s.remove("ClientAddressLatitude");
		js_s.remove("ClientAddressLongitude");
		js_s.remove("ClientZip");
		js_s.remove("ClientAddressLine2");
		js_s.remove("ClientAddressLine1");
		js_s.remove("ClientAddressType");
		js_s.remove("ClientCity");
		js_s.remove("ClientAddressIsPrimary");
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState cannot be null.");
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientZip cannot be null.");
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientCity cannot be null.");
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine1 cannot be null.");
	}

	public static String ClientAddress_Type, ClientAddressType="addr_type_qlfr", ClientAddressLine1="addr1" , ClientAddress_Line1 , Client_State, ClientState="state" ;

	//Case-2 Testing Client json with Address Segment (valid)
	@Test(groups = { "Databasetest"})
	public void TC92339_Alt_EVV_Client_Creation_with_Address_Segment() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		logger = extent.startTest("TC92339_Alt_EVV_Client_Creation_with_Address_Segment"); 
		logger.log(LogStatus.INFO, "Validating Client_Creation_with_Address_Segment"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonarray_sub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		JSONObject jsonObject3 = (JSONObject) jsonarray_sub.get(1);

		jsonObject3.put(globalVariables.ClientAddressType, DataGeneratorClient.clientAddressType());
		jsonObject3.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(15));
		jsonObject3.put(globalVariables.ClientState, DataGeneratorClient.generateClientState());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObject3);
	}

}
