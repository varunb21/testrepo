package AltEVV_generic.restassured.sandata.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- ChangeDateTime field formats/values

*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC94327_AltEVV_Visit_ChangeDateTime extends BaseTest{
	
	@Test
	public void R2267_TC94327_AltEVV_Visit_ChangeDateTime_validValue() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94327_AltEVV_Visit_ChangeDateTime_validValue");  
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson,CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T06:47:57Z");
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);
	
	}	
	
	@Test
	public void R2267_TC94327_AltEVV_Visit_ChangeDateTime_null() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94327_AltEVV_Visit_ChangeDateTime_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson,null);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ChangeDateTimeNullError);
		
	}
	
	@Test
	public void R2267_TC94327_AltEVV_Visit_ChangeDateTime_InvalidFormat() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC94327_AltEVV_Visit_ChangeDateTime_InvalidFormat");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson,CommonMethods.generateTodayDate_YYYY_MM_dd());
		
		@SuppressWarnings("unused")
		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

	}
}
