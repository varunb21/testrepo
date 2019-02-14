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

//Test Case 88847:Open EVV-Worker-Field Mapping-Schema:INBOX - Fully Populated

public class TC88847_Emp_Fully_Populated_Inbox_DB extends BaseTest{

	@Test
	public void TC88847_OpenEVV_Employee_validation_fully_populated_Inbox_DB() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException 
	{
		logger = extent.startTest("TC88847_OpenEVV_Employee_validation_fully_populated_Inbox_DB");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		
		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsonObject);

	}

}
