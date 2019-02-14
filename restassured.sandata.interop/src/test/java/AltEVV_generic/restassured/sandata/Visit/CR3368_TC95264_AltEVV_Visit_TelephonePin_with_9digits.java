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
// Test Case 95264:Inter-Op: Verify that TelephonyPin field is accepting values = 9 digits

public class CR3368_TC95264_AltEVV_Visit_TelephonePin_with_9digits extends BaseTest{

	//Case: Verify that TelephonyPin field is accepting values = 9 digits
	
	@Test
	public void TC95264_AltEVV_Visit_TelephonePin_with_9digits() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC95264_AltEVV_Visit_TelephonePin_with_9digits");  
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonePin_with_9digit_validlength"); 
	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson, CommonMethods.generateRandomNumberOfFixLength(9));

	JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges_call.put(globalVariables.TelephonyPINjson, CommonMethods.generateRandomNumberOfFixLength(9));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
	String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));
	Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
	Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges_call);
}
}
