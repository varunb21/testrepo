package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

public class TC89943_ClientPrimaryDiagnosisCode extends BaseTest{

	//To validate the valid ClientPrimaryDiagnosisCode 
	@Test
	public void TC89943_OpenEVV_valid_ClientPrimaryDiagnosisCode() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89943_OpenEVV_valid_ClientPrimaryDiagnosisCode"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPrimaryDiagnosisCode", "E32.92A");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	
	}

	//To validate the invalid ClientPrimaryDiagnosisCode length
	@Test
	public void TC89943_OpenEVV_invalid_ClientPrimaryDiagnosisCode_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89943_OpenEVV_invalid_ClientPrimaryDiagnosisCode_length"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPrimaryDiagnosisCode", "T"+ CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientPrimaryDiagnosisCode length is invalid. The length should be between 0 and 10.");
	}

	//To validate the ClientPrimaryDiagnosisCode with leading space
	@Test
	public void TC89943_OpenEVV_leading_space_ClientPrimaryDiagnosisCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89943_OpenEVV_leading_space_ClientPrimaryDiagnosisCode"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPrimaryDiagnosisCode", " " + "T"+ CommonMethods.generateRandomNumberOfFixLength(5));
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPrimaryDiagnosisCode format is incorrect"));
	}

	//To validate the ClientPrimaryDiagnosisCode with trailing space
	@Test
	public void TC89943_OpenEVV_trailing_space_ClientPrimaryDiagnosisCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89943_OpenEVV_trailing_space_ClientPrimaryDiagnosisCode"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPrimaryDiagnosisCode", "T"+ CommonMethods.generateRandomNumberOfFixLength(5) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPrimaryDiagnosisCode format is incorrect"));

	}

	//To validate the ClientPrimaryDiagnosisCode with special character
	@Test
	public void TC89943_OpenEVV_specialCharacter_ClientPrimaryDiagnosisCode() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89943_OpenEVV_specialCharacter_ClientPrimaryDiagnosisCode"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPrimaryDiagnosisCode", CommonMethods.generateSpecialChar(6));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPrimaryDiagnosisCode format is incorrect"));
	}

}