package com.globalMethods.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

/**
 * @author MayankM
 *
 */

public class GenerateUniqueParam {

	public static String primaryField[];


	// ************** Unique Generator for Client *********************************//

	@SuppressWarnings("unchecked")
	public static JSONArray ClientParams_OpenEVV(String jsonnameclient) throws FileNotFoundException, IOException, ParseException {

		String uniqueClientId = CommonMethods.generateRandomNumberOfFixLength(5);

		JSONArray j= CommonMethods.LoadJSON_OpenEVV(jsonnameclient);

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);
		
		JSONArray j4 = (JSONArray) js.get("ClientAddress");
		JSONObject js4 = (JSONObject) j4.get(1);
		js4.put("ClientID", uniqueClientId);

		js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientLastName",  CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientMedicaidID",CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("ClientEmailAddress",  CommonMethods.generateEmailAddress_string(10));

		return j;

	}

	@SuppressWarnings("unchecked")
	public static JSONArray ClientParams_3P(String jsonnameclient) throws FileNotFoundException, IOException, ParseException {

		JSONArray j= CommonMethods.LoadJSON_ThreeP(jsonnameclient);

		JSONObject js = (JSONObject) j.get(0);
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));
	
		JSONArray j2 = (JSONArray) js.get("Address");
		JSONObject js2 = (JSONObject) j2.get(0);
		
		JSONArray j5 = (JSONArray) js.get("Address");
		JSONObject js5 = (JSONObject) j5.get(1);
		js5.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));
		js2.put("PatientAddressLine2", CommonMethods.generateRandomAlphaNumeric(10));
		js2.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));
		
		JSONArray j3 = (JSONArray) js.get("Phones");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("PatientPhoneNumber", CommonMethods.generateRandomNumberOfFixLength(10));

		JSONArray j4 = (JSONArray) js.get("ResponsibleParty");
		JSONObject js4 = (JSONObject) j4.get(0);
		js4.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		js4.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(10));

		return j;

	}

	@SuppressWarnings("unchecked")
	public static JSONArray ClientParams_AltEVV(String jsonnameclient) throws FileNotFoundException, IOException, ParseException {

		JSONArray j= CommonMethods.LoadJSON_AltEVV(jsonnameclient);
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("ClientIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(10)); 
		js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientLastName",  CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientMedicaidID",CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("ClientEmailAddress",  CommonMethods.generateEmailAddress_string(10));

		JSONArray jsonArrayAuth = (JSONArray) js.get("ClientPayerInformation");
		JSONObject jsonObjectAuth = (JSONObject) jsonArrayAuth.get(0);
		jsonObjectAuth.put("PayerProgram", CommonMethods.generateRandomStringOfFixLength(5));	
		jsonObjectAuth.put("ProcedureCode", CommonMethods.generateRandomStringOfFixLength(5));	

		JSONArray jsAdd = (JSONArray) js.get("ClientAddress");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ClientResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("ClientContactZip", CommonMethods.generateRandomNumberOfFixLength(9));


		return j;
	}

	
	@SuppressWarnings("unchecked")
	public static JSONArray patient_AltEVV(String jsonnameclient) throws FileNotFoundException, IOException, ParseException {

		JSONArray j= CommonMethods.LoadJSON_AltEVV(jsonnameclient);
		JSONObject js = (JSONObject) j.get(0);

		js.put("PatientOtherID", CommonMethods.generateRandomAlphaNumeric(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));
	
		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));


		return j;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject updateJsonWithPrimaryFieldsClient(JSONArray jsonArray,HashMap<String, String> nonPrimaryField){

		JSONObject jsobject = (JSONObject) jsonArray.get(0);

		primaryField=new String[]{"ClientID","ClientSSN","ClientFirstName","ClientLastName","ClientMedicaidID"};


		Iterator<String> keyset=nonPrimaryField.keySet().iterator();
		ArrayList<String> primaryList = new ArrayList<String>(Arrays.asList(primaryField));
		while(keyset.hasNext()){


			primaryList.add(keyset.next().toString());
		}


		for(int i =0;i<primaryList.size();i++)
		{
			switch(primaryList.get(i)) {
			case "ClientID" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomNumberOfFixLength(5));
				break;
			case "ClientSSN" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomNumberOfFixLength(9));
				break;
			case "ClientFirstName" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomStringOfFixLength(10));
				break;
			case "ClientLastName" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomStringOfFixLength(10));
				break;
			case "ClientMedicaidID" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomNumberOfFixLength(10));
				break;
			default :
				jsobject.put(primaryList.get(i), nonPrimaryField.get(primaryList.get(i))); 
			}
		}
		return jsobject;
	}

	@SuppressWarnings("unchecked")
	public static JSONArray ClientParams_ohio(String jsonnameclient) throws FileNotFoundException, IOException, ParseException {

		JSONArray jsobject= CommonMethods.LoadJSON_ThreeP(jsonnameclient);


		JSONObject js = (JSONObject) jsobject.get(0);


		js.put("PatientFirstName", CommonMethods.generateRandomStringOfFixLength(14));
		js.put("PatientOtherID", CommonMethods.generateRandomStringOfFixLength(15));
		js.put("SequenceID",CommonMethods.generateRandomNumberOfFixLength(12));
		js.put("PatientMedicaidID",CommonMethods.generateRandomNumberOfFixLength(12));

		return jsobject;

	}
	
	@SuppressWarnings("unchecked")
	public static JSONArray molina_auth(String jsonnameauth) throws FileNotFoundException, IOException, ParseException {

		JSONArray jsobject= CommonMethods.LoadJSON_auth(jsonnameauth);


		JSONObject js = (JSONObject) jsobject.get(0);


		js.put("ClientIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PayerID", CommonMethods.generateRandomAlphaNumeric(64));
		
		return jsobject;

	}

	
	@SuppressWarnings("unchecked")
	public static JSONArray MemberParams_OpenEVV(String jsonnameclient) throws FileNotFoundException, IOException, ParseException {

		JSONArray j= CommonMethods.LoadJSON_OpenEVV(jsonnameclient);
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5));
		js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientLastName",  CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientCustomID", CommonMethods.generateRandomNumberOfFixLength(10)); 
		js.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(10)); 
		js.put("ClientMedicalRecordNumber", CommonMethods.generateRandomNumberOfFixLength(10)); 
		js.put("ClientEmail", CommonMethods.generateEmailAddress_string(10));
		

		String payerid = CommonMethods.generateRandomNumberOfFixLength(5);
		JSONArray jsonArrayAuth = (JSONArray) js.get("ClientPayerProgramService");
		JSONObject jsonObjectAuth = (JSONObject) jsonArrayAuth.get(0);
		jsonObjectAuth.put("PayerID", payerid);	
		
		JSONArray jsonArrayElig = (JSONArray) js.get("ClientEligibility");
		JSONObject jsonObjectElig = (JSONObject) jsonArrayElig.get(0);
		jsonObjectElig.put("PayerID", payerid);	

		JSONArray jsAdd = (JSONArray) js.get("ClientAddress");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		return j;

	}

	// ************** Unique Generator for pipe delimited *********************************//

	public static Map<String ,String> MemberParams_PipeDelimited() throws FileNotFoundException, IOException, ParseException {
		Map<String ,String> mapdataByValue = new HashMap<>();

		mapdataByValue.put(globalVariables.molinaClientId,CommonMethods.generateRandomNumberOfFixLength(5));
		mapdataByValue.put(globalVariables.molinaClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
		mapdataByValue.put(globalVariables.molinaClientFirstName, CommonMethods.generateRandomStringOfFixLength(10));
		mapdataByValue.put(globalVariables.molinaClientLastName,  CommonMethods.generateRandomStringOfFixLength(10));
		mapdataByValue.put(globalVariables.molinaClientCustomID, CommonMethods.generateRandomNumberOfFixLength(10)); 
		mapdataByValue.put(globalVariables.molinaClientOtherID, CommonMethods.generateRandomNumberOfFixLength(10)); 
		mapdataByValue.put(globalVariables.molinaClientMedicalRecordNum, CommonMethods.generateRandomNumberOfFixLength(10)); 
		mapdataByValue.put(globalVariables.molinaClientEmail, CommonMethods.generateEmailAddress_string(10));
		mapdataByValue.put(globalVariables.molinaAction, "A");

		return mapdataByValue;

	}

	public static Map<String ,String> providerParams_PipeDelimited() throws FileNotFoundException, IOException, ParseException {
		Map<String ,String> mapdataByValue = new HashMap<>();

		mapdataByValue.put(globalVariables.molinaproviderId,CommonMethods.generateRandomNumberOfFixLength(10));
		mapdataByValue.put(globalVariables.molinaprovider1FirstName, CommonMethods.generateRandomStringOfFixLength(10));
		mapdataByValue.put(globalVariables.molinaprovider1LastName,  CommonMethods.generateRandomStringOfFixLength(10));
		mapdataByValue.put(globalVariables.molinaproviderEmail, CommonMethods.generateEmailAddress_string(10));



		return mapdataByValue;

	}

	public static Map<String ,String> MemberParams_PipeDelimited_RequiredField() throws FileNotFoundException, IOException, ParseException {
		Map<String ,String> mapdataByValue = new HashMap<>();


		mapdataByValue.put(globalVariables.molinaClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
		mapdataByValue.put(globalVariables.molinaClientFirstName, CommonMethods.generateRandomStringOfFixLength(10));
		mapdataByValue.put(globalVariables.molinaClientLastName,  CommonMethods.generateRandomStringOfFixLength(10));
		mapdataByValue.put(globalVariables.molinaClientCustomID, CommonMethods.generateRandomNumberOfFixLength(10)); 
		mapdataByValue.put(globalVariables.molinaClientOtherID, CommonMethods.generateRandomNumberOfFixLength(10)); 
		mapdataByValue.put(globalVariables.molinaClientMedicalRecordNum, CommonMethods.generateRandomNumberOfFixLength(10)); 
		mapdataByValue.put(globalVariables.molinaClientEmail, CommonMethods.generateEmailAddress_string(10));
		mapdataByValue.put(globalVariables.molinaAction, "A");
		mapdataByValue.put(globalVariables.molinaclientAddressType,DataGeneratorClient.clientAddressType());
		mapdataByValue.put(globalVariables.molinaclientAddressLine1,CommonMethods.generateRandomAlphaNumeric(25));
		mapdataByValue.put(globalVariables.molinaclientCity,CommonMethods.generateRandomAlphaNumeric(25));
		mapdataByValue.put(globalVariables.molinaclientState,DataGeneratorClient.generateClientState());
		mapdataByValue.put(globalVariables.molinaclientZip,CommonMethods.generateRandomNumberOfFixLength(9));
		mapdataByValue.put(globalVariables.molinaclientEligibilityDateBegin,CommonMethods.generateTodayDate_YYYY_MM_dd());


		return mapdataByValue;

	}

	public static Map<String ,String> MemberParams_PipeDelimited_RequiredFieldMax() throws FileNotFoundException, IOException, ParseException {
		Map<String ,String> mapdataByValue = new HashMap<>();


		mapdataByValue.put(globalVariables.molinaClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
		mapdataByValue.put(globalVariables.molinaClientFirstName, CommonMethods.generateRandomStringOfFixLength(30));
		mapdataByValue.put(globalVariables.molinaClientLastName,  CommonMethods.generateRandomStringOfFixLength(30));
		mapdataByValue.put(globalVariables.molinaClientCustomID, CommonMethods.generateRandomNumberOfFixLength(24)); 
		mapdataByValue.put(globalVariables.molinaClientOtherID, CommonMethods.generateRandomNumberOfFixLength(24)); 
		mapdataByValue.put(globalVariables.molinaClientMedicalRecordNum, CommonMethods.generateRandomNumberOfFixLength(12)); 
		mapdataByValue.put(globalVariables.molinaAction, "A");
		mapdataByValue.put(globalVariables.molinaclientAddressLine1,CommonMethods.generateRandomAlphaNumeric(30));
		mapdataByValue.put(globalVariables.molinaclientCity,CommonMethods.generateRandomAlphaNumeric(30));
		mapdataByValue.put(globalVariables.molinaclientState,DataGeneratorClient.generateClientState());
		mapdataByValue.put(globalVariables.molinaclientZip,CommonMethods.generateRandomNumberOfFixLength(9));
		mapdataByValue.put(globalVariables.molinaclientEligibilityDateBegin,CommonMethods.generateTodayDate_YYYY_MM_dd());


		return mapdataByValue;

	}

	public static List<String> MemberParams_PipeDelimited_Missing_RequiredField() throws FileNotFoundException, IOException, ParseException {
		List<String> mapdataByValue = new ArrayList<String>();

		mapdataByValue.add(globalVariables.molinaClientSSN);
		mapdataByValue.add(globalVariables.molinaClientFirstName);
		mapdataByValue.add(globalVariables.molinaClientLastName);
		mapdataByValue.add(globalVariables.molinaClientCustomID);
		mapdataByValue.add(globalVariables.molinaClientOtherID);
		mapdataByValue.add(globalVariables.molinaClientMedicalRecordNum);
		mapdataByValue.add(globalVariables.molinaAction);
		mapdataByValue.add(globalVariables.molinaclientAddressLine1);
		mapdataByValue.add(globalVariables.molinaclientCity);
		mapdataByValue.add(globalVariables.molinaclientState);
		mapdataByValue.add(globalVariables.molinaclientZip);
		mapdataByValue.add(globalVariables.molinaclientEligibilityDateBegin);



		return mapdataByValue;

	}

	public static Map<String ,String> MemberParams_PipeDelimited_RequiredFieldMin() throws FileNotFoundException, IOException, ParseException {
		Map<String ,String> mapdataByValue = new HashMap<>();


		mapdataByValue.put(globalVariables.molinaClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
		mapdataByValue.put(globalVariables.molinaClientFirstName, CommonMethods.generateRandomStringOfFixLength(1));
		mapdataByValue.put(globalVariables.molinaClientLastName,  CommonMethods.generateRandomStringOfFixLength(1));
		mapdataByValue.put(globalVariables.molinaClientCustomID, CommonMethods.generateRandomNumberOfFixLength(1)); 
		mapdataByValue.put(globalVariables.molinaClientOtherID, CommonMethods.generateRandomNumberOfFixLength(1)); 
		mapdataByValue.put(globalVariables.molinaClientMedicalRecordNum, CommonMethods.generateRandomNumberOfFixLength(1)); 
		mapdataByValue.put(globalVariables.molinaAction, "A");
		mapdataByValue.put(globalVariables.molinaclientAddressLine1,CommonMethods.generateRandomAlphaNumeric(1));
		mapdataByValue.put(globalVariables.molinaclientCity,CommonMethods.generateRandomAlphaNumeric(1));
		mapdataByValue.put(globalVariables.molinaclientState,DataGeneratorClient.generateClientState());
		mapdataByValue.put(globalVariables.molinaclientZip,CommonMethods.generateRandomNumberOfFixLength(1));
		mapdataByValue.put(globalVariables.molinaclientEligibilityDateBegin,CommonMethods.generateTodayDate_YYYY_MM_dd());


		return mapdataByValue;

	}

	public static Map<String ,String> AuthParams_PipeDelimited() throws FileNotFoundException, IOException, ParseException {
		Map<String ,String> mapdataByValue = new HashMap<>();

		mapdataByValue.put("ClientIdentifier",CommonMethods.generateRandomNumberOfFixLength(9));
		mapdataByValue.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(9));
		mapdataByValue.put("ProviderID", CommonMethods.generateRandomStringOfFixLength(10));
		mapdataByValue.put("ProviderQualifier",  "SandataID");
		mapdataByValue.put("ProviderID", CommonMethods.generateRandomNumberOfFixLength(11)); 
		mapdataByValue.put("AuthorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(10)); 

		return mapdataByValue;

	}

	// ************** Unique Generator for Employee *********************************//

	@SuppressWarnings("unchecked")
	public static JSONArray EmpParams_OpenEVV(String jsonnameemp) throws FileNotFoundException, IOException, ParseException {

		JSONArray j=CommonMethods.LoadJSON_OpenEVV(jsonnameemp);

		JSONObject js = (JSONObject) j.get(0);

		js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(9));

		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(5));

		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(5));

		js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(10));

		js.put("EmployeeAltPhone", CommonMethods.generateRandomNumberOfFixLength(10));

		js.put("EmployeeAltPhone2", CommonMethods.generateRandomNumberOfFixLength(10));

		js.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(5));

		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(9));

		return j;

	}

	@SuppressWarnings("unchecked")
	public static JSONArray EmpParams_3P(String jsonnameemp) throws FileNotFoundException, IOException, ParseException {

		JSONArray j=CommonMethods.LoadJSON_ThreeP(jsonnameemp);

		JSONObject js = (JSONObject) j.get(0);

		js.put("StaffOtherID", DataGeneratorEmployee.generateEmpPIN(9));

		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));

		js.put("StaffID", CommonMethods.generateRandomNumberOfFixLength(9));

		js.put("StaffSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		js.put("StaffLastName", CommonMethods.generateRandomStringOfFixLength(5));

		js.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(5));

		js.put("StaffEmail", DataGeneratorEmployee.generateEmpEmail(10));

		js.put("StaffPosition", DataGeneratorEmployee.generateStaffPosition());

		return j;

	}

	@SuppressWarnings("unchecked")
	public static JSONArray EmpParams_AltEVV(String jsonnameemp) throws FileNotFoundException, IOException, ParseException {

		JSONArray j=CommonMethods.LoadJSON_AltEVV(jsonnameemp);

		JSONObject js = (JSONObject) j.get(0);

		String empssn = CommonMethods.generateRandomNumberOfFixLength(9);

		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10));

		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(10));

		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));

		js.put("EmployeeSSN", empssn);

		js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(14));

		js.put("EmployeeIdentifier", empssn);

		return j;

	}

	@SuppressWarnings("unchecked")
	public static JSONObject updateJsonWithPrimaryFieldsEmployee(JSONArray jsonArray,HashMap<String, String> nonPrimaryField){

		JSONObject jsobject = (JSONObject) jsonArray.get(0);
		primaryField=new String[]{"EmployeeFirstName","EmployeeLastName","EmployeeSSN","ProviderID","EmployeeEmail"};
		Iterator<String> keyset=nonPrimaryField.keySet().iterator();
		ArrayList<String> primaryList = new ArrayList<String>(Arrays.asList(primaryField));
		while(keyset.hasNext()){ 
			primaryList.add(keyset.next().toString());

		}

		for(int i =0;i<primaryList.size();i++)
		{
			switch(primaryList.get(i)) {
			case "EmployeeFirstName" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomStringOfFixLength(5));
				break;
			case "EmployeeLastName" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomStringOfFixLength(5));
				break;
			case "EmployeeSSN" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomNumberOfFixLength(9));
				break;
			case "ProviderID" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomNumberOfFixLength(5));
				break;
			case "EmployeeEmail" :
				jsobject.put(primaryList.get(i), DataGeneratorEmployee.generateEmpEmail(14));
				break;
			default :
				jsobject.put(primaryList.get(i), nonPrimaryField.get(primaryList.get(i))); 
			}

		}



		return jsobject;

	}

	public static void validateJsonResponseAltEVVSingleFieldEmployee(String[] updateValue,String ScenarioDetail,String field) throws FileNotFoundException, IOException, ParseException
	{
		for(int i=0;i<updateValue.length;i++){
			//Using Reusable method to load employee json
			JSONArray altEVVJsonArray=CommonMethods.LoadJSON_AltEVV("Staff_intake");

			HashMap<String, String> nonPrimaryField = new HashMap<String, String>();
			nonPrimaryField.put(field, updateValue[i]);

			@SuppressWarnings("unused")
			JSONObject altEVVJsonArrayobject=updateJsonWithPrimaryFieldsEmployee(altEVVJsonArray,nonPrimaryField);


			String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_emp"));


			if(ScenarioDetail.equalsIgnoreCase("Valid")){
				Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
				Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
			}
			else{
				//Assert.assertTrue(bodyAsString.contains("ERROR: The ProviderQualifier format is incorrect"));
				Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			}

		}
	}

	@SuppressWarnings("unchecked")
	public static JSONArray EmpTC91415_AltEVV(String jsonnameemp) throws FileNotFoundException, IOException, ParseException {

		JSONArray j=CommonMethods.LoadJSON_AltEVV(jsonnameemp);

		JSONObject js = (JSONObject) j.get(0);

		String empssn = CommonMethods.generateRandomNumberOfFixLength(9);

		js.put("EmployeeIdentifier", empssn);

		js.put("EmployeeOtherID",CommonMethods.generateRandomAlphaNumeric(64));

		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(16));

		js.put("EmployeeSSN", empssn);

		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(30));

		js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(49));

		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(30));

		js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(49)); 

		js.put("ProviderID", "8459327");

		js.put("EmployeeAPI", CommonMethods.generateRandomNumberOfFixLength(25));
		return j;

	}

	// ************** Unique Generator for Xref  *********************************//

	@SuppressWarnings("unchecked")
	public static JSONArray XrefParams(String jsonnamexref) throws FileNotFoundException, IOException, ParseException {

		JSONArray j=CommonMethods.LoadJSON_OpenEVV(jsonnamexref);

		JSONObject js = (JSONObject) j.get(0);

		js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(5));
		js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(5));

		return j;
	}

	// ************** Unique Generator for Visit *********************************//

	@SuppressWarnings({ "unchecked", "unused" })
	public static JSONArray VisitParam_3P(String jsonnamevisit) throws FileNotFoundException, IOException, ParseException {

		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		String bodyAsStringClient = CommonMethods.captureResponse3P(jsonArrayClient, CommonMethods.propertyfileReader("3P_patient"));
		

		JSONArray jsonArrayEmp = GenerateUniqueParam.EmpParams_3P(globalVariables.ThreeP_Staff_Json);
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		String bodyAsStringEmp = CommonMethods.captureResponse3P(jsonArrayEmp, CommonMethods.propertyfileReader("3P_Staff"));

		JSONArray jsonArrayVisit = CommonMethods.LoadVisitJSON_3P(globalVariables.ThreeP_visit_Json);
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		
		String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));


		////////////putting value in Visit subarray detail from alt EVV visitjson//////////////

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put("SequenceID", sequenceid);

		return jsonArrayVisit;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public static JSONArray VisitParams_AltEVV() throws FileNotFoundException, IOException, ParseException
	{
		////////////Generating Unique Client detail from  alt EVV client json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		
		String bodyAsStringClient = CommonMethods.captureResponseAltEVV(jsonArrayClient, CommonMethods.propertyfileReader("altevv_clients"));
		String resget_client=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsStringClient,CommonMethods.propertyfileReader("altevv_clients_get"));
	
		////////////Generating Unique Employee detail from alt EVV employee json//////////////

		JSONArray jsonArrayEmp = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseAltEVV(jsonArrayEmp, CommonMethods.propertyfileReader("altevv_emp"));
		String resget_emp=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsStringEmp,CommonMethods.propertyfileReader("altevv_emp_get"));
		
		////////////Generating Unique visit detail from alt EVV visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadVisitJSON(globalVariables.visit_intake);

		String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);

		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put("ClientIdentifier",jsonObjectClient.get("ClientIdentifier").toString());
		jsonObjectVisit.put("ClientIDQualifier","ClientID");
		jsonObjectVisit.put("ClientID",jsonObjectClient.get("ClientID").toString());

		jsonObjectVisit.put("EmployeeIdentifier",jsonObjectEmp.get("EmployeeIdentifier").toString());

		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));


		////////////putting value in Visit subarray detail from alt EVV visitjson//////////////

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);

		return jsonArrayVisit;
	}

	@SuppressWarnings("unchecked")
	public static  JSONObject updateJsonWithPrimaryFieldsVisit(JSONArray jsonArray,HashMap<String, String> nonPrimaryField){


		JSONObject jsobject = (JSONObject) jsonArray.get(0);

		primaryField=new String[]{"ClientID","PayerID","ClientOtherID","ClientQualifier","ClientIdentifier","ProviderID","SequenceID","EmployeeIdentifier"};


		Iterator<String> keyset=nonPrimaryField.keySet().iterator();
		ArrayList<String> primaryList = new ArrayList<String>(Arrays.asList(primaryField));
		while(keyset.hasNext()){


			primaryList.add(keyset.next().toString());
		}


		for(int i =0;i<primaryList.size();i++)
		{
			switch(primaryList.get(i)) {
			case "ClientID" :
				jsobject.put(primaryList.get(i), DataGeneratorVisit.generateClientID(5));
				break;
			case "PayerID" :
				jsobject.put(primaryList.get(i), DataGeneratorVisit.generatePayerID(5));
				break;
			case "ClientOtherID" :
				jsobject.put(primaryList.get(i), DataGeneratorVisit.generateRecipientIDCustom2(12));
				break;
			case "ClientQualifier" :
				jsobject.put(primaryList.get(i), DataGeneratorVisit.generateClientQualifier(7));
				break;
			case "ClientIdentifier" :
				jsobject.put(primaryList.get(i), DataGeneratorVisit.generateClientIdentifier(5));
				break;	
			case "ProviderID" :
				jsobject.put(primaryList.get(i), DataGeneratorVisit.generateProviderID(7));
				break;
			case "SequenceID" :
				jsobject.put(primaryList.get(i), DataGeneratorVisit.generateSequenceID(7));
				break;
			case "EmployeeIdentifier" :
				jsobject.put(primaryList.get(i), DataGeneratorVisit.generateEmployeeIdentifier(7));
				break;
			default :
				jsobject.put(primaryList.get(i), nonPrimaryField.get(primaryList.get(i))); 
			}
		}



		return jsobject;

	}

	@SuppressWarnings("unchecked")
	public static JSONArray createClient(String jsonnameclient, String providerId) throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONArray j = null;

		j = (JSONArray) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator +"src" + File.separator + "main"+ File.separator
				+ "java" +File.separator+ "Resources"+ File.separator+ "DWHExport"+File.separator +jsonnameclient+".json"));

