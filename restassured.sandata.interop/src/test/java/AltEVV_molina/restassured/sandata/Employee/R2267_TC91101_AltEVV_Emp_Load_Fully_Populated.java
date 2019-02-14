package AltEVV_molina.restassured.sandata.Employee;

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
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */
//Test Case 91101: Alt EVV-Worker-Load-Fully Populated

public class R2267_TC91101_AltEVV_Emp_Load_Fully_Populated extends BaseTest{

	//Validate valid employee with fully populated value in JSON
	@Test(priority=0)
	public void R2267_TC91101_AltEVV_Emp_Load_Fully_Populated_Json_Validation() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91101_AltEVV_Emp_Load_Fully_Populated_Json_Validation");  

		logger.log(LogStatus.INFO, "Validate valid employee with fully populated value in JSON"); 
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	

	}

	//Validate valid employee with fully populated value in DB
	@Test (priority=1)
	public void R2267_TC91101_AltEVV_Emp_Load_Fully_Populated_DB_Validation() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91101_AltEVV_Emp_Load_Fully_Populated_DB_Validation ");  

		logger.log(LogStatus.INFO, "Validate valid employee with fully populated value in DB"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	


	}

}