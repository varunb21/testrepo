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

//Test Case 92986:Alt EVV-Worker-Validate (Positive values) - EmployeeLastName field formats/values
public class TC92986_AltEVV_Emp_EmployeeLastName_field_formats extends BaseTest{


	@Test
	public void TC92986_AltEVV_Emp_EmployeeLastName_with_alphabet() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92986_AltEVV_Emp_EmployeeLastName_with_alphabet");  
	logger.log(LogStatus.INFO, "Validating_EmployeeLastName_field_with_alphabets"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeLastName, CommonMethods.generateRandomStringOfFixLength(10));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}
	
	@Test
	public void TC92986_AltEVV_Emp_EmployeeLastName_with_space_alphabet() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92986_AltEVV_Emp_EmployeeLastName_with_space_alphabet");  
	logger.log(LogStatus.INFO, "Validating_EmployeeLastName_field_with_space and alphabets"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeLastName, CommonMethods.generateRandomStringOfFixLength(5) +" " + CommonMethods.generateRandomStringOfFixLength(5));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}
	
	@Test
	public void TC92986_AltEVV_Emp_EmployeeLastName_with_leadingspace() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92986_AltEVV_Emp_EmployeeLastName_with_leadingspace");  
	logger.log(LogStatus.INFO, "TC92986_AltEVV_Emp_EmployeeLastName_with_leadingspace and alphabets"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeLastName, CommonMethods.generateRandomStringOfFixLength(10) +" " );

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}
	
	@Test
	public void TC92986_AltEVV_Emp_EmployeeLastName_with_trailingspace() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92986_AltEVV_Emp_EmployeeLastName_with_trailingspace");  
	logger.log(LogStatus.INFO, "TC92986_AltEVV_Emp_EmployeeLastName_with_trailingspace and alphabets"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeLastName, " " + CommonMethods.generateRandomStringOfFixLength(10) );

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}
	
	@Test
	public void TC92986_AltEVV_Emp_EmployeeLastName_with_dashes() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92986_AltEVV_Emp_EmployeeLastName_with_dashes");  
	logger.log(LogStatus.INFO, "TC92986_AltEVV_Emp_EmployeeLastName_with_dashes and alphabets"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeLastName, CommonMethods.generateRandomStringOfFixLength(3) +"-" +CommonMethods.generateRandomStringOfFixLength(6));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}
}
