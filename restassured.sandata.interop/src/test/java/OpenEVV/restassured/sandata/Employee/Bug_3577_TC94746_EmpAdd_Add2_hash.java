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

// TC94743 : Inter-Op: Verifies if EmployeeAddress, EmployeeAddress2 & EmployeeCity fields are accepting values with letters

public class Bug_3577_TC94746_EmpAdd_Add2_hash extends BaseTest
{

	@Test
	public void TC94746_EmpAdd_Add2_hash_validation() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC94746_EmpAdd_Add2_hash_validation"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);

		js.put(globalVariables.EmployeeAddress1, CommonMethods.generateRandomAlphaNumeric(15) +"#" +
				CommonMethods.generateRandomAlphaNumeric(5));
		js.put(globalVariables.EmployeeAddress2, CommonMethods.generateRandomAlphaNumeric(15) + "#" +
				CommonMethods.generateRandomAlphaNumeric(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, js);	
	}

}
