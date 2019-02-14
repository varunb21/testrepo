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

//Test Case 89803:Open EVV - Xref - Invalid XRefEndDate

public class TC89803_XrefEndDate_invalid extends BaseTest
{

	//To validate the invalid Xref end date with ramdom digit (072320188)
	@Test 
	public void TC89803_OpenEVV_xrefStartDate_invalid_RandomDigit() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89803_OpenEVV_xrefStartDate_invalid_RandomDigit");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the invalid Xref end date with ramdom digit (072320188)"); // adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("XRefStartDate",CommonMethods.generateTodayDate_MMddyyyy());
		js.put("XRefEndDate", "072320188");
		logger.log(LogStatus.INFO, "Passing XRefStartDate as Random and XRefEndDate as 072320188");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The XRefEndDate format is incorrect."));
	}

	//To validate the invalid Xref end date with invalid format ("07/23/2018")
	@Test 
	public void TC89803_OpenEVV_xrefStartDate_invalid_format_case1() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89803_OpenEVV_xrefStartDate_invalid_format_case1");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the invalid Xref end date with invalid format (07/23/2018)"); // adding what you are verifing


		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("XRefStartDate",CommonMethods.generateTodayDate_MMddyyyy() );
		js.put("XRefEndDate", "07/23/2018");
		logger.log(LogStatus.INFO, "Passing XRefStartDate as Random and XRefEndDate as 07/23/2018 ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The XRefEndDate format is incorrect."));
	}

	//To validate the invalid Xref end date with invalid format "07-23-2018" 
	@Test 
	public void TC89803_OpenEVV_xrefStartDate_invalid_format_case2() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89803_OpenEVV_xrefStartDate_invalid_format_case2");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the invalid Xref end date with invalid format 07-23-2018"); // adding what you are verifing


		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("XRefStartDate", CommonMethods.generateTodayDate_MMddyyyy());
		js.put("XRefEndDate", "07-23-2018");
		logger.log(LogStatus.INFO, "Passing XRefStartDate as Random and XRefEndDate as 07-23-2018  ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		//Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		//Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The XRefEndDate format is incorrect."));
	}

}
