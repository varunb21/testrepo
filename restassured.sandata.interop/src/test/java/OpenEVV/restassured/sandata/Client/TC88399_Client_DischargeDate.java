package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 88399:Open EVV: Verify error messages on uploading client with invalid input to 'DischargeDate'

public class TC88399_Client_DischargeDate extends BaseTest

{

	//**************************  DischargeDate :"062820188" (greater than 8 digits) (invalid Case) ***************************

	//case 1---- where every tag is included and is populated with a correct value except the below given field. ClientGender:"MF" (>1)

	@Test
	public void TC88399_OpenEVV_Client_DischargeDate_max_invalid_case() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88399_OpenEVV_Client_DischargeDate_max_invalid_case"); 
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("DischargeDate", "062820188");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The DischargeDate format is incorrect. The record should satisfy the date format [\\u0027MMddyyyy\\u0027]."));


	}

	//**************************************    DischargeDate :"28122018" (Incorrect format DDMMYYYY)   ********************************

	//case 2 each tag, where every tag is included and is populated with a correct value except the below given field.  DischargeDate :"28122018" (Incorrect format DDMMYYYY) 
	@Test
	public void TC88399_OpenEVV_Client_DischargeDate_Incorrect_format_DDMMYYYY_invalid_case() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88399_OpenEVV_Client_DischargeDate_Incorrect_format_DDMMYYYY_invalid_case");

		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("DischargeDate", "28122018");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The DischargeDate format is incorrect. The record should satisfy the date format [\\u0027MMddyyyy\\u0027]."));


	}
	//**************************************     DischargeDate :"20180618" (Incorrect format YYYYMMDD)    ********************************

	//case 3 each tag, where every tag is included and is populated with a correct value except the below given field.  DischargeDate :"28122018" (Incorrect format DDMMYYYY) 
	@Test
	public void TC88399_OpenEVV_Client_DischargeDate_Incorrect_format_YYYYMMDD_invalid_case() throws IOException, ParseException, ConfigurationException
	{

		logger = extent.startTest("TC88399_OpenEVV_Client_DischargeDate_Incorrect_format_YYYYMMDD_invalid_case");

		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("DischargeDate", "20180618");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The DischargeDate format is incorrect. The record should satisfy the date format [\\u0027MMddyyyy\\u0027]."));


	}

	//**************************************     DischargeDate :"0628201" (Incorrect format MMDDYYY)      ********************************

	//case 4 each tag, where every tag is included and is populated with a correct value except the below given field.  DischargeDate :"28122018" (Incorrect format DDMMYYYY) 
	@Test
	public void TC88399_OpenEVV_Client_DischargeDate_Incorrect_format_MMDDYYY_invalid_case() throws IOException, ParseException, ConfigurationException
	{

		logger = extent.startTest("TC88399_OpenEVV_Client_DischargeDate_Incorrect_format_MMDDYYY_invalid_case");
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("DischargeDate", "0628201");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The DischargeDate format is incorrect. The record should satisfy the date format [\\u0027MMddyyyy\\u0027]."));


	}
}