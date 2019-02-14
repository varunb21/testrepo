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
public class R2267_TC91524_AltEVV_Visit_cancelled_without_call_association extends BaseTest{
	
	//To validate visit without employee, record is accepted but raises an exception.
	
		@Test(groups = {"functest"})
		public void R2267_TC91524_AltEVV_Visit_cancelled_without_call_association_invalid() throws IOException, ParseException
		{
			logger = extent.startTest("R2267_TC91524_AltEVV_Visit_cancelled_without_call_association_invalid");  
			logger.log(LogStatus.INFO, "Validating R2267_TC91524_AltEVV_Visit_cancelled_without_call_association_invalid"); 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.remove(globalVariables.EmployeeOtherID);
			jsonObjectVisit.remove(globalVariables.EmployeeIdentifier);
			jsonObjectVisit.remove(globalVariables.EmployeeQualifier);
			jsonObjectVisit.remove(globalVariables.CallInOutDateTime_Error);
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
			
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeDetails_Error);	
		}
}
