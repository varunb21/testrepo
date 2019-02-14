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

/**
 * @author MayankM
 *
 */

//Test Case 91083: OpenEVV-altEVV- Client:  Validate (mix) - ClientQualifier field formats/values

public class R2267_TC91083_AltEVV_ClientQualifier extends BaseTest {

	//validating AltEVV clientQualifier = ClientSSN
	@Test
	public void R2267_TC91083_AltEVV_ClientQualifier_ClientSSN() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91083_AltEVV_ClientQualifier_ClientSSN"); 
		logger.log(LogStatus.INFO, "validating altEVV clientQualifier = ClientSSN"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", "ClientSSN");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	
	}

	//validating AltEVV clientQualifier = ClientOtherID
	@Test
	public void R2267_TC91083_AltEVV_ClientQualifier_ClientOtherID() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91083_AltEVV_ClientQualifier_ClientOtherID"); 
		logger.log(LogStatus.INFO, "validating altEVV clientQualifier = ClientOtherID"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", "ClientOtherID");
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	
	}

	//validating AltEVV clientQualifier = ClientCustomID
	@Test
	public void R2267_TC91083_AltEVV_ClientQualifier_ClientCustomID() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91083_AltEVV_ClientQualifier_ClientCustomID"); 
		logger.log(LogStatus.INFO, "validating altEVV clientQualifier = ClientCustomID"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", "ClientCustomID");
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	
	}

	//validating AltEVV clientQualifier invalid length
	@Test
	public void R2267_TC91083_AltEVV_ClientQualifier_invalid_length() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91083_AltEVV_ClientQualifier_invalid_length"); 
		logger.log(LogStatus.INFO, "validating ClientQualifier with invalid length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", CommonMethods.generateRandomStringOfFixLength(21));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierLengthError);
	}

	//validating AltEVV clientQualifier invalid format
	@Test
	public void R2267_TC91083_AltEVV_ClientQualifier_invalid_format() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91083_AltEVV_ClientQualifier_invalid_format"); 
		logger.log(LogStatus.INFO, "validating ClientQualifier with invalid format"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierFormatError);
	}

	//validating AltEVV clientQualifier = null
	@Test
	public void R2267_TC91083_AltEVV_ClientQualifier_null() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91083_AltEVV_ClientQualifier_null"); 
		logger.log(LogStatus.INFO, "validating ClientQualifier = null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierNullError);
	}



}