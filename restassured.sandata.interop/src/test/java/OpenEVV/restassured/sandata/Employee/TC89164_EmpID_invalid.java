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

//Test Case 89164:Open EVV-Worker-Validate (mix) - EmployeeID field formats/values

public class TC89164_EmpID_invalid extends BaseTest{


	String empid;

	//To validate the valid five digit empid
	@Test
	public void TC89164_OpenEVV_valid_five_digit_EmpId() throws IOException, ParseException
	{
		logger = extent.startTest("TC89164_OpenEVV_valid_five_digit_EmpId"); 

		logger.log(LogStatus.INFO, "To validate TC89164_OpenEVV_valid_five_digit_EmpId");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(5));
		empid = js.get("EmployeeID").toString();


		logger.log(LogStatus.INFO, "Passing EmployeeID as "+ empid);
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid five digit empid
	@Test
	public void TC89164_OpenEVV_valid_five_alpha() throws IOException, ParseException
	{
		logger = extent.startTest("TC89164_OpenEVV_valid_five_alpha"); 

		logger.log(LogStatus.INFO, "To validate TC89164_OpenEVV_valid_five_alpha");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeID", CommonMethods.getSaltString(5));
		empid = js.get("EmployeeID").toString();


		logger.log(LogStatus.INFO, "Passing EmployeeID as "+ empid);
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("  \"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeID expected format is not correct. The record should satisfy this regular expression"));
		}

	//To validate the valid five digit empid
	@Test
	public void TC89164_OpenEVV_valid_empid_alphanum() throws IOException, ParseException
	{
		logger = extent.startTest("TC89164_OpenEVV_valid_empid_alphanum"); 

		logger.log(LogStatus.INFO, "To validate TC89164_OpenEVV_valid_empid_alphanum");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeID", CommonMethods.generateRandomAlphaNumeric(5));
		empid = js.get("EmployeeID").toString();


		logger.log(LogStatus.INFO, "Passing EmployeeID as "+ empid);
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("  \"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeID expected format is not correct. The record should satisfy this regular expression"));
	}

	//To validate the valid five digit empid
	@Test
	public void TC89164_OpenEVV_valid_empid_specialchar() throws IOException, ParseException
	{
		logger = extent.startTest("TC89164_OpenEVV_valid_empid_specialchar"); 

		logger.log(LogStatus.INFO, "To validate TC89164_OpenEVV_valid_empid_specialchar");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeID", CommonMethods.generateSpecialChar(5));
		empid = js.get("EmployeeID").toString();


		logger.log(LogStatus.INFO, "Passing EmployeeID as "+ empid);
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("  \"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeID expected format is not correct. The record should satisfy this regular expression"));
		}

	//To validate the valid five digit empid
	@Test
	public void TC89164_OpenEVV_valid_empid_space11() throws IOException, ParseException
	{
		logger = extent.startTest("TC89164_OpenEVV_valid_empid_space11"); 

		logger.log(LogStatus.INFO, "To validate TC89164_OpenEVV_valid_empid_space11");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeID", "  " + CommonMethods.generateRandomNumberOfFixLength(5));
		empid = js.get("EmployeeID").toString();


		logger.log(LogStatus.INFO, "Passing EmployeeID as "+ empid);
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("  \"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeID expected format is not correct. The record should satisfy this regular expression"));
	}




}
