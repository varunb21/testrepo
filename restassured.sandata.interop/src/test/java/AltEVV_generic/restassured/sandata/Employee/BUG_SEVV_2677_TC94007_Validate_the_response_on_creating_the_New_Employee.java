package AltEVV_generic.restassured.sandata.Employee;

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

public class BUG_SEVV_2677_TC94007_Validate_the_response_on_creating_the_New_Employee extends BaseTest{
	
	@Test 
	public void BUG_SEVV_2677_TC94007_Validate_the_response_on_creating_the_New_Employee_with_valid_details() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC94007_Validate_the_response_on_creating_the_New_Employee_with_valid_details ");  

		logger.log(LogStatus.INFO, "Validate response for valid employee with fully populated value in DB"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		String empfirstname = CommonMethods.generateRandomStringOfFixLength(20);
		jsonObject.put("EmployeeFirstName",empfirstname );
		
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);

	}

}
