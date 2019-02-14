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
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
// Test Case 95222:Inter-Op: Verify that TelephonyPIN field accepting values "0"

public class CR3368_TC95222_AltEVV_Visit_TelephonePin_accepting_0 extends BaseTest{

	//Case: Verify that TelephonyPIN field accepting values "0"
	
	@Test
	public void TC95222_AltEVV_Visit_TelephonePin_accepting_0() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC95222_AltEVV_Visit_TelephonePin_accepting_0");  
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonePin_accepting_0"); 
	
	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	
	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson, 0000);
	JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges1.put(globalVariables.TelephonyPINjson, jsonObjectVisitChanges.get(globalVariables.TelephonyPINjson));
	

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
	
	Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

	
}
}
