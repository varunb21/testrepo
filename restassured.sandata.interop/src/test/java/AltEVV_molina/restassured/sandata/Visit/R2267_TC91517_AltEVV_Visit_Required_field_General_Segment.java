package AltEVV_molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91517_AltEVV_Visit_Required_field_General_Segment extends BaseTest{

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_invalid");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitOtherIDjson, DataGeneratorVisit.generateVisitOtherID(10));
		jsonObjectVisit.put(globalVariables.SequenceIDjson,DataGeneratorVisit.generateSequenceID(10) );
		jsonObjectVisit.put(globalVariables.EmployeeIdentifier,DataGeneratorVisit.generateEmployeeIdentifier(10));
		jsonObjectVisit.put(globalVariables.ClientIdentifierjson,DataGeneratorVisit.generateClientIdentifier(10));
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, false);
		jsonObjectVisit.put(globalVariables.PayerIDjson, DataGeneratorVisit.generatePayerID(5));
		jsonObjectVisit.put(globalVariables.PayerProgramjson,DataGeneratorVisit.generatePayerProgram());
		jsonObjectVisit.put(globalVariables.ProcedureCodejson,DataGeneratorVisit.generateProcedureCode(10));
		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,DataGeneratorVisit.generateVisitTimeZone());
		jsonObjectVisit.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(7));
		jsonObjectVisit.put(globalVariables.CallAssignmentjson,DataGeneratorVisit.generateCallAssignment());
		jsonObjectVisit.put(globalVariables.CallTypejson, "Other");
		jsonObjectVisit.put(globalVariables.ProcedureCodejson,DataGeneratorVisit.generateProcedureCode(10));
		jsonObjectVisit.put(globalVariables.ClientIdentifierOnCalljson,CommonMethods.generateRandomNumberOfFixLength(7));
		jsonObjectVisit.put(globalVariables.MobileLoginjson, "N/A");
		jsonObjectVisit.put(globalVariables.CallLatitudejson,DataGeneratorVisit.generateCallLatitude());
		jsonObjectVisit.put(globalVariables.CallLongitudejson,DataGeneratorVisit.generateCallLongitude());
		jsonObjectVisit.put(globalVariables.Locationjson,CommonMethods.generateRandomNumberOfFixLength(3));
		jsonObjectVisit.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(5));
		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson,CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObjectVisit.put(globalVariables.ChangeMadeByjson,CommonMethods.getSaltString(5));
		jsonObjectVisit.put(globalVariables.ChangeDateTimejson,DataGeneratorVisit.generateAdjOutDateTime("MMddyyyy"));
		jsonObjectVisit.put(globalVariables.ChangeReasonMemojson,CommonMethods.getSaltString(5));


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
	
	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_Visitotherid() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_Visitotherid"); 

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_Visitotherid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitOtherIDjson, DataGeneratorVisit.generateVisitOtherID(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
	
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);


	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_SequenceIDjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_SequenceIDjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_SequenceIDjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.SequenceIDjson,DataGeneratorVisit.generateSequenceID(10) );
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ClientIdentifierjson,DataGeneratorVisit.generateClientIdentifier(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_EmployeeIdentifier() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_EmployeeIdentifier");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_EmployeeIdentifier"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.EmployeeIdentifier,DataGeneratorVisit.generateEmployeeIdentifier(10));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_VisitCancelledIndicatorjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_invalid");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_VisitCancelledIndicatorjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, false);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_PayerIDjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_PayerIDjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_PayerIDjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.PayerIDjson, DataGeneratorVisit.generatePayerID(5));
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_PayerProgramjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_PayerProgramjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_PayerProgramjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.PayerProgramjson,DataGeneratorVisit.generatePayerProgram());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ProcedureCodejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ProcedureCodejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ProcedureCodejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ProcedureCodejson,DataGeneratorVisit.generateProcedureCode(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));


		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_VisitTimeZonejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_VisitTimeZonejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_VisitTimeZonejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,DataGeneratorVisit.generateVisitTimeZone());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_CallExternalIDjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_CallExternalIDjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_CallExternalIDjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(7));
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));


		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_CallAssignmentjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_CallAssignmentjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_CallAssignmentjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallAssignmentjson,DataGeneratorVisit.generateCallAssignment());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
	
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);


	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_CallTypejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_CallTypejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_CallTypejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallTypejson, "Other");
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);


	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierOnCalljson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierOnCalljson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierOnCalljson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ClientIdentifierOnCalljson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);


	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_MobileLoginjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_MobileLoginjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_MobileLoginjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.MobileLoginjson, "N/A");
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_CallLatitudejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_CallLatitudejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_CallLatitudejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallLatitudejson,DataGeneratorVisit.generateCallLatitude());
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_CallLongitudejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_CallLongitudejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_CallLongitudejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallLongitudejson,DataGeneratorVisit.generateCallLongitude());
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_Locationjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_Locationjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_Locationjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.Locationjson,CommonMethods.generateRandomNumberOfFixLength(3));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_TelephonyPINjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_TelephonyPINjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_TelephonyPINjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(5));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_OriginatingPhoneNumberjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_OriginatingPhoneNumberjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_OriginatingPhoneNumberjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ChangeMadeByjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ChangeMadeByjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ChangeMadeByjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ChangeMadeByjson,CommonMethods.getSaltString(5));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ChangeDateTimejson() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ChangeDateTimejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ChangeDateTimejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ChangeDateTimejson,DataGeneratorVisit.generateAdjOutDateTime("MMddyyyy"));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ChangeReasonMemojson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ChangeReasonMemojson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ChangeReasonMemojson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ChangeReasonMemojson,CommonMethods.getSaltString(5));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}


}

