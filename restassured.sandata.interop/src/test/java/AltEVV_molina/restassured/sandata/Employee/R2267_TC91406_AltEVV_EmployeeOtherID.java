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
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

/**
 * @author RRohiteshwar
 *
 */
//Test Case 91406: OpenEVV-altEVV- Employee - EmployeeOtherID validation field formats/values

public class R2267_TC91406_AltEVV_EmployeeOtherID extends BaseTest{
	String  empothrid,  empothid_db= "worker_id_custom1", empssn, empssn_db="worker_ssn";

	//To validate the valid  EmployeeOtherID by passing the String Value of 64char with correct format
	@Test(priority=0, groups = {"functest"})
	public void R2267_TC91406_AltEVV_EmployeeOtherID_valid_String_64char() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeOtherID_valid_String_64char");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", CommonMethods.generateRandomStringOfFixLength(64));

		String resp = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(resp, jsonObject);
}

	//To validate the valid  EmployeeOtherID by passing the String Value less than 64char with correct format
	@Test(priority=1, groups = {"functest"})
	public void R2267_TC91406_AltEVV_EmployeeOtherID_valid_String_lessthan_64char() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeOtherID_valid_String_lessthan_64char");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", CommonMethods.generateRandomStringOfFixLength(1));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);
	}

	//To validate the valid  EmployeeOtherID by passing the String Value as null in DB
	@Test(priority=2, groups = {"functest"})
	public void R2267_TC91406_AltEVV_EmployeeOtherID_valid_String_null_DB() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeOtherID_valid_String_null_DB");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);

	}


	//To validate the invalid  EmployeeOtherID by passing the String Value having no value
	@Test(priority=4, groups = {"functest"})
	public void R2267_TC91406_AltEVV_EmployeeOtherID_invalid_String_withnovalue() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeOtherID_invalid_String_withnovalue");  

		logger.log(LogStatus.INFO, "	//To validate the invalid  EmployeeOtherID by passing the String Value having no value"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID", "");

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeOtherID format is incorrect. It should be between ${min} and ${max} characters."));
	}

	//To validate the invalid  EmployeeOtherID by passing the String Value of  more than 64char
	@Test(priority=5, groups = {"functest"})
	public void R2267_TC91406_AltEVV_EmployeeOtherID_invalid_String_morethan_64() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeOtherID_invalid_String_morethan_64");  

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeOtherID by passing the String Value of  more than 64char"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID", CommonMethods.generateRandomNumberOfFixLength(65));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeOtherID format is incorrect. It should be between ${min} and ${max} characters."));
	}

	//To validate the invalid  EmployeeOtherID by passing the String Value as special character and numr
	@Test(priority=6, groups = {"functest"})
	public void R2267_TC91406_AltEVV_EmployeeOtherID_invalid_String_specialchar_num() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeOtherID_invalid_String_specialchar_num");  

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeOtherID by passing the String Value as special character and numr"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID", CommonMethods.generateRandomNumberOfFixLength(10)+ CommonMethods.generateSpecialChar(5)+ CommonMethods.generateRandomNumberOfFixLength(3));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeOtherID format is incorrect. It should be between ${min} and ${max} characters."));
	}

	//To validate the invalid  EmployeeOtherID by passing the String Value of  more than 64char including special char
	@Test(priority=7, groups = {"functest"})
	public void R2267_TC91406_AltEVV_EmployeeOtherID_invalid_String_specialchar_num_morethan_64() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeOtherID_invalid_String_specialchar_num_morethan_64");  

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeOtherID by passing the String Value of  more than 64char including special char"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID", CommonMethods.generateRandomNumberOfFixLength(30)+ CommonMethods.generateSpecialChar(20)+ CommonMethods.generateRandomNumberOfFixLength(20));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeOtherID format is incorrect. It should be between ${min} and ${max} characters."));
	}


}