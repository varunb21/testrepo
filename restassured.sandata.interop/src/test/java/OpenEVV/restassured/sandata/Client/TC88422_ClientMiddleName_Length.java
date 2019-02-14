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

public class TC88422_ClientMiddleName_Length extends BaseTest {

	//To validate the invalid ClientMiddleName length
	@Test
	public void TC88422_OpenEVV_ClientMiddleName_length_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88422_OpenEVV_ClientMiddleName_length_invalid");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMiddleName", CommonMethods.generateRandomStringOfFixLength(32));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientMiddleName length is invalid. The length should be between 0 and 30."));
	}
	
	//To validate the ClientMiddleName with special character
	@Test
	public void TC88422_OpenEVV_ClientMiddleName_with_SpecialChar() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88422_OpenEVV_ClientMiddleName_with_SpecialChar");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMiddleName", CommonMethods.generateRandomStringOfFixLength(10) + "@");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientMiddleName format is incorrect."));
	}
	
	//To validate the missing ClientMiddleName 
	@Test
	public void TC88422_OpenEVV_ClientMiddleName_null() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88422_OpenEVV_ClientMiddleName_null");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMiddleName", "");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientMiddleName format is incorrect."));
	}

}