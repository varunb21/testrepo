package OpenEVV.restassured.sandata.Client;

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

import java.io.IOException;

// Test Case 90276:Open EVV-Client-Validate (mix) - ClientZip field formats/values under ClientAddress

public class TC90276_ClientZip extends BaseTest{

	// case-1 To validate the valid ClientZip having numeric value equal to 9 with dash
	@Test
	public void TC90276_OpenEVV_ClientZip_valid_numeric_equal_9_with_dash() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_ClientZip_valid_numeric_equal_9_with_dash");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(5)+ "-"+ CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//case-2 To validate the ClientZip having numeric value equal to 9 heading 0
	@Test
	public void TC90276_OpenEVV_ClientZip_valid_numeric_equal_9_heading_0() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_ClientZip_valid_numeric_equal_9_heading_0");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", "0" +CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientZip format is incorrect."));
	}
	
	//case-3 To validate the valid ClientZip having numeric value 5
	@Test
	public void TC90276_OpenEVV_ClientZip_valid_numeric_value_5() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_ClientZip_valid_numeric_value_5");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//case-4 To validate the valid ClientZip having numeric value 5 with heading 0
	@Test
	public void TC90276_OpenEVV_ClientZip_valid_numeric_heading_0() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_ClientZip_valid_numeric_heading_0");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", "0" +CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}
	
	//case-5 To validate the valid ClientZip having numeric value 5 with heading 0
	@Test
	public void TC90276_OpenEVV_invalid_ClientZip_numeric_with_dashes() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_invalid_ClientZip_numeric_with_dashes");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(3) + "-" + CommonMethods.generateRandomNumberOfFixLength(2) + "-" +CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientZip format is incorrect."));
	}
	
	//case-6 To validate the valid ClientZip having numeric value less than 10
	@Test
	public void TC90276_OpenEVV_valid_ClientZip_numeric_less_than_10() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_invalid_ClientZip_numeric_less_than_10");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}
	
	//case-7 To validate the invalid ClientZip having alphanumeric
	@Test
	public void TC90276_OpenEVV_invalid_ClientZip_alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_invalid_ClientZip_alphanumeric");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", "Z" +CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientZip format is incorrect."));
	}
	
	//case-8 To validate the invalid ClientZip having embedded alphas not allowed
	@Test
	public void TC90276_OpenEVV_invalid_ClientZip_embedded_Alpha() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_invalid_ClientZip_embedded_Alpha");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(3) + "A" + CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientZip format is incorrect."));
	}
	
	//case-9 To validate the invalid ClientZip with special chars
	@Test
	public void TC90276_OpenEVV_invalid_ClientZip_with_specialchars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_invalid_ClientZip_with_specialchars");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(5) + "@" + CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientZip format is incorrect."));
	}
	
	//case-10 To validate the invalid ClientZip with leading space
	@Test
	public void TC90276_OpenEVV_invalid_ClientZip_with_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_invalid_ClientZip_with_leading_space");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", " " +CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientZip format is incorrect."));
	}
	
	//Case-11 To validate the invalid ClientZip with trailing space
	@Test
	public void TC90276_OpenEVV_invalid_ClientZip_with_trailing_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_invalid_ClientZip_with_trailing_space");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(9) +" ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientZip format is incorrect."));
	}
	
	//Case-12 To validate the invalid ClientZip with null
	@Test
	public void TC90276_OpenEVV_invalid_ClientZip_with_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90276_OpenEVV_invalid_ClientZip_with_null");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientZip cannot be null."));
	}
}