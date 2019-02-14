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

public class SEVV_538_TC95987_Validate_xref_relation_when_EmployeePIN_Valid_and_Invalid extends BaseTest {

	//To validate the invalid Employee_Pin
	@Test 
	public void TC95987_Invalid_xref_relation_when_EmployeePIN_length_greaterthan_9_Integer() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95987_Invalid_xref_relation_when_EmployeePIN_length_greaterthan_9_Integer");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(10));


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINlengtherror);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINformaterror);



	}

	//To validate the invalid Employee_Pin
	@Test 
	public void TC95987_Invalid_xref_relation_when_EmployeePIN_character_only() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95987_Invalid_xref_relation_when_EmployeePIN_character_only");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeePIN", "ASDFGHJKL");


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINformaterror);


	}

	//To validate the invalid Employee_Pin
	@Test 
	public void TC95987_Invalid_xref_relation_when_EmployeePIN_with_special_Character() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95987_Invalid_xref_relation_when_EmployeePIN_with_special_Character");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeePIN", "ASDFGHJ@L");


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINformaterror);

	}

	//To validate the invalid Employee_Pin
	@Test 
	public void TC95987_Invalid_xref_relation_when_EmployeePIN_alpha_numeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95987_Invalid_xref_relation_when_EmployeePIN_alpha_numeric");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeePIN", "A67FGHJ4L");


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINformaterror);


	}

	//To validate the invalid Employee_Pin
	@Test 
	public void TC95987_Invalid_xref_relation_when_EmployeePIN_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95987_Invalid_xref_relation_when_EmployeePIN_null");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeePIN", null);


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINnullerror);


	}

	//To validate the invalid Employee_Pin
	@Test 
	public void TC95987_Invalid_xref_relation_when_EmployeePIN_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95987_Invalid_xref_relation_when_EmployeePIN_leading_space");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeePIN", " 123456789");


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINformaterror);


	}

	//To validate the invalid Employee_Pin
	@Test 
	public void TC95987_Invalid_xref_relation_when_EMployeePIN_with_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95987_Invalid_xref_relation_when_EMployeePIN_with_space");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeePIN", " 23456789");


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINformaterror);


	}

	//To validate the invalid Employee_Pin
	@Test 
	public void TC95987_Invalid_xref_relation_when_EMployeePIN_blank() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95987_Invalid_xref_relation_when_EMployeePIN_blank");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeePIN", "");


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINformaterror);


	}
	//To validate the valid Employee_Pin
	@Test 
	public void TC95987_validate_xref_relation_when_EmployeePIN_is_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC95987_validate_xref_relation_when_EmployeePIN_is_valid");  // adding method name info via logger

		//Using Reusable method to load client json


		//Making json values dynamic
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(9));


		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);


	}

	// Case Validate EmployeeQualifier_equals_EmployeePIN

	@Test(groups = {"Database"})
	public void TC95987_XRef_EmployeeQualifier_equals_EmployeePIN() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC95987_XRef_EmployeeQualifier_equals_EmployeePin");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95987_XRef_EmployeeQualifier_equals_EmployeePin"); // adding what you are verifying details

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", "EmployeePIN");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
	}		

}
