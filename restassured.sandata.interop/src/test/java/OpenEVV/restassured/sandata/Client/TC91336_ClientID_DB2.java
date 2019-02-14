package OpenEVV.restassured.sandata.Client;

import static io.restassured.RestAssured.given;
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
import io.restassured.response.Response;

//Test Case 91336:Inter-op ; Open EVV - Client - Validate the Client creation for Client ID "00000"

public class TC91336_ClientID_DB2 extends BaseTest{
	
	//case-1 To validate the null ClientID DB verification 
	@Test
	public void TC91336_OpenEVV_verify_invalid_ClientID_null_db_verify() throws IOException, ParseException, ConfigurationException	{
		logger = extent.startTest("TC91336_OpenEVV_verify_invalid_ClientID_null_db_verify");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		js.put(globalVariables.ClientID, "00000");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
         
		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));
	  
	}
	
}