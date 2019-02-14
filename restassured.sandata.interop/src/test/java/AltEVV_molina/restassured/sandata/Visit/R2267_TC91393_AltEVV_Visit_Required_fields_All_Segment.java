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
import com.globalMethods.core.*;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class R2267_TC91393_AltEVV_Visit_Required_fields_All_Segment extends BaseTest {

	//Case1:Visit-Load Json with required fields Only (All Segments), Record should be created
	@Test
	public void R2267_TC91393_AltEVV_VisitCreation_LoadJson_with_required_fields() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{
		logger = extent.startTest("R2267_TC91393_AltEVV_VisitCreation_LoadJson_with_required_fields");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("ClientID",jsonObjectVisit.get("ClientID").toString());
		jsonObjectVisit.put("EmployeeIdentifier",jsonObjectVisit.get("EmployeeSSN").toString());
		jsonObjectVisit.put("ClientOtherID",jsonObjectVisit.get("ClientOtherID").toString());
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObjectVisit.put(globalVariables.EmployeeIdentifier,CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObjectVisit.put(globalVariables.ClientIdentifier,CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObjectVisit.put(globalVariables.VisitOtherID,CommonMethods.generateRandomNumberOfFixLength(8));
		jsonObjectVisit.put(globalVariables.PayerID,CommonMethods.generateRandomNumberOfFixLength(8));  
		jsonObjectVisit.put(globalVariables.PayerProgram,CommonMethods.generateRandomStringOfFixLength(3)); 
		jsonObjectVisit.put(globalVariables.VisitOtherID,CommonMethods.generateRandomNumberOfFixLength(8));
		jsonObjectVisit.put(globalVariables.ProcedureCode,CommonMethods.generateRandomAlphaNumeric(5));
		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,"US/Eastern"); 
		jsonObjectVisit.put(globalVariables.ClientIdentifier,CommonMethods.generateRandomNumberOfFixLength(8));
		jsonObjectVisit.put(globalVariables.SequenceIDjson,DataGeneratorVisit.generateSequenceID(10));
		jsonObjectVisit.put("VisitCancelledIndicator","true");
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
		
		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);
	}
	
}
