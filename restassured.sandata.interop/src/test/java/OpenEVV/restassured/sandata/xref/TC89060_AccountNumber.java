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
//Test Case 89060:Open EVV -xref -account number should be valid

public class TC89060_AccountNumber extends BaseTest{

	//To validate the valid Account number in between 4 to 10
	@Test 
	public void TC89060_OpenEVV_XRef_Acc_num_valid_between_4_10() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89060_OpenEVV_XRef_Acc_num_valid_between_4_10");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the valid Account number in between 4 to 10"); // adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", "14420");
		logger.log(LogStatus.INFO, "Passing Account as 14420 ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid Account number more than  10
	@Test 
	public void TC89060_OpenEVV_XRef_Acc_num_valid_above_10() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89060_OpenEVV_XRef_Acc_num_valid_above_10");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the valid Account number more than  10"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(11));
		logger.log(LogStatus.INFO, "Passing Account as Random ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));

		//		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid Account number less than 4
	@Test 
	public void TC89060_OpenEVV_XRef_Acc_num_valid_less_4() throws IOException, ParseException, ConfigurationException
	{
		
		logger = extent.startTest("TC89060_OpenEVV_XRef_Acc_num_valid_less_4");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the valid Account number less than  10"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(3));
		logger.log(LogStatus.INFO, "Passing Account as Random ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		//Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
}
}
