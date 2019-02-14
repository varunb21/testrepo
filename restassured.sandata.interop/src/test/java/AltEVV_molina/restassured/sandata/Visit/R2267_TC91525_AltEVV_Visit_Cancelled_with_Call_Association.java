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
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_Association extends BaseTest{

	//To validate visit without employee, record is accepted but raises an exception.

	@Test(groups = {"functest"})
	public void R2267_TC91525_AltEVV_Visit_Cancelled_with_adj_time_Association_invalid() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_Association_invalid");  
		logger.log(LogStatus.INFO, "Validating R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_Association_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, true);

		jsonObjectVisit.put(globalVariables.AdjInDateTimejson, "");
		jsonObjectVisit.put(globalVariables.AdjOutDateTimejson, "");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "");	
	}

	@Test(groups = {"functest"})
	public void R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_invalid() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_invalid");  
		logger.log(LogStatus.INFO, "Validating R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, true);

		JSONArray jsonArrayVisitcall = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitCallin =  (JSONObject) jsonArrayVisitcall.get(0);
		jsonObjectVisitCallin.put(globalVariables.CallDateTimejson, "");

		JSONObject jsonObjectVisitCallout =  (JSONObject) jsonArrayVisitcall.get(1);
		jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, "");


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "");	
	}

	@Test(groups = {"functest"})
	public void R2267_TC91525_AltEVV_Visit_Cancelled_with_adj_time_Association_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_Association_invalid");  
		logger.log(LogStatus.INFO, "Validating R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_Association_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, false);

		jsonObjectVisit.put(globalVariables.AdjInDateTimejson, "1212");
		jsonObjectVisit.put(globalVariables.AdjOutDateTimejson, "12123434");
		
		JSONArray jsonArrayVisitcall = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitCallin =  (JSONObject) jsonArrayVisitcall.get(0);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitCallin);
	
	

	}

	@Test(groups = {"functest"})
	public void R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_invalid");  
		logger.log(LogStatus.INFO, "Validating R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, false);

		JSONArray jsonArrayVisitcall = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitCallin =  (JSONObject) jsonArrayVisitcall.get(0);
		jsonObjectVisitCallin.put(globalVariables.CallDateTimejson, "");

		JSONObject jsonObjectVisitCallout =  (JSONObject) jsonArrayVisitcall.get(1);
		jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, "");


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitCallin);
	
	}
}
