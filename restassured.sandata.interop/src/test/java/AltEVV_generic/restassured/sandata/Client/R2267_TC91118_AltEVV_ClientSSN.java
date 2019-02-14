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

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

public class R2267_TC91118_AltEVV_ClientSSN extends BaseTest {


	@Test
	public void R2267_TC91118_AltEVV_ClientSSN_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_valid"); 
		logger.log(LogStatus.INFO, "Validate valid Client SSN"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	  	
	}

	@Test
	public void R2267_TC91118_AltEVV_ClientSSN_invalid_length() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_invalid_length"); 
		logger.log(LogStatus.INFO, "Validate invalid Client SSN length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN length is invalid. The length should be between 1 and 9.");
	}

	@Test
	public void R2267_TC91118_AltEVV_ClientSSN_alphanumeric() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_alphanumeric"); 
		logger.log(LogStatus.INFO, "Validate invalid Client SSN alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = CommonMethods.generateRandomAlphaNumeric(9);
		jsonObject.put("ClientSSN",clientssn );

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test
	public void R2267_TC91118_AltEVV_ClientSSN_nonnumeric() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_nonumeric"); 
		logger.log(LogStatus.INFO, "Validate invalid Client SSN length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = CommonMethods.generateRandomStringOfFixLength(9);
		jsonObject.put("ClientSSN",clientssn );

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test
	public void R2267_TC91118_AltEVV_ClientSSN_dash() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_nonumeric"); 
		logger.log(LogStatus.INFO, "Validate invalid Client SSN length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = CommonMethods.generateRandomStringOfFixLength(4) + "-" + CommonMethods.generateRandomStringOfFixLength(4);
		jsonObject.put("ClientSSN",clientssn);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test
	public void R2267_TC91118_AltEVV_ClientSSN_leading_zeros() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_leading_zeros"); 
		logger.log(LogStatus.INFO, "Validate invalid Client SSN with leading zeros"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = "00" + CommonMethods.generateRandomStringOfFixLength(7);
		jsonObject.put("ClientSSN",clientssn);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test
	public void R2267_TC91118_AltEVV_ClientSSN_Empty() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_valid"); 
		logger.log(LogStatus.INFO, "Validate valid Client SSN"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", "");

		String clientotherid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObject.put("ClientOtherID", clientotherid);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "");
	}


}