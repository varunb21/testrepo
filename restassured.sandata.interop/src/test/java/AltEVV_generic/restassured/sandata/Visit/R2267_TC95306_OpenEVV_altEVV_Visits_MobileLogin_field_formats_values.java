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

public class R2267_TC95306_OpenEVV_altEVV_Visits_MobileLogin_field_formats_values extends BaseTest {

	@Test
	public void R2267_TC95306_OpenEVV_altEVV_Visits_MobileLogin_field_formats_max() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC95306_OpenEVV_altEVV_Visits_MobileLogin_field_formats_max");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(64));

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(64));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges_call);

	

	}

	@Test
	public void R2267_TC95306_OpenEVV_altEVV_Visits_MobileLogin_field_formats_morethanmax() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95306_OpenEVV_altEVV_Visits_MobileLogin_field_formats_morethanmax");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(65));

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(65));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.MobileLoginNullError1);

	}

	@Test
	public void R2267_TC95306_OpenEVV_altEVV_Visits_MobileLogin_field_formats_blank() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC95306_OpenEVV_altEVV_Visits_MobileLogin_field_formats_blank");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, "");

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.MobileLoginjson,"");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.MobileLoginNullError1);


	}

	@Test
	public void R2267_TC95306_OpenEVV_altEVV_Visits_MobileLogin_field_formats_null() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC95306_OpenEVV_altEVV_Visits_MobileLogin_field_formats_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, null);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.MobileLoginjson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.MobileLoginNullError);

	}

	@Test
	public void R2267_TC95306_OpenEVV_altEVV_Visits_MobileLogin_field_formats_space() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95305_ClientIdentifierOnCall_specialChar");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, CommonMethods.generateSpecialChar(10));

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.MobileLoginjson,CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges_call);

	


	}


}
