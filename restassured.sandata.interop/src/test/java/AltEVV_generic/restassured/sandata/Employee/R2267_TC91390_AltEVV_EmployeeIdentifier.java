package AltEVV_generic.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

public class R2267_TC91390_AltEVV_EmployeeIdentifier extends BaseTest{

	//To validate the valid  EmployeeIdentifier 
	@Test
	public void R2267_TC91390_AltEVV_EmployeeIdentifier_valid_string() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91390_AltEVV_EmployeeIdentifier_valid_string");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier",CommonMethods.generateRandomStringOfFixLength(9));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);
	}

	@Test
	public void R2267_TC91390_AltEVV_EmployeeIdentifier_valid_numeric() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91390_AltEVV_EmployeeIdentifier_valid_string");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier",CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);
	}

	public void R2267_TC91390_AltEVV_EmployeeIdentifier_valid_alphanumeric() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91390_AltEVV_EmployeeIdentifier_valid_string");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier",CommonMethods.generateRandomAlphaNumeric(9));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);
	}

	@Test
	public void R2267_TC91390_AltEVV_EmployeeIdentifier_invalid_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91390_AltEVV_EmployeeIdentifier_invalid_length");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier",CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpIdentifierLengthError);
	}

	@Test
	public void R2267_TC91390_AltEVV_EmployeeIdentifier_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91390_AltEVV_EmployeeIdentifier_blank");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier","");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpIdentifierFormatError);
	}

	@Test
	public void R2267_TC91390_AltEVV_EmployeeIdentifier_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91390_AltEVV_EmployeeIdentifier_invalid_length");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier",null);

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpIdentifierNullError);
	}

}

