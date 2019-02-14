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
public class TC88932_EmpDBValidation extends BaseTest {

//Open EVV - Employee - Validate Department , EmployeeType , Discipline  field in DB
	
	@Test
	public void TC88932_OpenEVV_Emp_Dept_Disc_Type_DB() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException 
	{
		
		logger = extent.startTest("TC88932_OpenEVV_Emp_Dept_Disc_Type_DB"); 
	
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("Discipline", CommonMethods.generateRandomStringOfFixLength(3));
		jsonObject.put("Department", CommonMethods.generateRandomStringOfFixLength(3));
		jsonObject.put("EmployeeType", CommonMethods.generateRandomStringOfFixLength(1));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		
		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsonObject);

	}


}
