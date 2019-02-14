/**
 * 
 */
package OpenEVV.restassured.sandata.xref;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

/**
 * @author RRohiteshwar
 *
 */
//Test Case 89739:open evv-Xref- Invalid Employee pin

public class TC89739_EmployeePin extends BaseTest {
	

		//To validate the invalid EmployeePIN more than 9
		@Test 
		public void TC89739_OpenEVV_XRef_TC89739_OpenEVV_XRef_EmployeePIN_invalid_more_than_9() throws IOException, ParseException, ConfigurationException
		{
			logger = extent.startTest("TC89739_OpenEVV_XRef_TC89739_OpenEVV_XRef_EmployeePIN_invalid_more_than_9");  // adding method name info via logger
			 
			logger.log(LogStatus.INFO, "To validate the invalid EmployeePIN more than 9"); // adding what you are verifing
			
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(10));
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");
	   
			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}

		//To validate the invalid EmployeePIN less than 4
		@Test 
		public void TC89739_OpenEVV_XRef_EmployeePIN_invalid_less_than_49() throws IOException, ParseException, ConfigurationException
		{
			logger = extent.startTest("TC89739_OpenEVV_XRef_EmployeePIN_invalid_less_than_49");  // adding method name info via logger
			 
			logger.log(LogStatus.INFO, "To validate the invalid EmployeePIN less than 4"); // adding what you are verifing
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(3));
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");
	
			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}

		//To validate the invalid EmployeePIN with alpha numeric
		@Test 
		public void TC89739_OpenEVV_XRef_EmployeePIN_invalid_alpha_num() throws IOException, ParseException, ConfigurationException
		{
			logger = extent.startTest("TC89739_OpenEVV_XRef_EmployeePIN_invalid_alpha_num");  // adding method name info via logger
			 
			
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN", CommonMethods.generateRandomAlphaNumeric(5));
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");
	
			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}

		//To validate the invalid EmployeePIN with special character
		@Test 
		public void TC89739_OpenEVV_XRef_EmployeePIN_invalid_special_char() throws IOException, ParseException, ConfigurationException
		{
			logger = extent.startTest("TC89739_OpenEVV_XRef_EmployeePIN_invalid_special_char");  // adding method name info via logger
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN", CommonMethods.generateSpecialChar(6));
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");

			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}

		//To validate the invalid EmployeePIN with leading space
		@Test 
		public void TC89739_OpenEVV_XRef_EmployeePIN_invalid_leading_Space() throws IOException, ParseException, ConfigurationException
		{
			logger = extent.startTest("TC89739_OpenEVV_XRef_EmployeePIN_invalid_leading_Space");  // adding method name info via logger
			 
			
			
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN"," " + CommonMethods.generateRandomNumberOfFixLength(6));
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");

			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}
		
		//To validate the invalid EmployeePIN with trailing space
		@Test 
		public void TC89739_OpenEVV_XRef_EmployeePIN_invalid_trailing_space() throws IOException, ParseException, ConfigurationException
		{
			logger = extent.startTest("TC89739_OpenEVV_XRef_EmployeePIN_invalid_trailing_space");  // adding method name info via logger
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN",CommonMethods.generateRandomNumberOfFixLength(6)+" ");
			
			 
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");

			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}
	}

