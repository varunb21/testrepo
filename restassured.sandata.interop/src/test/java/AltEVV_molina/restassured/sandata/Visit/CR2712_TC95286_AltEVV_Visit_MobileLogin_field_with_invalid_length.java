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

//Test Case 95286:Inter-Op: Verify that MobileLogin field is not accepting values > 64

public class CR2712_TC95286_AltEVV_Visit_MobileLogin_field_with_invalid_length extends BaseTest{

	//Case: Verify that MobileLogin field is not accepting values > 64
	
	@Test
	public void TC95286_AltEVV_Visit_MobileLogin_field_with_invalid_length() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC95286_AltEVV_Visit_MobileLogin_field_with_invalid_length");  
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_MobileLogin_with_invalid_length"); 
	
	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	
	
	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(65));
	
	JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges1.put(globalVariables.MobileLoginjson, jsonObjectVisitChanges.get(globalVariables.MobileLoginjson));
	

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.MobileLoginFormatError);
	
}

}
