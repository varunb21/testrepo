/**
 * 
 */
package AltEVV_generic.restassured.sandata.Visit;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import junit.framework.Assert;

/**
 * @author Neeraj
 *
 */
public class R2267_TC92340_Visit_WithoutCall_BillVisit_false extends BaseTest{
	
	//To validate Visit_AdjustOut_greater_than_CallIn_Otherwise_record_rejected
	
		@Test
		public void R2267_TC92340_Visit_WithoutCall_BillVisit_false() throws IOException, ParseException, SQLException
		{
			logger = extent.startTest("R2267_TC92340_Visit_WithoutCall_BillVisit_false");  
			 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.BillVisitjson,false);
			
			jsonObjectVisit.remove("Calls");
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			
			Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
	
			DataBaseVerifier_Visit.DataBaseVerification_Visits_Status(DataBaseVerifier_Visit.visitKey_visit);

			if(DataBaseVerifier_Visit.vistStatus.equalsIgnoreCase("OMIT"))	{
				Assert.fail("Status is Omit");
			}
				
		}
}
