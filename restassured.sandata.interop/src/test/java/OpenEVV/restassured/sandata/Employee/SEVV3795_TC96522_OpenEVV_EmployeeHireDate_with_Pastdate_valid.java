/**
 * 
 */
package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Emp;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV3795_TC96522_OpenEVV_EmployeeHireDate_with_Pastdate_valid extends BaseTest {
	

	@Test
	public void TC96522_OpenEVV_EmployeeHireDate_with_Pastdate_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96522_OpenEVV_EmployeeHireDate_with_Pastdate_valid"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeHireDate, "08011991");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));
				
		String bodyAsStringget = CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("Emp_get"));
		
		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsobject);	
		
		Assert.assertTrue(bodyAsStringget.contains("messageSummary\": \"All records updated successfully.")); 
		
		Assertion_DbVerifier.jsonAssert_stxWorker_supp(bodyAsString, jsobject);
	
	}

}
