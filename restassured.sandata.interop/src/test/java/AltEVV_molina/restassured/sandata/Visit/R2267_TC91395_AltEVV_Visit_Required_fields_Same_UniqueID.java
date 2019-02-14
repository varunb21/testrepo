/**
 * 
 */
package AltEVV_molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

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
public class R2267_TC91395_AltEVV_Visit_Required_fields_Same_UniqueID extends BaseTest {

	// Case1: Should be able to Update all the required fields of a visit
	@Test
	public void R2267_TC91395_AltEVV_VisitCreation_LoadJson_with_required_fields() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC91395_AltEVV_VisitCreation_LoadJson_with_required_fields_of_visit");  
		logger.log(LogStatus.INFO, "Validating VisitCreation_LoadJson_with_required_fields_of_visit"); 
		
		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(9);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));
		jsonObjectVisit.put("PayerID",CommonMethods.generateRandomNumberOfFixLength(8));  
		jsonObjectVisit.put("PayerProgram","ODM"); 
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));
		jsonObjectVisit.put("ProcedureCode",CommonMethods.generateRandomAlphaNumeric(5));
		jsonObjectVisit.put("VisitTimeZone","US/Eastern"); 
	
		jsonObjectVisit.put("VisitCancelledIndicator","true");
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);	
		
	}
}
