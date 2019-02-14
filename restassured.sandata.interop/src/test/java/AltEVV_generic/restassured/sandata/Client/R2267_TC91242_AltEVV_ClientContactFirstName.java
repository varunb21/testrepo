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

public class R2267_TC91242_AltEVV_ClientContactFirstName extends BaseTest{


	//Case-1 Testing with ClientContactFirstName more than 30
	@Test 
	public void R2267_TC91242_AltEVV_ClientContactFisrtName_MoreThan30() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91242_AltEVV_ClientContactFisrtName_MoreThan30"); 



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, CommonMethods.generateRandomStringOfFixLength(31));



		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientContactFirstName (Responsible Party) value is incorrect. The length should be between 1 and 30.");
	}

	// Case-2 Testing with alphabets starting with a space
	@Test 
	public void R2267_TC91243_AltEVV_ClientContactFirstName_spacecombination() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91243_AltEVV_ClientContactFirstName_spacecombination"); 



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, " Clientfname");



		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, altEVVJsonObject, altEVVJsonObjectAddress);	

	}

	@Test 
	public void R2267_TC91242_AltEVV_ClientContactFirstName_Endspacecombination() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91242_AltEVV_ClientContactFirstName_Endspacecombination"); 



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, "lastname ");



		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, altEVVJsonObject, altEVVJsonObjectAddress);	
	}

	// Case-4 Testing with valid special characters ("." or " '  " or  "-" ) 
	@Test 
	public void R2267_TC91242_AltEVV_ClientContactFirstName_combination_with_specialcharpos() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91242_AltEVV_ClientContactFirstName_combination_with_specialcharpos"); 



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, "Fnu.Neerajor-kam");



		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, altEVVJsonObject, altEVVJsonObjectAddress);	
	}

	// Case-5 Testing with special characters other than few special characters ("@" ) 
	@Test 
	public void R2267_TC91242_AltEVV_ClientContactFirstName_withSpecialChar() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91242_AltEVV_ClientContactFirstName_withSpecialChar"); 



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, "Neeraj@Kumar");



		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientContactFirstName (Responsible Party) format is incorrect. The record should satisfy this regular expression");

	}

	@Test 
	public void R2267_TC91242_AltEVV_ClientContactFirstName_startwithNumber() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91242_AltEVV_ClientContactFirstName_startwithNumber"); 



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, "1NeerajKumar");

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientContactFirstName (Responsible Party) format is incorrect. The record should satisfy this regular expression");



	}


}
