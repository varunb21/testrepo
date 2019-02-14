package AltEVV_molina.restassured.sandata.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- SequenceID field formats/values

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

public class R2267_TC94311_AltEVV_VisitSequenceID extends BaseTest{
	
	@Test
	public void R2267_TC94311_AltEVV_VisitSequenceID_validValue() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94311_AltEVV_VisitSequenceID_validValue");  

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(50);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceid);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
	
		
	}
	
	@Test
	public void RR2267_TC94311_AltEVV_VisitSequenceID_greaterThan_Max() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("RR2267_TC94311_AltEVV_VisitSequenceID_greaterThan_Max");  

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(51);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceid);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
			
	}

	@Test
	public void R2267_TC94311_AltEVV_VisitSequenceID_AlphaNumeric() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94311_AltEVV_VisitSequenceID_AlphaNumeric");  
		String sequenceid=CommonMethods.generateRandomAlphaNumeric(23);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceid);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		
		
	}
	
	@Test
	public void R2267_TC94311_AltEVV_VisitSequenceID_null() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94311_AltEVV_VisitSequenceID_null");  
		String sequenceid=null;
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceid);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorSequenceIdNull);
	
	}
	
	@Test
	public void R2267_TC94311_AltEVV_VisitSequenceID_specialChar() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC94311_AltEVV_VisitSequenceID_specialChars");  
		String sequenceid=CommonMethods.generateSpecialChar(5);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceid);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		
	
		
		
	}
}