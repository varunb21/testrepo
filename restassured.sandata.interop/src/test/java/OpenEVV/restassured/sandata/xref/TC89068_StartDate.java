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

//Test Case 89068:Inter-op-Open EVV-Xref- Xref start date should not be greater than Xref end date.

public class TC89068_StartDate extends BaseTest
{

	//To validate the valid Xref start date that is same as Xref end date.
	@Test 
	public void TC89068_OpenEVV_xrefStartDate_same_xrefEndDate_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89068_OpenEVV_xrefStartDate_same_xrefEndDate_valid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the valid Xref start date that is same as Xref end date"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("XRefStartDate", CommonMethods.generateTodayDate_MMddyyyy());
		js.put("XRefEndDate", CommonMethods.generateTodayDate_MMddyyyy());

		logger.log(LogStatus.INFO, "Passing XRefStartDate and XRefEndDate  as Random ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		//Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		//Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid Xref start date that is lower than Xref end date.
	@Test 
	public void TC89068_OpenEVV_xrefStartDate_lowerthan_Than_xrefEndDate_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89068_OpenEVV_xrefStartDate_lowerthan_Than_xrefEndDate_valid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the valid Xref start date that is lower than Xref end date."); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("XRefStartDate", CommonMethods.generateTodayDate_MMddyyyy());
		js.put("XRefEndDate", CommonMethods.generateFutureDate_MMddyyyy());
		logger.log(LogStatus.INFO, "Passing XRefStartDate and XRefEndDate as Random ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		//Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		//Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid Xref start date that is greater than Xref end date.
	@Test 
	public void TC89068_OpenEVV_xrefStartDate_Greater_Than_xrefEndDate_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89068_OpenEVV_xrefStartDate_Greater_Than_xrefEndDate_invalid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the valid Xref start date that is greater than Xref end date."); // adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("XRefStartDate", CommonMethods.generateFutureDate_MMddyyyy());
		js.put("XRefEndDate",CommonMethods.generateTodayDate_MMddyyyy());
		logger.log(LogStatus.INFO, "Passing XRefStartDate and XRefEndDate as Random ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The XRefStartDate cannot be greater than XRefEndDate."));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

}
