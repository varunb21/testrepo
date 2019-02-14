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
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

//CloseTest Case 95287:Inter-Op: Verify that MobileLogin field is accepting values <= 64

public class Bug72_TC95626_AltEVV_Visit_ProviderID_field_Maxlength_validation extends BaseTest{

	//Case1: Verify that MobileLogin field is accepting values = 64

	@Test
	public void TC95287_AltEVV_Visit_MobileLogin_field_Max_length_validation() throws IOException, ParseException, SQLException, java.text.ParseException
	{

		logger = extent.startTest("TC95287_AltEVV_Visit_MobileLogin_field_Max_length_validation");  
		logger.log(LogStatus.INFO, "TC95287_AltEVV_Visit_MobileLogin_field_Max_length_validation"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);


		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(64));

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.MobileLoginjson, jsonObjectVisitChanges.get(globalVariables.MobileLoginjson));


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		
		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

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
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(60));

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.MobileLoginjson, jsonObjectVisitChanges.get(globalVariables.MobileLoginjson));


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

	}


}
