package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//TC91120: OpenEVV-altEVV- Client Address -ClientAddressLine2 validation field formats/values

public class R2267_TC91175_AltEVV_ClientAddressLine2 extends BaseTest {

	@Test
	public void R2267_TC91175_AltEVV_ClientAddressLine2_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2",CommonMethods.generateRandomStringOfFixLength(30));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",CommonMethods.generateRandomStringOfFixLength(30));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObjectAdd1);

	}

	@Test
	public void R2267_TC91175_AltEVV_ClientAddressLine2_invalid_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_invalid_length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine2",CommonMethods.getSaltString(35));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine2 value is incorrect. The length should be between 1 and 30.");

	}

	@Test
	public void R2267_TC91175_AltEVV_ClientAddressLine2_whitespace1() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_invalid_length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientAddressLine2", CommonMethods.getSaltString(5) + " " +  CommonMethods.generateRandomNumberOfFixLength(2));


		JSONObject jsonObjectAdd1 = (JSONObject) jsonArray1.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",CommonMethods.getSaltString(5) + " " +  CommonMethods.generateRandomNumberOfFixLength(2));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObjectAdd1);

	}

	@Test
	public void R2267_TC91175_AltEVV_ClientAddressLine2_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2",null);

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		
		DataBaseVerifier_Client.DataBaseVerificationClient_inboxclientsaddress("LOC",jsonObject.get("ClientID").toString(),
				"ADDR1",jsonObjectAdd1.get("ClientAddressLine1").toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.City_CA, jsonObjectAdd1.get(globalVariables.ClientCity).toString());
		
	}

	@Test
	public void R2267_TC91175_AltEVV_ClientAddressLine2_alphanumeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2",CommonMethods.generateRandomAlphaNumeric(10));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObjectAdd1);
	}

	@Test
	public void R2267_TC91175_AltEVV_ClientAddressLine2_spcl_char() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_nonumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2",CommonMethods.generateSpecialChar(10));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine2 format is incorrect. The record should satisfy this regular expression");

	}

	@Test
	public void R2267_TC91175_AltEVV_ClientAddressLine2_whitespace() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_whitespace"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2",CommonMethods.generateRandomStringOfFixLength(10) + " " +CommonMethods.generateRandomStringOfFixLength(5) );

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",CommonMethods.generateRandomStringOfFixLength(10) + " " +CommonMethods.generateRandomStringOfFixLength(5) );

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObjectAdd1);


	}

	@Test
	public void R2267_TC91175_AltEVV_ClientAddressLine2_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_blank"); 
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2","");

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2","");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine2 value is incorrect. The length should be between 1 and 30");
	}


}