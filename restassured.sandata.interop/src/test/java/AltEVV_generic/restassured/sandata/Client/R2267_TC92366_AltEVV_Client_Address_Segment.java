package AltEVV_generic.restassured.sandata.Client;

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

public class R2267_TC92366_AltEVV_Client_Address_Segment extends BaseTest{

	//Case-1 Testing without ClientOtherID field
	@Test 
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientstate() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientstate"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientState");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState cannot be null.");
	}

	@Test 
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientZIP() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientZIP"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientZip");


		logger.log(LogStatus.INFO, "Passing all parameters without ClientState");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientZip cannot be null.");
	}

	@Test 
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_cliencity() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_cliencity"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientCity");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientCity cannot be null.");
	}

	@Test 
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clienaddress1() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clienaddress1"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientAddressLine1");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine1 cannot be null.");
	}

	@Test
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientcounty() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientcounty"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientCounty");

		JSONObject js_s1 = (JSONObject) jsonarray_sub.get(1);
		//js_s1.remove("ClientCounty");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, js, js_s1);
	}

	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientstate_add() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientstate_add"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientState");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState cannot be null.");
	}

	@Test 
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientZIP_add() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientZIP_add"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientZip");


		logger.log(LogStatus.INFO, "Passing all parameters without ClientState");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientZip cannot be null.");
	}

	@Test 
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_cliencity_add() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_cliencity_add"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientCity");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientCity cannot be null.");
	}

	@Test 
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clienaddress1_add() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clienaddress1_add"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientAddressLine1");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine1 cannot be null.");
	}

	

}
