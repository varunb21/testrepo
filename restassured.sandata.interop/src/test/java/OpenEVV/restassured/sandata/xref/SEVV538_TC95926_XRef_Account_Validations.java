/**
 * @author Anupam
 *
 */
package OpenEVV.restassured.sandata.xref;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 95926:Open EVV- Xref: Validate xref relation when Account = Valid/Invalid

public class SEVV538_TC95926_XRef_Account_Validations extends BaseTest{


	// Case1 Validate invalid Account number length (>10)

	@Test 
	public void TC95926_OpenEVV_XRef_invalid_Account_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95926_OpenEVV_XRef_invalid_Account_length");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95926_OpenEVV_XRef_invalid_Account_length"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(11));

		logger.log(LogStatus.INFO, "Passing  invalid Account length");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
	}

	// Case2 Validate Account number = null

	@Test 
	public void TC95926_OpenEVV_XRef_Account_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95926_OpenEVV_XRef_Account_null");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95926_OpenEVV_XRef_Account_null"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", null);

		logger.log(LogStatus.INFO, "Passing Account with null");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
	}

	// Case3 Validate Account number with invalid value

	@Test 
	public void TC95926_OpenEVV_XRef_Account_with_invalidvalue() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95926_OpenEVV_XRef_Account_with_invalidvalue");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95926_OpenEVV_XRef_Account_with_invalidvalue"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(5));

		logger.log(LogStatus.INFO, "Passing Account with invalid value");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
	}

	// Case4 Validate Account number with leading spaces

	@Test 
	public void TC95926_OpenEVV_XRef_Account_with_leadingspaces() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95926_OpenEVV_XRef_Account_with_leadingspaces");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95926_OpenEVV_XRef_Account_with_leadingspaces"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", " "+CommonMethods.generateRandomNumberOfFixLength(5));

		logger.log(LogStatus.INFO, "Passing Account with leading spaces");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
	}

	// Case5 Validate Account number with trailing spaces

	@Test 
	public void TC95926_OpenEVV_XRef_Account_with_trailingspaces() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95926_OpenEVV_XRef_Account_with_trailingspaces");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95926_OpenEVV_XRef_Account_with_trailingspaces"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(5) + " ");

		logger.log(LogStatus.INFO, "Passing Account with trailing spaces");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
	}

	// Case6 Validate Account number with Special chars

	@Test 
	public void TC95926_OpenEVV_XRef_Account_with_specialchars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95926_OpenEVV_XRef_Account_with_specialchars");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95926_OpenEVV_XRef_Account_with_specialchars"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(5) +CommonMethods.generateSpecialChar(3));

		logger.log(LogStatus.INFO, "Passing Account with special chars");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
	}

	// Case7 Validate Account number with valid records

	@Test 
	public void TC95926_OpenEVV_XRef_Account_with_validrecords() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95926_OpenEVV_XRef_Account_with_validrecords");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95926_OpenEVV_XRef_Account_with_validrecords"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", 14420);
		/*String val3= js.get("Account").toString();

					String val1= "stx_id";

					DataBaseVerifier_xref.DataBaseVerificationxref_inbox(val1, val3); */

		logger.log(LogStatus.INFO, "Passing Account with valid records");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	// Case8 Validate Account number with NULL

	@Test 
	public void TC95926_OpenEVV_XRef_Account_with_NULL() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95926_OpenEVV_XRef_Account_with_NULL");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95926_OpenEVV_XRef_Account_with_NULL"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", "NULL");

		logger.log(LogStatus.INFO, "Passing Account with NULL");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
	}

	// Case9 Validate Account number with ""

	@Test 
	public void TC95926_OpenEVV_XRef_Account_with_commas() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC95926_OpenEVV_XRef_Account_with_commas");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95926_OpenEVV_XRef_Account_with_commas"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", "");

		logger.log(LogStatus.INFO, "Passing Account with commas");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
	}		

	// Case10 Validate Account number with valid record and stored in database

	@Test 
	public void TC95926_OpenEVV_XRef_valid_Account_with_DBvalidation() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95926_OpenEVV_XRef_valid_Account_with_DBvalidation");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95926_OpenEVV_XRef_valid_Account_with_DBvalidation"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", "10010");
		js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(9));
		String val3= js.get("Account").toString();
		String val1= "stx_id";

		DataBaseVerifier_xref.DataBaseVerificationxref_inbox(val1, val3);

		//assigning db value to local variables.

		String workeridqlf =DataBaseVerifier_xref.workeridqlf;
		String clientidqlf =DataBaseVerifier_xref.clientidqlf;
		String clientid =DataBaseVerifier_xref.clientid;
		String workerid =DataBaseVerifier_xref.workerid;


		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);

		logger.log(LogStatus.INFO, "Validating Json response ");


		// assert validation of start date in both schema to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		logger.log(LogStatus.INFO, "Validating DB response ");
		Assert.assertEquals(DataBaseVerifier_xref.workeridqlf,workeridqlf );
		Assert.assertEquals(DataBaseVerifier_xref.clientidqlf,clientidqlf );
		Assert.assertEquals(DataBaseVerifier_xref.clientid,clientid );
		Assert.assertEquals(DataBaseVerifier_xref.workerid,workerid );
	}				
}
