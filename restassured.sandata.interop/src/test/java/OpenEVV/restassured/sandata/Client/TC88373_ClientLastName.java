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

//Test Case 88373:Open EVV- Client-Validate (mix) - ClientLastName field formats/values
public class TC88373_ClientLastName extends BaseTest {

	@Test
	//test case with invalid client last name
	public void TC88373_OpenEVV_ClientLastName_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88373_OpenEVV_ClientLastName_invalid"); 

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientLastName", "*123");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Asserting that result of client data .
		//Assert.assertEquals(bodyAsString.contains(val1) Expected value, true Actual Value, "Response body contains Accout");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		

	}

	//test case with valid last name
	@Test
	public void TC88373_OpenEVV_ClientLastName_valid() throws IOException, ParseException, ConfigurationException
	{

		logger = extent.startTest("TC88373_OpenEVV_ClientLastName_valid"); 

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientLastName", "babaraja");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Asserting that result of client data .
		//Assert.assertEquals(bodyAsString.contains(val1) Expected value, true Actual Value, "Response body contains Accout");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		Assert.assertTrue(bodyAsString.contains("\"account\": \"14420\","));



	}




}


