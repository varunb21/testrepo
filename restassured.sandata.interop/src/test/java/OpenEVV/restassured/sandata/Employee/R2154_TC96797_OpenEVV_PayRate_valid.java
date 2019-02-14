package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Emp;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

// Test Case 96797: OpenEVV Employee- Validate PayRate field for positive values

public class R2154_TC96797_OpenEVV_PayRate_valid extends BaseTest {

	// Case1: PayRate- 1.45 (String)

	@Test
	public void TC96797_OpenEVV_PayRate_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96797_OpenEVV_PayRate_valid"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomNumberOfFixLength(1) +"." +CommonMethods.generateRandomNumberOfFixLength(2));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsobject);		

	}

	// Case2: PayRate- 12.45- Max length

	@Test
	public void TC96797_OpenEVV_PayRate_decimal_Maxlength() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96797_OpenEVV_PayRate_decimal_Maxlength"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomNumberOfFixLength(2) + "." + CommonMethods.generateRandomNumberOfFixLength(2));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));
		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsobject);

	}

	// Case3: PayRate- null 

	@Test
	public void TC96797_OpenEVV_PayRate_with_null() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96797_OpenEVV_PayRate_with_null"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsonobject = (JSONObject) jsonArr.get(0);

		jsonobject.put(globalVariables.PayRate, null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");
		DataBaseVerifier_Emp.DataBaseVerificationEmp("STX_ID", jsonobject.get(globalVariables.EmployeePIN).toString(), 
				"Account",jsonobject.get(globalVariables.Account).toString());

		Assert.assertEquals(DataBaseVerifier_Emp.ncode_inworker, "0");

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Account_inworker.toString(),jsonobject.get(globalVariables.Account).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Emp_L_Name_inworker.toString(),jsonobject.get(globalVariables.EmployeeLastName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Emp_F_Name_inworker.toString(),jsonobject.get(globalVariables.EmployeeFirstName).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Emp_M_Initial_inworker.toString(),jsonobject.get(globalVariables.EmployeeMiddleInitial).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Dept_inworker.toString(),jsonobject.get(globalVariables.Department).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpAPI_inworker.toString(),jsonobject.get(globalVariables.EmployeeAPI).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpType_inworker.toString(),jsonobject.get(globalVariables.EmployeeType).toString());
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.Payrate_inworker, null);

	}


}
