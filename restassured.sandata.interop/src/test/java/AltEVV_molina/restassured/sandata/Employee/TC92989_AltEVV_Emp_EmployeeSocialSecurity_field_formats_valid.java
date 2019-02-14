/**
 * 
 */
package AltEVV_molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
/**
 * @author Anupam
 *
 */

//Test Case 92989:Alt EVV-Worker-Validate (Positive) - EmployeeSocialSecurity field formats/values
public class TC92989_AltEVV_Emp_EmployeeSocialSecurity_field_formats_valid extends BaseTest{


	@Test
	public void TC92989_AltEVV_Emp_EmployeeSocialSecurity_numeric() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92989_AltEVV_Emp_EmployeeSocialSecurity_numeric");  
	logger.log(LogStatus.INFO, "TC92989_AltEVV_Emp_EmployeeSocialSecurity_numeric"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeSocialSecurity, CommonMethods.generateRandomNumberOfFixLength(9));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}
	
	@Test
	public void TC92989_AltEVV_Emp_EmployeeSocialSecurity_leadingzeros() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92989_AltEVV_Emp_EmployeeSocialSecurity_leadingzeros");  
	logger.log(LogStatus.INFO, "TC92989_AltEVV_Emp_EmployeeSocialSecurity_leadingzeros"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeSocialSecurity,  "0" + CommonMethods.generateRandomNumberOfFixLength(8));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}
	
	@Test
	public void TC92989_AltEVV_Emp_EmployeeSocialSecurity_headingzeros() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92989_AltEVV_Emp_EmployeeSocialSecurity_headingzeros");  
	logger.log(LogStatus.INFO, "TC92989_AltEVV_Emp_EmployeeSocialSecurity_headingzeros"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeSocialSecurity, CommonMethods.generateRandomNumberOfFixLength(8) +"0" );

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}
	
}
