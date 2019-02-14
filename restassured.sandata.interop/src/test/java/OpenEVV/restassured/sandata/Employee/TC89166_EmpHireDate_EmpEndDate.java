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
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 89166:Open EVV - Employee - Validate Employee Creation in case of EmployeeEndDate older than EmployeeHireDate

public class TC89166_EmpHireDate_EmpEndDate extends BaseTest {

	//To validate the Emp hire date cannot be greater than EmployeeEndDate
	@Test(groups = {"functest"})
	public void TC89166_OpenEVV_invalid_EmpHireDate_greaterThan_EmpEndDate() throws IOException, ParseException
	{
		logger = extent.startTest("TC89166_OpenEVV_invalid_EmpHireDate_greaterThan_EmpEndDate"); 
		 
		logger.log(LogStatus.INFO, "To validate the Emp hire date cannot be greater than EmployeeEndDate");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeHireDate", DataGeneratorEmployee.generateEmpHireDate());
		js.put("EmployeeEndDate", "08222017");
		logger.log(LogStatus.INFO, "Passing EmployeeEndDate as 08222017");
  
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeHireDate cannot be greater than EmployeeEndDate."));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeEndDate cannot be less than EmployeeHireDate."));
	}

}


