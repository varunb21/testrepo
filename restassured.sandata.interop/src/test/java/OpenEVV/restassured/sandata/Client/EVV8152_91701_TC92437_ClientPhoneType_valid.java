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

//Test Case 92437: Open EVV-Client-Validate  - ClientPhoneType field/format with valid value 'Other'

public class EVV8152_91701_TC92437_ClientPhoneType_valid extends BaseTest {
	
    
    //Case-1 Testing with valid ClientPhoneType values and format (Other)
	@Test 
	public void TC92437_OpenEVV_ClientPhoneType_validfield() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC92437_OpenEVV_ClientPhoneType_validfield"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating the valid value Others for ClientPhoneType"); 
		
		//loading the Json dynamically with unique value set
		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); 
		
		//json_parser("client") used to load the json file
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhoneType", "Other"); 
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));	
	}
}
