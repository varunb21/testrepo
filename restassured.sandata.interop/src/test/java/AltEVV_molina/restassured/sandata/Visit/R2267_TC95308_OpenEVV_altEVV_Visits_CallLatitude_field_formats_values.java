
package AltEVV_molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

/*Ravi Ranjan*/

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values extends BaseTest  {
	
		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_90() throws FileNotFoundException, IOException, ParseException, SQLException{
			
			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_90");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.CallLatitudejson,"-90");

			JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
			JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
		

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
	
			Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);


		}

		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_90() throws FileNotFoundException, IOException, ParseException, SQLException{

			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_90");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.CallLatitudejson,"+90");

			JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
			JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
		

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
	
			Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

		}

		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_plus() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_plus");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.CallLatitudejson,"+200");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLongitudeNullError);


		}

		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_minus() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_minus");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.CallLatitudejson,"-100");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLongitudeNullError);

		}

		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_null() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_null");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.CallLatitudejson,null);

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLongitudeNullError);

		}

		@Test
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_blank() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_blank");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.CallLatitudejson,"");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLongitudeNullError);

		}

	}






