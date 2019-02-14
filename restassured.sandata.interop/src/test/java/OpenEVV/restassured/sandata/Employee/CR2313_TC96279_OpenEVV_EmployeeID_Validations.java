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
public class CR2313_TC96279_OpenEVV_EmployeeID_Validations extends BaseTest {

	//To validate the valid  EmployeeID 
		@Test
		public void TC96279_OpenEVV_EmployeeID_valid_length() throws IOException, ParseException, SQLException, java.text.ParseException
		{
			logger = extent.startTest("TC96279_OpenEVV_EmployeeID_valid_length");  

			JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
			JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("EmployeeID",CommonMethods.generateRandomNumberOfFixLength(5));

			String bodyAsString = 
					CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

			Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);
		}

}
