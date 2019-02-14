package AltEVV_generic.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91519_AltEVV_with_required_field_only_generalinfosegment extends BaseTest{

	@Test
	public void R2267_TC91519_AltEVV_with_required_field_only_generalinfosegment_invalid() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC91519_AltEVV_with_required_field_only_generalinfosegment_invalid");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91519_AltEVV_with_required_field_only_generalinfosegment_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitOtherIDjson, DataGeneratorVisit.generateVisitOtherID(10));
		jsonObjectVisit.put(globalVariables.SequenceIDjson,DataGeneratorVisit.generateSequenceID(10) );
		jsonObjectVisit.put(globalVariables.EmployeeIdentifier,DataGeneratorVisit.generateEmployeeIdentifier(10));
		jsonObjectVisit.put(globalVariables.ClientIdentifierjson,DataGeneratorVisit.generateClientIdentifier(10));
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, false);
		jsonObjectVisit.put(globalVariables.PayerIDjson, DataGeneratorVisit.generatePayerID(5));
		jsonObjectVisit.put(globalVariables.PayerProgramjson,DataGeneratorVisit.generatePayerProgram());
		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,DataGeneratorVisit.generateVisitTimeZone());
		
		
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.CallAssignmentjson, DataGeneratorVisit.generateCallAssignment());

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.CallAssignmentjson, DataGeneratorVisit.generateCallAssignment());
		
		jsonObjectVisitCalls.put(globalVariables.CallTypejson, "OTHER");
		jsonObjectVisitCalls1.put(globalVariables.CallTypejson, "OTHER");
		jsonObjectVisitCalls.put(globalVariables.ProcedureCodejson,DataGeneratorVisit.generateProcedureCode(10));
		jsonObjectVisitCalls1.put(globalVariables.ProcedureCodejson,DataGeneratorVisit.generateProcedureCode(10));
		jsonObjectVisitCalls.put(globalVariables.ClientIdentifierOnCalljson,CommonMethods.generateRandomNumberOfFixLength(7));
		jsonObjectVisitCalls1.put(globalVariables.ClientIdentifierOnCalljson,CommonMethods.generateRandomNumberOfFixLength(7));
		jsonObjectVisitCalls.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObjectVisitCalls1.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(10));
		
		jsonObjectVisitCalls.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(7));
		jsonObjectVisitCalls1.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(7));
		
		jsonObjectVisitCalls.put(globalVariables.CallLatitudejson,DataGeneratorVisit.generateCallLatitude());
		jsonObjectVisitCalls1.put(globalVariables.CallLatitudejson,DataGeneratorVisit.generateCallLatitude());
		jsonObjectVisitCalls.put(globalVariables.CallLongitudejson,DataGeneratorVisit.generateCallLongitude());
		jsonObjectVisitCalls1.put(globalVariables.CallLatitudejson,DataGeneratorVisit.generateCallLatitude());
		jsonObjectVisitCalls.put(globalVariables.Locationjson,CommonMethods.generateRandomNumberOfFixLength(3));
		jsonObjectVisitCalls1.put(globalVariables.CallLatitudejson,DataGeneratorVisit.generateCallLatitude());
		
		jsonObjectVisitCalls.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(5));
		jsonObjectVisitCalls1.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(5));
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson,CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson,CommonMethods.generateRandomNumberOfFixLength(10));
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson, CommonMethods.generateEmailAddress_string(8));
		
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObjectVisitChanges.put(globalVariables.ReasonCodejson, CommonMethods.generateEmailAddress_string(8));
		jsonObjectVisitChanges.put(globalVariables.VisitGroupCodejson, CommonMethods.generateRandomAlphaNumeric(5));
		
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson,CommonMethods.generateTodayDate_MMddyyyy());
		jsonObjectVisitChanges.put(globalVariables.ChangeReasonMemojson,CommonMethods.getSaltString(5));


		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

	/*	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitTimeZoneNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitCancelledIndicatorNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerProgramNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitOtherIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIdentifierNullError);  */


	}

	

}

