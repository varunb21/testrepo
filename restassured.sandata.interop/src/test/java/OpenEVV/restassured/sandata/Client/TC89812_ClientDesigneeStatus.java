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

//Test Case 89812:Open EVV-Client-Validate (mix) - If the ClientDesigneeStatus is provided, ClientDesigneeEnddate and ClientDesigneeStartDate are not required

public class TC89812_ClientDesigneeStatus extends BaseTest {

	// Case-1 Testing with single instance of each tag with valid record
	@Test(priority=1)
	public void TC89812_OpenEVV_ClientDesigneeStatus_numeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89812_OpenEVV_ClientDesigneeStatus_numeric"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeStatus", "02");
		js.put("ClientDesigneeStartDate", null);
		js.put("ClientDesigneeEndDate", null);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}
	// Case-2 Testing with single instance of each tag with another valid record
	@Test(priority=2)
	public void TC89812_OpenEVV_ClientDesigneeStatus_starting_0() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89812_OpenEVV_ClientDesigneeStatus_starting_0"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeStatus", "04");
		js.put("ClientDesigneeStartDate", null);
		js.put("ClientDesigneeEndDate", null);

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}
	// Case-3 Testing with single instance of each tag with invalid record
	@Test(priority=3)
	public void TC89812_OpenEVV_ClientDesigneeStatus_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89812_OpenEVV_ClientDesigneeStatus_null"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientDesigneeStatus", "Null");
		js.put("ClientDesigneeStartDate", null);
		js.put("ClientDesigneeEndDate", null);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeStatus format is incorrect."));
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeStatus length is invalid. The length should be between 0 and 2."));
	}

}
