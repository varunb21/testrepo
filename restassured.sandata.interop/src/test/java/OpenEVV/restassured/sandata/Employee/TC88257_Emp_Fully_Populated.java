package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author MayankM
 *
 */

//Test Case 88257:Open EVV - Fully Populated Worker

public class TC88257_Emp_Fully_Populated extends BaseTest{


	//To validate the valid Employee fully populated
	
	@Test 
	public void TC88269_OpenEVV_Emp_Fully_Populated_valid_case_DB() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC88269_OpenEVV_Emp_Fully_Populated_valid_case_DB"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsonObject);


	}

}
