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

/**
 * @author MayankM
 *
 */

//Test Case 88420:Open EVV: Verify error messages on uploading client with invalid input for 'AccountNo'
public class TC88420_Client_AccountNo extends BaseTest {


	//To validate the invalid account length
	@Test
	public void TC88420_OpenEVV_Client_Account_length_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88420_OpenEVV_Client_Account_length_valid");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}
	
	//To validate the account with alphanumeric value
	@Test
	public void TC88420_OpenEVV_Client_alphanumeric_accountno() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88420_OpenEVV_Client_alphanumeric_accountno");  
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomAlphaNumeric(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}

	//To validate the account with non numeric value
	@Test
	public void TC88420_OpenEVV_Client_nonnumeric_accountno() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88420_OpenEVV_Client_nonnumeric_accountno");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}
	
	//To validate the account with whitespace
	@Test
	public void TC88420_OpenEVV_Client_Account_with_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88420_OpenEVV_Client_Account_with_leading_space");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", " " + "14420");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}
	
	//To validate the account with special character
	@Test
	public void TC88420_OpenEVV_Client_AccountNO_with_SpecialCharacter() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88420_OpenEVV_Client_AccountNO_with_SpecialCharacter");  
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}

}