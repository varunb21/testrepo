package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;


import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import static io.restassured.RestAssured.given;
//Test Case 89819:Open EVV-Client-Validate (mix) - ClientAddressType field/format
public class TC89819_ClientAddressType extends BaseTest{

	//To validate the valid ClientAddressType
	@Test
	public void TC89818_OpenEVV_ClientAddressType_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientAddressType_valid"); 



		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressType", "Other");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));
	}

	//To validate the invalid ClientAddressType length
	@Test
	public void TC89818_OpenEVV_ClientAddressType_ClientAddressType_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientAddressType_ClientAddressType_length"); 



		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressType", "Business23432");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressType format is incorrect"));
	}

	//To validate the invalid ClientAddressType
	@Test
	public void TC89818_OpenEVV_ClientAddressType_invalid_ClientAddressType() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientAddressType_invalid_ClientAddressType"); 



		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressType", "Individual");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressType format is incorrect"));
	}

	//To validate the ClientAddressType with trailing space
	@Test
	public void TC89818_OpenEVV_ClientAddressType_trailing_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientAddressType_trailing_space"); 



		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressType", "Home ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressType format is incorrect"));
	}

	//To validate the ClientAddressType with leading space
	@Test
	public void TC89818_OpenEVV_ClientAddressType_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientAddressType_leading_space"); 



		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressType", " Home");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressType format is incorrect"));
	}

}
