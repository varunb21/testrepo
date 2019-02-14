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
public class R2267_TC91281_AltEVV_Visit_Rejected_without_Employee extends BaseTest{
	
	//To validate visit without employee, record is accepted but raises an exception.
	
		@Test(groups = {"functest"})
		public void R2267_TC91281_AltEVV_VisitCreation_without_Employee() throws IOException, ParseException
		{
			logger = extent.startTest("R2267_TC91281_AltEVV_VisitCreation_without_Employee");  
			logger.log(LogStatus.INFO, "Validating_VisitCreation_without_Employee"); 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.remove(globalVariables.EmployeeOtherID);
			jsonObjectVisit.remove(globalVariables.EmployeeIdentifier);
			jsonObjectVisit.remove(globalVariables.EmployeeQualifier);
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
			
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeDetails_Error);	
		}
}
