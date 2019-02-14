package AltEVV_molina.restassured.sandata.Client;

import java.io.FileNotFoundException;
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
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91110_AltEVV_ClientAddressIsPrimary_Validate extends BaseTest {
	
	@Test
	public void R2267_TC91110_AltEVV_ClientAddressIsPrimary_true_true() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R71852_TC91110_AltEVV_ClientAddressIsPrimary_true_Flase_");  

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", true);

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", true);

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));
		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonobject,jsonobject_add1);

	}

	@Test
	public void R2267_TC91110_AltEVV_ClientAddressIsPrimary_true_Flase() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R71852_TC91110_AltEVV_ClientAddressIsPrimary_true_Flase_");  

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", true);

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", false);

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));
		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonobject,jsonobject_add1);

	}

	@Test
	public void R2267_TC91110_AltEVV_ClientAddressIsPrimary_Flase_true() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R71852_TC91110_AltEVV_ClientAddressIsPrimary_true_Flase_");  

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", false);

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", true);

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));
		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonobject,jsonobject_add1);

	}

	@Test
	public void R2267_TC91110_AltEVV_ClientAddressIsPrimary_false_Flase() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R71852_TC91110_AltEVV_ClientAddressIsPrimary_true_Flase_");  

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", false);

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", false);

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));
		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonobject,jsonobject_add1);

	}
	
	@Test
	public void R2267_TC91110_AltEVV_ClientAddressIsPrimary_length_otherthan_true_False() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91110_AltEVV_ClientAddressIsPrimary_length_otherthan_true_False");  

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", CommonMethods.generateRandomStringOfFixLength(5));

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressIsPrimary format is incorrect. The record should satisfy this regular expression");
	}

	@Test
	public void R2267_TC91110_AltEVV_ClientAddressIsPrimary_lengthInvalid() throws FileNotFoundException, IOException, ParseException{
		logger = extent.startTest("R71852_TC91110_AltEVV_ClientAddressIsPrimary_lengthInvalid");  

		//Using Reusable method to load employee json
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", CommonMethods.generateRandomStringOfFixLength(6));

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressIsPrimary format is incorrect.");

	}

	@Test
	public void R2267_TC91110_AltEVV_ClientAddressIsPrimary_InvalidType_num() throws FileNotFoundException, IOException, ParseException{
		logger = extent.startTest("R71852_TC91110_AltEVV_ClientAddressIsPrimary_lengthInvalid");  

		//Using Reusable method to load employee json
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", CommonMethods.generateRandomNumberOfFixLength(5));

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The ClientAddressIsPrimary format is incorrect."));

	}

	@Test
	public void R2267_TC91110_AltEVV_ClientAddressIsPrimary_blank() throws FileNotFoundException, IOException, ParseException{
		logger = extent.startTest("R71852_TC91110_AltEVV_ClientAddressIsPrimary_blank");  

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", "");

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", "");

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The ClientAddressIsPrimary format is incorrect."));

	}

	@Test
	public void R2267_TC91110_AltEVV_ClientAddressIsPrimary_null() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R71852_TC91110_AltEVV_ClientAddressIsPrimary_true_Flase_");  

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", null);

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", null);

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressIsPrimary cannot be null.");
	}

	@Test
	public void R2267_TC91110_AltEVV_ClientAddressIsPrimary_with_specialCharacter() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("R71852_TC91110_AltEVV_ClientAddressIsPrimary_with_specialCharacter");  
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", CommonMethods.generateSpecialChar(3));

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", CommonMethods.generateSpecialChar(3));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressIsPrimary format is incorrect.");
	}


}

