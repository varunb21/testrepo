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
// Test Case 95263:Inter-Op: Verify that TelephonyPin field is not accepting values less than 0 or in -

public class CR3368_TC95263_AltEVV_Visit_TelephonePin_less_than_0_or_negative extends BaseTest{

	//Case: Verify that TelephonyPin field is not accepting values less than 0 or in  -
	
	@Test
	public void TC95263_AltEVV_Visit_TelephonePin_with_invalidvalue() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC95263_AltEVV_Visit_TelephonePin_with_invalidvalue");  
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonePin_with_0_or_negativevalue"); 

	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson,"-"+CommonMethods.generateRandomNumberOfFixLength(4));

	JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges_call.put(globalVariables.TelephonyPINjson,"-"+ CommonMethods.generateRandomNumberOfFixLength(4));


	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
	
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.TelephonyPINNegativeError);

	
}
}
