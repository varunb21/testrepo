package Ohio.sandata.patient;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2106_TC97058_Validate_messagesummary_case_warning_in_subsegment extends BaseTest {
	
	@Test
	public void SEVV_2106_TC97058_Validate_messagesummary_in_case_warning_in_get_due_to_subsegment() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("SEVV_2106_TC97058_Validate_messagesummary_in_case_warning_in_get_due_to_subsegment"); 

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("BusinessEntityID", "10013");
		jsonObject.put("BusinessEntityMedicaidIdentifier", "7654321");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Phones");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("PatientPhoneNumber", "");

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3P_fail(bodyAsString, CommonMethods.propertyfileReader("3PPatient_get"));
         
		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"The uploaded record(s) has(have) been processed with some error or warning message(s). Please check individual record to see whether it was loaded successfully or rejected.\","));

	}

}
