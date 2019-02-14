package AltEVV_molina.restassured.sandata.Client;

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
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91091_AltEVVClientMedicaidId_FormatValidation extends BaseTest{

	//To validate the invalid ClientMedicaidID length
	@Test
	public void R2267_TC91091_AltEVVClientMedicaidId_length_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("R71852_TC91091_AltEVVClientMedicaidId_length_invalid");  

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(65));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientMedicaidID value is incorrect. The length should be between 1 and 64");
	}

	//To validate the ClientMedicaidID with alphanumeric value
	@Test
	public void R2267_TC91091_AltEVVClientMedicaidId_with_alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("R71852_TC91091_AltEVVClientMedicaidId_with_alphanumeric");  


		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateRandomAlphaNumeric(64));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientMedicaidID format is incorrect. The record should satisfy this regular expression");

	}

	//To validate the ClientMedicaidID with duplicate value
	@Test
	public void R2267_TC91091_AltEVVClientMedicaidId_with_duplicate() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("R71852_TC91091_AltEVVClientMedicaidId_with_numeric");  


		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(6));
		String ClientMedicaidID = jsonobject.get("ClientMedicaidID").toString();

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));
	
		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonobject);	

		//putting Duplicate value for clientMedicadId 
	
		//Making json values dynamic
		jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", ClientMedicaidID);

		bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));


	}

	//To validate the ClientMedicaidID with non numeric value
	@Test
	public void R2267_TC91091_AltEVVClientMedicaidId_with_nonnumeric() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88430_OpenEVV_ClientMedicaidID_with_nonnumeric");  

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateRandomStringOfFixLength(8));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientMedicaidID format is incorrect.");
	}

	//To validate the ClientMedicaidID with whitespace
	@Test
	public void R2267_TC91091_AltEVVClientMedicaidId_with_headingspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("R71852_TC91091_AltEVVClientMedicaidId_with_headingspace");  


		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", " " + CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientMedicaidID format is incorrect.");
	}

	//To validate the ClientMedicaidID with special character
	@Test
	public void R2267_TC91091_AltEVVClientMedicaidId_with_specialCharacter() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88430_OpenEVV_ClientMedicaidID_with_specialCharacter");  


		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateSpecialChar(8));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientMedicaidID format is incorrect.");
	}

	//To validate the ClientMedicaidID with dash character
	@Test
	public void TR2267_TC91091_AltEVVClientMedicaidId_dashCharacter() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TR71852_TC91091_AltEVVClientMedicaidId_dashCharacter");  

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateSpecialChar(3) + "-" + CommonMethods.generateSpecialChar(3));

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientMedicaidID format is incorrect.");

	}


}
