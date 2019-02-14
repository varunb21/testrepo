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
public class R2267_TC91270_AltEVV_Visit_creation_without_including_clientdetails extends BaseTest{
	
//	Case1: To validate if visit doesn't include ClientQualifier complete visit will be rejected
	
		@Test(groups = {"functest"})
		public void R2267_TC91270_AltEVV_VisitCreation_Rejected_without_ClientQualifier() throws IOException, ParseException
		{
			logger = extent.startTest("R2267_TC91270_AltEVV_VisitCreation_Rejected_without_ClientQualifier");  
			logger.log(LogStatus.INFO, "Validating_VisitCreation_Rejected_without_ClientQualifier"); 

			
			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			//jsonObjectVisit.put(globalVariables.VisitOtherIDjson,CommonMethods.generateRandomNumberOfFixLength(50));
			jsonObjectVisit.put(globalVariables.ClientQualifier, null);
		 //   jsonObject.put(globalVariables.ClientQualifier, null);
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

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
				jsonObjectVisit.put(globalVariables.ClientID, null);
				
				JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.visit_intake_json);
				JSONObject jsonObject = (JSONObject) jsonArray.get(0);

			   jsonObject.put(globalVariables.ClientID, null);
				

				String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

				CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientID_Error);
						
			}
				
//  Case3: To validate if visit doesn't include ClientIdentifier complete visit will be rejected
				
				@Test(groups = {"functest"})
		public void R2267_TC91270_AltEVV_VisitCreation_Rejected_without_ClientIdentifier() throws IOException, ParseException
				{
					logger = extent.startTest("R2267_TC91270_AltEVV_VisitCreation_Rejected_without_ClientIdentifier");  
					logger.log(LogStatus.INFO, "Validating_VisitCreation_Rejected_without_ClientIdentifier"); 

					
					JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
					JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
				
					jsonObjectVisit.put(globalVariables.ClientIdentifier, null);
					jsonObjectVisit.put(globalVariables.ClientOtherID, null);
					

					String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

				    CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIdentifierQualifier_Error);
							
				}
}
