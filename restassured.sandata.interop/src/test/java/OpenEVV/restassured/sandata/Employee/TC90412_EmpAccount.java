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

//Test Case 90412:Inter-op - Open EVV- Employee- Account field validation for any Random Value

public class TC90412_EmpAccount extends BaseTest {

	//To validate the random value for account
	@Test
	public void TC90412_EmpAccount_invalid() throws IOException, ParseException
	{
		logger = extent.startTest("TC90412_EmpAccount_invalid"); 
		logger.log(LogStatus.INFO, "validating the random value for account"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("Account", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpAccountFormatError);
	}

}	

