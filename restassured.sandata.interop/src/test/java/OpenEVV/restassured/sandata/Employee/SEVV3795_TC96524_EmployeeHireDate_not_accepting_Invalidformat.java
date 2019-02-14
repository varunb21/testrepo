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
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;
import junit.framework.AssertionFailedError;

/**
 * @author Anupam
 *
 */
public class SEVV3795_TC96524_EmployeeHireDate_not_accepting_Invalidformat extends BaseTest{

	
	@Test
	public void TC96524_EmployeeHireDate_not_accepting_Invalidformat() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96524_EmployeeHireDate_not_accepting_Invalidformat"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeHireDate, "19990108");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeHireDateformaterror);	
		
	}
}
