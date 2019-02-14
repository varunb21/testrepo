package AltEVV_generic.restassured.sandata.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- ProcedureCode field formats/values

*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC94326_AltEVV_Visit_ChangeMadeBy extends BaseTest{
	
	@Test
	public void R2267_TC94326_AltEVV_Visit_ChangeMadeBy_validValue() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_validValue");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,CommonMethods.generateEmailAddress_string(10));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

	
	}
	
	@Test
	public void R2267_TC94326_AltEVV_Visit_ChangeMadeBy_greaterThan_Max() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_greaterThan_Max");  
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,CommonMethods.generateRandomAlphaNumeric(66));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorChangedMadeby);
		
	}

	@Test
	public void R2267_TC94326_AltEVV_Visit_ChangeMadeBy_validvalue() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_validvalue");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson, CommonMethods.generateEmailAddress_string(20));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
		
		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);
	
		
	}
	
	@Test
	public void R2267_TC94326_AltEVV_Visit_ChangeMadeBy_null() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,null);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorChangeMadeByNull);
		
	}
	
	@Test
	public void R2267_TC94326_AltEVV_Visit_ChangeMadeBy_specialChar() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_specialChar");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,"Null");
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
		
		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

		
	}
}
