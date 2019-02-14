package Ohio.sandata.visits;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2106_TC97055_Validate_message_in_case_error_in_sub_segments extends BaseTest{
	
	@Test
	public void SEVV_2106_TC97055_Validate_message_summary_in_case_error_in_sub_segments_of_get() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("SEVV_2106_TC97055_Validate_message_summary_in_case_error_in_sub_segments_of_get"); 

		JSONArray jsonArr=GenerateUniqueParam.VisitParam_3P(globalVariables.ThreeP_visit_Json);
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("VisitException");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("ExceptionAcknowledged", "");
		jsonObjectPay.put("ExceptionID", "");
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_Visit"));

		String bodyAsStringget=CommonMethods.captureGetResponse3P_fail(bodyAsString, CommonMethods.propertyfileReader("3P_Visit_get"));

		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"The uploaded record(s) has(have) been processed with some error or warning message(s). Please check individual record to see whether it was loaded successfully or rejected.\","));
	}

}
