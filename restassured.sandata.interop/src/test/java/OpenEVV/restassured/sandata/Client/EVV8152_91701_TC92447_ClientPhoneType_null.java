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

//Test Case 92447: Open EVV-Client-Validate ClientPhoneType field with null

public class EVV8152_91701_TC92447_ClientPhoneType_null extends BaseTest{
	
    //Case-1 Testing with invalid ClientContactPhoneType value null
    @Test 
	public void TC92477_OpenEVV_ClientPhoneType_Null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC92477_OpenEVV_ClientPhoneType_Null"); 
		logger.log(LogStatus.INFO, "Validating the invalid ClientPhoneType as Null"); 
		
		//json_parser("client") used to load the json file
		
		JSONArray j = GenerateUniqueParam.ClientParams_OpenEVV("client"); //loading the Json dynamically with unique value set to check how its working go to the load json and understand the concept

		logger.log(LogStatus.INFO, "Loading Json with unique value and the request body generated is " +j.toJSONString());
		JSONObject js = (JSONObject) j.get(0);
		
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhoneType", "Null"); 
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
	    Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientPhoneType format is incorrect."));		
	}

	
}
