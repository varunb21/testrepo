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

/**
 * @author rahul Rohit
 *
 */
public class Bug4647_TC96531_3PStaff_BusinessEntityMedicaidIdentifier extends BaseTest {

	@Test
	public void Bug4647_TC96515_3PStaff_BusinessEntityMedicaidIdentifier_valid_10010() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("Bug4647_TC96515_3PStaff_BusinessEntityMedicaidIdentifier_valid_10010"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_3P(globalVariables.ThreeP_Staff_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);
		js.put("BusinessEntityID", "10010");
		js.put("BusinessEntityMedicaidIdentifier", "10010");

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_Staff"));
		
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("3P_Staff_get"));
	
		Assertion_DbVerifier.jsonAssert_InboxWorker_3P(bodyAsStringget, js);
	
	}

	@Test
	public void Bug4647_TC96515_3PStaff_BusinessEntityMedicaidIdentifier_valid_010010() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("Bug4647_TC96515_3PStaff_BusinessEntityMedicaidIdentifier_valid_10010"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_3P(globalVariables.ThreeP_Staff_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);
		js.put("BusinessEntityID", "10010");
		js.put("BusinessEntityMedicaidIdentifier", "010010");

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_Staff"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("3P_Staff_get"));
	
		Assertion_DbVerifier.jsonAssert_InboxWorker_3P(bodyAsStringget, js);
	
	}

	@Test
	public void Bug4647_TC96515_3PStaff_BusinessEntityMedicaidIdentifier_valid_0010010() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("Bug4647_TC96515_3PStaff_BusinessEntityMedicaidIdentifier_valid_0010010"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_3P(globalVariables.ThreeP_Staff_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);
		js.put("BusinessEntityID", "10010");
		js.put("BusinessEntityMedicaidIdentifier", "0010010");

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_Staff"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("3P_Staff_get"));

		Assertion_DbVerifier.jsonAssert_InboxWorker_3P(bodyAsStringget, js);
	
	}

}
