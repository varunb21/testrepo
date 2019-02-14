package AltEVV_generic.restassured.sandata.Visit;

/*
@Neeraj

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

public class R2267_TC94316_AltEVV_Visit_ClientIdentifier extends BaseTest{
	
	@Test
	public void R2267_TC94316_AltEVV_ClientIdentifier_validValue() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94316_AltEVV_ClientIdentifier_validValue");  

		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitClientIdentifierjson,CommonMethods.generateRandomNumberOfFixLength(45));
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallTypejson, "OTHER");

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.CallTypejson, "OTHER");
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		
		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));
		
		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

	}
	
	@Test
	public void R2267_TC94316_AltEVV_ClientIdentifier_greaterThan_Max() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94316_AltEVV_ClientIdentifier_greaterThan_Max");  


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitClientIdentifierjson,CommonMethods.generateRandomNumberOfFixLength(81));
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorEmployeeIdentifierlength);
		
	}

	@Test
	public void R2267_TC94316_AltEVV_ClientIdentifier_AlphaNumeric() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94316_AltEVV_ClientIdentifier_AlphaNumeric");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitClientIdentifierjson,CommonMethods.generateRandomAlphaNumeric(7));
		
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

	}
	
	@Test
	public void R2267_TC94316_AltEVV_ClientIdentifier_NULL() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94316_AltEVV_ClientIdentifier_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitClientIdentifierjson, "NULL");
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorClientIdentifierNull);
		
	}
	
	@Test
	public void R2267_TC94316_AltEVV_ClientIdentifier_specialChar() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC94316_AltEVV_ClientIdentifier_specialChar");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		
		jsonObjectVisit.put(globalVariables.VisitClientIdentifierjson,CommonMethods.generateSpecialChar(5));
		
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorClientIdentifierFormat);
		
		
	}
}
