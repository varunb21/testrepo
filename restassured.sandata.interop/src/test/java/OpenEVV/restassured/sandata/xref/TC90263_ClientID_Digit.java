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
//Test Case 90263:Open EVV - xref - ClientID should accept only Digits (No alphaNumeric)

public class TC90263_ClientID_Digit extends BaseTest
{

	//To validate the valid ClientID with digit only
	@Test 
	public void TC90263_OpenEVV_XRef_ClientID_valid_Digit_only() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90263_OpenEVV_XRef_ClientID_valid_Digit_only");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the valid ClientID with digit only"); // adding what you are verifing



		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(5));
		logger.log(LogStatus.INFO, "Passing ClientID as Random ");
  
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
//		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
//		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
//		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));



logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}



}
