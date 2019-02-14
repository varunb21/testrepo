package AltEVV_generic.restassured.sandata.Visit;

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
import io.restassured.path.json.JsonPath;

/*ravi ranjan*/

public class Bug_90166_TC90429_Alt_EVV_Visits_Validate_Response_incase_of_Worker_Not_Found extends BaseTest{

	// Case1:	To validate if visit doesn't include EmployeeIdentifier complete visit will be rejected
	@Test(groups = {"functest"})
	public void TC90429_Alt_EVV_Visits_Validate_Response_incase_of_Worker_Not_Found() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC90429_Alt_EVV_Visits_Validate_Response_incase_of_Worker_Not_Found");  
		logger.log(LogStatus.INFO, "Validating_VisitCreation_has error worker not found"); 

		JSONArray jsonArray = GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.VisitEmployeeIdentifier, "987653210");
		jsonObject.put(globalVariables.employeequalifier, "EmployeeSSN"); 
		jsonObject.put(globalVariables.VisitEmployeeOtherID, "98765430"); 

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_visit"));

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));

		CommonMethods.Assert_Visit_FailCase(bodyAsStringGet, "Worker not found");
	}
}
