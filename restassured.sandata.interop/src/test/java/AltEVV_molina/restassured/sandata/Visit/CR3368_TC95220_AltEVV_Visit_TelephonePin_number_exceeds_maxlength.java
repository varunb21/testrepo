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
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
// Test Case 95220:Inter-Op: Verify that TelephonyPIN field is not accepting values with numbers (Max length +1)

public class CR3368_TC95220_AltEVV_Visit_TelephonePin_number_exceeds_maxlength extends BaseTest{

	//Case: Verify that TelephonyPIN field is not accepting values with numbers MAX LENGTH +1
	
	@Test
	public void TC95220_AltEVV_Visit_TelephonePin_number_exceeds_maxlength() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC95220_AltEVV_Visit_TelephonePin_number_exceeds_maxlength");  
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonePin_number_exceeds_maxlength"); 
	
	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	
	
	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson, CommonMethods.generateRandomNumberOfFixLength(10));
	JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges1.put(globalVariables.TelephonyPINjson, CommonMethods.generateRandomNumberOfFixLength(10));
	

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.TelephonyPINFormatError);

}
}
