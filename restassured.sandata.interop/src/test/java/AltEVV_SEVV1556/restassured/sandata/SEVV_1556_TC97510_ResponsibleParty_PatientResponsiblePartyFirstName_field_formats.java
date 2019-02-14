package AltEVV_SEVV1556.restassured.sandata;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_1556_TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats extends BaseTest{
	
	@Test
	public void TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_valid"); 
		logger.log(LogStatus.INFO, "TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ResponsibleParty");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(30));
		
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test
	public void TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_morethan_allowed_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_morethan_allowed_length"); 
		logger.log(LogStatus.INFO, "TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_morethan_allowed_length"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ResponsibleParty");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(31));
		
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.PatientResponsiblePartyFirstNamelengtherror);
	}
	
	@Test
	public void TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_blank"); 
		logger.log(LogStatus.INFO, "TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ResponsibleParty");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientResponsiblePartyFirstName", "");
		
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.PatientResponsiblePartyFirstNamelengtherror);
	}
	
	@Test
	public void TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_null"); 
		logger.log(LogStatus.INFO, "TC97510_ResponsibleParty_PatientResponsiblePartyFirstName_field_formats_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ResponsibleParty");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientResponsiblePartyFirstName", null);
		
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.PatientResponsiblePartyFirstNamenullerror);
	}
	

}
