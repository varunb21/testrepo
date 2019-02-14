package Production;

import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Client;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;

public class Bug_5182_TC97691_Logs_IODATA_Patient_request_DB extends BaseTest{

	@Test
	public void Bug_5182_TC97691_Logs_IODATA_for_Patient_intake_invalid_DB_rejected_case() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("Bug_5182_TC97691_Logs_IODATA_for_Patient_intake_invalid_DB_rejected_case"); 

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject js = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_patient"));

		 bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_patient"));

			String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("3PPatient_get"));
		
		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsString, js);
		assertNotEquals(DataBaseVerifier_Client.ncode_inClient, 0);

		Assertion_DbVerifier.jsonAssert_iodata_ohio(bodyAsStringget, CommonMethods.capturegetIDonly(bodyAsStringget));

	}
}
