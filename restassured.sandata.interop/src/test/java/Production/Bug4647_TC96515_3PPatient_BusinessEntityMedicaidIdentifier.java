package Production;

import java.io.FileNotFoundException;
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
import io.restassured.path.json.JsonPath;

/**
 * @author Rahul Rohit
 *
 */
public class Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier extends BaseTest {

	@Test
	public void Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier_valid_10010() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier"); 

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject js = (JSONObject) jsonArr.get(0);
		js.put("BusinessEntityID", "10010");
		js.put("BusinessEntityMedicaidIdentifier", "0010010");

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("3PPatient_get"));

		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, js);

	}

	@Test
	public void Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier_valid_0010010() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier"); 

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject js = (JSONObject) jsonArr.get(0);
		js.put("BusinessEntityID", "10010");
		js.put("BusinessEntityMedicaidIdentifier", "0010010");

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("3PPatient_get"));

		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, js);
	}

	@Test
	public void Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier_valid_010010() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier"); 

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject js = (JSONObject) jsonArr.get(0);
		js.put("BusinessEntityID", "10010");
		js.put("BusinessEntityMedicaidIdentifier", "010010");

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("3PPatient_get"));

		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, js);

	}
}
