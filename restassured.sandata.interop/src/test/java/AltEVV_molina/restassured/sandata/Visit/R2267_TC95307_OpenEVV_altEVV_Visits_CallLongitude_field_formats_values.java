

package AltEVV_molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;

/*Ravi Ranjan*/

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_values extends BaseTest {
	

		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_max_minus() throws FileNotFoundException, IOException, ParseException, SQLException{
			
			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_max_minus");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.CallLongitudejson,"-180");
			
			JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
			JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
		
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
			Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);		
		
		
		}

		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_max_plus() throws FileNotFoundException, IOException, ParseException, SQLException{

			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_max_plus");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.CallLongitudejson,"+180");
			
			JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
			JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
		
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
			Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);		
		}

		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_blank() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_blank");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.CallLongitudejson,"");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeMinError11);


		}

		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_null() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_null");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.CallLongitudejson,null);

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeNull11);

		}

		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_space() throws FileNotFoundException, IOException, ParseException, SQLException{

			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_space");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.CallLongitudejson," ");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeNull11);


		}
		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_morethanmax() throws FileNotFoundException, IOException, ParseException, SQLException{

			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_morethanmax");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.CallLongitudejson,"+200 ");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeMaxError11);
		}
		
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_lessthanmin() throws FileNotFoundException, IOException, ParseException, SQLException{

			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_lessthanmin");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.CallLongitudejson,"-200 ");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeMinError11);
		}
		

	}



