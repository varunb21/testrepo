/**
 * 
 */
package AltEVV_molina.restassured.sandata.Visit;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
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
	JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges1.put(globalVariables.TelephonyPINjson, jsonObjectVisitChanges.get(globalVariables.TelephonyPINjson));
	

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
	
	Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);
}
}
