package AltEVV_molina.restassured.sandata.Client;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

public class R2267_TC92216_AltEVV_Client_Initial_load_Negative_Response extends BaseTest{

	//Case-1 Testing  Sequence ID field Blank
	@Test 
	public void TC92216_OpenEVV_altEVV_Client_Initial_load_and_Negative_Response_for_Inavalid_entry() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92216_OpenEVV_altEVV_Client_Initial_load_and_Negative_Response_for_Inavalid_entry"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The SequenceID value is incorrect. The length should be between 1 and 16.");

	}

	@Test 
	public void TC92216_OpenEVV_altEVV_Client_Initial_load_and_Negative_Response_for_Field_removed() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92216_OpenEVV_altEVV_Client_Initial_load_and_Negative_Response_for_Field_removed"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 

		JSONObject js = (JSONObject) j.get(0);
		js.remove("SequenceID");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The SequenceID cannot be null");

	}

}
