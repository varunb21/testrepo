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

//Test Case 89818:Open EVV-Client-Validate (mix) - ClientDesigneeFirstName field formats/values

public class TC89818_ClientDesigneeFirstName  extends BaseTest{

	@Test(priority=1)
	public void TC89818_OpenEVV_ClientDesigneeFirstName_Alphabetcombination() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("Bug_88400_TC88789_OpenEVV_Emp_Populated_with_Max_values"); 
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeFirstName", "Clientfname");

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}
	// Case-2 Testing with alphabets starting with a space
	@Test(priority=2)
	public void TC89818_OpenEVV_ClientDesigneeFirstName_heading_spacecombination() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientDesigneeFirstName_heading_spacecombination"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeFirstName", " Clientfname");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	// Case-3 Testing with alphabets ending with a space
	@Test(priority=3)
	public void TC89818_OpenEVV_ClientDesigneeFirstName_Leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientDesigneeFirstName_Leading_space"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeFirstName", "Clientfname ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	// Case-4 Testing with special characters
	@Test(priority=4)
	public void TC89818_OpenEVV_ClientDesigneeFirstName_with_dashes() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientDesigneeFirstName_with_dashes"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeFirstName", "Fnu.Anupamor-kam");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	// Case-5 Testing with special characters other than few
	@Test(priority=5)
	public void TC89818_OpenEVV_ClientDesigneeFirstName_combinationwithspecialchars() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientDesigneeFirstName_combinationwithspecialchars"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeFirstName", "F@n$u-Anupamor_kam");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeFirstName format is incorrect."));
	}
	// Case-6 Testing with combination of alphanumeric, starting with an alpha
	@Test(priority=6)
	public void TC89818_OpenEVV_ClientDesigneeFirstName_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientDesigneeFirstName_Alphanumeric"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeFirstName", "ClientLoginFN12");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeFirstName format is incorrect."));
	}
	// Case-7 Testing with combination of alphanumeric, starting with a number
	@Test(priority=7)
	public void TC89818_OpenEVV_ClientDesigneeFirstName_invalid_numberformat() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientDesigneeFirstName_invalid_numberformat"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeFirstName", "9F9821a");
		//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
		//	js.put("ClientLastName", "Null");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeFirstName format is incorrect."));
	}
	// Case-8 Testing with >30 characters  
	@Test(priority=8)
	public void TC89818_OpenEVV_ClientDesigneeFirstName_charlength() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89818_OpenEVV_ClientDesigneeFirstName_charlength"); 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeFirstName", "asfakfksafkafkafasfakfksafkafkafasfakfksafkafka");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("The ClientDesigneeFirstName length is invalid. The length should be between 0 and 30."));
	}

}
