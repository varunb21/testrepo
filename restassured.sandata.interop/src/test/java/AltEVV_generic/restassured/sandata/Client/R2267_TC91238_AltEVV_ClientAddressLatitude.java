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

public class R2267_TC91238_AltEVV_ClientAddressLatitude extends BaseTest{


	@Test 
	public void R2267_TC91238_AltEVV_ClientAddressLatitudetude_Format_MoreThan_90() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitudetude_Format_MoreThan_90"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, "91.23");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLatitude, "91.23");

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientLatitude value cannot be greater than 90.");
	}

	@Test 
	public void R2267_TC91238_AltEVV_ClientAddressLatitude_Format_Null() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_Null"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, null);

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientLatitude cannot be null.");
	}

	@Test 
	public void R2267_TC91238_AltEVV_ClientAddressLatitude_Format_lessthan90() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_lessthan90"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, "79");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLatitude, "79");
		
		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, altEVVJsonObject, altEVVJsonObjectAddress_add);	  	
	}

	@Test 
	public void R2267_TC91238_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude,CommonMethods.generateRandomNumberOfFixLength(101));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLatitude,CommonMethods.generateRandomNumberOfFixLength(101));
		
		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientLatitude value cannot be greater than 90.");
	}
	
	@Test 
	public void R2267_TC91238_AltEVV_ClientAddressLatitude_Format_Minus90() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude,"-91");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLatitude,"-91");
		
		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientLatitude value cannot be less than -90.");
	}
	
	@Test 
	public void R2267_TC91238_AltEVV_ClientAddressLatitude_Format_speciale() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude,CommonMethods.generateSpecialChar(10));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLatitude,CommonMethods.generateSpecialChar(10));
		
		String bodyAsString=CommonMethods.captureResponseAltEVV_400(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}

}



