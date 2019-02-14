package AltEVV_generic.restassured.sandata.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- VisitOtherID field formats/values

 */

import java.io.FileNotFoundException;
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
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC95242_AltEVV_Visit_ClientVerifiedTasks extends BaseTest{

	@Test
	public void R2267_TC95242_Visit_ClientVerifiedTasks_true() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95242_Visit_ClientVerifiedTasks_true");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTasksjson,true);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
	}
	
	@Test
	public void R2267_TC95242_Visit_ClientVerifiedTasks_false() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95242_Visit_ClientVerifiedTasks_true");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTasksjson,false);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
	}

	@Test
	public void R2267_TC95242_Visit_ClientVerifiedTasks_optional() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95242_Visit_ClientVerifiedTasks_true");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTasksjson,"");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedTasksError);


	}
	
	@Test
	public void R2267_TC95242_Visit_ClientVerifiedTasks_numeric() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95242_Visit_ClientVerifiedTasks_true");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTasksjson, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedTasksError);
	}
	
	@Test
	public void R2267_TC95242_Visit_ClientVerifiedTasks_invalid_length() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95242_Visit_ClientVerifiedTasks_true");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTasksjson, CommonMethods.getSaltString(6));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedTasksError);
	}
	@Test
	public void R2267_TC95242_Visit_ClientVerifiedTasks_null() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95242_Visit_ClientVerifiedTasks_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTasksjson, "NULL");
		

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedTasksError);
	}

}
