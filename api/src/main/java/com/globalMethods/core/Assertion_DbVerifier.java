package com.globalMethods.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class Assertion_DbVerifier extends BaseTest

{
	// ***********************inbox.Client method mapping ****************************************//

	public static  void jsonAssert_InboxClient(String bodyAsString, JSONObject jsonobject) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response "); 

		DataBaseVerifier_Client.DataBaseVerification_STXClient("LOC", jsonobject.get(globalVariables.ClientID).toString(),
				"F_NAME",jsonobject.get(globalVariables.ClientFirstName).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Account_stxClient,jsonobject.get(globalVariables.Account).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.lastname_stxClient, jsonobject.get(globalVariables.ClientLastName).toString());		

	}

	public static  void jsonAssert_InboxClient_3P(String bodyAsString, JSONObject jsonobject) throws SQLException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");
//		Assert.assertTrue(bodyAsString.contains("\"status\": \"null\","));
		Assert.assertTrue(bodyAsString.contains("\"All records uploaded successfully.\""));
		
		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerification_STXClient( "client_version_number", jsonobject.get("SequenceID").toString(), 
				"ACCOUNT",jsonobject.get("BusinessEntityID").toString());  

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Account_stxClient,jsonobject.get("BusinessEntityID").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.sequenceid_stxClient, jsonobject.get("SequenceID").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.firstname_stxClient, jsonobject.get("PatientFirstName").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.lastname_stxClient, jsonobject.get("PatientLastName").toString());
		
		DataBaseVerifier_Client.DataBaseVerification_STXClient_Supp("clientkey", DataBaseVerifier_Client.ClientKey_stxClient);
		JSONArray jsonArrayAdd = 	(JSONArray) jsonobject.get(globalVariables.Addressjson);
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(0);   
		
		JSONArray jsonArrayAdd1 = 	(JSONArray) jsonobject.get(globalVariables.Addressjson);
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrayAdd1.get(1);
		
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PatientAddLine2_stxClientSupp,jsonObjectAdd.get("PatientAddressLine2").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PatientAddLine1_stxClientSupp,jsonObjectAdd.get("PatientAddressLine1").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PatientCity_stxClientSupp,jsonObjectAdd.get("PatientCity").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PatientState_stxClientSupp,jsonObjectAdd.get("PatientState").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PatientZip_stxClientSupp,jsonObjectAdd.get("PatientZip").toString());
		
		DataBaseVerifier_Client.DataBaseVerificationClient_inboxclientsaddress("addr1", jsonObjectAdd1.get("PatientAddressLine1").toString(), 
				"zip_code", jsonObjectAdd1.get("PatientZip").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr1_CA,jsonObjectAdd1.get("PatientAddressLine1").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr2_CA,jsonObjectAdd1.get("PatientAddressLine2").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.City_CA,jsonObjectAdd1.get("PatientCity").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ZipCode_CA,jsonObjectAdd1.get("PatientZip").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.State_CA,jsonObjectAdd1.get("PatientState").toString());
	
	}
	
	public static  void jsonAssert_InboxClient_Member(String bodyAsString, JSONObject jsonobject) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerification_STXClient("LOC", jsonobject.get(globalVariables.ClientID).toString(),
				"f_name",jsonobject.get(globalVariables.ClientFirstName).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Account_stxClient,jsonobject.get(globalVariables.Account).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.lastname_stxClient, jsonobject.get(globalVariables.ClientLastName).toString());	

	}

	public static  void jsonAssert_InboxClients(String bodyAsString, JSONObject jsonobject) throws SQLException, ParseException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", jsonobject.get(globalVariables.ClientID).toString(),
				"f_name",jsonobject.get(globalVariables.ClientFirstName).toString());

		Assert.assertEquals(DataBaseVerifier_Client.ncode_inClient, "0");

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Account_inClient,jsonobject.get(globalVariables.Account).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientssn_inClient, jsonobject.get(globalVariables.clientSSN).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.firstname_inClient, jsonobject.get(globalVariables.ClientFirstName).toString() );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.lastname_inClient, jsonobject.get(globalVariables.ClientLastName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Email_inClient, jsonobject.get(globalVariables.clientEmailAddress).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.RecipientIDCustom2_inClient, jsonobject.get(globalVariables.RecipientIDCustom2).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.RecipientIDCustom1_inClient, jsonobject.get(globalVariables.RecipientIDCustom1).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ClientAddressType_inClient, jsonobject.get(globalVariables.ClientAddressType).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr1_inClient, jsonobject.get(globalVariables.ClientAddressLine1).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr2_inClient, jsonobject.get(globalVariables.ClientAddressLine2).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.City_inClient, jsonobject.get(globalVariables.ClientCity).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.MedicaidID_inClient, jsonobject.get(globalVariables.ClientMedicaidID).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PayerID_inClient, jsonobject.get(globalVariables.PayerID).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Email_inClient, jsonobject.get(globalVariables.clientEmailAddress).toString());
		

	}

	public static  void jsonAssert_iodata_ohio(String bodyAsString, String uuid) throws SQLException
	{

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerification_iodata_ohio(bodyAsString,uuid);
		
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.req_id_iodata,uuid);
	}
	
	public static  void jsonAssert_InboxClient_AltEVV(String bodyAsString, JSONObject jsonobject) throws SQLException
	{
		//	if ClientQualifier is "ClientSSN", ClientSSN will be overwritten by ClientIdentifier.
		//	if ClientQualifier is "ClientOtherID", ClientOtherID will be overwritten by ClientIdentifier.
		//	if ClientCustomID is "ClientCustomID", ClientCustomID will be overwritten by ClientIdentifier.

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", jsonobject.get(globalVariables.ClientID).toString(),
				"f_name",jsonobject.get(globalVariables.ClientFirstName).toString());


		if(jsonobject.get("ClientQualifier").toString().equals("ClientOtherID"))
		{
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientssn_inClient, jsonobject.get("ClientSSN").toString());
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientotherID, jsonobject.get("ClientIdentifier").toString());

		}else if (jsonobject.get("ClientQualifier").toString().equals("ClientSSN")) 
		{
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientssn_inClient, jsonobject.get("ClientIdentifier").toString());

		}else if (jsonobject.get("ClientQualifier").toString().equals("ClientCustomID")) 
		{
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientssn_inClient, jsonobject.get("ClientSSN").toString());
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ClientCustomID, jsonobject.get("ClientIdentifier").toString());
		}

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.firstname_inClient, jsonobject.get("ClientFirstName").toString() );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.lastname_inClient, jsonobject.get("ClientLastName").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.sequenceid_inClient, jsonobject.get("SequenceID").toString());

	}

	public static  void jsonAssert_InboxClient_AltEVV_lateruse(String bodyAsString, JSONObject jsonobject) throws SQLException
	{
		//	if ClientQualifier is "ClientSSN", ClientSSN will be overwritten by ClientIdentifier.
		//	if ClientQualifier is "ClientOtherID", ClientOtherID will be overwritten by ClientIdentifier.
		//	if ClientCustomID is "ClientCustomID", ClientCustomID will be overwritten by ClientIdentifier.

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));


		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", jsonobject.get(globalVariables.ClientID).toString(),
				"f_name",jsonobject.get(globalVariables.ClientFirstName).toString());

		//		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ncode, "0");
		System.out.println("0");

		if(jsonobject.get("ClientQualifier").toString().equals("ClientOtherID"))
		{
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientssn_inClient, jsonobject.get("ClientSSN").toString());
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientotherID, jsonobject.get("ClientIdentifier").toString());

		}else if (jsonobject.get("ClientQualifier").toString().equals("ClientSSN")) 
		{
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientssn_inClient, jsonobject.get("ClientIdentifier").toString());

		}else if (jsonobject.get("ClientQualifier").toString().equals("ClientCustomID")) 
		{
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientssn_inClient, jsonobject.get("ClientSSN").toString());
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ClientCustomID, jsonobject.get("ClientIdentifier").toString());

		}

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.firstname_inClient, jsonobject.get("ClientFirstName").toString() );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.lastname_inClient, jsonobject.get("ClientLastName").toString());

		//DataBaseVerifier_Client.DataBaseVerification_STXClient("LOC", jsonobject.get(globalVariables.ClientID).toString());

	}

	// ***********************inbox.Client Contact method mapping ****************************************//

	public static  void jsonAssert_InboxClientContact(String bodyAsString,JSONObject jsonobject_mainArray, JSONObject jsonobject_SubArray) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerification_InboxClientContact("LOC", jsonobject_mainArray.get(globalVariables.ClientID).toString(),
				"F_NAME", jsonobject_SubArray.get(globalVariables.ClientContactFirstName).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.lastname_ClientContact, jsonobject_SubArray.get(globalVariables.ClientContactLastName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Email_ClientContact, jsonobject_SubArray.get(globalVariables.ClientContactEmailAddress).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr1_ClientContact, jsonobject_SubArray.get(globalVariables.ClientContactAddressLine1).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr2_ClientContact, jsonobject_SubArray.get(globalVariables.ClientContactAddressLine2).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.City_ClientContact, jsonobject_SubArray.get(globalVariables.ClientContactCity).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.State_ClientContact, jsonobject_SubArray.get(globalVariables.ClientContactState).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ZipCode_ClientContact, jsonobject_SubArray.get(globalVariables.ClientContactZip).toString());
		
	}
	
	public static  void jsonAssert_STXClientContact(String bodyAsString,JSONObject jsonobject) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerification_STXClientContact( jsonobject.get(globalVariables.ClientID).toString(),
				 jsonobject.get(globalVariables.ClientFirstName).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.contactTypeCode_ClientContact_stx, "EC");
	}

	public static  void jsonAssert_InboxClientContact_Member(String bodyAsString,JSONObject jsonobject_mainArray) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerification_InboxClientContact("LOC", jsonobject_mainArray.get(globalVariables.ClientID).toString(),
				"F_NAME", jsonobject_mainArray.get(globalVariables.ClientContactFirstName).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.lastname_ClientContact, jsonobject_mainArray.get(globalVariables.ClientContactLastName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Email_ClientContact, jsonobject_mainArray.get(globalVariables.ClientContactEmailAddress).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr1_ClientContact, jsonobject_mainArray.get(globalVariables.ClientContactAddressLine1).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr2_ClientContact, jsonobject_mainArray.get(globalVariables.ClientContactAddressLine2).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.City_ClientContact, jsonobject_mainArray.get(globalVariables.ClientContactCity).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.State_ClientContact, jsonobject_mainArray.get(globalVariables.ClientContactState).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ZipCode_ClientContact, jsonobject_mainArray.get(globalVariables.ClientContactZip).toString());

	}

	// ***********************inbox.Client address method mapping ****************************************//

	public static  void jsonAssert_STXClient_Supp(String bodyAsString, JSONObject jsonobject, JSONObject jsonobject_subarray) throws SQLException
	{

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));


		DataBaseVerifier_Client.DataBaseVerification_STXClient_Supp("ZIP_CODE", jsonobject.get(globalVariables.PatientZip).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Latitude_stxClientSupp, jsonobject_subarray.get("ClientLatitude").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Longitude_stxClientSupp, jsonobject_subarray.get("ClientLongitude").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.sequenceid_inClient, jsonobject.get("SequenceID").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PatientAddLine1_stxClientSupp, jsonobject.get("PatientAddressLine1").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PatientAddLine2_stxClientSupp, jsonobject.get("PatientAddressLine2").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PatientCity_stxClientSupp, jsonobject.get("PatientCity").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PatientZip_stxClientSupp, jsonobject.get("PatientZip").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PatientState_stxClientSupp, jsonobject.get("PatientState").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientkey_stxClientSupp, jsonobject.get("ClientKey").toString());
	}

	public static  void jsonAssert_InboxClientAddress(String bodyAsString,JSONObject jsonObject_mainArray, JSONObject jsonObject_SubArray) throws SQLException, FileNotFoundException, IOException, ParseException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//	Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));
		logger.log(LogStatus.INFO, "Validating DB response ");


		DataBaseVerifier_Client.DataBaseVerificationClient_inboxclientsaddress("LOC",jsonObject_mainArray.get("ClientID").toString(),
				"ADDR1",jsonObject_SubArray.get("ClientAddressLine1").toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr1_CA, jsonObject_SubArray.get(globalVariables.ClientAddressLine1).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr2_CA, jsonObject_SubArray.get(globalVariables.ClientAddressLine2).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.City_CA, jsonObject_SubArray.get(globalVariables.ClientCity).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.State_CA, jsonObject_SubArray.get(globalVariables.ClientState).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ZipCode_CA, jsonObject_SubArray.get(globalVariables.ClientZip).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.County_CA, jsonObject_SubArray.get(globalVariables.ClientCounty).toString()); 
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ClientAddressType_CA, jsonObject_SubArray.get(globalVariables.ClientAddressType).toString()); 

