package AltEVV_molina.restassured.sandata.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- VisitOtherID field formats/values

 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC95238_AltEVV_Visit_ScheduleEndTime extends BaseTest{

	@Test
	public void R2267_TC95238_Visit_ScheduleEndTime_valid() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95238_Visit_ScheduleEndTime_valid");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T06:47:57Z");
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,CommonMethods.generateFutureDate_YYYY_MM_dd()+ "T06:47:57Z");

		JSONArray jsonArrayVisitsch=(JSONArray) jsonObjectVisit.get("");
		JSONObject jsonObjectVisitsch = (JSONObject) jsonArrayVisitsch.get(0);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisitSchedule(bodyAsString, jsonObjectVisit, jsonObjectVisitsch);

	}

	@Test
	public void R2267_TC95238_Visit_ScheduleEndTime_null() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95238_Visit_ScheduleEndTime_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,null);


		JSONArray jsonArrayVisitsch=(JSONArray) jsonObjectVisit.get("");
		JSONObject jsonObjectVisitsch = (JSONObject) jsonArrayVisitsch.get(0);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisitSchedule(bodyAsString, jsonObjectVisit, jsonObjectVisitsch);

	}

	@Test
	public void R2267_TC95238_Visit_ScheduleEndTime_invalid() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95238_Visit_ScheduleEndTime_invalid");  

		Date date = new Date();
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,date);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,CommonMethods.generatePastDate_YYYY_MM_dd()+ "T06:47:57Z");

		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitDateError);

	}

	@Test
	public void R2267_TC95237_Visit_ScheduleEndTime_less_than_ScheduleStartTime() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95237_Visit_ScheduleStartTime_greater_than_ScheduleEndTime");  

		Date date = new Date();
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,date);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,CommonMethods.generateFutureDate_YYYY_MM_dd()+ "T06:47:57Z");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ScheduleEndTimeError);

	}


}
