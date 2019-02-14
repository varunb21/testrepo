/**
 * 
 */
package Ohio.sandata.workers;
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
public class SEVV_1214_TC96643_Ohio3p_StaffFirstName_with_characters extends BaseTest {
	@Test
	public void TC96643_Ohio3p_StaffFirstName_with_characters() throws IOException, ParseException, ConfigurationException, SQLException, Exception {

			logger = extent.startTest("SEVV_2106_TC96556_Worker_Validate_message_summary_Get_response_in_case_of_rejection"); 

			JSONArray jsonArr=GenerateUniqueParam.EmpParams_3P(globalVariables.ThreeP_Staff_Json);

			JSONObject jsonobject = (JSONObject) jsonArr.get(0);
			jsonobject.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(4));

			String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_Staff"));
			
			String bodyAsStringget=CommonMethods.captureGetResponse3P_fail(bodyAsString, CommonMethods.propertyfileReader("3P_Staff_get"));
		
			Assert.assertTrue(bodyAsStringget.contains("\"status\": null,"));
			
			Assert.assertTrue(bodyAsStringget.contains("\"data\": \"All records uploaded successfully.\""));
			
			Assertion_DbVerifier.jsonAssert_InboxWorker_3P(bodyAsString, jsonobject);
		
		}
	
	@Test
	public void TC96643_Ohio3p_StaffFirstName_with_singlebrackets() throws IOException, ParseException, ConfigurationException, SQLException, Exception {

			logger = extent.startTest("TC96643_Ohio3p_StaffFirstName_with_singlebrackets"); 

			JSONArray jsonArr=GenerateUniqueParam.EmpParams_3P(globalVariables.ThreeP_Staff_Json);

			JSONObject jsonObject = (JSONObject) jsonArr.get(0);
			jsonObject.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(2) +"(" + CommonMethods.generateRandomStringOfFixLength(3));

			String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_Staff"));
			
			String bodyAsStringget=CommonMethods.captureGetResponse3P_fail(bodyAsString, CommonMethods.propertyfileReader("3P_Staff_get"));
		
			Assert.assertTrue(bodyAsStringget.contains("\"status\": null,"));
			
			Assert.assertTrue(bodyAsStringget.contains("\"data\": \"All records uploaded successfully.\""));
			
			Assertion_DbVerifier.jsonAssert_InboxWorker_3P(bodyAsString, jsonObject);
		
		}
		
	@Test
	public void TC96643_Ohio3p_StaffFirstName_with_brackets() throws IOException, ParseException, ConfigurationException, SQLException, Exception {

			logger = extent.startTest("TC96643_Ohio3p_StaffFirstName_with_brackets"); 

			JSONArray jsonArr=GenerateUniqueParam.EmpParams_3P(globalVariables.ThreeP_Staff_Json);

			JSONObject jsonObject = (JSONObject) jsonArr.get(0);
			jsonObject.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(2) +")" + CommonMethods.generateRandomStringOfFixLength(3));

			String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_Staff"));
			
			String bodyAsStringget=CommonMethods.captureGetResponse3P_fail(bodyAsString, CommonMethods.propertyfileReader("3P_Staff_get"));
		
			Assert.assertTrue(bodyAsStringget.contains("\"status\": null,"));
			
			Assert.assertTrue(bodyAsStringget.contains("\"data\": \"All records uploaded successfully.\""));
			
			Assertion_DbVerifier.jsonAssert_InboxWorker_3P(bodyAsString, jsonObject);
		
		}
	}


