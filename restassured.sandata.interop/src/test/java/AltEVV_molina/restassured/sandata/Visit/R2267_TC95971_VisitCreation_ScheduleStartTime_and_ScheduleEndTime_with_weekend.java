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
public class R2267_TC95971_VisitCreation_ScheduleStartTime_and_ScheduleEndTime_with_weekend extends BaseTest{

	//Case1: Validating VisitCreation_with_ScheduleStartTime_and_ScheduleEndTime_passed_with_weekend_holidays_in_CalenderDays
	@Test
	public void R2267_TC95971_AltEVV_VisitCreation_ScheduleStartTime_and_ScheduleEndTime_with_weekends() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC95971_AltEVV_VisitCreation_ScheduleStartTime_and_ScheduleEndTime_with_weekends");  

		logger.log(LogStatus.INFO, "Validating R2267_TC95971_AltEVV_VisitCreation_ScheduleStartTime_and_ScheduleEndTime_with_weekends"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson, "2018-09-07T10:02:26Z");

		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson, "2018-09-07T22:02:20Z");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
	}

	//Case2: Validating ScheduleStartTime_and_ScheduleEndTime dates which fall under Holidays (ClientEligibilityDateBegin,ClientEligibilityDateEnd,ScheduleStartTime,ScheduleEndTime (EndTime),AdjInDateTime,AdjOutDateTime,ChangeDateTime(visit changes))
	@Test
	public void R2267_TC95971_AltEVV_VisitCreation_with_ScheduleStartTime_ScheduleEndTime_in_Holidays() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC95971_AltEVV_VisitCreation_with_ScheduleEndTime_Holidays_in_CalenderDays");  

		logger.log(LogStatus.INFO, "Validating VisitCreation_with_ScheduleStartTime_and_ScheduleEndTime_Holidays_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson, "2018-09-03T10:02:26Z");

		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson, "2018-09-03T22:02:20Z");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
	}

	//Case3: Validating ScheduleStartTime_and_ScheduleEndTime dates which fall in leap year (Visit creation successful) (ClientEligibilityDateBegin,ClientEligibilityDateEnd,ScheduleStartTime,ScheduleEndTime (EndTime),AdjInDateTime,AdjOutDateTime,ChangeDateTime(visit changes))
	@Test
	public void R2267_TC95971_AltEVV_VisitCreation_ScheduleStartTime_ScheduleEndTime_in_leap_year() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC95971_AltEVV_VisitCreation_ScheduleStartTime_ScheduleEndTime_in_leap_year");  

		logger.log(LogStatus.INFO, "Validating VisitCreation with ScheduleStartTime_and_ScheduleEndTime_in_leap_year_Calender"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson, "2016-02-29T10:02:26Z");

		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson, "2016-02-29T22:02:20Z");


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
	}

}
