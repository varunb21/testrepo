package AltEVV_generic.restassured.sandata.Employee;

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

//Test Case 91415: Open EVV - Alt EVV - Worker -Load Worker with Maximum Length

public class R2267_TC91415_AltEVV_Emp_Min_Value extends BaseTest{

	String field = "worker_ssn";

	//Validate valid employee with max assigned value in JSON
	@Test(priority=0)
	public void R2267_TC91415_AltEVV_Emp_Max_Value_JSON_Validation() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91415_AltEVV_Emp_Max_Value_JSON_Validation ");  

		logger.log(LogStatus.INFO, "Validate valid employee with max assigned value in JSON"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpTC91415_AltEVV("Staff_intake");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		String resp = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(resp, jsonObject);

	}

	//Validate valid employee with max assigned value in DB
	@Test(priority=1)
	public void R2267_TC91415_AltEVV_Emp_Max_Value_DB_Validation() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91415_AltEVV_Emp_Max_Value_DB_Validation");  

		logger.log(LogStatus.INFO, "Validate valid employee with max assigned value in DB"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpTC91415_AltEVV("Staff_intake");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		String resp = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(resp, jsonObject);


	}
}