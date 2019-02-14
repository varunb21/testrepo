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
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class R2267_TC91400_AltEVV_VisitCreation_LoadJson_with_Max_length extends BaseTest {

	// Case1: Visit Load json with all fields value=Maximum Length, Record should be created.
	@Test
	public void R2267_TC91400_AltEVV_VisitCreation_LoadJson_with_Maxlength() throws FileNotFoundException, IOException, ParseException, SQLException
	{

		logger = extent.startTest("R2267_TC91400_AltEVV_VisitCreation_LoadJson_with_Maxlength"); 
		logger.log(LogStatus.INFO, "Validating_VisitCreation_LoadJson_with_all_fields_with_Maxlength"); 

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(16);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(50));
		jsonObjectVisit.put("PayerID",CommonMethods.generateRandomNumberOfFixLength(65));
		jsonObjectVisit.put("EmployeeOtherID",CommonMethods.generateRandomNumberOfFixLength(64));
		jsonObjectVisit.put("EmployeeIdentifier",CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObjectVisit.put("GroupCode",CommonMethods.generateRandomStringOfFixLength(6));
		jsonObjectVisit.put("ClientOtherID",CommonMethods.generateRandomNumberOfFixLength(24));
		jsonObjectVisit.put("ClientIdentifier",CommonMethods.generateRandomNumberOfFixLength(63));
		jsonObjectVisit.put("PayerID",CommonMethods.generateRandomNumberOfFixLength(64));
		jsonObjectVisit.put("PayerProgram",CommonMethods.generateRandomAlphaNumeric(9));
		jsonObjectVisit.put("Modifier1",CommonMethods.generateRandomStringOfFixLength(2));
		jsonObjectVisit.put("Modifier2",CommonMethods.generateRandomStringOfFixLength(2));
		jsonObjectVisit.put("Modifier3",CommonMethods.generateRandomStringOfFixLength(2));
		jsonObjectVisit.put("Modifier4",CommonMethods.generateRandomStringOfFixLength(2));
		jsonObjectVisit.put("ProcedureCode",CommonMethods.generateRandomAlphaNumeric(5));
		jsonObjectVisit.put("Memo",CommonMethods.generateRandomStringOfFixLength(512));
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,true);
		jsonObjectVisit.put(globalVariables.visitTimeZonejson,"US/Eastern");
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T06:47:57Z");
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,CommonMethods.generateFutureDate_YYYY_MM_dd()+ "T06:47:57Z");
		jsonObjectVisit.put(globalVariables.AdjInDateTime, "2018-09-10T10:02:26Z");
		jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2018-09-22T22:02:20Z");
		jsonObjectVisit.put(globalVariables.HoursToBilljson, CommonMethods.getRandomDoubleBetweenRange(0, 9));
		jsonObjectVisit.put(globalVariables.HoursToPayjson, CommonMethods.getRandomDoubleBetweenRange(0, 9));
		jsonObjectVisit.put(globalVariables.BillVisitjson,true);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson,true);
		jsonObjectVisit.put(globalVariables.ClientVerifiedServicejson,true);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTasksjson,true);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson,true);
		jsonObjectVisit.put(globalVariables.ClientVoiceRecordingjson,true);

		JSONArray jsonArrayVisitException = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitException =  (JSONObject) jsonArrayVisitException.get(0);

		jsonObjectVisitException.put(globalVariables.ExceptionAcknowledgedjson, true);
		jsonObjectVisitException.put(globalVariables.ExceptionIDjson, "15");
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChangesIn =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChangesIn.put(globalVariables.CallAssignmentjson, "Time In");
		JSONObject jsonObjectVisitChangesOut =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChangesOut.put(globalVariables.CallAssignmentjson, "Time Out");
		//JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, DataGeneratorVisit.generateCallDateTime());
		jsonObjectVisit.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(16));
		jsonObjectVisit.put(globalVariables.ClientIdentifierOnCalljson,CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObjectVisitChanges.put(globalVariables.CallTypejson, "Mobile");
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitException(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

	}
}
