package OpenEVV.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;

//Test Case 89816:Open EVV-Client-Validate (mix) - ClientDesigneeLastName field formats/values

public class TC89816_ClientDesigneeLastName  extends BaseTest {
	
    
	@Test(priority=1)
	public void TC89816_OpenEVV_ClientDesigneeLastName_Alphabet() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89816_OpenEVV_ClientDesigneeLastName_Alphabet"); 
		 
		


		logger.log(LogStatus.INFO, "Validating Json response ");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeLastName", "ClientLogin");
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
		
	}
	
	@Test(priority=2)
	public void TC89816_OpenEVV_ClientDesigneeLastName_heading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89816_OpenEVV_ClientDesigneeLastName_heading_space"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeLastName", " ClientLogin");
		  
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	@Test(priority=3)
	public void TC89816_OpenEVV_ClientDesigneeLastName_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89816_OpenEVV_ClientDesigneeLastName_leading_space"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeLastName", "ClientLogin ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	@Test(priority=4)
	public void TC89816_OpenEVV_ClientDesigneeLastName_dashes() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89816_OpenEVV_ClientDesigneeLastName_dashes"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeLastName", "Fnu.Anupamor-kam");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	@Test(priority=5)
	public void TC89816_OpenEVV_ClientDesigneeLastName_specialchars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89816_OpenEVV_ClientDesigneeLastName_specialchars"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeLastName", "F@n$u-Anupamor_kam");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeLastName format is incorrect."));
	}
	@Test(priority=6)
	public void TC89816_OpenEVV_ClientDesigneeLastName_incorrectemailcombination() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89816_OpenEVV_ClientDesigneeLastName_heading_space"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeLastName", "ClientLoginFN12");
	//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
	//	js.put("ClientLastName", "Null");
		 
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeLastName format is incorrect."));
	}
	@Test(priority=7)
	public void TC89816_OpenEVV_ClientDesigneeLastName_incorrectformatspecialchars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89816_OpenEVV_ClientDesigneeLastName_incorrectformatspecialchars"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeLastName", "F9821a");
	//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
	//	js.put("ClientLastName", "Null");
		 
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeLastName format is incorrect."));
	}
	@Test(priority=8)
	public void TC89816_OpenEVV_ClientDesigneeLastName_charlength() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89816_OpenEVV_ClientDesigneeLastName_charlength"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeLastName", "asfakfksafkafkafasfakfksafkafkafasfakfksafkafka");
		 
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("The ClientDesigneeLastName length is invalid. The length should be between 0 and 30."));
	}
	
	@Test(priority=9)
	public void TC89816_OpenEVV_ClientDesigneeLastName_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89816_OpenEVV_ClientDesigneeLastName_Alphanumeric"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeLastName", "9F9821a");
 
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeLastName format is incorrect."));
	}
}
