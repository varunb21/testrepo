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

//Test Case 91061: OpenEVV-altEVV- Client:  Validate If the client Json does not include at least 1 address with a latitude and longitude

public class R2267_TC91061_AltEVV_Latitude_Longitude_not_included extends BaseTest{

	//Case-1 Testing with least 1 address without a latitude and longitude
	@Test 
	public void TC91061_AltEVV_CreateClient_without_ClientAddressLatitude_ClientAddressLongitude_sub() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91061_AltEVV_CreateClient_without_ClientAddressLatitude_ClientAddressLongitude"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientAddressLatitude_ClientAddressLongitude"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) altEVVJsonArray.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");	
		JSONObject js3 = (JSONObject) js2.get(0);

		js3.remove("ClientAddressLatitude");
		js3.remove("ClientAddressLongitude");


		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		//Validating the expected Result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressLongitude cannot be null");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressLatitude cannot be null.");

	}

	@Test
	public void TC91061_AltEVV_CreateClient_without_ClientAddressLatitude_ClientAddressLongitude_address() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91061_AltEVV_CreateClient_without_ClientAddressLatitude_ClientAddressLongitude"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientAddressLatitude_ClientAddressLongitude"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject js = (JSONObject) altEVVJsonArray.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");	
		JSONObject js3 = (JSONObject) js2.get(1);

		js3.remove("ClientAddressLatitude");
		js3.remove("ClientAddressLongitude");


		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		//Validating the expected Result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressLongitude cannot be null");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressLatitude cannot be null.");


	}

}