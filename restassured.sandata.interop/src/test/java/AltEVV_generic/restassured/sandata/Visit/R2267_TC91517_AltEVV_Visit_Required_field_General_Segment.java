package AltEVV_generic.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91517_AltEVV_Visit_Required_field_General_Segment extends BaseTest{

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid"); 

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
		
		jsonObjectVisit.put(globalVariables.VisitOtherID, CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_SequenceIDjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_SequenceIDjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_SequenceIDjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.SequenceIDjson,DataGeneratorVisit.generateSequenceID(10));
		String SequenceID=jsonObjectVisit.get(globalVariables.SequenceIDjson).toString();
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, SequenceID);	
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ClientIdentifierjson,DataGeneratorVisit.generateClientIdentifier(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_EmployeeIdentifier() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_EmployeeIdentifier");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_EmployeeIdentifier"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.EmployeeIdentifier,DataGeneratorVisit.generateEmployeeIdentifier(10));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorEmployeeIdentifierFormat);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_VisitCancelledIndicatorjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_invalid");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_VisitCancelledIndicatorjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, false);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));
		
		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_PayerIDjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_PayerIDjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_PayerIDjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.PayerIDjson, DataGeneratorVisit.generatePayerID(5));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		
		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_PayerProgramjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_PayerProgramjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_PayerProgramjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.PayerProgramjson,DataGeneratorVisit.generatePayerProgram());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		
		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ProcedureCodejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ProcedureCodejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ProcedureCodejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.ProcedureCodejson,DataGeneratorVisit.generateProcedureCode(5));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.ProcedureCodejson,DataGeneratorVisit.generateProcedureCode(5));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
	
	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_VisitTimeZonejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_VisitTimeZonejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_VisitTimeZonejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,DataGeneratorVisit.generateVisitTimeZone());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_CallExternalIDjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_CallExternalIDjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_CallExternalIDjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(7));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_CallAssignmentjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_CallAssignmentjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_CallAssignmentjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.CallAssignmentjson,DataGeneratorVisit.generateCallAssignment());

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.CallAssignmentjson,DataGeneratorVisit.generateCallAssignment());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
		
	

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_CallTypejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_CallTypejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_CallTypejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.CallTypejson, "OTHER");

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.CallTypejson, "OTHER");
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);


	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierOnCalljson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierOnCalljson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ClientIdentifierOnCalljson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.ClientIdentifierOnCalljson, null);

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.ClientIdentifierOnCalljson, null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIdentifierOnCallNullError);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_MobileLoginjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_MobileLoginjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_MobileLoginjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(7));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(8));
			
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));
		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_CallLatitudejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_CallLatitudejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_CallLatitudejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.CallLatitudejson, DataGeneratorVisit.generateCallLatitude());

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.CallLatitudejson, DataGeneratorVisit.generateCallLatitude());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_CallLongitudejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_CallLongitudejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_CallLongitudejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.CallLongitudejson,DataGeneratorVisit.generateCallLongitude());

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.CallLongitudejson,DataGeneratorVisit.generateCallLongitude());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
	
	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_Locationjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_Locationjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_Locationjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.Locationjson,CommonMethods.generateRandomNumberOfFixLength(3));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.Locationjson,CommonMethods.generateRandomNumberOfFixLength(3));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));
		
		
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_TelephonyPINjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_TelephonyPINjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_TelephonyPINjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(5));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
		

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_OriginatingPhoneNumberjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_OriginatingPhoneNumberjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_OriginatingPhoneNumberjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomNumberOfFixLength(10));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson,CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
		

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ChangeMadeByjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ChangeMadeByjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ChangeMadeByjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.ChangeMadeByjson,CommonMethods.getSaltString(5));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.ChangeMadeByjson,CommonMethods.getSaltString(5));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
	

	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ChangeDateTimejson() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ChangeDateTimejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ChangeDateTimejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson, "2018-12-07T19:02:26Z");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
	
	}

	@Test
	public void R2267_TC91517_AltEVV_with_required_field_valid_ChangeReasonMemojson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91517_AltEVV_with_required_field_valid_ChangeReasonMemojson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91517_AltEVV_with_required_field_valid_ChangeReasonMemojson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

	
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeReasonMemojson, CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
		


	}


}

