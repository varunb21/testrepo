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
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
// Test Case 95228:Inter-Op: Verify that TelephonyPIN field is not accepting values with '.'

public class CR3368_TC95228_AltEVV_Visit_TelephonyPin_with_dot_invalid extends BaseTest{

	//Case: Verify that TelephonyPIN field is not accepting values with  '.'
	
	@Test
	public void SEVV3368_TC95228_AltEVV_Visit_TelephonyPin_with_dot_Invalid() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("SEVV3368_TC95228_AltEVV_Visit_TelephonyPin_with_dot_Invalid");  
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonyPin_with_dot_invalid"); 
	
	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(4)+"."+CommonMethods.generateRandomNumberOfFixLength(4));

	JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges_call.put(globalVariables.TelephonyPINjson, CommonMethods.generateRandomNumberOfFixLength(4)+"."+CommonMethods.generateRandomNumberOfFixLength(4));


	String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
	

	CommonMethods.verifyjsonassertFailcase_400(bodyAsString, globalVariables.TelephonyPINFormatError1);
	
}
}
