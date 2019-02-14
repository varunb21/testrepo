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

public class TC89932_Client_BillRate extends BaseTest{

	//To validate the valid numeric BillRate length
	@Test
	public void TC89932_OpenEVV_valid_numeric_BillRate() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89932_OpenEVV_valid_numeric_BillRate"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "1.2345");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid BillRate length
	@Test
	public void TC89932_OpenEVV_invalid_BillRate_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89932_OpenEVV_invalid_BillRate_length"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "1.23456");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate length is invalid. The length should be between 0 and 6."));
	}

	//To validate the BillRate with comma
	@Test
	public void TC89932_OpenEVV_BillRate_comma() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89932_OpenEVV_BillRate_comma"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "1,2345");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate format is incorrect"));

	}

	//To validate the BillRate with underscore
	@Test
	public void TC89932_OpenEVV_BillRate_underscore() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89932_OpenEVV_BillRate_underscore"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "1_2345");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate format is incorrect"));
	}

	//To validate the BillRate with leading space
	@Test
	public void TC89932_OpenEVV_leading_space_BillRate() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89932_OpenEVV_leading_space_BillRate"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", " " + "1.234");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate format is incorrect"));
	}

	//To validate the BillRate with trailing space
	@Test
	public void TC89932_OpenEVV_trailing_space_BillRate() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89932_OpenEVV_trailing_space_BillRate"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "1.234" + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate format is incorrect"));

	}

	//To validate the negative BillRate
	@Test
	public void TC89932_OpenEVV_negative_BillRate() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89932_OpenEVV_negative_BillRate"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "-1.23");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate format is incorrect"));

	}

}