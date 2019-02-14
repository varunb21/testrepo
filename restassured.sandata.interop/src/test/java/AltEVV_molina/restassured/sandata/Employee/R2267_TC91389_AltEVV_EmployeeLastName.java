package AltEVV_molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */

//Test Case 91389: OpenEVV-altEVV- Employee - EmployeeLastName validation field formats/values.

public class R2267_TC91389_AltEVV_EmployeeLastName extends BaseTest{

	//To validate the valid  EmployeeLastName by passing the String Value of 30chars
	@Test
	public void R2267_TC91389_AltEVV_EmployeeLastName_valid_String_30char() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_valid_String_30char");  

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_Intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName",CommonMethods.generateRandomStringOfFixLength(30));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));


		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);
	}

	//To validate the valid  EmployeeLastName by passing the String Value of less than 30chars
	@Test(priority=1, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_valid_String_lessthan_30char() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_valid_String_lessthan_30char");  

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeLastName by passing the String Value of less than 30chars"); 

		//Using Reusable method to load employee json
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(29));
	
		String bodyAsString = 
			CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);

	}

	//To validate the valid  EmployeeLastName by passing the String Value as mid value 15chars
	@Test(priority=2, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_valid_String_midvalue_15char() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_valid_String_midvalue_15char");  

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeLastName by passing the String Value as mid value 15chars"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(15));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
			Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}

	//To validate the valid  EmployeeLastName by passing the String Value as min value as 1 chars
	@Test(priority=3, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_valid_String_minvalue_1char() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_valid_String_minvalue_1char");  

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeLastName by passing the String Value as min value as 1 chars"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(1));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
			Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}

	//To validate the valid  EmployeeLastName by passing the String Value as mid space
	@Test(priority=4, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_valid_String_with_midSpace() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_valid_String_with_midSpace");  

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeLastName by passing the String Value as mid space"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(5)+ " " + CommonMethods.generateRandomStringOfFixLength(5) + " " + CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
			Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}

	//To validate the valid  EmployeeLastName by passing the String Value as null quoted
	@Test(priority=5, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_valid_String_with_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_valid_String_with_null");  

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeLastName by passing the String Value as null quoted"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", "null");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
			Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}

	//To validate the invalid  EmployeeLastName by passing the value as numeric
	@Test(priority=6, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_invalid_numeric() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_invalid_numeric");  

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeLastName by passing the value as numeric"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomNumberOfFixLength(15));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName format is incorrect."));
	}

	//To validate the invalid  EmployeeLastName by passing the value as alphanumeric
	@Test(priority=7, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_invalid_alphanumeric() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_invalid_alphanumeric");  

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeLastName by passing the value as alphanumeric"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomAlphaNumeric(16));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName format is incorrect."));
	}

	//To validate the invalid  EmployeeLastName by passing the value as special chars
	@Test(priority=8, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_invalid_specialchars() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_invalid_specialchars");  

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeLastName by passing the value as special chars"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateSpecialChar(16));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName format is incorrect."));
	}

	//To validate the invalid  EmployeeLastName by passing the value as blank
	@Test(priority=9, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_invalid_blank() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_invalid_blank");  

		logger.log(LogStatus.INFO, "//To validate the invalid  EmployeeLastName by passing the value as blank"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", "");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName format is incorrect."));
	}

	//To validate the invalid  EmployeeLastName by passing the value as leading space
	@Test(priority=10, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_invalid_leading_space() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_invalid_leading_space");  

		logger.log(LogStatus.INFO, "	//To validate the invalid  EmployeeLastName by passing the value as leading space"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", "   " + CommonMethods.generateRandomStringOfFixLength(15));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);
}

	//To validate the invalid  EmployeeLastName by passing the value as trailing space
	@Test(priority=11, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_invalid_trailing_space() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_invalid_trailing_space");  

		logger.log(LogStatus.INFO, "//To validate the invalid  EmployeeLastName by passing the value as trailing space"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(15) + "  ");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);
	}
	//To validate the invalid  EmployeeLastName by passing the null 
	@Test(priority=12, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeLastName_invalid__null() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeLastName_invalid__null");  

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeLastName by passing the null "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", null);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName cannot be NULL."));
	}

}