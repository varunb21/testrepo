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
import org.testng.Assert;
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
public class CR5002_TC97072_ALTEVV_Visit_with_clientverified_true extends BaseTest {
	
		@Test
		public void TC97072_ALTEVV_Visit_with_clientverified_true() throws FileNotFoundException, IOException, ParseException, SQLException
		{

			logger = extent.startTest("TC97072_ALTEVV_Visit_with_clientverified_true"); 
			logger.log(LogStatus.INFO, "Validating_Visit_with_clientverified_true"); 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put("ClientVerifiedService", "true");
			
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallTypejson, "OTHER");
	
			JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges1.put(globalVariables.CallTypejson, "OTHER");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));
			
			Assert.assertTrue(bodyAsStringGet.contains("\"messageSummary\": \"All records updated successfully.\""));
			
			Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);	
		}

}
