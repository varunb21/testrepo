package Ohio.sandata.visits;

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

public class SEVV_2106_TC96557_Visit_Validate_message_in_Get_case_of_rejection extends BaseTest{
	
	@Test
	public void SEVV_2106_TC96557_Validate_visit_response_message_in_Get_case_of_rejection() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("SEVV_2106_TC96557_Validate_visit_response_message_in_Get_case_of_rejection"); 

		JSONArray jsonArr=GenerateUniqueParam.VisitParam_3P(globalVariables.ThreeP_visit_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);
		
		CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_Visit"));

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_Visit"));

		String bodyAsStringget=CommonMethods.captureGetResponse3P_fail(bodyAsString, CommonMethods.propertyfileReader("3P_Visit_get"));
        
		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"Records rejected, please review error and try again.\","));

	}

}
