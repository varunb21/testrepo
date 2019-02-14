/**
 * 
 */
package OpenEVV.restassured.sandata.xref.copy;

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
//Test Case 89796:Open EVV - xref - ClientID-Field should not accept more than 5 digits

public class TC89796_ClientID extends BaseTest{

	//To validate the invalid ClientID more than 5
	@Test 
	public void TC89796_OpenEVV_XRef_ClientID_invalid_more_than_5() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89796_OpenEVV_XRef_ClientID_invalid_more_than_5");
		logger.log(LogStatus.INFO, "To validate the invalid ClientID more than 5"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(6));
		logger.log(LogStatus.INFO, "Passing ClientID as Random ");
   
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid ClientID less than 5
	@Test 
	public void TC89796_OpenEVV_XRef_ClientID_invalid_less_than_5() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89796_OpenEVV_XRef_ClientID_invalid_less_than_5");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the invalid ClientID less than 5"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(4));
		logger.log(LogStatus.INFO, "Passing ClientID as Random ");
 
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid ClientID with alpha numeric
	@Test 
	public void TC89796_OpenEVV_XRef_ClientID_invalid_alpha_num() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89796_OpenEVV_XRef_ClientID_invalid_alpha_num");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the invalid ClientID with alpha numeric"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomAlphaNumeric(5));
		logger.log(LogStatus.INFO, "Passing ClientID as Random ");
   
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid ClientID with leading space
	@Test 
	public void TC89796_OpenEVV_XRef_ClientID_invalid_leading_Space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89796_OpenEVV_XRef_ClientID_invalid_leading_Space");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the invalid ClientID with leading space"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID"," " + CommonMethods.generateRandomNumberOfFixLength(6));
		logger.log(LogStatus.INFO, "Passing ClientID as Random ");
  
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid ClientID with trailing space
	@Test 
	public void TC89796_OpenEVV_XRef_ClientID_invalid_trailing_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89796_OpenEVV_XRef_ClientID_invalid_trailing_space");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the invalid ClientID with trailing space"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(6)+" ");
		logger.log(LogStatus.INFO, "Passing ClientID as Random ");
	
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

}

