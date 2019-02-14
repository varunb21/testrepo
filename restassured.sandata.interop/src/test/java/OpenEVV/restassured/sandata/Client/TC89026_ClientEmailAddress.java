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

//Test Case 89026:Open EVV-Client-Validate (mix) - ClientEmailAddress field formats/values
public class TC89026_ClientEmailAddress extends BaseTest
{
     
	@Test(priority=1)
	public void TC89026_OpenEVV_ClientEmailAddress_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89026_OpenEVV_ClientEmailAddress_valid");  
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientEmailAddress","abcxyz@mail.com");
	        
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	
	@Test(priority=2)
	public void TC89026_OpenEVV_ClientEmailAddress_valid_format() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89026_OpenEVV_ClientEmailAddress_valid_format");  
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientEmailAddress","ABCDQWERT@mail.com");
	
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
	     
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	
	@Test(priority=5)
	public void TC89026_OpenEVV_ClientEmailAddress_valid_combination() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89026_OpenEVV_ClientEmailAddress_valid_combination");  
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientEmailAddress","testabc12@mailinator.com");
	
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		    
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	
	@Test(priority=3)
	
    public void TC89026_OpenEVV_ClientEmailAddress_invalidformat() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89026_OpenEVV_ClientEmailAddress_invalidformat");  
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientEmailAddress","abctestgn12");
	
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		//Assert.assertTrue(bodyAsString1.contains("\"statuscode\": \"200\","));
		//Assert.assertTrue(bodyAsString1.contains("\"ClientLastName\": \"Absjdsshfsfhsfkh\","));
	}
	
	@Test(priority=4)
	public void TC89026_OpenEVV_ClientEmailAddress_withoutcom_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89026_OpenEVV_ClientEmailAddress_withoutcom_invalid");  
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientEmailAddress","testabc12@mailinator");
	
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientEmailAddress format is incorrect."));
	}


}
