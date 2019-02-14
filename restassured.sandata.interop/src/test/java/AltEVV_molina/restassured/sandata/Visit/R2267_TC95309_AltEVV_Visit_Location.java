package AltEVV_molina.restassured.sandata.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- Location field formats/values

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

public class R2267_TC95309_AltEVV_Visit_Location extends BaseTest{

	@Test
	public void R2267_TC95309_AltEVV_Location_numeric() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC95309_AltEVV_Location_numeric");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.Locationjson,CommonMethods.generateRandomNumberOfFixLength(10));

		JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
	

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

	}

	@Test
	public void R2267_TC95309_AltEVV_Location_greaterThan_Max() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95309_Location_greaterThan_Max");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.Locationjson,CommonMethods.generateRandomNumberOfFixLength(26));

		JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
	

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

	}

	@Test
	public void R2267_TC95309_AltEVV_Location_AlphaNumeric() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC95309_Location_AlphaNumeric");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.Locationjson,CommonMethods.generateRandomAlphaNumeric(10));

		JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
	

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);


	}

	@Test
	public void R2267_TC95309_AltEVV_Location_null() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC95309_Location_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.Locationjson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.LocationNullError);

	}

	@Test
	public void R2267_TC95309_AltEVV_Location_specialChar() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95309_Location_specialChar");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.Locationjson,CommonMethods.generateRandomStringOfFixLength(10) + "'" + "." + "'");

		JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
	

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

	}

	@Test
	public void R2267_TC95309_AltEVV_Location_optional() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95309_AltEVV_Location_optional");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.Locationjson,"");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.LocationFormatError);


	}

	@Test
	public void R2267_TC95309_AltEVV_Location_letters() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC95309_AltEVV_Location_letters");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.Locationjson,CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
	

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

	}

}
