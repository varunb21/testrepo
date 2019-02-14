package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;
/**
 * @author Anupam
 *
 */
// Test Case 92994:OpenEVV-altEVV- Employee - EmployeeOtherID validation field formats/values

public class TC92994_OpenEVV_Employee_EmployeeOtherID_validation extends BaseTest {

	public void TC92994_OpenEVV_Employee_EmployeeOtherID_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
	logger = extent.startTest("TC92994_OpenEVV_Employee_EmployeeOtherID_valid"); 

	JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

	JSONObject jsobject = (JSONObject) jsonArr.get(0);

	jsobject.put(globalVariables.EmployeeOtherID, "STX12343");

	String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

	Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsobject);	
	
    }
}
