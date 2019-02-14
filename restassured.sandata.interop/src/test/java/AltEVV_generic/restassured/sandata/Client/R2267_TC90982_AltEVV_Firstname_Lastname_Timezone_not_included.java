package AltEVV_generic.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;

//Test Case 90982: OpenEVV-altEVV- Client:  Validate If the client Json does not include first name, last name and time zone

public class R2267_TC90982_AltEVV_Firstname_Lastname_Timezone_not_included extends BaseTest{
    
    //Case-1 Testing without Clientfirstname_lastname_timezone field
	@Test 
	public void TC90982_AltEVV_CreateClient_without_firstname_lastname_timezone() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC90982_AltEVV_CreateClient_without_firstname_lastname_timezone"); 
		
		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without firstname_lastname_timezone"); 
		
		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
		JSONObject altEVVJsonArrayObject = (JSONObject) altEVVJsonArray.get(0);
		
		altEVVJsonArrayObject.remove("ClientFirstName");
		altEVVJsonArrayObject.remove("ClientLastName");
		altEVVJsonArrayObject.remove("ClientTimezone");
		
		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));
		
		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	  
	    Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientFirstName cannot be null."));
	    Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientTimezone cannot be null."));
	    Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientLastName cannot be null."));
	
}

}