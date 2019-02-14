package AltEVV_generic.restassured.sandata.Client;

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

//Test Case 90979: OpenEVV-altEVV- Client:  Validate If the client Json does not include a Client Other ID (external ID)

public class R2267_TC90979_AltEVV_ClientOtherID_not_included extends BaseTest{
    
    //Case-1 Testing without ClientOtherID field
	@Test 
	public void TC90979_AltEVV_CreateClient_without_ClientOtherID() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC90979_AltEVV_CreateClient_without_ClientOtherID"); 
		
		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientOtherID"); 
		
		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		
		JSONObject js = (JSONObject) j.get(0);
		js.remove("ClientOtherID");
		js.remove("SequenceID");
		 
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		//Validating the expected Result
	   Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	}

	
}