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

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

public class R2267_TC91122_AltEVV_ClientTimeZone extends BaseTest {


	// Validating valid altEVV ClientTimeZone field with 50chars
	@Test (priority=0)
	public void R2267_TC91122_AltEVV_ClientTimeZone_valid_50chars() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91122_AltEVV_ClientTimeZone_valid_5"); 
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientTimeZone field with 50chars"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, "qa");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientTimeZone value is invalid.");

	}

	// Validating valid altEVV ClientTimeZone field with min 1chars
	@Test (priority=1)
	public void R2267_TC91122_AltEVV_ClientTimeZone_valid_min_1char() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91122_AltEVV_ClientTimeZone_valid_5"); 
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientTimeZone field min 1chars"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, CommonMethods.generateRandomStringOfFixLength(1));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientTimeZone value is invalid.");

	}

	// Validating valid altEVV ClientTimeZone field having EST_otherthanallowedvalue
	@Test (priority=2)
	public void R2267_TC91122_AltEVV_ClientTimeZone_valid_EST_otherthanallowedvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91122_AltEVV_ClientTimeZone_valid_blank_value"); 
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientTimeZone field having EST_otherthanallowedvalue"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, "EST");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

	      Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	  	

	}

	// Validating invalid altEVV ClientTimeZone field with blank value
	@Test (priority=3)
	public void R2267_TC91122_AltEVV_ClientTimeZone_invalid_blank_value() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91122_AltEVV_ClientTimeZone_invalid_blank_value"); 
		logger.log(LogStatus.INFO, "Validating invalid altEVV ClientTimeZone field with blank value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, CommonMethods.generateRandomStringOfFixLength(0));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientTimezonesizeerror);

	}

	// Validating invalid altEVV ClientTimeZone field with null value
	@Test (priority=1)
	public void R2267_TC91122_AltEVV_ClientTimeZone_invalid_null_value() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91122_AltEVV_ClientTimeZone_invalid_null_value"); 
		logger.log(LogStatus.INFO, "Validating invalid altEVV ClientTimeZone field with null value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientTimezonenullerror);

	}

	// Validating invalid altEVV ClientTimeZone field haivng all_otherthanallowedvalue
	@Test (priority=1)
	public void R2267_TC91122_AltEVV_ClientTimeZone_invalid_all_otherthanallowedvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91122_AltEVV_ClientTimeZone_invalid_blank_value"); 
		logger.log(LogStatus.INFO, "Validating invalid altEVV ClientTimeZone field having all_otherthanallowedvalue"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, "ALL");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientTimeZone value is invalid.");

	}

}