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

//Test Case 88417:Open EVV: Verify error messages on uploading client with invalid input to ClientTimeZone

public class TC88417_ClientTimeZone extends BaseTest {



	// To validate the invalid length of clientTimeZone
	@Test
	public void TC88417_OpenEVV_clientTimeZone_length_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88417_OpenEVV_clientTimeZone_length_invalid"); 

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientTimeZone", "fjlkdsajfdsjflkdsjaflkdsajflkdsjflkdsjflkdsajlkdsajlkdsajlkdsjjflkdsajflkdsaj");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientTimeZone length is invalid. The length should be between 0 and 64."));

	}

	//To validate incorrect format of clientTimeZone
	@Test
	public void TC88417_OpenEVV_ClientTimeZone() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88417_OpenEVV_ClientTimeZone");  

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientTimeZone", "ggg");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientTimeZone value is invalid."));
		//Assert.assertTrue(bodyAsString.contentEquals("ERROR: The ClientTimeZone value is invalid. Invalid Value='ggg'."));
	}

	//To validate clientTimeZone with whitespace
	@Test
	public void TC88417_OpenEVV_clientTimeZone_invalid_format() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88417_OpenEVV_clientTimeZone_invalid_format");  

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientTimeZone", " EST");
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
 

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientTimeZone value is invalid."));
		//Assert.assertTrue(bodyAsString.contentEquals("ERROR: The ClientTimeZone value is invalid. Invalid Value=' EST'."));
	}

}