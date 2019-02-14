/**
 * 
 */
package AltEVV_molina.restassured.sandata.Visit;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class R2267_TC91276_Visit_CallOut_greater_than_AdjustIn_Otherwise_record_rejected extends BaseTest{
	
	//To validate Visit_Call Out must be > Adj. In  Otherwise record rejected.
	
		@Test(groups = {"functest"})
		public void R2267_TC91276_AltEVV_VisitCreation_Rejected_AdjustIn_greater_than_CallOut() throws IOException, ParseException
		{
			logger = extent.startTest("R2267_TC91276_AltEVV_VisitCreation_Rejected_AdjustIn_greater_than_CallOut");  
			logger.log(LogStatus.INFO, "Validating_VisitCreation_Rejected_AdjustIn_greater_than_CallOut"); 

            JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			
			JSONArray jsonArrayVisit1 = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisit1 =  (JSONObject) jsonArrayVisit1.get(1);
			jsonObjectVisit1.put(globalVariables.CallDateTimejson, "2018-10-05T19:02:26Z");
		    
			jsonObjectVisit.put(globalVariables.AdjInDateTime, "2018-10-07T19:02:26Z");
		   
		  
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		   CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AdjInCallOutDateTime_Error);	
		}
}
