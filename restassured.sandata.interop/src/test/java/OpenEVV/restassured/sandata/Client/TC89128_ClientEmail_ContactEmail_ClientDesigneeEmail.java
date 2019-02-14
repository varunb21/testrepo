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

//Test Case 89128:Inter-op-OpenEVV: Client is created when ClientEmail, ContactEmail or ClientDesigneeEmail is not sent by Json
public class TC89128_ClientEmail_ContactEmail_ClientDesigneeEmail extends BaseTest
{	
		
	//case 1---- - ClientEmailAddress, ContactEmail and ClientDesigneeEmail send these 3 fields as null (valid Case)
	@Test
	public void TC89128_OpenEVV_ClientMedicalRecordNumber_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89128_OpenEVV_ClientMedicalRecordNumber_valid");  
		
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ClientEmailAddress", null);
	js.put("ContactEmail", null);
	js.put("ClientDesigneeEmail", null);

	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));
		
	}
	
	
}