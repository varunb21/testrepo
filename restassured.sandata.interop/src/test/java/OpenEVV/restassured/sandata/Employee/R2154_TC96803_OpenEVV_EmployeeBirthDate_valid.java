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
 * @author MayankM
 *
 */

	// Test Case 96803: OpenEVV Employee- Validate EmployeeBirthDate field for positive values

	public class R2154_TC96803_OpenEVV_EmployeeBirthDate_valid extends BaseTest {
	
	@Test
	public void TC96803_OpenEVV_EmployeeBirthDate_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96803_OpenEVV_EmployeeBirthDate_valid"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeBirthDate, CommonMethods.generatePastDate_MMddYYYY());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsobject);	
	}

		@Test
	public void TC96803_OpenEVV_EmployeeBirthDate_currentdate_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
		{
			logger = extent.startTest("TC96803_OpenEVV_EmployeeBirthDate_currentdate_valid"); 

			JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

			//Making json values dynamic

			JSONObject jsobject = (JSONObject) jsonArr.get(0);

			jsobject.put(globalVariables.EmployeeBirthDate, CommonMethods.generateTodayDate_MMddyyyy());

			String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

			Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsobject);	
		}
			
		
}
