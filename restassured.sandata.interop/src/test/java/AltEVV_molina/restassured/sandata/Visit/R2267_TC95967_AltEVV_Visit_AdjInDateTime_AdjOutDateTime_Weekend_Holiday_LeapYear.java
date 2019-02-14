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
public class R2267_TC95967_AltEVV_Visit_AdjInDateTime_AdjOutDateTime_Weekend_Holiday_LeapYear extends BaseTest{
	
	//Case1: Validating AdjInDateTime and AdjOutDateTime dates which fall under Weekends(Saturday/Sunday) (ClientEligibilityDateBegin,ClientEligibilityDateEnd,ScheduleStartTime,ScheduleEndTime (EndTime),AdjInDateTime,AdjOutDateTime,ChangeDateTime(visit changes))
	@Test
public void R2267_TC95967_AltEVV_VisitCreation_in_Weekends_in_CalenderDays() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{
	
	logger = extent.startTest("R2267_TC95967_AltEVV_VisitCreation_with_Weekends_in_CalenderDays");  

	logger.log(LogStatus.INFO, "Validating R2267_TC95967_AltEVV_VisitCreation_with_Weekends_in_CalenderDays"); 
	
	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	jsonObjectVisit.put(globalVariables.AdjInDateTime, "2018-10-07T10:02:26Z");
	//jsonObjectVisit.put(globalVariables.AdjInDateTime, DataGeneratorVisit.AdjInDateTime("YYYY-MM-DD")+ "T06:47:57Z");
	
	jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2018-10-07T22:02:20Z");
	
	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

	Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
	}
	
	//Case2: Validating AdjInDateTime and AdjOutDateTime dates which fall under Holidays (ClientEligibilityDateBegin,ClientEligibilityDateEnd,ScheduleStartTime,ScheduleEndTime (EndTime),AdjInDateTime,AdjOutDateTime,ChangeDateTime(visit changes))
		@Test
public void R2267_TC95967_AltEVV_VisitCreation_with_Holidays_in_CalenderDays() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{
		
		logger = extent.startTest("R2267_TC95967_AltEVV_VisitCreation_with_Holidays_in_CalenderDays");  

		logger.log(LogStatus.INFO, "Validating R2267_TC95967_AltEVV_VisitCreation_with_Holidays_in_CalenderDays"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.AdjInDateTime, "2018-09-03T10:02:26Z");
		
		jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2018-09-03T22:02:20Z");
		
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
	}

	//Case3: Validating AdjInDateTime and AdjOutDateTime dates which fall in leap year (Visit creation successful) (ClientEligibilityDateBegin,ClientEligibilityDateEnd,ScheduleStartTime,ScheduleEndTime (EndTime),AdjInDateTime,AdjOutDateTime,ChangeDateTime(visit changes))
				@Test
public void R2267_TC95967_AltEVV_VisitCreation_in_leap_year_Calender() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{
				
				logger = extent.startTest("R2267_TC95967_AltEVV_VisitCreation_in_leap_year_Calender");  

				logger.log(LogStatus.INFO, "Validating R2267_TC95967_AltEVV_VisitCreation_in_leap_year_Calender"); 
				
				JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
				JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
				jsonObjectVisit.put(globalVariables.AdjInDateTime, "2016-02-29T10:02:26Z");
				//jsonObjectVisit.put(globalVariables.AdjInDateTime, DataGeneratorVisit.AdjInDateTime("yyyy-MM-dd HH:mm:ss"));
				jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2016-02-29T22:02:20Z");
				//DataGeneratorVisit.AdjInDateTime("yyyy-MM-dd HH:mm:ss")
				
				String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

				Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
		}

}
