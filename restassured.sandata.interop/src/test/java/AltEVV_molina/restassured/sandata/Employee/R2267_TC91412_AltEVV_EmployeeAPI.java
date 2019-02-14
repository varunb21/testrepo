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
 * @author MayankM
 *
 */
//Test Case 91411: OpenEVV-altEVV- Employee - EmployeeAPI validation field formats/values

public class R2267_TC91412_AltEVV_EmployeeAPI extends BaseTest{

	//To validate the valid EmployeeAPI
	@Test
	public void R2267_TC91406_AltEVV_EmployeeAPI_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeAPI_valid");  

		logger.log(LogStatus.INFO, "To validate the valid EmployeeAPI "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeAPI", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}

	//To validate the invalid EmployeeAPI
	@Test
	public void R2267_TC91406_AltEVV_EmployeeAPI_invalid() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeAPI_invalid");  

		logger.log(LogStatus.INFO, "To validate the invalid EmployeeAPI "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeAPI", CommonMethods.generateRandomNumberOfFixLength(30));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeAPI value exceeds the maximum length of 25 characters."));

	}

	//To validate the optional EmployeeAPI
	@Test
	public void R2267_TC91406_AltEVV_EmployeeAPI_optional() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeAPI_optional");  

		logger.log(LogStatus.INFO, "To validate the optional EmployeeAPI "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeAPI", "");


		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_emp"));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);
	}

	//To validate the null EmployeeAPI
	@Test
	public void R2267_TC91406_AltEVV_EmployeeAPI_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeAPI_optional");  

		logger.log(LogStatus.INFO, "To validate the optional EmployeeAPI "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeAPI", null);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}

}