package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 88259:Open EVV -Worker-Load-Maximum Values

public class TC88259_Emp_Populated_MaxValues extends BaseTest{

	//To validate the Employee with fields populated with maximum length values
	@Test
	public void TC90412_EmpAccount_invalid() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC90412_EmpAccount_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsonObject);
	}

}



