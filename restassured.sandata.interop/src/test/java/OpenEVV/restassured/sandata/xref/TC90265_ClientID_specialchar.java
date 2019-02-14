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

//Test Case 90265:Open EVV - xref - ClientId field should accept only Digits (No special Characters)

public class TC90265_ClientID_specialchar extends BaseTest

{
	//To validate the invalid ClientID with special character
	@Test 
	public void TC90265_OpenEVV_XRef_ClientID_invalid_special_char() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90265_OpenEVV_XRef_ClientID_invalid_special_char");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the invalid ClientID with special character"); // adding what you are verifing


		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateSpecialChar(6));
		logger.log(LogStatus.INFO, "Passing ClientID as Special Character ");
  
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}


}