//		JSONArray j= CommonMethods.LoadJSON_AltEVV(jsonnameclient);
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientID", DataGeneratorClient.generateClientID(5));

		js.put("ClientSSN", DataGeneratorClient.generateClientSSN(9));

		js.put("ClientOtherID", DataGeneratorClient.generateRecipientIDCustom2(12));

		js.put("ClientFirstName", DataGeneratorClient.generateClientFirstName(10));

		js.put("ClientLastName", DataGeneratorClient.generateClientLastName(10));

		js.put("ClientMedicaidID",CommonMethods.generateRandomNumberOfFixLength(10));

		js.put("ClientIdentifier", DataGeneratorClient.generateClientID(9));

		js.put("SequenceID", DataGeneratorClient.generateClientID(8));

		JSONObject providerIdentification = (JSONObject) js.get("ProviderIdentification");
		providerIdentification.put("ProviderID", providerId);

		//create new unique phone number to compare with CLIENT_PHONE file
		String newClientPhone = DataGeneratorClient.generateClientPhone(10);
		JSONArray clientPhones = (JSONArray) js.get("ClientPhone");
		JSONObject clientPhone = (JSONObject) clientPhones.get(0);
		clientPhone.put("ClientPhone", newClientPhone);

		JSONObject clientPhone2 = (JSONObject) clientPhones.get(1);
		clientPhone2.put("ClientPhone", newClientPhone);


		return j;
	}


}




