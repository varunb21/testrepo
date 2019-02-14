package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 91334:Open EVV - Employee - Validate EmployeeId if its given as 000000

public class TC91334_EmployeeID_00000 extends BaseTest {

	//To validate the Employee ID with zeros
	@Test
	public void TC91334_EmployeeID_00000_validation() throws IOException, ParseException
	{
		logger = extent.startTest("TC91334_EmployeeID_00000_validation"); 
		logger.log(LogStatus.INFO, "validating Employee ID with zeros"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeID", "00000");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpIDFormatError);
	}
}
