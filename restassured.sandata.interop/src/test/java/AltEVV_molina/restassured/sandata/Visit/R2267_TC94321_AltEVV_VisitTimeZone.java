package AltEVV_molina.restassured.sandata.Visit;

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
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC94321_AltEVV_VisitTimeZone extends BaseTest{
	
	@Test
	public void R2267_TC94321_AltEVV_VisitTimeZone_validValue() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94321_AltEVV_VisitTimeZone_validValue");  

		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.visitTimeZonejson,"US/Eastern");
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}
	
	@Test
	public void R2267_TC94321_AltEVV_VisitTimeZone_greaterThan_Max() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94321_AltEVV_VisitTimeZone_greaterThan_Max");  


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.visitTimeZonejson,CommonMethods.generateRandomAlphaNumeric(65));
		String bodyAsString = CommonMethods.captureResponseAltEVV_500(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		
	}

	@Test
	public void R2267_TC94321_AltEVV_VisitTimeZone_AlphaNumeric() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94321_AltEVV_VisitTimeZone_AlphaNumeric");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		
		
		jsonObjectVisit.put(globalVariables.visitTimeZonejson,CommonMethods.generateRandomAlphaNumeric(5));
		
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitTiemZoneFormat);
		
		
	}
	
	@Test
	public void R2267_TC94321_AltEVV_VisitTimeZone_null() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94321_AltEVV_VisitTimeZone_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		
		
		jsonObjectVisit.put(globalVariables.visitTimeZonejson,null);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitTimeZoneNull);
		
	}

}
