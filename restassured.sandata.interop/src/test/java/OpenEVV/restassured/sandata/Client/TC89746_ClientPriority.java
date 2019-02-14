package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 89746:Open EVV-Client-Validate (mix) - ClientPriority field formats/values
public class TC89746_ClientPriority extends BaseTest
{	
		
	@Test
	//case 1---- wClientPriority: "213" (> 2 digit) (invalid Case)
	public void TC89746_OpenEVV_ClientPriority_max_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89746_OpenEVV_ClientPriority_max_invalid");  
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ClientPriority", "213");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
	Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientPriority length is invalid. The length should be between 0 and 2."));
		
	}

	@Test
	//case 2---- ClientPriority: " 21" ( space with 2 digit) (invalid Case)
	public void TC89746_OpenEVV_ClientPriority_space_with_2digit_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89746_OpenEVV_ClientPriority_space_with_2digit_invalid");  
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPriority", " 23");
	
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
	Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientPriority length is invalid. The length should be between 0 and 2."));
	
		
	}
	
	@Test
	//case 3---- *ClientPriority: "#1" ( SpecialCharacter with digit) (invalid Case)
	public void TC89746_OpenEVV_ClientPriority_Specialchar_with_digit_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89746_OpenEVV_ClientPriority_Specialchar_with_digit_invalid");  
		
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ClientPriority", "#1");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
	Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientPriority format is incorrect. The record should satisfy this regular expression [\\u0027[\\\\w]{0,2}$\\u0027]"));
	
		
	}		

	@Test
	//case 4---- ClientPriority: "1" (digit only) (valid Case) 
	public void TC89746_OpenEVV_ClientPriority_singledigit_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89746_OpenEVV_ClientPriority_Specialchar_with_digit_invalid");  
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ClientPriority", "1");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		
	}				
	
	@Test
	//case 5-ClientPriority: "13" (digit only)  (valid Case) 
	public void TC89746_OpenEVV_ClientPriority_digit_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89746_OpenEVV_ClientPriority_singledigit_valid");  
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ClientPriority", "21");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		
	}

	@Test
	//case 6---ClientPriority: "AB" (Alphabets only)  (valid Case)
	public void TC89746_OpenEVV_ClientPriority_alphabet_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89746_OpenEVV_ClientPriority_alphabet_valid");  
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ClientPriority", "21");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		
	}				
		
	@Test
	//case 7----ClientPriority: "A2" (Alphanumeric) (valid Case) 
	public void TC89746_OpenEVV_ClientPriority__alphabet_digit_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89746_OpenEVV_ClientPriority__alphabet_digit_valid");  
		
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ClientPriority", "2A");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
			
		}	
}