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

public class R2267_TC95428_OpenEVV_altEVV_Validate_Visit_Changes_Positive_Values_Required_Fields extends BaseTest{
	
	
	@Test
	public void R2267_TC95428_OpenEVV_altEVV_Validate_Visit_Changes_Positive_Values_Required() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC95428_OpenEVV_altEVV_Validate_Visit_Changes_Positive_Values_Required_with_change_details");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ChangeDateTimejson,DataGeneratorVisit.generateCallDateTime());
		jsonObjectVisit.put(globalVariables.ChangeMadeByjson,CommonMethods.generateRandomStringOfFixLength(10));
		jsonObjectVisit.put(globalVariables.ChangeReasonMemojson,CommonMethods.generateRandomStringOfFixLength(20));
		jsonObjectVisit.put(globalVariables.ReasonCodejson,CommonMethods.generateRandomNumberOfFixLength(2));

		JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
	

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);


	}

}
