package AltEVV_molina.restassured.sandata.Employee;

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

		logger.log(LogStatus.INFO, "// validate the Staff Intake JSON with exceeding max values"); 

		JSONArray jsonArray = CommonMethods.LoadJSON_AltEVV("Staff_intake_exceeding_max");

		logger.log(LogStatus.INFO, "request body generated is " +jsonArray.toJSONString()); 

		String resp = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_emp"));

		logger.log(LogStatus.INFO, "response body extracted is " +resp.toString()); 

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(resp.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(resp.contains("ERROR: The ProviderID value exceeds the maximum length of 50 characters."));
		Assert.assertTrue(resp.contains("ERROR: The EmployeeIdentifier value exceeds the maximum length of 9 characters."));
		Assert.assertTrue(resp.contains("ERROR: The EmployeeSSN value is incorrect.  It must be 9 digits."));
		Assert.assertTrue(resp.contains("ERROR: The EmployeeOtherID value is greater than 64 characters."));
		Assert.assertTrue(resp.contains("ERROR: The SequenceID value exceeds the maximum length of 50 characters."));
		Assert.assertTrue(resp.contains("The EmployeeLastName the length should be between 1 and 30."));
		Assert.assertTrue(resp.contains("The EmployeeEmail value exceeds the maximum length of 64 characters."));
		Assert.assertTrue(resp.contains("The EmployeeManagerEmail value exceeds the maximum length of 64 characters."));
		Assert.assertTrue(resp.contains("The EmployeeFirstName the length should be between 1 and 30."));
		Assert.assertTrue(resp.contains("The EmployeeAPI value exceeds the maximum length of 25 characters."));
		Assert.assertTrue(resp.contains("ERROR: The ProviderID value exceeds the maximum length of 50 characters."));
		Assert.assertTrue(resp.contains("ERROR: The ProviderID value exceeds the maximum length of 50 characters."));

		logger.log(LogStatus.INFO, "DB Validated");
	}


}