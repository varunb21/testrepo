package AltEVV_molina.restassured.sandata.Client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class R2267_TC91111_AltEVV_ProcedureCode extends BaseTest{


	////  Validating with valid ProcedureCode with invalid length
	@Test 
	public void R2267_TC91111_AltEVV_ProcedureCode_invalid_Length() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91105_AltEVV_ProcedureCode_invalid_Length"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArraypayer = (JSONArray) altEVVJsonObject.get("ClientPayerInformation");

		JSONObject altEVVJsonObjectpayer = (JSONObject) altEVVJsonArraypayer.get(0);
		altEVVJsonObjectpayer.put(globalVariables.jsonProcedureCode,CommonMethods.generateRandomNumberOfFixLength(6));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ProcedureCode value is incorrect. The length should be between 1 and 5.");

	}
	//// Validating with valid ProcedureCode with valid length
	@Test 
	public void R2267_TC91111_AltEVV_ProcedureCode_valid_Length() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91111_AltEVV_ProcedureCode_valid_Length"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		
		JSONArray altEVVJsonArraypayer = (JSONArray) altEVVJsonObject.get("ClientPayerInformation");
		JSONObject altEVVJsonObjectpayer = (JSONObject) altEVVJsonArraypayer.get(0);

		altEVVJsonObjectpayer.put(globalVariables.jsonProcedureCode,"A4211");

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, altEVVJsonObject, altEVVJsonObjectpayer);

	}

	//// Validating with valid ProcedureCode with special char
	@Test 
	public void R2267_TC91111_AltEVV_ProcedureCode_with_SpecialChar() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91105_AltEVV_ProcedureCode_with_SpecialChar"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		
		JSONArray altEVVJsonArraypayer = (JSONArray) altEVVJsonObject.get("ClientPayerInformation");
		JSONObject altEVVJsonObjectpayer = (JSONObject) altEVVJsonArraypayer.get(0);
		
		altEVVJsonObjectpayer.put(globalVariables.jsonProcedureCode,"a@sb");

		String bodyAsString=CommonMethods.captureResponseAltEVV_500(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));


	}


}

