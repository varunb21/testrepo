package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 88362:Open EVV- Verify error message on uploading client with null ClientLastName
public class TC88362_ClientLastName extends BaseTest
{	

		
	//case 1 Open EVV- Verify error message on uploading client with null ClientLastName
	@Test
	public void TC88362_OpenEVV_ClientLastName_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88362_OpenEVV_ClientLastName_null"); 
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ClientLastName", null);
	
	// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
		
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


	logger.log(LogStatus.INFO, "Validating Json response ");
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
    Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientLastName cannot be null."));
		
	}
	
	
}