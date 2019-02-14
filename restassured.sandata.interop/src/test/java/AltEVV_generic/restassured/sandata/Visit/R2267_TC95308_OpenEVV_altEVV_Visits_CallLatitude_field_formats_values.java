
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

public class R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values extends BaseTest  {
	
		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_90() throws FileNotFoundException, IOException, ParseException, SQLException{
			
			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_90");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, "-90");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, "-90");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges_call);


		}

		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_90() throws FileNotFoundException, IOException, ParseException, SQLException{

			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_90");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, "90");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, "90");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges_call);

		}

		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_plus() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_plus");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, "200");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, "200");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLatitudeMaxLengthError);


		}

		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_minus() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_minus");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, "-200");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, "-200");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
	


			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLatitudeMinLengthError);

		}

		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_null() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_null");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, null);

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, null);

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
	

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLatitudeNullError);

		}

		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_blank() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_blank");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, "");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, "");

			String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
	
		}

	}






