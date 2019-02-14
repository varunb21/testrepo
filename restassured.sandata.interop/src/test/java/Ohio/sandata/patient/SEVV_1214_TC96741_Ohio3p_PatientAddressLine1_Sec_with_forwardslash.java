/**
 * 
 */
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

/**
 * @author Anupam
 *
 */
public class SEVV_1214_TC96741_Ohio3p_PatientAddressLine1_Sec_with_forwardslash extends BaseTest{
	
	@Test
	public void TC96741_Ohio3p_PatientAddressLine1_Sec_with_forwardslash() throws IOException, ParseException, ConfigurationException, SQLException, Exception {
		
		logger =extent.startTest("TC96741_Ohio3p_PatientAddressLine1_Sec_with_forwardslash");
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAdd1 = 	(JSONArray) jsonObject.get(globalVariables.Addressjson);
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrayAdd1.get(1);
		
		jsonObjectAdd1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(2) +"/" +CommonMethods.generateRandomStringOfFixLength(1) + CommonMethods.generateRandomStringOfFixLength(3));
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("3P_patient"));
		
		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsString, jsonObject);
		
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("3PPatient_get"));
				
		Assert.assertTrue(bodyAsStringget.contains("\"status\": null,"));
		Assert.assertTrue(bodyAsStringget.contains("\"data\": \"All records uploaded successfully.\""));
	
		
	}

}
