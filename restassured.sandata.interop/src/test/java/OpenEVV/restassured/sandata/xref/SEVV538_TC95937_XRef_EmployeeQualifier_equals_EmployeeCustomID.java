/**
 * 
 */
package OpenEVV.restassured.sandata.xref;

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
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV538_TC95937_XRef_EmployeeQualifier_equals_EmployeeCustomID extends BaseTest{

	// Case1 Validate EmployeeQualifier_equals_EmployeeCustomID

	@Test(groups = {"Database"})
	public void TC95937_XRef_EmployeeQualifier_equals_EmployeeCustomID() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC95937_XRef_EmployeeQualifier_equals_EmployeeCustomID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95937_XRef_EmployeeQualifier_equals_EmployeeCustomID"); // adding what you are verifying details

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", "EmployeeCustomID");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);

	}

	@Test 
	public void TC95937_XRef_EmployeeQualifier_equals_Employeecustomid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95937_XRef_EmployeeQualifier_equals_Employeecustomid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95937_XRef_EmployeeQualifier_equals_Employeecustomid"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.EmployeeQualifier, "Employeecustomid");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
	}
	// Case3 Validate EmployeeQualifier_equals_employeeCustomID (Invalid)

	@Test 
	public void TC95937_XRef_EmployeeQualifier_equals_employeeCustomID() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95937_XRef_EmployeeQualifier_equals_employeeCustomID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95937_XRef_EmployeeQualifier_equals_employeeCustomID"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.EmployeeQualifier, "employeeCustomID");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
	}

	// Case4 Validate EmployeeQualifier_equals_employeecustomid (Invalid)

	@Test 
	public void TC95937_XRef_EmployeeQualifier_equals_employeecustomid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95937_XRef_EmployeeQualifier_equals_employeecustomid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95937_XRef_EmployeeQualifier_equals_employeecustomid"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.EmployeeQualifier, "employeecustomid");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
	}

	// Case5 Validate EmployeeQualifier_Randomvalue

	@Test 
	public void TC95937_XRef_EmployeeQualifier_Randomvalue() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95937_XRef_EmployeeQualifier_Randomvalue");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject js = (JSONObject) jsonarray.get(0);

		//Making json values dynamic
		js.put(globalVariables.EmployeeQualifier, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);

	}



}
