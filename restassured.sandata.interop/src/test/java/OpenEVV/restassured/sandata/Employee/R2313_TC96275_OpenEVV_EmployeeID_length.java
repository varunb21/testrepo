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
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class R2313_TC96275_OpenEVV_EmployeeID_length extends BaseTest {

	//To validate EmployeeID length (invalid >5)
		@Test
		public void TC96275_OpenEVV_EmployeeID_invalid_length() throws IOException, ParseException, SQLException
		{
			logger = extent.startTest("TC96275_OpenEVV_EmployeeID_invalid_length");  

			JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
			JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("EmployeeID",CommonMethods.generateRandomNumberOfFixLength(6));

			String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpIDFormatError);

		}
		
		//To validate EmployeeID length (invalid <5)
				@Test
				public void TC96275_OpenEVV_EmployeeID_invalid_length_validation() throws IOException, ParseException, SQLException
				{
					logger = extent.startTest("TC96275_OpenEVV_EmployeeID_invalid_length");  

					JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
					JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

					jsonObject.put("EmployeeID",CommonMethods.generateRandomNumberOfFixLength(4));

					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpIDFormatError);
				}

}
