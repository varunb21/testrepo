package AltEVV_generic.restassured.sandata.Employee;

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
 * @author MayankM
 *
 */
public class TC96576_AltEVV_Emp_StaffSSN extends BaseTest {
	
	@Test
	public void TC96576_AltEVV_Emp_StaffSSN_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96576_AltEVV_Emp_StaffSSN_valid");  

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_Intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSSN",CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);
	}
	
	@Test
	public void TC96576_AltEVV_Emp_StaffSSN_invalid_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96576_AltEVV_Emp_StaffSSN_invalid_length");  

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_Intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSSN",CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSSNFormatError);
	}
	
	@Test
	public void TC96576_AltEVV_Emp_StaffSSN_hyphen() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96576_AltEVV_Emp_StaffSSN_hyphen");  

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_Intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSSN",CommonMethods.generateRandomNumberOfFixLength(5) + "-" + CommonMethods.generateRandomNumberOfFixLength(4) );

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSSNFormatError);
	}


}
