package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//TC91121: OpenEVV-altEVV- Client- Validate (mix) - ClientStatus field formats/values

public class R2267_TC91121_AltEVV_ClientStatus extends BaseTest {

	String field = " ";

	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_valid"); 
		logger.log(LogStatus.INFO, "Validate valid Client Address Line 1"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientStatus", "");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

	      Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	  	
	}

	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_invalid_length() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_valid"); 
		logger.log(LogStatus.INFO, "Validate valid Client Address Line 1"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientStatus", CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The ClientStatus format is incorrect."));
	}

	public void R2267_TC91121_AltEVV_ClientStatus_optional() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_valid"); 
		logger.log(LogStatus.INFO, "Validate valid Client Address Line 1"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientEligibilityDateBegin", CommonMethods.DateGenerator("MMddyyyy"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}


}