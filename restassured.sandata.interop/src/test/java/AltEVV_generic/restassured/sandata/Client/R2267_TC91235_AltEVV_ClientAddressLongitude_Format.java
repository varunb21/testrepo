package AltEVV_generic.restassured.sandata.Client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class R2267_TC91235_AltEVV_ClientAddressLongitude_Format extends BaseTest{


	//Case-1 Testing with longitude more than -180
	@Test 
	public void R2267_TC91235_AltEVV_ClientAddressLongitude_Format_minus180() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91235_AltEVV_ClientAddressLongitude_Format_MoreThan_100"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, "-181.99");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLongitude, "-181.99");

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientLongitude value cannot be less than -180.");

	}
 
	@Test 
	public void R2267_TC91235_AltEVV_ClientAddressLongitude_Format_plus180() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91235_AltEVV_ClientAddressLongitude_Format_MoreThan_100"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, "181.99");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLongitude, "181.99");

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientLongitude value cannot be greater than 180.");

	}

	//Case-1 Testing with longitude is null
	@Test 
	public void R2267_TC91235_AltEVV_ClientAddressLongitude_Format_Null() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91235_AltEVV_ClientAddressLongitude_Format_Null"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, null);

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientLatitude cannot be null");
	}


	//Case-3 Testing with longitude less than -180 
	@Test 
	public void R2267_TC91235_AltEVV_ClientAddressLongitude_Format_lessthan180() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91235_AltEVV_ClientAddressLongitude_Format_lessthan180"); 


		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	

		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, "-79");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLongitude, "-179");


		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, altEVVJsonObject, altEVVJsonObjectAddress_add);	  	

	}


	//Case-1 Testing with longitude more than 100 character
	@Test 
	public void R2267_TC91235_AltEVV_ClientAddressLongitude_Format_MaxLengthplusone() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91235_AltEVV_ClientLongitude_Format_MaxLengthplusone"); 


		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	

		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLongitude,CommonMethods.generateRandomNumberOfFixLength(101));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLongitude,"181");


		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientLongitude value cannot be greater than 180.");

	}
	
	public void R2267_TC91238_AltEVV_ClientAddressLongitude_Format_speciale() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLongitude,CommonMethods.generateSpecialChar(10));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLongitude,CommonMethods.generateSpecialChar(10));
		
		String bodyAsString=CommonMethods.captureResponseAltEVV_400(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}


}
