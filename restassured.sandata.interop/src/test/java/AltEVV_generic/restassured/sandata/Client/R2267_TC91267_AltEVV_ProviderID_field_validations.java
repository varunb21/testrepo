package AltEVV_generic.restassured.sandata.Client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class R2267_TC91267_AltEVV_ProviderID_field_validations extends BaseTest{

	//Test Case 91267: OpenEVV-altEVV- Client- Validate (mix) - ProviderID field formats/values

	//Case-1 Testing with ProviderID : >50  
	@Test 
	public void R2267_TC91267_AltEVV_invalid_ProviderID_more_than_50() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91267_AltEVV_invalid_ProviderID_more_than_50"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderID", CommonMethods.generateRandomStringOfFixLength(51));

		String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ProviderID (Client) value is incorrect. The length should be between 1 and 50.");

	}

	// Case-2 Testing with correct ProviderID value as string
	@Test(groups = { "Databasetest"})
	public void R2267_TC91267_AltEVV_valid_ProviderID_string() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91267_AltEVV_valid_ProviderID_string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderID", CommonMethods.generateRandomNumberOfFixLength(15));

		String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	// Case-3 Testing with invalid ProviderID null
	@Test(groups = { "Databasetest"})
	public void R2267_TC91267_AltEVV_invalid_ProviderID_null() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91267_AltEVV_invalid_ProviderID_null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderID", null);

		String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.provider_ID_Error_format);


	}

	// Case-4 Testing with correct ProviderID value and Database validation
	@Test(groups = { "Databasetest"})
	public void R2267_TC91267_AltEVV_valid_ProviderID_Database() throws FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91267_AltEVV_valid_ProviderID_Database"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderID", CommonMethods.generateRandomNumberOfFixLength(50));

		String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//Case-5 Testing with invalid ProviderID as duplicate 
	@Test 
	public void R2267_TC91267_AltEVV_invalid_ProviderID_with_duplicate_entry() throws FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		logger = extent.startTest("R2267_TC91267_AltEVV_invalid_ProviderID_with_duplicate_entry"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderID", "8459327");

		String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}
}
