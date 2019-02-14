package AltEVV_generic.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC95310_AltEVV_Visit_TelephonyPin extends BaseTest{

	@Test
	public void R2267_TC95310_Visit_TelephonyPin_valid_numeric_9() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95310_Visit_TelephonyPin_valid");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.TelephonyPinjson, CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.TelephonyPinjson, CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

		
	}

	public void R2267_TC95310_Visit_TelephonyPin_valid_numeric_between_4_9() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95310_Visit_TelephonyPin_valid_numeric_between_4_9");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.TelephonyPinjson, CommonMethods.generateRandomNumberOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);
	
		
	}

	public void R2267_TC95310_Visit_TelephonyPin_numeric_less_than_4() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95310_Visit_TelephonyPin_valid_numeric_less_than_4");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.TelephonyPinjson, CommonMethods.generateRandomNumberOfFixLength(2));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.TelephonyPinLengthError);
	
	}

	public void R2267_TC95310_Visit_TelephonyPin_blank() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95310_Visit_TelephonyPin_blank");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.TelephonyPinjson, "");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		
	CommonMethods.verifyjsonassertFailcase_400(bodyAsString, globalVariables.TelephonyPinFormatError);
	
	}

	@Test
	public void R2267_TC95310_Visit_TelephonyPin_null() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95310_Visit_TelephonyPin_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.TelephonyPinjson, null);

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.TelephonyPinjson, null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
	
	}

	public void R2267_TC95310_Visit_TelephonyPin_alphanumeric() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95310_Visit_TelephonyPin_alphanumeric");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.TelephonyPinjson, CommonMethods.generateRandomAlphaNumeric(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
	
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.TelephonyPinFormatError);
	
	}

}