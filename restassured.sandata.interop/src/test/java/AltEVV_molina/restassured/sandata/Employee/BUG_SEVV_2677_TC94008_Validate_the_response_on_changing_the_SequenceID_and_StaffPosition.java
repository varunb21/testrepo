package AltEVV_molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorEmployee;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class BUG_SEVV_2677_TC94008_Validate_the_response_on_changing_the_SequenceID_and_StaffPosition extends BaseTest{
	

	@Test 
	public void SEVV_2677_TC94008_Validate_the_response_on_changing_the_SequenceID_and_StaffPosition() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC94008_Validate_the_response_on_changing_the_SequenceID_and_StaffPosition");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.SequenceID,CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject.put(globalVariables.EmployeePosition, DataGeneratorEmployee.generateStaffPosition());

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);

	}


}
