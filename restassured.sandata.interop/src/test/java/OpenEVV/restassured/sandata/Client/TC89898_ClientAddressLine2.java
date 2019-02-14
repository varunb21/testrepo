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

//Test Case 89898:Open EVV-Client-Validate (mix) - ClientAddressLine2 field formats/values
public class TC89898_ClientAddressLine2 extends BaseTest {


	//To validate the valid ClientAddressLine2
	@Test
	public void TC89898_OpenEVV_ClientAddressLine2() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89898_OpenEVV_ClientAddressLine2"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));
	}

	//To validate the invalid ClientAddressLine2 length
	@Test
	public void TC89898_OpenEVV_ClientAddressLine2_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89898_OpenEVV_ClientAddressLine2_length"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "PYQUHBIJOEUFQDHPRUDSGORSGIQVOHMANHATTAN");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressLine2 length is invalid. The length should be between 1 and 30."));
	}

	//To validate the ClientAddressLine2 with single space
	@Test
	public void TC89898_OpenEVV_ClientAddressLine2_single_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89898_OpenEVV_ClientAddressLine2_single_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "South Amboy");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the numeric value in ClientAddressLine2
	@Test
	public void TC89898_OpenEVV_ClientAddressLine2_Numeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89898_OpenEVV_ClientAddressLine2_Numeric"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "Man1hattan");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine2 with trailing space
	@Test
	public void TC89898_OpenEVV_ClientAddressLine2_trailing_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89898_OpenEVV_ClientAddressLine2_trailing_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "Manhattan ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine2 with leading space
	@Test
	public void TC89898_OpenEVV_ClientAddressLine2_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89898_OpenEVV_ClientAddressLine2_leading_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", " Manhattan");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine2 with mid space and numeric
	@Test
	public void TC89898_OpenEVV_ClientAddressLine2_multiple_spaces_Alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89898_OpenEVV_ClientAddressLine2_multiple_spaces_Alphanumeric"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "Test Address qwert1 piou abc");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine2 with special char
	@Test
	public void TC89898_OpenEVV_ClientAddressLine2_special_char() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89898_OpenEVV_ClientAddressLine2_special_char"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "Manhatt@n");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressLine2 format is incorrect."));
	}

}
