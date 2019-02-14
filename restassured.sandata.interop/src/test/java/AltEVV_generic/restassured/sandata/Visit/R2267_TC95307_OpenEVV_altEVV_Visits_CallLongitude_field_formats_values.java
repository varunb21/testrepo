

package AltEVV_generic.restassured.sandata.Visit;

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
		
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, "-180");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, "-180");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges_call);

		}

		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_max_plus() throws FileNotFoundException, IOException, ParseException, SQLException{

			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_max_plus");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, "180");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, "180");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges_call);
	}

		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_blank() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_blank");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, "");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, "");

			String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			

		}

		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_null() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_null");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			;
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, null);

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson,null);

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeNullvisit);

		}

		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_space() throws FileNotFoundException, IOException, ParseException, SQLException{

			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_space");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, " ");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, " ");

			String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));



		}
		@Test
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_morethanmax() throws FileNotFoundException, IOException, ParseException, SQLException{

			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_morethanmax");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, "+200");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, "+200");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeMaxErrorLength);
		}
		
		public void R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_lessthanmin() throws FileNotFoundException, IOException, ParseException, SQLException{

			logger = extent.startTest("R2267_TC95307_OpenEVV_altEVV_Visits_CallLongitude_field_formats_lessthanmin");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, "-200");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, "-200");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeMinErrorLength);
		}
		

	}



