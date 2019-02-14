package AltEVV_generic.restassured.sandata.Visit;

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

public class R2267_TC95428_OpenEVV_altEVV_Validate_Visit_Changes_Positive_Values_Required_Fields extends BaseTest{
	
	
	@Test
	public void R2267_TC95428_OpenEVV_altEVV_Validate_Visit_Changes_Positive_Values_Required() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC95428_OpenEVV_altEVV_Validate_Visit_Changes_Positive_Values_Required_with_change_details");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson, CommonMethods.generateRandomStringOfFixLength(10));
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson, DataGeneratorVisit.generateCallDateTime());
		jsonObjectVisitChanges.put(globalVariables.ReasonCodejson, CommonMethods.generateRandomNumberOfFixLength(2));
		jsonObjectVisitChanges.put(globalVariables.ResolutionCodejson, CommonMethods.generateRandomStringOfFixLength(02));
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomNumberOfFixLength(14));
		jsonObjectVisitChanges.put(globalVariables.ChangeReasonMemojson, CommonMethods.generateRandomStringOfFixLength(10));
		jsonObjectVisitChanges.put(globalVariables.VisitGroupCode, CommonMethods.generateRandomStringOfFixLength(3));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		
		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);


	}

}
