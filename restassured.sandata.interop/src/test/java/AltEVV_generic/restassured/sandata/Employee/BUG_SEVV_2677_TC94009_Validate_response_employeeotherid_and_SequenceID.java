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
import Utills_ExtentReport_Log4j.BaseTest;

public class BUG_SEVV_2677_TC94009_Validate_response_employeeotherid_and_SequenceID extends BaseTest{

	@Test 
	public void SEVV_2677_TC94009_Validate_the_response_when_employeeotherid_and_SequenceID_is_changed_rest_other_fields_remains_sames() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC94009_Validate_employeeotherid_and_SequenceID_changed_rest_same");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.SequenceID,CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject.put(globalVariables.EmployeeOtherID, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString1 = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString1, jsonObject);


	}

}
