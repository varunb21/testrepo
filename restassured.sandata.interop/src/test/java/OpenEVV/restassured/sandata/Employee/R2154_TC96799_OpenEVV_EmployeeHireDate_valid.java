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
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

	// Test Case 96799: OpenEVV Employee- Validate EmployeeHireDate field for valid values

	public class R2154_TC96799_OpenEVV_EmployeeHireDate_valid extends BaseTest {

	// Case1: EmployeHireDate- 10282016 (Pastdate - valid)
	
	@Test
	public void TC96799_OpenEVV_EmployeeHireDate_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96799_OpenEVV_EmployeeHireDate_valid"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeHireDate, CommonMethods.generatePastDate_MMddYYYY());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsobject);	
	}

	// Case2: EmployeeHireDate- Current date (valid)
	
		@Test
	public void TC96799_OpenEVV_EmployeeHireDate_currentdate_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
		{
			logger = extent.startTest("TC96799_OpenEVV_EmployeeHireDate_currentdate_valid"); 

			JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

			//Making json values dynamic

			JSONObject jsobject = (JSONObject) jsonArr.get(0);

			jsobject.put(globalVariables.EmployeeHireDate, CommonMethods.generateTodayDate_MMddyyyy());

			String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

			Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsobject);	
		}
	
	// Case3: EmployeeHireDate-Past date (valid)
		
			@Test
	public void TC96799_OpenEVV_EmployeeHireDate_validYear() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
			{
				logger = extent.startTest("TC96799_OpenEVV_EmployeeHireDate_validYear"); 

				JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

				//Making json values dynamic

				JSONObject jsobject = (JSONObject) jsonArr.get(0);

				jsobject.put(globalVariables.EmployeeHireDate, CommonMethods.generatePastDate_MMddYYYY() );

				String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

				Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsobject);	
			}
	
}
