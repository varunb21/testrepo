/**
 * 
 */
package AltEVV_generic.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class R2267_TC91280_VisitCreation_CallDateTime_in_weekend_Holiday_LeapYear extends BaseTest{

	//Case1: Validating visit should be created successfully when CallDateTime passed with "weekend" in calendar days
	@Test
	public void R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_weekend_Holiday_LeapYear() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{


		logger = extent.startTest("R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_weekend_Holiday_LeapYear");  

		logger.log(LogStatus.INFO, "Validating VisitCreation_with_CallDateTime_falls_in_weekend_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisit.put(globalVariables.AdjInDateTime, "2018-10-03T19:02:26Z");
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2018-10-07T10:02:26Z");

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2018-10-07T22:02:20Z");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
		


	}

	//Case2: Validating visit should be created successfully when CallDateTime passed with "weekend-Saturday" in calendar days
	@Test
	public void R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_weekend_Saturday() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_weekend_Saturday");  

		logger.log(LogStatus.INFO, "Validating VisitCreation_with_CallDateTime_falls_in_weekend_Saturday_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2018-10-06T10:02:26Z");

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2018-10-06T22:02:20Z");


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
			}

	//Case3: Validating CallDateTime dates which fall under Holidays 
	@Test
	public void R2267_TC91280_AltEVV_VisitCreation_CallDateTime_with_Holidays() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC91280_AltEVV_VisitCreation_CallDateTime_with_Holidays");  

		logger.log(LogStatus.INFO, "Validating VisitCreation_CallDateTime_fall_under_Holidays_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2018-09-03T10:02:26Z");

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2018-09-03T22:02:20Z");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
			}

	//Case4: Validating CallDateTime dates which fall in leap year (Visit creation successful)

	@Test
	public void R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_leapYear() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		logger = extent.startTest("R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_leapYear");  

		logger.log(LogStatus.INFO, "Validating VisitCreation_CallDateTime_falls_in_leapYear"); 
	

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisit.put(globalVariables.AdjInDateTime, "2016-02-03T19:02:26Z");
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2016-02-29T10:02:26Z");

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2016-02-29T22:02:20Z");


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
			}

}
