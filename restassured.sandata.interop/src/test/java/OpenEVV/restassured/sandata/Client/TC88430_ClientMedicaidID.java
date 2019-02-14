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

//Test Case 88430:Open EVV: Verify error messages on uploading client with invalid input of 'ClientMedicaidID'
public class TC88430_ClientMedicaidID extends BaseTest{

	//To validate the invalid ClientMedicaidID length
	@Test
	public void TC88430_OpenEVV_ClientMedicaidID_length_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88430_OpenEVV_ClientMedicaidID_length_invalid");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", "16351225253265321516373838383837364748382920387474839374839374874521532112355");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientMedicaidID length is invalid. The length should be between 0 and 64."));
	}

	//To validate the ClientMedicaidID with alphanumeric value
	@Test
	public void TC88430_OpenEVV_ClientMedicaidID_with_alphanumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88430_OpenEVV_ClientMedicaidID_with_alphanumeric");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", "5678hdhe11");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));
	}

	//To validate the ClientMedicaidID with non numeric value
	@Test
	public void TC88430_OpenEVV_ClientMedicaidID_with_nonnumeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88430_OpenEVV_ClientMedicaidID_with_nonnumeric");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", "mayanknst");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));
	}

	//To validate the ClientMedicaidID with whitespace
	@Test
	public void TC88430_OpenEVV_ClientMedicaidID_with_headingspace() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88430_OpenEVV_ClientMedicaidID_with_headingspace");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", " 987654321");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientMedicaidID format is incorrect."));
	}

	//To validate the ClientMedicaidID with special character
	@Test
	public void TC88430_OpenEVV_ClientMedicaidID_with_specialCharacter() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88430_OpenEVV_ClientMedicaidID_with_specialCharacter");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", "14420@234");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientMedicaidID format is incorrect."));
	}

	//To validate the ClientMedicaidID with dash character
	@Test
	public void TC88430_OpenEVV_ClientMedicaidID_dashCharacter() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88430_OpenEVV_ClientMedicaidID_dashCharacter");  

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", "2442-9234");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientMedicaidID format is incorrect."));
	}

}