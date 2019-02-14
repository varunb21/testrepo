package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91096:OpenEVV-altEVV- Client Payer: Validate (mix) - PayerID field formats/values

public class R2267_TC91096_AltEVV_PayerID_field extends BaseTest {


	//validating valid altEVV client  having PayerID_valid of Max Length i.e 64 char
	@Test (priority=0)
	public void R2267_TC91096_AltEVV_PayerID_valid_Max_Length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91096_AltEVV_PayerID_valid_Max_Length"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having PayerID_valid of Max Length i.e 64 char"); 
		String payerid=CommonMethods.generateRandomNumberOfFixLength(64);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerID, payerid);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
	}
	
	//validating valid altEVV client  having PayerID_valid of Max minus one Length i.e 63 char
	@Test (priority=1)
	public void R2267_TC91096_AltEVV_PayerID_valid_Max_minus_one_Length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91096_AltEVV_PayerID_valid_Max_minus_one_Length"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having PayerID_valid of Max minus one Length i.e 63 char"); 
		String payerid=CommonMethods.generateRandomNumberOfFixLength(63);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerID, payerid);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
	}

	//validating valid altEVV client  having PayerID_valid of mid Length i.e 32 char
	@Test (priority=2)
	public void R2267_TC91096_AltEVV_PayerID_valid_mid_Length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91096_AltEVV_PayerID_valid_mid_Length"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having PayerID_valid of mid Length i.e 32 char"); 
		String payerid=CommonMethods.generateRandomNumberOfFixLength(32);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerID, payerid);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	
		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
	}
	
	//validating valid altEVV client  having PayerID_valid of min Length i.e 1 char
	@Test (priority=3)
	public void R2267_TC91096_AltEVV_PayerID_valid_Min_Length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91096_AltEVV_PayerID_valid_Min_Length"); 

		String payerid=CommonMethods.generateRandomNumberOfFixLength(1);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerID, payerid);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
	}

	//validating valid altEVV client  having PayerID_having no value i.e null
	@Test (priority=4)
	public void R2267_TC91096_AltEVV_PayerID_invalid_missing_value() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91096_AltEVV_PayerID_invalid_missing_value"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having PayerID_having no value i.e null"); 
		String payerid=null;

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerID, payerid);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The PayerID cannot be null.");
		
		}
	
	//validating valid altEVV client  having PayerID_having maximum plus one value
	@Test (priority=4)
	public void R2267_TC91096_AltEVV_PayerID_invalid_max_plus_one_value() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91096_AltEVV_PayerID_invalid_max_plus_one_value"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having PayerID_having maximum plus one value"); 
		String payerid=CommonMethods.generateRandomNumberOfFixLength(100);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerID, payerid);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The PayerID value is incorrect. The length should be between 1 and 64.");
		}
}