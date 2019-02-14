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

//Test Case 88377:Open EVV - Verify error message on uploading client with null ClientFirstName
public class TC88377_ClientFirstName_null extends BaseTest
{	


	//case 1---- - "ClientFirstName": null (invalid Case)
	@Test
	public void TC88377_OpenEVV_ClientFirstName_invalid_null() throws IOException, ParseException, ConfigurationException
	{
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		logger = extent.startTest("TC88377_OpenEVV_ClientFirstName_invalid_null");  
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientFirstName cannot be null."));

	}


}