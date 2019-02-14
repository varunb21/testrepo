package AltEVV_molina.restassured.sandata.Client;

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
		logger.log(LogStatus.INFO, "R2267_TC91118_AltEVV_ClientAddressLine1_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObject_sub = (JSONObject) jsonArray_sub.get(0);
	
		jsonObject_sub.put("ClientStatus", "01");

		JSONArray jsonArray_sub2 = (JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObject_sub2 = (JSONObject) jsonArray_sub2.get(1);
	
		jsonObject_sub2.put("ClientStatus", "01");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

	      Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	  	
	}

	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_invalid_null() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91121_AltEVV_ClientStatus_invalid_null"); 
		logger.log(LogStatus.INFO, "R2267_TC91121_AltEVV_ClientStatus_invalid_null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObject_sub = (JSONObject) jsonArray_sub.get(0);
	
		jsonObject_sub.put("ClientStatus", "");

		JSONArray jsonArray_sub2 = (JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObject_sub2 = (JSONObject) jsonArray_sub2.get(1);
	
		jsonObject_sub2.put("ClientStatus", "");jsonObject.put("ClientStatus", CommonMethods.generateRandomNumberOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "");

		}
	
	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_invalid_length() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91121_AltEVV_ClientStatus_invalid_length"); 
		logger.log(LogStatus.INFO, "R2267_TC91121_AltEVV_ClientStatus_invalid_length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObject_sub = (JSONObject) jsonArray_sub.get(0);
	
		jsonObject_sub.put("ClientStatus", CommonMethods.generateRandomNumberOfFixLength(6));

		JSONArray jsonArray_sub2 = (JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObject_sub2 = (JSONObject) jsonArray_sub2.get(1);
	
		jsonObject_sub2.put("ClientStatus", CommonMethods.generateRandomNumberOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "");

		}

	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_optional() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91121_AltEVV_ClientStatus_optional"); 
		logger.log(LogStatus.INFO, "R2267_TC91121_AltEVV_ClientStatus_optional"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObject_sub = (JSONObject) jsonArray_sub.get(0);
	
		jsonObject_sub.put("ClientStatus", null);
		jsonObject.put("ClientEligibilityDateBegin", CommonMethods.DateGenerator("MMddyyyy"));
		jsonObject.put("ClientEligibilityDateEnd", CommonMethods.DateGenerator("MMddyyyy"));

		JSONArray jsonArray_sub2 = (JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObject_sub2 = (JSONObject) jsonArray_sub2.get(1);
	
		jsonObject_sub2.put("ClientStatus", null);
		jsonObject.put("ClientEligibilityDateBegin", CommonMethods.DateGenerator("MMddyyyy"));
		jsonObject.put("ClientEligibilityDateEnd", CommonMethods.DateGenerator("MMddyyyy"));


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}


}