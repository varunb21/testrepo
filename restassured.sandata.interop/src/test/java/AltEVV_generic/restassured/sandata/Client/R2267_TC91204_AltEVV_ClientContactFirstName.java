package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


 
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import junit.framework.Assert;

//Test Case 91204:OpenEVV-altEVV- Responsible Party/Designated Signer: Validate If the ClientContactFirstName should contains maximum characters.

public class R2267_TC91204_AltEVV_ClientContactFirstName extends BaseTest {

	String clntid,clintid_db="LOC", clntcontctfstname_db = "F_NAME";

	//validating valid altEVV client  having ClientContactFirstname with Max_minus_one_Length
	@Test (priority=0)
	public void R2267_TC91204_AltEVV_ClientContactFirstname_valid_Max_minus_one_Length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91204_AltEVV_ClientContactFirstname_valid_Max_minus_one_Length"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_minus_one_Length"); 
		String clntcontactfstname=CommonMethods.generateRandomStringOfFixLength(30);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, clntcontactfstname);
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	
	}

	//validating valid altEVV client  having ClientContactFirstname with Mid_Length
	@Test (priority=1)
	public void R2267_TC91204_AltEVV_ClientContactFirstname_valid_Mid_Length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91204_AltEVV_ClientContactFirstname_valid_Mid_Length"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Mid_Length"); 
		String clntcontactfstname=CommonMethods.generateRandomStringOfFixLength(15);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, clntcontactfstname);
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	
	}

	//validating valid altEVV client  having ClientContactFirstname with Min_Length
	@Test (priority=2)
	public void R2267_TC91204_AltEVV_ClientContactFirstname_valid_Min_Length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91204_AltEVV_ClientContactFirstname_valid_Min_Length"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Min_Length"); 
		String clntcontactfstname=CommonMethods.generateRandomStringOfFixLength(1);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, clntcontactfstname);
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	
	}

	//validating valid altEVV client  having ClientContactFirstname with Max_plus_one_Length
	@Test (priority=3)
	public void R2267_TC91204_AltEVV_ClientContactFirstname_invalid_Max_plus_one_Length() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91204_AltEVV_ClientContactFirstname_invalid_Max_plus_one_Length"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_plus_one_Length"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, CommonMethods.generateRandomStringOfFixLength(31));
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientContactFirstName (Responsible Party) value is incorrect. The length should be between 1 and 30.");

	}

	//validating valid altEVV client  having ClientContactFirstname with Max_minus_specialString
	@Test (priority=3)
	public void R2267_TC91204_AltEVV_ClientContactFirstname_invalid_Max_minus_specialString() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91204_AltEVV_ClientContactFirstname_invalid_Max_minus_specialString"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_minus_specialString"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, CommonMethods.generateSpecialChar(15));
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientContacFirstNameFormaterror);

	}
	
	//validating valid altEVV client  having ClientContactFirstname with Max_plus_specialString
	@Test (priority=4)
	public void R2267_TC91204_AltEVV_ClientContactFirstname_invalid_Max_plus_specialString() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91204_AltEVV_ClientContactFirstname_invalid_Max_plus_specialString"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_plus_specialString"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, CommonMethods.generateSpecialChar(31));
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientContactFirstName (Responsible Party) format is incorrect. The record should satisfy this regular expression");

	}
	
	//validating valid altEVV client  having ClientContactFirstname with _null
	@Test (priority=5)
	public void R2267_TC91204_AltEVV_ClientContactFirstname_invalid_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91204_AltEVV_ClientContactFirstname_invalid_null"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with _null"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, null);
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));
		
		DataBaseVerifier_Client.DataBaseVerification_InboxClientContact("LOC", jsonObject.get(globalVariables.ClientID).toString(),
				"L_NAME", jsonObject1.get(globalVariables.ClientContactLastName).toString());

	
	}

}