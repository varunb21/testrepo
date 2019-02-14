package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import junit.framework.Assert;

//Test Case 91253:Open EVV- altEVV- Client- Validate (mix) - ClientContactAddressLine1 field formats/values

public class R2267_TC91258_AltEVV_ClientContactAddressLine2 extends BaseTest {

	//validating valid altEVV client  having ClientContactAddressLine2 with 30 char as string
	@Test (priority=0)
	public void R2267_TC91250_AltEVV_ClientContactAddressLine2_valid_with_30char_asstring() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactAddressLine2_valid_with_30char_asstring"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactAddressLine2 with 30 char as string"); 

		String clntcontctaddlin1=CommonMethods.generateRandomAlphaNumeric(30);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientContactAddressLine2", clntcontctaddlin1);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	
		
		}

	//validating valid altEVV client  having ClientContactAddressLine2 with 15 char as string
	@Test (priority=1)
	public void R2267_TC91250_AltEVV_ClientContactAddressLine2_valid_with_15char_asstring() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactAddressLine2_valid_with_15char_asstring"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactAddressLine2 with 15 char as string"); 

		String clntcontctaddlin1=CommonMethods.generateRandomAlphaNumeric(15);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientContactAddressLine2", clntcontctaddlin1);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	
		
	}

	//validating invalid altEVV client having ClientContactAddressLine2 with maximum string
	@Test (priority=2)
	public void R2267_TC91250_AltEVV_ClientContactAddressLine2_invalid_with_maxstring() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactAddressLine2_invalid_with_maxstring"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV client having ClientContactAddressLine2 with maximum string"); 

		String clntcontctaddlin1=CommonMethods.generateRandomAlphaNumeric(35);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientContactAddressLine2", clntcontctaddlin1);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientContactAddressLine2 (Responsible Party) value is incorrect. The length should be between 1 and 30."));

	}

	//validating invalid altEVV client having ClientContactAddressLine2 with 30char_with special character
	@Test (priority=3)
	public void R2267_TC91250_AltEVV_ClientContactAddressLine2_invalid_with_30char_specialchar() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactAddressLine2_invalid_with_30char_butnot_string"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV client having ClientContactAddressLine2 with special character"); 

		String clntcontctaddlin1=  CommonMethods.generateRandomAlphaNumeric(5)+
									CommonMethods.generateSpecialChar(2)+
									CommonMethods.generateRandomNumberOfFixLength(2);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientContactAddressLine2", clntcontctaddlin1);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientContactAddressLine2 (Responsible Party) format is incorrect. The record should satisfy this regular expression"));

	}

	//validating invalid altEVV client having ClientContactAddressLine2 with more than 30char with special character
	@Test (priority=4)
	public void R2267_TC91250_AltEVV_ClientContactAddressLine2_invalid_with_morethan_30char_specialchar() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactAddressLine2_invalid_with_morethan_30char_specialchar"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV client having ClientContactAddressLine2 with more than 30char_with special character"); 

		String clntcontctaddlin1=  CommonMethods.generateRandomAlphaNumeric(10)+
				CommonMethods.generateSpecialChar(12)+
				CommonMethods.generateRandomNumberOfFixLength(12);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientContactAddressLine2", clntcontctaddlin1);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientContactAddressLine2 (Responsible Party) format is incorrect. The record should satisfy this regular expression"));

	}

}

