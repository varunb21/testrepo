package AltEVV_molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC95301_AltEVV_Visit_CallDateTime extends BaseTest{

	@Test
	public void R2267_TC95301_Visit_CallDateTime_valid() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95301_Visit_CallDateTime_valid");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, DataGeneratorVisit.generateCallDateTime());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);	
}

	@Test
	public void R2267_TC95301_Visit_CallDateTime_optional() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95301_Visit_CallDateTime_optional");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, DataGeneratorVisit.generateCallDateTime());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase_400(bodyAsString, globalVariables.VisitDateError);

	}

	public void R2267_TC95301_Visit_CallDateTime_null() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95301_Visit_CallDateTime_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallDateTimeNullError);

	}

}