//		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Latitude_CA, jsonObject_SubArray.get(globalVariables.ClientAddressLatitude).toString()); 
//		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Longitude_CA, jsonObject_SubArray.get(globalVariables.ClientAddressLongitude).toString()); 

	}

	public static  void jsonAssert_InboxClientAddress_altevv(String bodyAsString,JSONObject jsonObject_mainArray, JSONObject jsonObject_SubArray) throws SQLException, FileNotFoundException, IOException, ParseException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));
		logger.log(LogStatus.INFO, "Validating DB response ");


		DataBaseVerifier_Client.DataBaseVerificationClient_inboxclientsaddress("LOC",jsonObject_mainArray.get("ClientID").toString(),
				"ADDR1",jsonObject_SubArray.get("ClientAddressLine1").toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr1_CA, jsonObject_SubArray.get(globalVariables.ClientAddressLine1).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr2_CA, jsonObject_SubArray.get(globalVariables.ClientAddressLine2).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.City_CA, jsonObject_SubArray.get(globalVariables.ClientCity).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.State_CA, jsonObject_SubArray.get(globalVariables.ClientState).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ZipCode_CA, jsonObject_SubArray.get(globalVariables.ClientZip).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.County_CA, jsonObject_SubArray.get(globalVariables.ClientCounty).toString()); 
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ClientAddressType_CA, jsonObject_SubArray.get(globalVariables.ClientAddressType).toString()); 
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Latitude_CA, jsonObject_SubArray.get(globalVariables.ClientAddressLatitude).toString()); 
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Longitude_CA, jsonObject_SubArray.get(globalVariables.ClientAddressLongitude).toString()); 

	}

	public static  void jsonAssert_InboxClientAddress_Member(String bodyAsString,JSONObject jsonObject_mainArray, JSONObject jsonObject_SubArray) throws SQLException, FileNotFoundException, IOException, ParseException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//	Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));
		logger.log(LogStatus.INFO, "Validating DB response ");


		DataBaseVerifier_Client.DataBaseVerificationClient_inboxclientsaddress("LOC",jsonObject_mainArray.get("ClientID").toString(),
				"ADDR1",jsonObject_SubArray.get("ClientAddressLine1").toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr1_CA, jsonObject_SubArray.get(globalVariables.ClientAddressLine1).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Addr2_CA, jsonObject_SubArray.get(globalVariables.ClientAddressLine2).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.City_CA, jsonObject_SubArray.get(globalVariables.ClientCity).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.State_CA, jsonObject_SubArray.get(globalVariables.ClientState).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ZipCode_CA, jsonObject_SubArray.get(globalVariables.ClientZip).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.County_CA, jsonObject_SubArray.get(globalVariables.ClientCounty).toString()); 
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ClientAddressType_CA, jsonObject_SubArray.get(globalVariables.ClientAddressType).toString()); 

	}

	public static  void jsonAssert_InboxAni(String bodyAsString,JSONObject jsonObject_mainArray, JSONObject jsonObject_SubArray) throws SQLException, FileNotFoundException, IOException, ParseException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerificationClient_inboxAni("LOC",jsonObject_mainArray.get("ClientID").toString()
				);

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Phonetype_inboxAni, jsonObject_mainArray.get("ClientPhoneType").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ClientPhone_inboxAni, jsonObject_mainArray.get("ClientPhone").toString());


	}

	// ***********************inbox.auth, limit provider method mapping ****************************************//

	public static void jsonAssert_Authlimits(String bodyAsString, JSONObject jsonobject_mainArray, JSONObject jsonobject_SubArray) throws SQLException
	{

	logger.log(LogStatus.INFO, "Validating JSON response ");

	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	logger.log(LogStatus.INFO, "Validating DB response ");

	DataBaseVerifier_Client.DataBaseVerificationClient_inbox_auth_limits(jsonobject_mainArray.get("ClientID").toString(),jsonobject_SubArray.get("PayerID").toString() );

	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.program_authLimit,jsonobject_SubArray.get("PayerProgram").toString() );
	
	
	}
	
	public static void jsonAssert_Authsuccess(String bodyAsString, JSONObject jsonobject_mainArray) throws SQLException
	{

	logger.log(LogStatus.INFO, "Validating JSON response ");

	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	logger.log(LogStatus.INFO, "Validating DB response ");

	DataBaseVerifier_Client.DataBaseVerificationClient_inbox_auth_limits(jsonobject_mainArray.get("ClientIdentifier").toString(),jsonobject_mainArray.get("PayerID").toString() );

	//CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.end_time_authLimit, jsonobject_mainArray.get(globalVariables.Authendtime).toString()); 
	//CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.service_authLimit, jsonobject_mainArray.get(globalVariables.Service).toString());
	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.program_authLimit,jsonobject_mainArray.get(globalVariables.Program).toString());

	}
	
	public static void jsonAssert_Authorizationpass(String bodyAsString, JSONObject jsonobject_mainArray) throws SQLException
	{

	logger.log(LogStatus.INFO, "Validating JSON response ");

	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	logger.log(LogStatus.INFO, "Validating DB response ");

	DataBaseVerifier_Client.DataBaseVerificationClient_inbox_authorization(jsonobject_mainArray.get("ClientIdentifier").toString(),jsonobject_mainArray.get("PayerID").toString() );
	
	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Auth_ref_number, jsonobject_mainArray.get(globalVariables.Auth_ref_number).toString()); 
	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.AuthorizationMaximum, jsonobject_mainArray.get(globalVariables.AuthorizationMaximum).toString()); 
	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Clientidentifier, jsonobject_mainArray.get(globalVariables.Clientidentifier).toString()); 
	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.client_id, jsonobject_mainArray.get(globalVariables.Clientidentifier).toString()); 
	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.payor_id, jsonobject_mainArray.get(globalVariables.payor_id).toString()); 
	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.provider_id, jsonobject_mainArray.get(globalVariables.ProviderID).toString()); 
	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.provider_id_quelifier, jsonobject_mainArray.get(globalVariables.provider_id_quelifier).toString()); 
	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.auth_limit_maximum, jsonobject_mainArray.get(globalVariables.AuthorizationMaximum).toString()); 
	
	

	}
	
	
	public static  void jsonAssert_Authlimits_altevv(String bodyAsString, JSONObject jsonobject_mainArray, JSONObject jsonobject_SubArray) throws SQLException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerificationClient_inbox_auth_limits(jsonobject_mainArray.get("ClientID").toString(),jsonobject_SubArray.get("PayerID").toString() );
	
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.program_authLimit,jsonobject_SubArray.get("PayerProgram").toString() );
	
		
	}

	public static  void jsonAssert_Authorizations(String bodyAsString, JSONObject jsonobject_mainArray) throws SQLException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerificationClient_inbox_authorizations("LOC", jsonobject_mainArray.get("ClientID").toString());

	}

	public static  void jsonAssert_ClientProvider(String bodyAsString ,JSONObject jsonobject_Main,JSONObject jsonobject_sub) throws SQLException{

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerificationClient_inbox_clientProviders(
				"PROVIDER_ID", jsonobject_sub.get("ProviderID").toString(),
				"PROVIDER_ID_QLFR", jsonobject_sub.get(globalVariables.ProviderQualifier).toString()
				);

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ncode_providers, null);
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PROVIDERID_providers,jsonobject_sub.get("ProviderID").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.PROVIDERIDQLFR_providers,jsonobject_sub.get("ProviderQualifier").toString());


	}

	// ***********************inbox.Worker method mapping ****************************************//

	public static  void jsonAssert_InboxWorker(String bodyAsString, JSONObject jsonobject) throws SQLException, ParseException, java.text.ParseException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");
		DataBaseVerifier_Emp.DataBaseVerificationEmp("STX_ID", jsonobject.get(globalVariables.EmployeePIN).toString(), 
				"Account",jsonobject.get(globalVariables.Account).toString());

		Assert.assertEquals(DataBaseVerifier_Emp.ncode_inworker, "0");

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Account_inworker,jsonobject.get(globalVariables.Account).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Emp_L_Name_inworker,jsonobject.get(globalVariables.EmployeeLastName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Emp_F_Name_inworker,jsonobject.get(globalVariables.EmployeeFirstName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Emp_M_Initial_inworker,jsonobject.get(globalVariables.EmployeeMiddleInitial).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Dept_inworker,jsonobject.get(globalVariables.Department).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpAPI_inworker,jsonobject.get(globalVariables.EmployeeAPI).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpType_inworker,jsonobject.get(globalVariables.EmployeeType).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpId_inworker,jsonobject.get(globalVariables.EmployeeID).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Payrate_inworker,jsonobject.get(globalVariables.PayRate).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpHireDate_inworker,CommonMethods.dateToDateTimeFormat(jsonobject.get(globalVariables.EmployeeHireDate).toString()));
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpEndDate_inworker,CommonMethods.dateToDateTimeFormat(jsonobject.get(globalVariables.EmployeeEndDate).toString()));
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpbirthDate_inworker,jsonobject.get(globalVariables.EmployeeBirthDate).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpDisc_inworker,jsonobject.get(globalVariables.Discipline).toString());

	}

	public static  void jsonAssert_InboxWorker_3P(String bodyAsString, JSONObject jsonobject) throws SQLException, ParseException, java.text.ParseException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		
		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));
	
		DataBaseVerifier_Emp.DataBaseVerificationEmp("worker_ssn", jsonobject.get("StaffSSN").toString(), 
				"Account",jsonobject.get("BusinessEntityID").toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Emp_L_Name_inworker,jsonobject.get("StaffLastName").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Emp_F_Name_inworker,jsonobject.get("StaffFirstName").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.SeqID_inworker,jsonobject.get("SequenceID").toString());
		
		DataBaseVerifier_Emp.DataBaseVerificationEmp_stx_worker_3P("worker_version_number", jsonobject.get("SequenceID").toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Staff_L_Name_stxworker_3P,jsonobject.get("StaffLastName").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Staff_F_Name_stxworker_3P,jsonobject.get("StaffFirstName").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.StaffSeqID_stxworker_3p,jsonobject.get("SequenceID").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Account_stxworker_3P,jsonobject.get("BusinessEntityID").toString());
	
		DataBaseVerifier_Emp.DataBaseVerificationEmp_stxworker_supp("WORKER_SSN", jsonobject.get("StaffSSN").toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.WorkerKey_stxworker_supp,DataBaseVerifier_Emp.WorkerKey_stxworker_3P);
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Account_stxworker_3P,jsonobject.get("BusinessEntityID").toString());
	
	}

	public static  void jsonAssert_InboxWorker_AltEVV(String bodyAsString, JSONObject jsonobject) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		logger.log(LogStatus.INFO, "Validating DB response ");
		DataBaseVerifier_Emp.DataBaseVerificationEmp("WORKER_VERSION_NUMBER", jsonobject.get("SequenceID").toString(),
				"L_Name",jsonobject.get(globalVariables.EmployeeLastName).toString() );

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.ncode_inworker, "0");

		if(jsonobject.get("EmployeeQualifier").toString().equals("EmployeeRegID"))
		{
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpSocialSec_inworker,jsonobject.get("EmployeeSSN").toString());
		}
		else if (jsonobject.get("EmployeeQualifier").toString().equals("EmployeeSSN")) 
		{
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpSocialSec_inworker,jsonobject.get("EmployeeIdentifier").toString());
		}

		else if (jsonobject.get("EmployeeQualifier").toString().equals("EmployeeCustomID")) 
		{
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpSocialSec_inworker,jsonobject.get("EmployeeSSN").toString());
		} 

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Emp_L_Name_inworker,jsonobject.get(globalVariables.EmployeeLastName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Emp_F_Name_inworker,jsonobject.get(globalVariables.EmployeeFirstName).toString());	
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpAPI_inworker,jsonobject.get(globalVariables.EmployeeAPI).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.SeqID_inworker,jsonobject.get(globalVariables.SequenceID).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpEmail_inworker,jsonobject.get(globalVariables.EmployeeEmail).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpDisc_inworker,jsonobject.get(globalVariables.EmployeePosition).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpMgrEmail_inworker,jsonobject.get(globalVariables.EmployeeManagerEmail).toString());
	}

	// ***********************inbox.Xref method mapping ****************************************//

	public static void jsonAssert_XrefService(String bodyAsString ,JSONObject jsonobject) throws SQLException, ParseException, java.text.ParseException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		
		logger.log(LogStatus.INFO, "Validating DB response in inbox.xrefservice");

		DataBaseVerifier_Client.DataBaseVerificationClient_inbox_XrefService("LOC", jsonobject.get(globalVariables.ClientID).toString(), 
				"WORKER_ID", jsonobject.get("EmployeeID").toString());
		
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ncode_inboxXref, "0");

		if(jsonobject.get("ClientIDQualifier").toString().equals("ClientOtherID"))
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientIdQualifier_inboxXref, "CLIENT_ID_CUSTOM2");
		
		else if (jsonobject.get("ClientIDQualifier").toString().equals("ClientSSN")) 
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientIdQualifier_inboxXref, "CLIENT_SSN");
		
		else if (jsonobject.get("ClientIDQualifier").toString().equals("ClientID")) 
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientIdQualifier_inboxXref, "LOC");
		
		else if (jsonobject.get("ClientIDQualifier").toString().equals("ClientCustomID")) 
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.clientIdQualifier_inboxXref, "CLIENT_ID_CUSTOM1");

		if(jsonobject.get("EmployeeQualifier").toString().equals("EmployeeRegID"))
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.workerIdQualifier_inboxXref, "STX_ID");
		else if (jsonobject.get("EmployeeQualifier").toString().equals("EmployeeSSN")) 
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.workerIdQualifier_inboxXref, "WORKER_SSN");
		else if (jsonobject.get("EmployeeQualifier").toString().equals("EmployeePIN")) 
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.workerIdQualifier_inboxXref, "STX_ID");
		else if (jsonobject.get("EmployeeQualifier").toString().equals("EmployeeCustomID")) 
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.workerIdQualifier_inboxXref, "WORKER_ID_CUSTOM1");
		
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.xrefstartdate_inboxXref,CommonMethods.dateToDateTimeFormat(jsonobject.get("XRefStartDate").toString()) );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.xrefEnddate_inboxXref,CommonMethods.dateToDateTimeFormat(jsonobject.get("XRefEndDate").toString() ));
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Account_inboxXref,jsonobject.get("Account").toString() );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.service_inboxXref,jsonobject.get("Service").toString() );

		logger.log(LogStatus.INFO, "Validating DB response in stx.xrefservice ");
		DataBaseVerifier_Client.DataBaseVerificationClient_stx_XrefService("LOC", jsonobject.get(globalVariables.ClientID).toString());
		
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Account_StxXref,jsonobject.get("Account").toString() );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.service_StxXref,jsonobject.get("Service").toString() );	


	}

	// ***********************mySQl (member & Auth) method mapping ****************************************//

	public static void verify_ImportFile_MySQlDataBase(Map<String ,String> finalMapapdataByRow) throws SQLException, InterruptedException
	{

		System.out.println("------------Verifying Db Assertion----------------------");
		MYSQL_Database_Verifier.DataBaseVerificationClient(finalMapapdataByRow.get("clientOtherID"));
		CommonMethods.AssertEqualsAndPrintValuesString("0"+MYSQL_Database_Verifier.status_code,finalMapapdataByRow.get("clientStatus"),"clientStatus");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.account,"28000","Account");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.clientFirstName,finalMapapdataByRow.get("clientFirstName").toString().trim(),"clientFirstName");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.clientLastName,finalMapapdataByRow.get("clientLastName").toString().trim(),"clientLastName");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_m_name,finalMapapdataByRow.get("clientMiddleInitial").toString().trim(),"clientMiddleInitial");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_ssn,finalMapapdataByRow.get("clientSsn").toString().trim(),"clientSsn");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_medicaid_id,finalMapapdataByRow.get("clientCustomID").toString().trim(),"clientCustomID");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_id,finalMapapdataByRow.get("clientOtherID").toString().trim(),"clientId");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_name_suffix,finalMapapdataByRow.get("clientSuffix").toString().trim(),"clientSuffix");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Action_code,finalMapapdataByRow.get("action").toString().trim(),"action");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_addr_typ_qlfr,finalMapapdataByRow.get("clientAddressType").toString().trim(),"clientAddressType");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_addr1,finalMapapdataByRow.get("clientAddressLine1").toString().trim(),"clientAddressLine1");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_addr2,finalMapapdataByRow.get("clientAddressLine2").toString().trim(),"clientAddressLine2");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_country,finalMapapdataByRow.get("clientCounty").toString().trim(),"clientCounty");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_city,finalMapapdataByRow.get("clientCity").toString().trim(),"clientCity");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_state,finalMapapdataByRow.get("clientState").toString().trim(),"clientState");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_zip_code,finalMapapdataByRow.get("clientZip").toString().trim(),"clientZip");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Action_code_elig,finalMapapdataByRow.get("action").toString().trim(),"action Elig");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.payor_id,finalMapapdataByRow.get("payerId").toString().trim(),"payerId");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.program,finalMapapdataByRow.get("payerProgram").toString().trim(),"payerProgram");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_elig_beg_date,finalMapapdataByRow.get("clientEligibilityDateBegin").toString().trim(),"clientEligibilityDateBegin");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_start_of_care_date,finalMapapdataByRow.get("clientStartOfCareDate").toString().trim(),"clientStartOfCareDate");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_end_of_care_date,finalMapapdataByRow.get("clientEndOfCareDate").toString().trim(),"clientEndOfCareDate");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_prmy_dx_code,finalMapapdataByRow.get("clientPrimaryDiagnosisCode").toString().trim(),"clientPrimaryDiagnosisCode");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_scndry_dx_code,finalMapapdataByRow.get("clientSecondaryDiagnosisCode").toString().trim(),"clientSecondaryDiagnosisCode");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.payor_id_payor,finalMapapdataByRow.get("payerId").toString().trim(),"payerId program");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.service,finalMapapdataByRow.get("payerService").toString().trim(),"payerService");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.region,finalMapapdataByRow.get("payerRegion").toString().trim(),"payerRegion");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_phone_typ,finalMapapdataByRow.get("clientPhoneType").trim().toString(),"clientPhoneType");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_phone_num,finalMapapdataByRow.get("clientPhone").trim().toString(),"clientPhone");

	}

	public static void verify_ImportFile_Provider_STx_Account(Map<String ,String> finalMapapdataByRow) throws SQLException, InterruptedException
	{
		
		Thread.sleep(30000);
		System.out.println("------------Verifying Db Assertion----------------------");

		DataBaseVerfier_Provider.DataBaseVerification_provider(finalMapapdataByRow.get("ProviderID"));
		CommonMethods.AssertEqualsAndPrintValuesString(DataBaseVerfier_Provider.contact_last_name,finalMapapdataByRow.get("PrimaryContactLastName"),"PrimaryContactLastName");
		CommonMethods.AssertEqualsAndPrintValuesString(DataBaseVerfier_Provider.contact_first_name,finalMapapdataByRow.get("PrimaryContactFirstName"),"PrimaryContactFirstName");
		CommonMethods.AssertEqualsAndPrintValuesString(DataBaseVerfier_Provider.provider_name,finalMapapdataByRow.get("ProviderName"),"ProviderName");
		CommonMethods.AssertEqualsAndPrintValuesString(DataBaseVerfier_Provider.address1,finalMapapdataByRow.get("AddressLine1"),"AddressLine1");
		CommonMethods.AssertEqualsAndPrintValuesString(DataBaseVerfier_Provider.address2,finalMapapdataByRow.get("AddressLine2"),"AddressLine2");
		CommonMethods.AssertEqualsAndPrintValuesString(DataBaseVerfier_Provider.city,finalMapapdataByRow.get("AddressCity"),"AddressCity");
		CommonMethods.AssertEqualsAndPrintValuesString(DataBaseVerfier_Provider.email,finalMapapdataByRow.get("AgencyEmail"),"AgencyEmail");



	}

	public static void verify_ImportFile_MySQlDataBase_Auth(Map<String ,String> finalMapapdataByRow) throws SQLException, InterruptedException
	{
		Thread.sleep(30000);
		System.out.println("------------Verifying Db Assertion----------------------");
		MYSQL_Database_Verifier.DataBaseVerificationClientAuth(finalMapapdataByRow.get("ClientID"));

		CommonMethods.AssertEqualsAndPrintValuesString("0"+MYSQL_Database_Verifier.payor_id_auth,finalMapapdataByRow.get("PayerID"),"PayerID");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.program_auth,finalMapapdataByRow.get("PayerProgram").toString(),"PayerProgram");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_id_qlfr,finalMapapdataByRow.get("ClientQualifier").toString(),"ClientQualifier");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_id_auth,finalMapapdataByRow.get("ClientIdentifier").toString(),"ClientIdentifier");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.provider_id_qlfr_auth,finalMapapdataByRow.get("ProviderQualifier").toString(),"ProviderQualifier");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.provider_id_auth,finalMapapdataByRow.get("ProviderID").toString(),"ProviderID");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_ref_num,finalMapapdataByRow.get("AuthorizationReferenceNumber").toString(),"AuthorizationReferenceNumber");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.service_auth,finalMapapdataByRow.get("AuthorizationServiceID").toString(),"AuthorizationServiceID");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.service_auth,finalMapapdataByRow.get("AuthorizationBillingType").toString(),"AuthorizationBillingType");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Modifier1,finalMapapdataByRow.get("Modifier1").toString(),"Modifier1");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Modifier2,finalMapapdataByRow.get("Modifier2").toString(),"Modifier2");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Modifier3,finalMapapdataByRow.get("Modifier3").toString(),"Modifier3");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Modifier4,finalMapapdataByRow.get("Modifier4").toString(),"Modifier4");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_amt_typ,finalMapapdataByRow.get("AuthorizationAmountType").toString(),"AuthorizationAmountType");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_max,finalMapapdataByRow.get("AuthorizationMaximum").toString(),"AuthorizationMaximum");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_start_date,finalMapapdataByRow.get("AuthorizationStartDate").toString(),"AuthorizationStartDate");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_end_date,finalMapapdataByRow.get("AuthorizationEndDate").toString(),"AuthorizationEndDate");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_shared_ind,finalMapapdataByRow.get("AuthorizationShared").toString(),"AuthorizationShared");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_cmnt,finalMapapdataByRow.get("AuthorizationComments").toString(),"AuthorizationComments");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_lmt_typ,finalMapapdataByRow.get("AuthorizationLimitType").toString(),"AuthorizationLimitType");
		CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_status,finalMapapdataByRow.get("AuthorizationStatus").toString(),"AuthorizationStatus");
	}

	public static void assertControlFileValid(List<String> fileNames,String fileNameProcessedFile,Map<String ,String> finalMapapdataByRow ,String OutboundFile ) throws Exception
	{
		try{
			int count =0;
			Assertion_DbVerifier.verify_ImportFile_MySQlDataBase(finalMapapdataByRow);
			for(String filevalue:fileNames){

				if((filevalue).equalsIgnoreCase(fileNameProcessedFile))
				{
					System.out.println("Successfully imported");
					
					
				}
				if((filevalue).equalsIgnoreCase(OutboundFile))
				{
					System.out.println("Successfully imported outbound file");
					
				}

				if((filevalue+".gpg").equalsIgnoreCase(globalVariables.generatedControlFile)){
					System.out.println("-------------Varifying Control File----------");

					Map<String ,String> controlFileData = new HashMap<>();
					controlFileData=	FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo+filevalue);

					CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile+".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
					CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
					CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
					CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");

					
				}
			}
			}
		finally{
			System.gc();
			FileContentReader.deleteAllFilesInDirectory(globalVariables.decryptedfileResult);
			FileContentReader.deleteAllFilesInDirectory(globalVariables.EncryptedfileResult);
			FileContentReader.deleteFile(globalVariables.Encryptfile+fileNameProcessedFile);
			FileContentReader.deleteAllFilesInDirectory(globalVariables.decryptedfileResultTo);
		}
	}

	public static void assertControlFileValid_Auth(List<String> fileNames,String fileNameProcessedFile,Map<String ,String> finalMapapdataByRow) throws Exception
	{
		try{
			Assertion_DbVerifier.verify_ImportFile_MySQlDataBase_Auth(finalMapapdataByRow);
			for(String filevalue:fileNames){

				if((filevalue).equalsIgnoreCase(fileNameProcessedFile))
				{
					System.out.println("Successfully imported");
					FileContentReader.deleteFile(filevalue+".gpg");
				}

				if((filevalue+".gpg").equalsIgnoreCase(globalVariables.generatedControlFile)){
					System.out.println("-------------Verifying Control File----------");

					Map<String ,String> controlFileData = new HashMap<>();
					controlFileData=	FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo+filevalue);

					CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile+".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
					CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
					CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
					CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");


				}
			}}
		finally{
			System.gc();
			FileContentReader.deleteAllFilesInDirectory(globalVariables.decryptedfileResult);
			FileContentReader.deleteAllFilesInDirectory(globalVariables.EncryptedfileResult);
			FileContentReader.deleteFile(globalVariables.Encryptfile+fileNameProcessedFile);
			FileContentReader.deleteAllFilesInDirectory(globalVariables.decryptedfileResultTo);
		}
	}

	public static void assertControlFileInValid(List<String> fileNames,String fileNameProcessedFile,List<String> ErroMessage) throws Exception
	{
		try{
			for(String filevalue:fileNames){

				if(filevalue.equalsIgnoreCase(fileNameProcessedFile))
				{
					System.out.println("Successfully imported");
					FileContentReader.deleteFile(filevalue+".gpg");
				}

				if((filevalue+".gpg").equalsIgnoreCase(globalVariables.generatedErrorFile) ){
					System.out.println();
					FileContentReader.verifyFileContainString(globalVariables.decryptedfileResultTo+filevalue,ErroMessage,2);

				}
				if((filevalue+".gpg").equalsIgnoreCase(globalVariables.generatedControlFile)){

					Map<String ,String> controlFileData = new HashMap<>();
					controlFileData=	FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo+filevalue);
					CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile+".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
					CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
					CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
					CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");

				}

			}}
		finally{
			System.gc();
			FileContentReader.deleteAllFilesInDirectory(globalVariables.decryptedfileResult);
			FileContentReader.deleteAllFilesInDirectory(globalVariables.EncryptedfileResult);
			FileContentReader.deleteFile(globalVariables.Encryptfile+fileNameProcessedFile);
			FileContentReader.deleteAllFilesInDirectory(globalVariables.decryptedfileResultTo);
		}
	}

	// ***********************inbox Visit method mapping ****************************************//
	
	public static  void jsonAssert_inboxVisit_altevv(String bodyAsString ,JSONObject jsonobject) throws SQLException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));
	//	Assert.assertTrue(bodyAsString.contains("\"messageSummary\": \"All records updated successfully.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Visit.DataBaseVerification_Visit("visit_id", jsonobject.get("VisitOtherID").toString(), 
				"visit_version_number", jsonobject.get("SequenceID").toString() );

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.ncode_visit, "0");
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.workerID_visit, jsonobject.get("EmployeeIdentifier").toString() );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.ClientOtherID_visit, jsonobject.get("ClientID").toString());

	}

	public static  void jsonAssert_inboxVisit(String bodyAsString ,JSONObject jsonobject) throws SQLException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Visit.DataBaseVerification_Visit("visit_id", jsonobject.get("VisitOtherID").toString(), 
				"WORKER_ID", jsonobject.get("StaffOtherID").toString() );

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.ncode_visit, "0");
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.Account_visit, jsonobject.get("BusinessEntityID").toString() );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.visitSeqID_visit, jsonobject.get("SequenceID").toString());

	}
	
	public static  void jsonAssert_inboxVisitChanges(String bodyAsString, JSONObject jsonobject_mainArray, JSONObject jsonobject_SubArray) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));
