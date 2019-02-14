package AltEVV_generic.restassured.sandata.Employee;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 93651: Alt EVV-Worker-Validate-Exceed Maximum Values > to be rejected

public class R2267_TC93651_AltEVV_Emp_ExceedingMaxValues extends BaseTest{

	//To validate the Staff Intake JSON with exceeding max values
	@Test
	public void R2267_TC93651_AltEVV_Employee_Exceeding_MaxValues() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC93651_AltEVV_Employee_Exceeding_MaxValues ");  


		JSONArray jsonArray = CommonMethods.LoadJSON_AltEVV("Staff_intake_exceeding_max");
		String resp = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_emp"));

		logger.log(LogStatus.INFO, "response body extracted is " +resp.toString()); 

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(resp.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(resp.contains("The EmployeeQualifier format is incorrect."));
		Assert.assertTrue(resp.contains("The EmployeeEmail value exceeds the maximum length of 64 characters."));
		Assert.assertTrue(resp.contains("The EmployeeManagerEmail value is incorrect."));
		Assert.assertTrue(resp.contains("The EmployeeAPI value exceeds the maximum length of 25 characters."));
		Assert.assertTrue(resp.contains("The EmployeePosition value is incorrect."));
		Assert.assertTrue(resp.contains("The EmployeeOtherID expected format is not correct."));
	}


}