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

// Test Case 96798: OpenEVV Employee- Validate EmployeeHireDate field for Invalid values

public class R2154_TC96798_OpenEVV_EmployeeHireDate_invalid extends BaseTest {

	// Case1: EmployeeHireDate-13232016 (mmddyyyy - invalid month)

	@Test
	public void TC96798_OpenEVV_EmployeeHireDate_invalid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96798_OpenEVV_EmployeeHireDate_invalid"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeHireDate, 13232016);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeHireDateformaterror);	
	}

	// Case2: EmployeeHireDate-11322016 (Past date- Invalid day)

	@Test
	public void TC96798_OpenEVV_EmployeeHireDate_invalidday() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96798_OpenEVV_EmployeeHireDate_invalidday"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeHireDate, 11322016);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeHireDateformaterror);	
	}

	// Case3: EmployeeHireDate-11281899 (Invalid Year)

	@Test
	public void TC96798_OpenEVV_EmployeeHireDate_invalidYear() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96798_OpenEVV_EmployeeHireDate_invalidYear"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeHireDate, 11281899 );

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeHireDateYearformat);	
	}

	// Case4: EmployeeHireDate-112820176  (Exceeds maximum length - Invalid)

	@Test
	public void TC96798_OpenEVV_EmployeeHireDate_exceeds_maxlength() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96798_OpenEVV_EmployeeHireDate_exceeds_maxlength"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeHireDate, CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeHireDateformaterror);
	}

	// Case5: EmployeeHireDate-null  (null - Invalid)

	@Test
	public void TC96798_OpenEVV_EmployeeHireDate_with_null() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96798_OpenEVV_EmployeeHireDate_with_null"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeHireDate, "null");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeHireDateformaterror);	
	}	

}
