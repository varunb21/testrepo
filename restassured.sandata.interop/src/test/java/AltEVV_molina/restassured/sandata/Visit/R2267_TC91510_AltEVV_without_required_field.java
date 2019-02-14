package AltEVV_molina.restassured.sandata.Visit;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91510_AltEVV_without_required_field extends BaseTest{

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitOtherIDjson, null);
		jsonObjectVisit.put(globalVariables.SequenceIDjson, null);
		jsonObjectVisit.put(globalVariables.EmployeeIdentifier,null);
		jsonObjectVisit.put(globalVariables.ClientIdentifierjson,null);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,null);
		jsonObjectVisit.put(globalVariables.PayerIDjson,null);
		jsonObjectVisit.put(globalVariables.PayerProgramjson,null);
		jsonObjectVisit.put(globalVariables.ProcedureCodejson,null);
		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,null);
		jsonObjectVisit.put(globalVariables.CallExternalIDjson,null);
		jsonObjectVisit.put(globalVariables.CallAssignmentjson,null);
		jsonObjectVisit.put(globalVariables.CallTypejson,null);
		jsonObjectVisit.put(globalVariables.ProcedureCodejson,null);
		jsonObjectVisit.put(globalVariables.ClientIdentifierOnCalljson,null);
		jsonObjectVisit.put(globalVariables.MobileLoginjson,null);
		jsonObjectVisit.put(globalVariables.CallLatitudejson,null);
		jsonObjectVisit.put(globalVariables.CallLongitudejson,null);
		jsonObjectVisit.put(globalVariables.Locationjson,null);
		jsonObjectVisit.put(globalVariables.TelephonyPINjson,null);
		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson,null);
		jsonObjectVisit.put(globalVariables.ChangeMadeByjson,null);
		jsonObjectVisit.put(globalVariables.ChangeDateTimejson,null);
		jsonObjectVisit.put(globalVariables.ChangeReasonMemojson,null);


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitTimeZoneNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitCancelledIndicatorNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerProgramNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitOtherIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIdentifierNullError);


	}

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_Visitotherid() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_Visitotherid"); 
		
		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_Visitotherid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitOtherIDjson, null);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitOtherIDNullError);


	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_SequenceIDjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_SequenceIDjson");  
		
		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_SequenceIDjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.SequenceIDjson, null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDNullError);
	

	}

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_ClientIdentifierjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_ClientIdentifierjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_ClientIdentifierjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.ClientIdentifierjson,null);
		

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIdentifierNullError);
	

	}

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_EmployeeIdentifier() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_EmployeeIdentifier");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_EmployeeIdentifier"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.EmployeeIdentifier,null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIdentifierNullError);

	}

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_VisitCancelledIndicatorjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_VisitCancelledIndicatorjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitCancelledIndicatorNullError);
	

	}

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_PayerIDjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_PayerIDjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_PayerIDjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.PayerIDjson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDNullError);

	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_PayerProgramjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_PayerProgramjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_PayerProgramjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.PayerProgramjson,null);
	

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerProgramNullError);


	}

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_ProcedureCodejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_ProcedureCodejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_ProcedureCodejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ProcedureCodejson,null);
	

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProcedureCodeError);
		

	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_VisitTimeZonejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_VisitTimeZonejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_VisitTimeZonejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,null);
		

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitTimeZoneNullError);

	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_CallExternalIDjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_CallExternalIDjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_CallExternalIDjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallExternalIDjson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallExternalIDNullError);

	}

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_CallAssignmentjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_CallAssignmentjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_CallAssignmentjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallAssignmentjson,null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallAssignmentNullError);
	

	}

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_CallTypejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_CallTypejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_CallTypejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallTypejson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallTypeNullError);
	

	}

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_ClientIdentifierOnCalljson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_ClientIdentifierOnCalljson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_ClientIdentifierOnCalljson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ClientIdentifierOnCalljson,null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIdentifierOnCallNullError);
	

	}

	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_MobileLoginjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_MobileLoginjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_MobileLoginjson"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.MobileLoginjson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.MobileLoginNullError);
	
	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_CallLatitudejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_CallLatitudejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_CallLatitudejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallLatitudejson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLatitudeNullError);
	
	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_CallLongitudejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_CallLongitudejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_CallLongitudejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.CallLongitudejson,null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLongitudeNullError);
	
	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_Locationjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_Locationjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_Locationjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.Locationjson,null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.LocationNullError);
	
	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_TelephonyPINjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_TelephonyPINjson");  
		
		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_TelephonyPINjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.TelephonyPINjson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.TelephonyPINNullError);

	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_OriginatingPhoneNumberjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_OriginatingPhoneNumberjson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_OriginatingPhoneNumberjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson,null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberNullError);
	
	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_ChangeMadeByjson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_ChangeMadeByjson");  
	
		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_ChangeMadeByjson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ChangeMadeByjson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ChangeMadeByNullError);

	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_ChangeDateTimejson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_ChangeDateTimejson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_ChangeDateTimejson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ChangeDateTimejson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ChangeDateTimeNullError);

	}
	
	@Test
	public void R2267_TC91510_AltEVV_without_required_field_invalid_ChangeReasonMemojson() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid_ChangeReasonMemojson");  

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid_ChangeReasonMemojson"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.ChangeReasonMemojson,null);


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ChangeReasonMemoNullError);
	
	}
	

}

