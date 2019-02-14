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
 * @author MayankM
 *
 */

// Test Case 96802: OpenEVV Employee- Validate EmployeeBirthDate field for Invalid values

public class R2154_TC96802_OpenEVV_EmployeeBirthDate_invalid extends BaseTest {


	@Test
	public void TC96802_OpenEVV_EmployeeBirthDate_invalid_month() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96802_OpenEVV_EmployeeBirthDate_invalid"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeBirthDate, 13032018);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeBirthDateformaterror);	
	}

	@Test
	public void TC96802_OpenEVV_EmployeeBirthDate_invalidday() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96802_OpenEVV_EmployeeBirthDate_invalidday"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeBirthDate, 11322016);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeBirthDateformaterror);	
	}

	@Test
	public void TC96802_OpenEVV_EmployeeBirthDate_exceeds_maxlength() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96802_OpenEVV_EmployeeBirthDate_exceeds_maxlength"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeBirthDate, 112820176);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeBirthDateformaterror);
	}

	@Test
	public void TC96802_OpenEVV_EmployeeBirthDate_with_null() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96802_OpenEVV_EmployeeBirthDate_with_null"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeBirthDate, "null");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeBirthDateformaterror);	
	}	

}
