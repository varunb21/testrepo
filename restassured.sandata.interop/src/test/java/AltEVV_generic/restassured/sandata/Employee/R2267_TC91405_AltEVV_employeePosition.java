package AltEVV_generic.restassured.sandata.Employee;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.globalMethods.core.*;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

/**
 * @author RRohiteshwar
 *
 */
//Test Case 91404:OpenEVV-altEVV- Employee - EmployeeEmail validation field formats/values.

public class R2267_TC91405_AltEVV_employeePosition extends BaseTest{
	SoftAssert softAssert = new SoftAssert();

	//Validate the valid employeePosition with correct set of value
	@Test(priority=0, groups = {"functest"})
	public void R2267_TC91405_AltEVV_employeePosition_valid_correctvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91405_AltEVV_employeePosition_valid_correctvalue");  

		logger.log(LogStatus.INFO, "//Validate the valid employeePosition with correct set of value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", DataGeneratorEmployee.generateStaffPosition());

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_emp"));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}
	
	//Validate the invalid employeePosition with incorrect set of value
	@Test(priority=1, groups = {"functest"})
	public void R2267_TC91405_AltEVV_invalid_employeePosition_incorrectValue() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91405_AltEVV_invalid_employeePosition_incorrectValue");  

		logger.log(LogStatus.INFO, "//Validate the invalid employeePosition with incorrect set of value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", CommonMethods.getSaltString(3));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_emp"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeePosition expected format is not correct.");


	}

	//Validate the invalid employeePosition with incorrect set of value
	@Test(priority=2, groups = {"functest"})
	public void R2267_TC91405_AltEVV_invalid_employeePosition_incorrectValue_1char() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91405_AltEVV_invalid_employeePosition_incorrectValue_1char");  

		logger.log(LogStatus.INFO, "//Validate the invalid employeePosition with incorrect set of value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", CommonMethods.getSaltString(1));
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_emp"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeePosition expected format is not correct.");

	}

	//Validate the invalid employeePosition with incorrect set of special char value
	@Test(priority=3, groups = {"functest"})
	public void R2267_TC91405_AltEVV_invalid_employeePosition_incorrectValue_specialchar() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91405_AltEVV_invalid_employeePosition_incorrectValue_specialchar");  

		logger.log(LogStatus.INFO, "//Validate the invalid employeePosition with incorrect set of special char value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", CommonMethods.getSaltString(1) +CommonMethods.generateSpecialChar(2));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_emp"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeePosition expected format is not correct.");

	}

	//Validate the invalid employeePosition with incorrect set of num only value
	@Test(priority=4, groups = {"functest"})
	public void R2267_TC91405_AltEVV_invalid_employeePosition_incorrectValue_num() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91405_AltEVV_invalid_employeePosition_incorrectValue_num");  

		logger.log(LogStatus.INFO, "//Validate the invalid employeePosition with incorrect set of num only value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", CommonMethods.generateRandomNumberOfFixLength(3));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_emp"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeePosition expected format is not correct.");


	}

	//Validate the invalid employeePosition with incorrect set of alphnum value
	@Test(priority=4, groups = {"functest"})	
	public void R2267_TC91405_AltEVV_invalid_employeePosition_incorrectValue_alphnum() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91405_AltEVV_invalid_employeePosition_incorrectValue_alphnum");  

		logger.log(LogStatus.INFO, "//Validate the invalid employeePosition with incorrect set of alphnum value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", CommonMethods.generateRandomAlphaNumeric(3));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_emp"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeePosition expected format is not correct.");


	}

}