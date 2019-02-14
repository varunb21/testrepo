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

public class BUG_SEVV_2267_TC94010_Validate_Response_when_StaffSSN_and_SequenceID_changed extends BaseTest{


	@Test 
	public void SEVV_2267_TC94010_Validate_the_response_when_StaffSSN_and_SequenceID_is_changed_while_the_other_fields_remains_the_same() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC94010_Validate_the_response_when_StaffSSN_and_SequenceID_is_changed_while_the_other_fields_remains_the_same");
		logger.log(LogStatus.INFO, "Validate_the_response_when_StaffSSN_and_SequenceID_is_changed_while_the_other_fields_remains_the_same");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.EmpSSN,CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject.put(globalVariables.SequenceID, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString1 = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));


		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString1, jsonObject);
	}

}
