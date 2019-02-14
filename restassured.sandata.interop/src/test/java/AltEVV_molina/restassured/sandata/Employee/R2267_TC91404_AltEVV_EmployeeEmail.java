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
//Test Case 91404:OpenEVV-altEVV- Employee - EmployeeEmail validation field formats/values.

public class R2267_TC91404_AltEVV_EmployeeEmail extends BaseTest{

	//To validate the valid  EmployeeEmail by passing the String Value of 64char with correct format
	@Test(priority=0, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeEmail_validFormat_String_64char() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeEmail_validFormat_String_64char");  

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeEmail by passing the String Value of 64char with correct format"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(49));

		String resp = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_emp"));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(resp, js);	

	}

	//To validate the invalid  EmployeeEmail by passing the String Value of morethan 64char
	@Test(priority=1, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeEmail_invalidFormat_String_Morethan_64char() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeEmail_invalidFormat_String_Morethan_64char");  

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeEmail by passing the String Value of morethan 64char"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(60));

		String resp = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_emp"));

		Assert.assertTrue(resp.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(resp.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(resp.contains("ERROR: The EmployeeEmail value exceeds the maximum length of 64 characters. The length should be between 1 and 64."));
	}

	//To validate the invalid  EmployeeEmail by passing the String Value of 64char with incorrect format
	@Test(priority=2, groups = {"functest"})
	public void R2267_TC91389_AltEVV_EmployeeEmail_invalidFormat() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91389_AltEVV_EmployeeEmail_invalidFormat");  

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeEmail by passing the String Value of 64char with incorrect format"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(10) + ".test " + " @");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_emp"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeEmail format is incorrect"));
	}

}