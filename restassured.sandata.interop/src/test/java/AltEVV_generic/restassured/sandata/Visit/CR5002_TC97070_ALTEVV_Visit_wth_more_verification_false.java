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
public class CR5002_TC97070_ALTEVV_Visit_wth_more_verification_false extends BaseTest {
	
		@Test
		public void TC97070_ALTEVV_Create_visit_verification_false() throws FileNotFoundException, IOException, ParseException, SQLException
		{

			logger = extent.startTest("TC97070_ALTEVV_Create_visit_verification_false"); 
			logger.log(LogStatus.INFO, "Validating_visit_withmore than 1 verfification false"); 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put("ClientVerifiedService", "false");
			jsonObjectVisit.put("ClientVerifiedTasks","false");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));
			
			Assertion_DbVerifier.jsonAssert_inboxVisit_altevv(bodyAsStringGet, jsonObjectVisit);
		}

}
