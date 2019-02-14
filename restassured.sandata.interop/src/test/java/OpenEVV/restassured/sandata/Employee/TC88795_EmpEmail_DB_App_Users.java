package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.globalMethods.core.*;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 88795:Open EVV - Employee - Validate Employee login in App_User Table

public class TC88795_EmpEmail_DB_App_Users extends BaseTest{


	public static String val= "user_f_name";

	@Test
	public void TC88795_OpenEVV_EmpEmail_DB_App_Users_Validation() throws IOException, ParseException, ConfigurationException, SQLException 
	{
		logger = extent.startTest("TC88795_OpenEVV_EmpEmail_DB_App_Users_Validation"); 
		
		
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		JSONObject js = (JSONObject) j.get(0);
		
		String empemail = DataGeneratorEmployee.generateEmpEmail(5);
		String empssn = CommonMethods.generateRandomNumberOfFixLength(9);
		String empfname = CommonMethods.generateRandomStringOfFixLength(5);
		
		js.put("EmployeeEmailAddress", empemail);
		js.put("EmployeeSocialSecurity", empssn);
		js.put("EmployeeFirstName", empfname);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
	
		// assert validation to verify the outcome
		DataBaseVerifier_Emp.DataBaseVerificationEmp_app_user(val, empfname);

		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		Assert.assertEquals(empemail,DataBaseVerifier_Emp.Username_appuser);
		Assert.assertEquals(empfname,DataBaseVerifier_Emp.UserFName_appuser);

	}

}
