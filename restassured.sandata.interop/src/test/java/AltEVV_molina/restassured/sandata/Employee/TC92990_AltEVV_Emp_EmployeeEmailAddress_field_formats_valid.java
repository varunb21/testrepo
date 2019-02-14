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
public class TC92990_AltEVV_Emp_EmployeeEmailAddress_field_formats_valid extends BaseTest{
	
	@Test
	public void TC92990_AltEVV_Emp_EmployeeEmailAddress_without_dashes_valid() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92990_AltEVV_Emp_EmployeeEmailAddress_without_dashes_valid");  
	logger.log(LogStatus.INFO, "Validating_EmployeeEmailAddress_field_without_dashes"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeEmail, CommonMethods.generateEmailAddress_alpha(6));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
   }
	
	@Test
	public void TC92990_AltEVV_Emp_EmployeeEmailAddress_alphanumeric_valid() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92990_AltEVV_Emp_EmployeeEmailAddress_alphanumeric_valid");  
	logger.log(LogStatus.INFO, "Validating_EmployeeEmailAddress_field_with_alphanumeric"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeEmail, CommonMethods.generateEmailAddress_string(8));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}

	@Test
	public void TC92990_AltEVV_Emp_EmployeeEmailAddress_alphabet() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92990_AltEVV_Emp_EmployeeEmailAddress_alphabet");  
	logger.log(LogStatus.INFO, "TC92990_AltEVV_Emp_EmployeeEmailAddress_alphabet"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeEmail, CommonMethods.generateEmailAddress_alpha(10));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}
	@Test
	public void TC92990_AltEVV_Emp_EmployeeEmailAddress_numeric() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC92990_AltEVV_Emp_EmployeeEmailAddress_numeric");  
	logger.log(LogStatus.INFO, "TC92990_AltEVV_Emp_EmployeeEmailAddress_numeric"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeEmail, CommonMethods.generateEmailAddress_num(6));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
}
}
