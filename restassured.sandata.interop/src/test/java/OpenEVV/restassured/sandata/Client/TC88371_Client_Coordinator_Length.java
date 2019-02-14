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

//Test Case 88371:Open EVV- Verify the error message on giving invalid length of Coordinator
public class TC88371_Client_Coordinator_Length extends BaseTest
{	
		
	//case 1---- - Coordinator (Supervisor): >3 characters (invalid Case)
	@Test
	public void TC88371_OpenEVV_Client_Coordinator_length_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88371_OpenEVV_Client_Coordinator_length_invalid"); 
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("Coordinator", "raja");
	
	// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
		
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

	logger.log(LogStatus.INFO, "Validating Json response ");
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
    Assert.assertTrue(bodyAsString.contains( "ERROR: The Coordinator format is incorrect. The record should satisfy this regular expression [\\u0027[\\\\w]{0,3}$\\u0027]."));
		
	}
	
	
}