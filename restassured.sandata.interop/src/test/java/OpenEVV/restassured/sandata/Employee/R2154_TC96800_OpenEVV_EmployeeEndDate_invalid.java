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
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

	// Test Case 96800: OpenEVV Employee- Validate EmployeeEndDate field for Invalid values

	public class R2154_TC96800_OpenEVV_EmployeeEndDate_invalid extends BaseTest {

	// Case1: EmployeeEndDate-13232016 (mmddyyyy - invalid month)
	
	@Test
	public void TC96800_OpenEVV_EmployeeEndDate_invalid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96800_OpenEVV_EmployeeEndDate_invalid"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeEndDate, 13232016);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeEndDateformaterror);	
	}

	// Case2: EmployeeEndDate-11322016 (Day- Invalid)
	
		@Test
	public void TC96800_OpenEVV_EmployeeEndDate_invalidday() throws IOException, ParseException, ConfigurationException, SQLException
		{
			logger = extent.startTest("TC96800_OpenEVV_EmployeeEndDate_invalidday"); 

			JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

			//Making json values dynamic

			JSONObject jsobject = (JSONObject) jsonArr.get(0);

			jsobject.put(globalVariables.EmployeeEndDate, 11322016);

			String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeEndDateformaterror);	
		}
	
	// Case3: EmployeeEndDate-11281899 (Invalid Year)
		
			@Test
	public void TC96800_OpenEVV_EmployeeEndDate_invalidYear() throws IOException, ParseException, ConfigurationException, SQLException
			{
				logger = extent.startTest("TC96800_OpenEVV_EmployeeEndDate_invalidYear"); 

				JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

				//Making json values dynamic

				JSONObject jsobject = (JSONObject) jsonArr.get(0);

				jsobject.put(globalVariables.EmployeeEndDate, 11281899 );

				String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

				CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeEndDateerror);	
			}
	
	// Case4: EmployeeEndDate-112820176  (Exceeds maximum length - Invalid)
			
				@Test
	public void TC96800_OpenEVV_EmployeeEndDate_exceeds_maxlength() throws IOException, ParseException, ConfigurationException, SQLException
				{
					logger = extent.startTest("TC96800_OpenEVV_EmployeeEndDate_exceeds_maxlength"); 

					JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

					//Making json values dynamic

					JSONObject jsobject = (JSONObject) jsonArr.get(0);

					jsobject.put(globalVariables.EmployeeEndDate, 112820176);

					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeEndDateformaterror);	
				    
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeMaxEndDateerror);
				}
	 // Case5: EmployeeEndDate-null  (null - Invalid)
				
				@Test
	public void TC96800_OpenEVV_EmployeeEndDate_with_null() throws IOException, ParseException, ConfigurationException, SQLException
				{
					logger = extent.startTest("TC96800_OpenEVV_EmployeeEndDate_with_null"); 

					JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

					//Making json values dynamic

					JSONObject jsobject = (JSONObject) jsonArr.get(0);

					jsobject.put(globalVariables.EmployeeEndDate, "null");

					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeEndDateformaterror);	
				}	
}
