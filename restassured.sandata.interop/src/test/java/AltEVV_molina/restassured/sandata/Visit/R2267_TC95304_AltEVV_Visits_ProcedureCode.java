package AltEVV_molina.restassured.sandata.Visit;


/*
@RaviRanjan

OpenEVV_altEVV_Visits_ProcedureCode_field_formats_values

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


public class R2267_TC95304_AltEVV_Visits_ProcedureCode extends BaseTest {
	
	//validating valid procedure code
		@Test
		public void R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_valid() throws FileNotFoundException, IOException, ParseException, SQLException{
			
			logger = extent.startTest("R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_valid");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.ProcedureCodejson,"G0299");
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
			
			Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		}
		
		//validating procedure code null
		@Test
		public void R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_null() throws FileNotFoundException, IOException, ParseException, SQLException{
			
			logger = extent.startTest("R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_null");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.ProcedureCodejson,null);
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
			
					
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorProcedureCodeNull);
		
		
			

	}
		//validating procedure code less than min length
		@Test
		public void R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_invalid_lessthanminlenghth() throws FileNotFoundException, IOException, ParseException, SQLException{
			
			logger = extent.startTest("R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_lessthan_minimum_lenghth");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.ProcedureCodejson,"G");
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
			
					
		
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorProcedureCodeFormat);
		
		
			

	}
	
		//validating procedure code more than max length
		@Test
		public void R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_morethanmaxlenghth() throws FileNotFoundException, IOException, ParseException, SQLException{
			
			logger = extent.startTest("R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_morethan_max_lenghth");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.ProcedureCodejson,"G0000099988766");
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
			
					
		
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorProcedureCodeFormat);
		
		
			

	}
		
		//validating procedure code with blank values
		@Test
		public void R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_blank() throws FileNotFoundException, IOException, ParseException, SQLException{
			
			logger = extent.startTest("R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_with_blank");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.ProcedureCodejson," ");
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
			
					
		
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorProcedureCodeFormat);
		
		
			

	}
}



