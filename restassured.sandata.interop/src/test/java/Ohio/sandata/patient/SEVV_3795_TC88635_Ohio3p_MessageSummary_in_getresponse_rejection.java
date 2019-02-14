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

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV_3795_TC88635_Ohio3p_MessageSummary_in_getresponse_rejection extends BaseTest{
	
	public void TC88635_Ohio3p_MessageSummary_in_getresponse_rejection() throws IOException, ParseException, ConfigurationException, SQLException, Exception {
		
		logger = extent.startTest("TC88635_Ohio3p_MessageSummary_in_getresponse_rejection"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject js = (JSONObject) jsonArr.get(0);
	//	js.put("BusinessEntityMedicaidIdentifier", "10010");

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_patient"));
		
		String bodyAsStringget=CommonMethods.captureGetResponse3P_fail(bodyAsString, CommonMethods.propertyfileReader("3PPatient_get"));
		
		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"Records rejected, please review error and try again.\","));
	}

}
