package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//TC91120: OpenEVV-altEVV- Client Address -ClientAddressLine1 validation field formats/values

public class R2267_TC91120_AltEVV_ClientAddLine1 extends BaseTest {

	@Test
	public void R2267_TC91118_AltEVV_ClientAddressLine1_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd1.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(30));

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(30));


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObjectAdd);
}

	@Test
	public void R2267_TC91118_AltEVV_ClientAddressLine1_invalid_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_invalid_length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.getSaltString(35));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine1 value is incorrect. The length should be between 1 and 30.");
	}

	@Test
	public void R2267_TC91118_AltEVV_ClientAddressLine1_null() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1",null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1NullError);

	}

	@Test
	public void R2267_TC91118_AltEVV_ClientAddressLine1_alphanumeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd1.put("ClientAddressLine1",CommonMethods.generateRandomAlphaNumeric(10));

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObjectAdd);
	}

	@Test
	public void R2267_TC91118_AltEVV_ClientAddressLine1_spcl_char() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_nonumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1FormatError);

	}

	@Test
	public void R2267_TC91118_AltEVV_ClientAddressLine1_whitespace() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_whitespace"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd1.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(10) + " " +CommonMethods.generateRandomStringOfFixLength(5) );

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(10) + " " +CommonMethods.generateRandomStringOfFixLength(5) );

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObjectAdd);

	}

	@Test
	public void R2267_TC91118_AltEVV_ClientAddressLine1_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_blank"); 
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1","");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine1 value is incorrect. The length should be between 1 and 30");
	}


}