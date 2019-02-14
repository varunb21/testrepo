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

//Test Case 91414: Open EVV-Alt EVV-Worker-Load-Values with Minimum Length

public class R2267_TC91414_AltEVV_Emp_max_value extends BaseTest{

	String field = "worker_ssn";

	//validate the Staff Intake JSON with min value only in json repsonse
	@Test(priority=0)
	public void R2267_TC91414_AltEVV_Emp_Min_Value_JSON_Validation() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91414_AltEVV_Emp_Min_Value_JSON_Validation ");  

		logger.log(LogStatus.INFO, "validate the Staff Intake JSON with min value only in json repsonse"); 

		JSONArray jsonArray = CommonMethods.LoadJSON_AltEVV("Staff_intake_min_value");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeSSN", CommonMethods.generateRandomNumberOfFixLength(9));
		
		String resp = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(resp, jsonObject);


	}

	//validate the Staff Intake JSON with min value only in DB repsonse
	@Test (priority=1)
	public void R2267_TC91414_AltEVV_Emp_Min_Value_DB_Validation() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91414_AltEVV_Emp_Min_Value_DB_Validation ");  

		logger.log(LogStatus.INFO, "// validate the Staff Intake JSON with min value in DB only"); 
		JSONArray jsonArray = CommonMethods.LoadJSON_AltEVV("Staff_intake_min_value");
		
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeSSN", CommonMethods.generateRandomNumberOfFixLength(9));
		String resp = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(resp, jsonObject);

	}

}