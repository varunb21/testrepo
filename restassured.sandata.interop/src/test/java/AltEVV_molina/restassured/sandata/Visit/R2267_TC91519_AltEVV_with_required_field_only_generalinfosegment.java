package AltEVV_molina.restassured.sandata.Visit;

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

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitTimeZoneNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitCancelledIndicatorNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerProgramNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitOtherIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIdentifierNullError);


	}

	

}

