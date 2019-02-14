/**
 * 
 */
package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;

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
public class R2313_TC96279_OpenEVV_EmployeeID_Validations extends BaseTest {

	//To validate the valid  EmployeeID 
		@Test
		public void TC96279_OpenEVV_EmployeeID_valid_length() throws IOException, ParseException, SQLException, java.text.ParseException
		{
			logger = extent.startTest("TC96279_OpenEVV_EmployeeID_valid_length");  

			JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
			JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("EmployeeID",CommonMethods.generateRandomNumberOfFixLength(5));

			String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
			Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsonObject);
		}

}
