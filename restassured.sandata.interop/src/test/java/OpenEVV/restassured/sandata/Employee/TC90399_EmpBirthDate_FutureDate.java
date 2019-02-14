/**
 * 
 */
package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 90399:Open EVV-Worker-Validate Employee creation with EmployeeBirthDate > Current Date

public class TC90399_EmpBirthDate_FutureDate extends BaseTest {

	//To validate the scenario with EmployeeBirthDate > Current Date
	@Test 
	public void TC90399_OpenEVV_EmpBirthDate_FutureDate() throws IOException, ParseException
	{
		logger = extent.startTest("TC90399_OpenEVV_EmpBirthDate_FutureDate"); 
		 
		logger.log(LogStatus.INFO, "To validate the scenario with EmployeeBirthDate > Current Date");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);

		js.put("EmployeeBirthDate",CommonMethods.generateFutureDate_YYYY_MM_dd());
		logger.log(LogStatus.INFO, "Passing EmployeeBirthDate as ");
        logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		js.put("EmployeeBirthDate",CommonMethods.generateFutureDate_YYYY_MM_dd());


		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

}
