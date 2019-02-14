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

public class R2267_TC91105_AltEVV_ClientAddressType extends BaseTest{


	// Validating with valid ClientAddressType Under ClientAddress_BUSINESS
	@Test 
	public void R2267_TC91105_AltEVV_ClientAddressType_valid_AddressType_Under_ClientAddress_BUSINESS() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91105_AltEVV_ClientAddressType_valid_AddressType_Under_ClientAddress_BUSINESS"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.addressType,DataGeneratorClient.clientAddressType());

		JSONObject altEVVJsonObjectAddress_CA = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_CA.put(globalVariables.addressType,DataGeneratorClient.clientAddressType());

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, altEVVJsonObject, altEVVJsonObjectAddress_CA);
	}

	//Validating with invalid ClientAddressType Under ClientAddress_AddressType other than Business|Home|Other
	@Test 
	public void R2267_TC91105_AltEVV_ClientAddressType_invalid_AddressType_Under_ClientAddress() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91105_AltEVV_ClientAddressType_invalid_AddressType_Under_ClientAddress"); 


		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.addressType,CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientAddressTypeFormaterror);


	}

	//Validating with invalid ClientAddressType Under ClientAddress_AddressType greater than 12
	@Test 
	public void R2267_TC91105_AltEVV_ClientAddressType_valid_AddressType_greterThan12() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91105_AltEVV_ClientAddressType_valid_AddressType_greterThan12"); 



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.addressType,CommonMethods.generateRandomStringOfFixLength(14));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientAddressTypeFormaterror);

	}

	//Validating with invalid ClientAddressType Under ClientAddress_AddressType with null
	@Test 
	public void R2267_TC91105_AltEVV_ClientAddressType_valid_AddressType_null() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91105_AltEVV_ClientAddressType_valid_AddressType_Other_Trailingspace"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.addressType,null);

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressTypeNullError);


	}

	//Validating with invalid ClientAddressType Under ClientAddress_AddressType with blank
	@Test 
	public void R2267_TC91105_AltEVV_ClientAddressType_valid_AddressType_blank() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91105_AltEVV_ClientAddressType_valid_AddressType_blank"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.addressType," ");

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientAddressTypeFormaterror);


	}

}