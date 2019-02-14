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

//Test Case 91572:Open EVV - Employee- Create Multiple Employee with Same SSN

public class TC91572_MultipleEmp_SameSSN extends BaseTest{


	@Test 
	public void TC91572_OpenEVV_Emp_ssn_new_dberrorcode() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException 
	{
		logger = extent.startTest("TC91572_OpenEVV_Emp_ssn_new_dberrorcode"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject  js = (JSONObject) jsonArray.get(0);

		String empssn = CommonMethods.generateRandomNumberOfFixLength(9);
		js.put("EmployeeSocialSecurity",empssn);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, js);

		// To send the request again with same ssn
		js.put("EmployeeSocialSecurity",empssn);

		String bodyAsStringRe = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsStringRe, js);
	}


}



