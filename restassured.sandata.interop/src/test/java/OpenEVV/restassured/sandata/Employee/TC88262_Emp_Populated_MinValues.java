package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
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

//Test Case 88262:Open EVV -Worker-Load-Minimum Values

public class TC88262_Emp_Populated_MinValues extends BaseTest {

	//To validate the Employee with fields populated with minimum length values
	@Test
	public void TC88262_OpenEVV_Emp_Populated_with_Min_values() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException 
	{
		logger = extent.startTest("TC88262_OpenEVV_Emp_Populated_with_Min_values"); 
		 
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_min_openevv_Json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		
		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsonObject);

	}


}



