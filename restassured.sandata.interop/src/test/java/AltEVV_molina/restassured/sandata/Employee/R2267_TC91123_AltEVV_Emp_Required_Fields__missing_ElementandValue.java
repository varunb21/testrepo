package AltEVV_molina.restassured.sandata.Employee;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

/**
 * @author RRohiteshwar
 *
 */


//Test Case 91123: Alt EVV-Worker-Validate - Required Fields Missing [element and value]

public class R2267_TC91123_AltEVV_Emp_Required_Fields__missing_ElementandValue extends BaseTest{

	String field = "worker_ssn";
	//Validate valid employee with fully populated required value in JSON
	@Test(priority=0)
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_Json_Validation() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_Json_Validation");  

		logger.log(LogStatus.INFO, "Validate valid employee with fully populated required value in JSON"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake_req_fields");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", null);


		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

	//	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);

	}

	//Validate valid employee with fully populated required value in DB
	@Test(priority=1)
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_DB_Validation() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_DB_Validation ");  

		logger.log(LogStatus.INFO, "// validate the Staff Intake JSON with max value  only"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake_req_fields");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", null);
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);

	}

	//Validate invalid employee required field is populated except EmployeeQualifier 
	@Test(priority=2)
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeQualifier__missing_ElementandValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeQualifier__missing_ElementandValue ");  

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeQualifier "); 

		JSONArray jsonArray = CommonMethods.LoadJSON_AltEVV("Staff_intake_req_fields");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeQualifier");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeQualifier cannot be NULL."));
	}

	//Validate invalid employee required field is populated except EmployeeIdentifier 
	@Test(priority=3)
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeIdentifier__missing_ElementandValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeIdentifier__missing_ElementandValue ");  

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeIdentifier "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake_req_fields");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeIdentifier");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeIdentifier cannot be NULL."));

	}

	//Validate invalid employee required field is populated except SequenceID 
	@Test(priority=4)
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_SequenceID__missing_ElementandValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_SequenceID__missing_ElementandValue ");  

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except SequenceID "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake_req_fields");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("SequenceID");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The SequenceID  cannot be NULL. The record is being rejected."));

	}

	//Validate invalid employee required field is populated except EmployeeSSN 
	@Test(priority=5)
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeSSN__missing_ElementandValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeSSN__missing_ElementandValue ");  

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeSSN "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake_req_fields");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeSSN");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSSN cannot be NULL. The record is being rejected."));

	}

	//Validate invalid employee required field is populated except EmployeeLastName 
	@Test(priority=6)
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeLastName__missing_ElementandValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeLastName__missing_ElementandValue ");  

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeLastName "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake_req_fields");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeLastName");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName cannot be NULL. The record is being rejected."));

	}

	//Validate invalid employee required field is populated except EmployeeFirstName 
	@Test(priority=7)
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeFirstName__missing_ElementandValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeFirstName__missing_ElementandValue ");  

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeFirstName "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake_req_fields");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeFirstName");


		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName cannot be NULL. The record is being rejected."));

	}

	//Validate invalid employee required field is populated except EmployeeEmail 
	@Test(priority=8)
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeEmail__missing_ElementandValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeEmail__missing_ElementandValue ");  

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeEmail "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake_req_fields");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeEmail");


		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeEmail cannot be NULL. The record is being rejected."));

	}

}