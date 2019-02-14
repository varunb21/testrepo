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

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

/**
 * @author RRohiteshwar
 *
 */

//Test Case 90435:Open EVV - xref - Validate xref relation for null Client ID and Employee ID

public class TC90435_ClientId_EmpId_null extends BaseTest
{

	//To validate the invalid ClientID & EmpPin with null only
	@Test 
	public void TC90435_OpenEVV_XRef_ClientID_empPin_invalid_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90435_OpenEVV_XRef_ClientID_empPin_invalid_null");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the invalid ClientID & EmpPin with null only"); // adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", null);
		js.put("EmployeePIN", null);
		logger.log(LogStatus.INFO, "Passing ClientID as null and EmployeePIN as null ");
    
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID cannot be null."));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN cannot be null."));
		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}


}
