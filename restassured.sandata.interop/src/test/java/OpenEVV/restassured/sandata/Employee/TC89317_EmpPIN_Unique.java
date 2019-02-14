/**
 * 
 */
package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
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

// Test Case 89317:Open-EVV : Employee Pin filed should be unique for every worker.

public class TC89317_EmpPIN_Unique extends BaseTest
{

	String emppin, emppin1;

	//To validate the valid EmployeePIN length max 9
	@Test(priority=1)
	public void TC89317_OpenEVV_EmployeePIN_valid_length_9() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89317_OpenEVV_EmployeePIN_valid_length_9"); 
		 
		logger.log(LogStatus.INFO, "To validate the valid EmployeePIN length max 9");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(9));
		emppin= js.get("EmployeePIN").toString();
		System.out.println(emppin);
		logger.log(LogStatus.INFO, "Passing EmployeePIN as "+emppin);
   
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the duplicate EmployeePIN length max 9
	@Test (priority=2)
	public void TC89317_OpenEVV_EmployeePIN_valid_length_9_duplicate() throws IOException, ParseException, ConfigurationException
	{

		logger = extent.startTest("TC89317_OpenEVV_EmployeePIN_valid_length_9_duplicate"); 
		 
		logger.log(LogStatus.INFO, "To validate the valid EmployeePIN length max 9 duplicate");

		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);

		js.put("EmployeePIN", emppin);
		logger.log(LogStatus.INFO, "Passing EmployeePIN as "+emppin);
  
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
	
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
}

	//To validate the valid EmployeePIN length max 4
	@Test(priority=3)
	public void TC89317_OpenEVV_EmployeePIN_valid_length_4() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89317_OpenEVV_EmployeePIN_valid_length_4"); 
		 
		logger.log(LogStatus.INFO, "To validate the valid EmployeePIN length max 4 duplicate");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(4));
		emppin1= js.get("EmployeePIN").toString();
		System.out.println(emppin);
		logger.log(LogStatus.INFO, "Passing EmployeePIN as "+emppin1);
 
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		System.out.println("Response Body is: " + bodyAsString);

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the duplicate EmployeePIN length max 4
	@Test(priority=4)
	public void TC89317_OpenEVV_EmployeePIN_valid_length_4_duplicate() throws IOException, ParseException, ConfigurationException
	{

		logger = extent.startTest("TC89317_OpenEVV_EmployeePIN_valid_length_4_duplicate"); 
		 
		logger.log(LogStatus.INFO, "To validate the valid EmployeePIN length max 4 duplicate");

		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);

		js.put("EmployeePIN", emppin1);
		logger.log(LogStatus.INFO, "Passing EmployeePIN as "+emppin);
  
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		logger.log(LogStatus.INFO, "Validating Json response ");
		System.out.println("Response Body is: " + bodyAsString);
		System.out.println("Employee PIN" +  "-" + " " + emppin + " " + "is duplicate" );
		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}


}
