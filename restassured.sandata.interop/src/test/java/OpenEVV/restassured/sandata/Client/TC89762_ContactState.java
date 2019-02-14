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

import Utills_ExtentReport_Log4j.BaseTest;

import static io.restassured.RestAssured.given;
//Test Case 89762:Open EVV-Client-Validate (mix) - ContactState field/format
public class TC89762_ContactState extends BaseTest {

	//To validate the valid ContactState
	@Test
	public void TC89762_OpenEVV_ContactState_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89762_OpenEVV_ContactState_valid");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactState", DataGeneratorClient.generateClientState());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid ContactState
	@Test
	public void TC89762_OpenEVV_ContactState_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89762_OpenEVV_ContactState_invalid");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactState", "AP");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactState format is incorrect."));

	}

	//To validate the invalid ContactState length
	@Test
	public void TC89762_OpenEVV_ContactState_invalid_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89762_OpenEVV_ContactState_invalid_length");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactState", "ALM");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactState length is invalid. The length should be between 2 and 2."));
	}

	//To validate the numeric value in ContactState
	@Test
	public void TC89762_OpenEVV_ContactState_numeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89762_OpenEVV_ContactState_numeric");  

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactState", "N1");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactState format is incorrect."));
	}

	//To validate the ContactState with trailing spaces
	@Test
	public void TC89762_OpenEVV_ContactState_trailing_spaces() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89762_OpenEVV_ContactState_trailing_spaces");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactState", "NY ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactState length is invalid. The length should be between 2 and 2."));
	}

	//To validate the ContactState with leading spaces
	@Test
	public void TC89762_OpenEVV_ContactState_leading_spaces() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89762_OpenEVV_ContactState_leading_spaces");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactState", " NY");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactState length is invalid. The length should be between 2 and 2."));
	}

	//To validate the missing ContactState 
	@Test
	public void TC89762_OpenEVV_ContactState_NULL() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89762_OpenEVV_ContactState_NULL");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactState", "null");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactState length is invalid. The length should be between 2 and 2."));
	}

}