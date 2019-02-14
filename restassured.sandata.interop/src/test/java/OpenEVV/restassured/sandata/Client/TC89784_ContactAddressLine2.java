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

//Test Case 89784:Open EVV-Client-Validate (mix) - ContactAddressLine2 field formats/values
public class TC89784_ContactAddressLine2 extends BaseTest {

	//To validate the valid ContactAddressLine2
	@Test
	public void TC89784_OpenEVV_Client_ContactAddLine2_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89784_OpenEVV_Client_ContactAddLine2_valid");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine2", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));
	}

	//To validate the invalid ContactAddressLine2 length
	@Test
	public void TC89784_OpenEVV_Client_ContactAddressLine2_length_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89784_OpenEVV_Client_ContactAddressLine2_length_invalid");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine2", "PYQUHBIJOEUFQDHPRUDSGORSGIQVOHMANHATTAN");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactAddressLine2 length is invalid. The length should be between 0 and 30."));
	}

	//To validate the ContactAddressLine2 with mid space
	@Test
	public void TC89784_OpenEVV_Client_ContactAddressLine2_mid_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89784_OpenEVV_Client_ContactAddressLine2_mid_space");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine2", "South Amboy");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the numeric value in ContactAddressLine2
	@Test
	public void TC89784_OpenEVV_Client_numeric_ContactAddressLine2() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89784_OpenEVV_Client_numeric_ContactAddressLine2");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine2", "Man1hattan");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ContactAddressLine2 with trailing space
	@Test
	public void TC89784_OpenEVV_Client_ContactAddressLine2_trailing_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89784_OpenEVV_Client_ContactAddressLine2_trailing_space");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine2", "Manhattan ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ContactAddressLine2 with leading space
	@Test
	public void TC89784_OpenEVV_Client_ContactAddressLine2_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89784_OpenEVV_Client_ContactAddressLine2_leading_space");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine2", " Manhattan");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ContactAddressLine2 with mid space and numeric
	@Test
	public void TC89784_OpenEVV_Client_ContactAddressLine2_mid_space_with_numeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89784_OpenEVV_Client_ContactAddressLine2_mid_space_with_numeric");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine2", "Test Address qwerty piou abc");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ContactAddressLine2 with special char
	@Test
	public void TC89784_OpenEVV_Client_ContactAddressLine2_special_char() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89784_OpenEVV_Client_ContactAddressLine2_special_char");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine2", "Manhatt@n");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactAddressLine2 format is incorrect."));
	}

}