//		Assert.assertTrue(bodyAsString.contains("\"messageSummary\": \"All records updated successfully.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");
		DataBaseVerifier_Visit.DataBaseVerification_Visit("visit_id", jsonobject_mainArray.get("VisitOtherID").toString(), 
					"visit_version_number", jsonobject_mainArray.get("SequenceID").toString() );

			
			DataBaseVerifier_Visit.DataBaseVerification_VisitChanges(globalVariables.dbvisitKey,DataBaseVerifier_Visit.visitKey_visit,"visit_version_number"
					,jsonobject_SubArray.get("SequenceID").toString());
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.reasonCode_visitChange, jsonobject_SubArray.get("ReasonCode").toString());

			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.reasonCodeMemo_visitChange, jsonobject_SubArray.get("ChangeReasonMemo").toString());
			
	}

	public static  void jsonAssert_inboxVisitCalls(String bodyAsString, JSONObject jsonobject_mainArray, JSONObject jsonobject_SubArray) throws SQLException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));
	//	Assert.assertTrue(bodyAsString.contains("\"messageSummary\": \"All records updated successfully.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");
		DataBaseVerifier_Visit.DataBaseVerification_Visit("visit_id", jsonobject_mainArray.get("VisitOtherID").toString(), 
					"visit_version_number", jsonobject_mainArray.get("SequenceID").toString());

			DataBaseVerifier_Visit.DataBaseVerification_VisitCalls(globalVariables.dbvisitKey,DataBaseVerifier_Visit.visitKey_visit,"call_assignment_qlfr"
					,jsonobject_SubArray.get("CallAssignment").toString());   
			
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.callID_visitCall, jsonobject_SubArray.get("CallExternalID").toString());
			//CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.CallDateTime_visitCall, jsonobject_SubArray.get("CallDateTime").toString());
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.latitude_visitCall, jsonobject_SubArray.get("CallLatitude").toString());
			CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.longitude_visitCall,jsonobject_SubArray.get("CallLongitude").toString());		
		
	}

	public static  void jsonAssert_inboxVisitSchedule(String bodyAsString, JSONObject jsonobject_mainArray, JSONObject jsonobject_SubArray) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": null,"));
		Assert.assertTrue(bodyAsString.contains("\"data\": \"All records uploaded successfully.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		//DataBaseVerifier_Visit.DataBaseVerification_VisitSchedule(DBfield1, value1, DBfield2, value2);

	}
	
	public static  void jsonAssert_STXSchedule(String bodyAsString, JSONObject jsonobject) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Emp.DataBaseVerificationEmp_stx_schedule("STX_id", jsonobject.get("EmployeePIN").toString());
		//CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Account_stxschedule, jsonobject.get(globalVariables.Account).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmployeePin_stxschedule, jsonobject.get(globalVariables.EmployeePIN).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmployeeID_stxschedule, jsonobject.get(globalVariables.EmployeeID).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmployeePayRate_stxschedule, jsonobject.get(globalVariables.PayRate).toString());

	}

	public static  void jsonAssert_inboxVisitException(String bodyAsString, JSONObject jsonobject_mainArray, JSONObject jsonobject_SubArray) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	//	Assert.assertTrue(bodyAsString.contains("\"data\": \"All records uploaded successfully.\""));

		logger.log(LogStatus.INFO, "Validating DB response");
		
		DataBaseVerifier_Visit.DataBaseVerification_visits_exceptions("exception_id",jsonobject_mainArray.get("ExceptionID").toString());
	
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.ncode_visitexc, null);
	//	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Visit.exception_ack_ind_visitexc, jsonobject_SubArray.get("ExceptionAcknowledged").toString());
	}

	// ***********************inbox APP User ****************************************//

	public static  void jsonAssert_Inbox_STX_AppUser(String bodyAsString, JSONObject jsonobject) throws SQLException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Client.DataBaseVerificationClient_Inbox_App_User("USERNAME", jsonobject.get(globalVariables.DesigneeEmail).toString(),
				"user_f_name",jsonobject.get(globalVariables.ClientDesigneeFirstName).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.UserStatus_inappuser, "OPEN");
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.UserFName_inappuser, jsonobject.get(globalVariables.ClientDesigneeFirstName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.UserLName_inappuser, jsonobject.get(globalVariables.ClientDesigneeLastName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.UserDesc_inappuser, "null" );
		//	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.DesigneeStartDate, "null");
		//	CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.DesigneeEndDate, jsonobject.get(globalVariables.ClientDesigneeEndDate).toString());

		DataBaseVerifier_Client.DataBaseVerificationClient_STX_App_User("USERNAME", jsonobject.get(globalVariables.DesigneeEmail).toString(),
				"user_f_name",jsonobject.get(globalVariables.ClientDesigneeFirstName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.UserLName_appuser, jsonobject.get(globalVariables.ClientDesigneeLastName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.UserDesc_appuser, jsonobject.get(globalVariables.description).toString());

	}

   // ************************ XrefService for Xref.json *****************//
	
	public static void jsonAssert_XrefService_xref(String bodyAsString ,JSONObject jsonobject) throws SQLException, ParseException, java.text.ParseException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		logger.log(LogStatus.INFO, "Validating DB response in inbox.xrefservice");

		DataBaseVerifier_Client.DataBaseVerificationClient_inbox_XrefService("LOC", jsonobject.get(globalVariables.ClientID).toString(),
				"WORKER_ID", jsonobject.get("EmployeeID").toString());
		
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ncode_inboxXref, "0");	
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.xrefstartdate_inboxXref,CommonMethods.dateToDateTimeFormat(jsonobject.get("XRefStartDate").toString()) );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.xrefEnddate_inboxXref,CommonMethods.dateToDateTimeFormat(jsonobject.get("XRefEndDate").toString() ));
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Account_inboxXref,jsonobject.get("Account").toString() );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.service_inboxXref,jsonobject.get("Service").toString() );

		logger.log(LogStatus.INFO, "Validating DB response in stx.xrefservice ");
		DataBaseVerifier_Client.DataBaseVerificationClient_stx_XrefService("LOC", jsonobject.get(globalVariables.ClientID).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.Account_StxXref,jsonobject.get("Account").toString() );
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.service_StxXref,jsonobject.get("Service").toString() );	


	}

	// *********************** STX.Worker_supp for OpenEVV ********************//
	
	public static  void jsonAssert_stxWorker_supp(String bodyAsString, JSONObject jsonobject) throws SQLException, ParseException, java.text.ParseException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Emp.DataBaseVerificationEmp_stxworker_supp("WORKER_SSN", jsonobject.get("EmployeeSocialSecurity").toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmployeeAdd2_stxworker_supp,jsonobject.get(globalVariables.EmployeeAddress2).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmployeeAdd1_stxworker_supp,jsonobject.get("EmployeeAddress1").toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmployeeHireDate_stxworker_supp,CommonMethods.dateToDateTimeFormat(jsonobject.get(globalVariables.EmployeeHireDate).toString()));
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmployeeEndDate_stxworker_supp,CommonMethods.dateToDateTimeFormat(jsonobject.get(globalVariables.EmployeeEndDate).toString()));

	}
}




