/**
 * 
 */
package AltEVV_molina.restassured.sandata.Visit;

import java.io.IOException;

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

/**
 * @author Anupam
 *
 */
public class R2267_TC91279_Visit_Accepted_with_Exception_InvalidUnknown_Employee extends BaseTest{
	
	//To validate Invalid or Unknown Employee Provided, record is accepted but raises an exception.
	
		@Test(groups = {"functest"})
		public void R2267_TC91279_AltEVV_Visit_Accepted_with_Exception() throws IOException, ParseException
		{
			logger = extent.startTest("R2267_TC91279_AltEVV_Visit_Accepted_with_Exception");  
			logger.log(LogStatus.INFO, "Validating_VisitAccepted_with_Exception_Passing_InvalidUnknown_Employee_Provided"); 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.EmployeeOtherID, DataGeneratorVisit.generateClientOtherID(6));
			jsonObjectVisit.put(globalVariables.EmployeeIdentifier, DataGeneratorVisit.generateEmployeeIdentifier(9));
			jsonObjectVisit.put(globalVariables.SequenceIDjson,DataGeneratorVisit.generateSequenceID(10));
			jsonObjectVisit.put(globalVariables.VisitOtherID,DataGeneratorVisit.generateVisitOtherID(7));
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitOtherIdLength);	
		}
}
