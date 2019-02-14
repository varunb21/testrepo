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
public class R2267_TC91417_Visit_Validate_VisitExceptionID extends BaseTest {

	// Case1: Verify all exception ID in one visit
	@Test
	public void R2267_TC91417_Validate_VisitExceptionID() throws FileNotFoundException, IOException, ParseException, SQLException
	{

		logger = extent.startTest("R2267_TC91417_Validate_VisitExceptionID"); 
		logger.log(LogStatus.INFO, "Validating_VisitExceptionID"); 

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(16);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitException = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitException =  (JSONObject) jsonArrayVisitException.get(0);

		jsonObjectVisitException.put(globalVariables.ExceptionAcknowledgedjson, true);
		jsonObjectVisitException.put(globalVariables.ExceptionIDjson, CommonMethods.generateRandomNumberOfFixLength(2));


		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));


		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

	}
	// Case2: Validating exception ID with valid entry in one visit
	@Test
	public void R2267_TC91417_Validate_VisitExceptionID_valid() throws FileNotFoundException, IOException, ParseException, SQLException
	{

		logger = extent.startTest("R2267_TC91417_Validate_VisitExceptionID_valid"); 
		logger.log(LogStatus.INFO, "Validating_VisitExceptionID with valid value"); 

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(16);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitException = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitException =  (JSONObject) jsonArrayVisitException.get(0);

		jsonObjectVisitException.put(globalVariables.ExceptionAcknowledgedjson, true);
		jsonObjectVisitException.put(globalVariables.ExceptionIDjson, "15");

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);
	}

	// Case3: Validating exception ID with null
	@Test
	public void R2267_TC91417_Validate_VisitExceptionID_with_nullvalue() throws FileNotFoundException, IOException, ParseException, SQLException
	{

		logger = extent.startTest("R2267_TC91417_Validate_VisitExceptionID_with_nullvalue"); 
		logger.log(LogStatus.INFO, "Validating_VisitExceptionID_with_nullvalue"); 

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(16);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitException = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitException =  (JSONObject) jsonArrayVisitException.get(0);

		jsonObjectVisitException.put(globalVariables.ExceptionAcknowledgedjson, true);
		jsonObjectVisitException.put(globalVariables.ExceptionIDjson, null);


		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);
	}

	// Case4: Validating exception ID with "null"
	@Test
	public void R2267_TC91417_Validate_VisitExceptionID_with_null() throws FileNotFoundException, IOException, ParseException, SQLException
	{

		logger = extent.startTest("R2267_TC91417_Validate_VisitExceptionID_with_null"); 
		logger.log(LogStatus.INFO, "Validating_VisitExceptionID_with_null"); 

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(16);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitException = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitException =  (JSONObject) jsonArrayVisitException.get(0);

		jsonObjectVisitException.put(globalVariables.ExceptionAcknowledgedjson, true);
		jsonObjectVisitException.put(globalVariables.ExceptionIDjson, "null");


		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ExceptionIDError);

	}
}
