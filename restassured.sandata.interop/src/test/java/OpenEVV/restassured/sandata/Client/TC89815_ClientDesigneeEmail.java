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

// Test Case 89815:Open EVV-Client-Validate (mix) - ClientDesigneeEmail field formats/values

public class TC89815_ClientDesigneeEmail extends BaseTest {

	@Test(priority=1)
	public void TC89815_OpenEVV_ClientDesigneeEmail() throws IOException, ParseException, ConfigurationException
	{

		logger = extent.startTest("TC89815_OpenEVV_ClientDesigneeEmail"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEmail", "ClientLoginFN@mailinator.com");

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}

	@Test(priority=2)
	public void TC89815_OpenEVV_ClientDesigneeEmail_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89815_OpenEVV_ClientDesigneeEmail_Alphanumeric"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEmail", "ClientLoginFN12@mailinator.com");
	
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	@Test(priority=3)
	public void TC89815_OpenEVV_ClientDesigneeEmail_without_specialchars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89815_OpenEVV_ClientDesigneeEmail_without_specialchars"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEmail", "ClientLoginFN12");
		//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
		//	js.put("ClientLastName", "Null");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeEmail format is incorrect."));
	}
	@Test(priority=4)
	public void TC89815_OpenEVV_ClientDesigneeEmail_incorrectemail_without_com() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89815_OpenEVV_ClientDesigneeEmail_incorrectemail_without_com"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEmail", "ClientLoginFN12@mailinator");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeEmail format is incorrect."));

	}
	@Test(priority=4)
	public void TC89815_OpenEVV_ClientDesigneeEmail_charlength() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89815_OpenEVV_ClientDesigneeEmail_charlength"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEmail", "ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1ClientLoginFN1@mail.com");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("The ClientDesigneeEmail length is invalid. The length should be between 0 and 50."));

	}
}
