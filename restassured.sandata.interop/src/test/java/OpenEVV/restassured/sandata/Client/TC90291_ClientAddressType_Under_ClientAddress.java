/**
 * 
 */
package OpenEVV.restassured.sandata.Client;

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

/**
 * @author RRohiteshwar
 *
 */
//Test Case 90291:Open EVV-Client-Validate (mix) - ClientAddressType field/format under ClientAddress

public class TC90291_ClientAddressType_Under_ClientAddress extends BaseTest
{

	// Validating with valid ClientAddressType Under ClientAddress_BUSINESS
	@Test(priority=1)
	public void TC90291_OpenEVV_Client_valid_AddressType_Under_ClientAddress_BUSINESS() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90291_OpenEVV_Client_valid_AddressType_Under_ClientAddress_BUSINESS");

		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("AddressType",DataGeneratorClient.clientAddressType());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//Validating with invalid ClientAddressType Under ClientAddress_AddressType other than Business|Home|Other
	@Test(priority=4)
	public void TC90291_OpenEVV_invalid_AddressType_Under_ClientAddress () throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90291_OpenEVV_invalid_AddressType_Under_ClientAddress");

		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("AddressType",CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains(" \"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The AddressType format is incorrect. The record should satisfy this regular expression"));


	}

	//Validating with invalid ClientAddressType Under ClientAddress_AddressType other than Business|Home|Other
	@Test(priority=5)
	public void TC90291_OpenEVV_invalid_AddressType_Under_ClientAddress_greater_than_12Char () throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90291_OpenEVV_invalid_AddressType_Under_ClientAddress_greater_than_12Char");

		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("AddressType",CommonMethods.generateRandomStringOfFixLength(14));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains(" \"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The AddressType format is incorrect. The record should satisfy this regular expression"));


	}


}
