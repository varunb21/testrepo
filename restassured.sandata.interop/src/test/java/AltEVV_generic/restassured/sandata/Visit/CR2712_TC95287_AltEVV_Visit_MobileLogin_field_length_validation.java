/**
 * 
 */
package AltEVV_generic.restassured.sandata.Visit;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

//CloseTest Case 95287:Inter-Op: Verify that MobileLogin field is accepting values <= 64

public class CR2712_TC95287_AltEVV_Visit_MobileLogin_field_length_validation extends BaseTest{

	//Case1: Verify that MobileLogin field is accepting values = 64
	
	@Test
	public void TC95287_AltEVV_Visit_MobileLogin_field_Max_length_validation() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC95287_AltEVV_Visit_MobileLogin_field_Max_length_validation");  
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_MobileLogin_with_Max_valid_length"); 
	
	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

	JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
	jsonObjectVisitCalls.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(64));

	JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
	jsonObjectVisitCalls1.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(64));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

	String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

	
	Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls);
	Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitCalls1);

}
	//Case2: Verify that MobileLogin field is accepting values < 64
	
		@Test
	public void TC95287_AltEVV_Visit_MobileLogin_field_length_validation() throws IOException, ParseException, SQLException
		{
		
		logger = extent.startTest("TC95287_AltEVV_Visit_MobileLogin_field_length_validation");  
		logger.log(LogStatus.INFO, "Validating_Visit_Creation_MobileLogin_with_valid_length"); 
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
	
	
}
