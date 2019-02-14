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

//Test Case 92439: Open EVV-Client-Validate  - ClientPhoneType field length validation

public class EVV8152_91701_TC92439_ClientPhoneType_length_validation extends BaseTest {
	

    
    //Case-1 Open EVV-Client-Validate  -ClientPhoneType field length validation
     @Test 
	public void TC92439_OpenEVV_ClientPhoneType_length_validation() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC92439_OpenEVV_ClientPhoneType_length_validation"); // adding method name info via logger
		
		 logger.log(LogStatus.INFO, "Passing ClientPhoneType field with invalid length");

		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); //loading the Json dynamically with unique value set to check how its working go to the load json and understand the concept

		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
	
		js3.put("ClientPhoneType", "Mosdsllesdsfd"); 
		
			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPhoneType length is invalid. The length should be between 1 and 12."));	
	}
}
