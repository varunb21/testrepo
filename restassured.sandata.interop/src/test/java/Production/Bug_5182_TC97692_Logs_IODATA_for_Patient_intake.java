package Production;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;

public class Bug_5182_TC97692_Logs_IODATA_for_Patient_intake extends BaseTest {

	@Test
	public void Bug_5182_TC97692_Logs_IODATA_for_Patient_intake_valid_case() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("Bug_5182_TC97692_Logs_IODATA_for_Patient_intake_valid_case"); 

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject jsonobject = (JSONObject) jsonArr.get(0);
	

		String bodyAsString = CommonMethods.captureResponse_ohio(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_patient));

		Assertion_DbVerifier.jsonAssert_iodata_ohio(bodyAsString, CommonMethods.capturegetIDonly(bodyAsString));
		
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("3PPatient_get"));

		Assertion_DbVerifier.jsonAssert_iodata_ohio(bodyAsStringget, CommonMethods.capturegetIDonly(bodyAsStringget));
	}


}
