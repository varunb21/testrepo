package AltEVV_molina.restassured.sandata.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- PayorID field formats/values

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

public class R2267_TC94317_AltEVV_VisitCancelledIndicator extends BaseTest{
	
	@Test
	public void R2267_TC94317_AltEVV_VisitCancelledIndicator_validValue() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94317_AltEVV_VisitCancelledIndicator_validValue");  

		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,true);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
	
	}
	
	@Test
	public void R2267_TC94317_AltEVV_VisitCancelledIndicator_greaterThan_Max() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94317_AltEVV_VisitCancelledIndicator_greaterThan_Max");  


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,CommonMethods.generateRandomStringOfFixLength(6));
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIdLength);
		
	}

	@Test
	public void R2267_TC94317_AltEVV_VisitCancelledIndicator_AlphaNumeric() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94317_AltEVV_VisitCancelledIndicator_AlphaNumeric");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		
		
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,CommonMethods.generateRandomAlphaNumeric(3));
		
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}
	
	@Test
	public void R2267_TC94317_AltEVV_VisitCancelledIndicator_null() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94318_AltEVV_PayerID_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		
		
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,null);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIDNull);
		
	}
	
	@Test
	public void R2267_TC94317_AltEVV_VisitCancelledIndicator_specialChar() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC94317_AltEVV_VisitCancelledIndicator_specialChar");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,CommonMethods.generateSpecialChar(3));
		
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIDFormat);
		
		
	}
}
