package AltEVV_molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC95302_AltEVV_Visit_CallAssignment extends BaseTest{

	@Test
	public void R2267_TC95302_Visit_CallAssignment_TimeIn_TimeOut() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95302_Visit_CallAssignment_TimeIn_TimeOut");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitChangesIn =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChangesIn.put(globalVariables.CallAssignmentjson, "Time In");

		JSONObject jsonObjectVisitChangesOut =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChangesOut.put(globalVariables.CallAssignmentjson, "Time Out");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChangesOut);	
		
	}

	@Test
	public void R2267_TC95302_Visit_CallAssignment_Other() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95302_Visit_CallAssignment_TimeIn_TimeOut");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitChangesOt =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChangesOt.put(globalVariables.CallAssignmentjson, "Other");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChangesOt);		
	}

	@Test
	public void R2267_TC95302_Visit_CallAssignment_invalid_format() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95302_Visit_CallAssignment_TimeIn_TimeOut");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitChangesOt =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChangesOt.put(globalVariables.CallAssignmentjson, CommonMethods.getSaltString(5));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallAssignmentError);
	}

	@Test
	public void R2267_TC95302_Visit_CallAssignment_invalid_length() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95302_Visit_CallAssignment_TimeIn_TimeOut");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitChangesOt =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChangesOt.put(globalVariables.CallAssignmentjson, CommonMethods.getSaltString(11));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallAssignmentError);
	}


}

