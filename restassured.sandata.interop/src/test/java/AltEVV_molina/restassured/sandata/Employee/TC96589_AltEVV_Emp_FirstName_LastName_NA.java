package AltEVV_molina.restassured.sandata.Employee;

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
 * @author MayankM
 *
 */
public class TC96589_AltEVV_Emp_FirstName_LastName_NA extends BaseTest {

	@Test
	public void TC96589_AltEVV_Emp_FirstName_LastName_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96589_AltEVV_Emp_FirstName_LastName_blank");  

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_Intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName","");
		js.put("EmployeeLastName","");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffFirstNameFormatError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffLastNameFormatError);
	}

	@Test
	public void TC96589_AltEVV_Emp_FirstName_LastName_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96589_AltEVV_Emp_FirstName_LastName_null");  

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_Intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName",null);
		js.put("EmployeeLastName",null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffFirstNameNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffLastNameNullError);
	}

	@Test
	public void TC96589_AltEVV_Emp_FirstName_LastName_Not_Present() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96589_AltEVV_Emp_FirstName_LastName_Not_Present");  

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_Intake");
		JSONObject js = (JSONObject) j.get(0);
		js.remove("EmployeeFirstName");
		js.remove("EmployeeLastName");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffFirstNameNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffLastNameNullError);
	}

}
