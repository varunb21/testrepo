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
import junit.framework.Assert;

//Test Case 91250:Open EVV- altEVV- Client- Validate (mix) - ClientContactEmailAddress field formats/values

public class R2267_TC91250_AltEVV_ClientContactEmailAddress extends BaseTest {

	String slntssn,slntssn_db="client_ssn", clntcontctemail_db = "e_mail";

	//validating valid altEVV client  having clientcontactemailaddress with numeric char only
	@Test (priority=0)
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_num() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_num"); 
		logger.log(LogStatus.INFO, "validating valid alt evv client  having clientcontactemailaddress with numeric char only"); 

		String clntcontctemail=CommonMethods.generateEmailAddress_num(12);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	
	}

	//validating valid altEVV client  having clientcontactemailaddress with alphanumeric char only
	@Test (priority=1)
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_alphnum() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_alphnum"); 
		logger.log(LogStatus.INFO, "validating valid alt evv client  having clientcontactemailaddress with alphanumeric char only"); 

		String clntcontctemail= CommonMethods.generateEmailAddress_alpha(12);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientContactEmailAddress", clntcontctemail);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	
	}

	//validating valid altEVV client  having clientcontactemailaddress with alphabet char only
	@Test (priority=2)
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_alpha() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_alpha"); 
		logger.log(LogStatus.INFO, "//validating valid alt evv client  having clientcontactemailaddress with alphabet char only"); 

		String clntcontctemail= CommonMethods.generateEmailAddress_string(12);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientContactEmailAddress", clntcontctemail);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);

		slntssn=jsonObject.get("ClientSSN").toString();


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	
	}

	//validating invalid altEVV client having clientcontactemailaddress with no valid extension
	@Test (priority=3)
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_novalidation() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_novalidation"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV client having clientcontactemailaddress with no valid extension"); 

		String clntcontctemail=CommonMethods.generateEmailAddress_num(64);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientContactEmailAddress", clntcontctemail);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);

		slntssn=jsonObject.get("ClientSSN").toString();


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientContactEmailAddress (Responsible Party) value is incorrect. The length should be between 0 and 64."));

	}

	//validating invalid altEVV client having clientcontactemailaddress with no valid extension
	@Test (priority=4)
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_maxchar() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_novalidation"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV client having clientcontactemailaddress with no valid extension"); 

		String clntcontctemail=CommonMethods.generateRandomAlphaNumeric(14);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientContactEmailAddress", clntcontctemail);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);

		slntssn=jsonObject.get("ClientSSN").toString();


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientContactEmailAddress (Responsible Party) format is incorrect"));

	}

	//validating invalid altEVV client having clientcontactemailaddress with no incomplete validation
	@Test (priority=5)
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_incompletevalidation() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_incompletevalidation"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV client having clientcontactemailaddress with no incomplete validation"); 

		String clntcontctemail=CommonMethods.generateRandomAlphaNumeric(14) + "@mailinator";

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientContactEmailAddress", clntcontctemail);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);

		slntssn=jsonObject.get("ClientSSN").toString();


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientContactEmailAddress (Responsible Party) format is incorrect"));

	}

}