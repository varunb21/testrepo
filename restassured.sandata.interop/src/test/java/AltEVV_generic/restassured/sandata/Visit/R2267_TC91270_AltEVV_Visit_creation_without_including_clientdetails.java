/**
 * 
 */
package AltEVV_generic.restassured.sandata.Visit;

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
public class R2267_TC91270_AltEVV_Visit_creation_without_including_clientdetails extends BaseTest{
	
//	Case1: To validate if visit doesn't include ClientQualifier complete visit will be rejected
	
		@Test(groups = {"functest"})
		public void R2267_TC91270_AltEVV_VisitCreation_Rejected_without_ClientQualifier() throws IOException, ParseException
		{
			logger = extent.startTest("R2267_TC91270_AltEVV_VisitCreation_Rejected_without_ClientQualifier");  
			logger.log(LogStatus.INFO, "Validating_VisitCreation_Rejected_without_ClientQualifier"); 
			
			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.remove(globalVariables.ClientIDQualifier);

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierError);
			
			
					
		}
		
//	Case2: To validate if visit doesn't include ClientID complete visit will be rejected
		
			@Test(groups = {"functest"})
		public void R2267_TC91270_AltEVV_VisitCreation_Rejected_without_ClientID() throws IOException, ParseException
			{
				logger = extent.startTest("R2267_TC91270_AltEVV_VisitCreation_Rejected_without_ClientID");  
				logger.log(LogStatus.INFO, "Validating_VisitCreation_Rejected_without_ClientID"); 

				JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
				JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

				jsonObjectVisit.remove(globalVariables.ClientID);

				String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));

				CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientID_Error);
						
			}
				

}
