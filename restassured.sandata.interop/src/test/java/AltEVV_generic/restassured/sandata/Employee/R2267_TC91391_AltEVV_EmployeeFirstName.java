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
//Test Case 91391: OpenEVV-altEVV- Employee - EmployeeFirstName validation field formats/values.

public class R2267_TC91391_AltEVV_EmployeeFirstName extends BaseTest{

	//To validate the valid  EmployeeFirstName by passing the String Value of 30chars
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_valid_String_30char() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_valid_String_30char");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomStringOfFixLength(30));
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);

	}

	//To validate the valid  EmployeeFirstName by passing the String Value of less than 30chars
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_valid_String_exceeding_30char() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_valid_String_lessthan_30char");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomStringOfFixLength(31));
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameLengthError);
	}

	//To validate the valid  EmployeeFirstName by passing the String Value as min value as 1 chars
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_valid_String_minvalue_1char() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_valid_String_minvalue_1char");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomStringOfFixLength(1));
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);
	}

	//To validate the valid  EmployeeFirstName by passing the String Value as whitespace
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_valid_String_with_whiteSpace() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_valid_String_with_whiteSpace");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomStringOfFixLength(5) + " " +CommonMethods.generateRandomStringOfFixLength(5) );
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);
	}

	//To validate the valid  EmployeeFirstName by passing the String Value as null 
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_valid_String_with_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_valid_String_with_null");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",null);
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameNullError);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as numeric
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_invalid_numeric() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_invalid_numeric");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomNumberOfFixLength(5));
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameFormatError);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as alphanumeric
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_invalid_alphanumeric() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_invalid_alphanumeric");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomAlphaNumeric(5));
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameFormatError);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as special chars
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_invalid_specialchars() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_invalid_specialchars");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateSpecialChar(10));
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameFormatError);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as blank
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_invalid_blank() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_invalid_blank");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName","");
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameFormatError);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as leading space
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_invalid_leading_space() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_invalid_leading_space");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName"," " + CommonMethods.generateRandomStringOfFixLength(10));
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as trailing space
	@Test
	public void R2267_TC91391_AltEVV_EmployeeFirstName_invalid_trailing_space() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91391_AltEVV_EmployeeFirstName_invalid_trailing_space");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomStringOfFixLength(10)+ " ");
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);
	}

	
}