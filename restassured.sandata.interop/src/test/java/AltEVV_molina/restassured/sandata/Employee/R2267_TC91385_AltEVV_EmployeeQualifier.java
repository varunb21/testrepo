/**
 * 
 */
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
public class R2267_TC91385_AltEVV_EmployeeQualifier extends BaseTest{

	//To validate the valid  EmployeeQualifier by passing the String Value as "EmployeeSSN"
	@Test(priority=0, groups = {"functest"})
	public void R2267_TC91385_AltEVV_EmployeeQualifier_valid_String_as_EmployeeSSN() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91385_AltEVV_EmployeeQualifier_valid_String_as_EmployeeSSN");  
		
		logger.log(LogStatus.INFO, "To validate the valid  EmployeeQualifier by passing the String Value as EmployeeSSN"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype("EmployeeSSN"));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}

	//To validate the valid  EmployeeQualifier by passing the String Value as "EmployeeRegID"
	@Test(priority=1, groups = {"functest"})
	public void R2267_TC91385_AltEVV_EmployeeQualifier_valid_String_as_EmployeeRegID() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91385_AltEVV_EmployeeQualifier_valid_String_as_EmployeeRegID");  
		
		logger.log(LogStatus.INFO, "To validate the valid  EmployeeQualifier by passing the String Value as EmployeeRegID"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype("EmployeeRegID"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}

	//To validate the valid  EmployeeQualifier by passing the String Value as "EmployeeCustomID"
	@Test(priority=2, groups = {"functest"})
	public void R2267_TC91385_AltEVV_EmployeeQualifier_valid_String_as_EmployeeCustomID() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91385_AltEVV_EmployeeQualifier_valid_String_as_EmployeeCustomID");  
		
		logger.log(LogStatus.INFO, "	//To validate the valid  EmployeeQualifier by passing the String Value as \"EmployeeCustomID\""); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype("EmployeeCustomID"));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}

	//To validate the invalid  EmployeeQualifier by passing the String Value as "null"
	@Test(priority=3, groups = {"functest"})
	public void R2267_TC91385_AltEVV_EmployeeQualifier_invalid_as_null_value() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91385_AltEVV_EmployeeQualifier_invalid_as_null_value");  
		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeQualifier by passing the String Value as \"null\""); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype("null"));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeQualifier format is incorrect. It should be one of these excepted values [\\u0027EmployeeSSN|EmployeeRegID|EmployeeCustomID\\u0027]"));
	}

	//To validate the invalid  EmployeeQualifier by passing the as null
	@Test(priority=4, groups = {"functest"})
	public void R2267_TC91385_AltEVV_EmployeeQualifier_invalid_as_null() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91385_AltEVV_EmployeeQualifier_invalid_as_null");  
		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeQualifier by passing the value as null"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeQualifier cannot be NULL"));
	}

	//To validate the invalid  EmployeeQualifier by passing the String Value as "EmployeeFirstName"
	@Test(priority=5, groups = {"functest"})
	public void R2267_TC91385_AltEVV_EmployeeQualifier_invalid_string_as_EmployeeFirstName() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91385_AltEVV_EmployeeQualifier_invalid_string_as_EmployeeFirstName");  
		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeQualifier by passing the String Value as \"EmployeeFirstName\""); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype("EmployeeFirstName"));
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeQualifier format is incorrect. It should be one of these excepted values [\\u0027EmployeeSSN|EmployeeRegID|EmployeeCustomID\\u0027]"));
	}

	//To validate the invalid  EmployeeQualifier by passing the String Value as no-value
	@Test(priority=6, groups = {"functest"})
	public void R2267_TC91385_AltEVV_EmployeeQualifier_invalid_string_as_novalue() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91385_AltEVV_EmployeeQualifier_invalid_string_as_novalue");  
		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeQualifier by passing the String Value as novalue"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype(""));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeQualifier format is incorrect. It should be one of these excepted values [\\u0027EmployeeSSN|EmployeeRegID|EmployeeCustomID\\u0027]"));
	}

}
