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

//Test Case 88388:Open EVV: Verify error messages on uploading client with invalid input to ClientBirthDate

public class TC88388_ClientBirthDate extends BaseTest

{

	//**************************   ClientBirthDate :"062820188" (greater than 8 digits) (invalid Case) ***************************

	//case 1---- where every tag is included and is populated with a correct value except the below given field.  ClientBirthDate :"062820188" (greater than 8 digits)

	@Test
	public void TC88388_OpenEVV_ClientBirthDate_Greaterthan_8_digit() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88388_OpenEVV_ClientBirthDate_Greaterthan_8_digit"); 
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientBirthDate", "062820188");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientBirthDate format is incorrect."));


	}


	//**************************    ClientBirthDate :"28122018" (Incorrect format DDMMYYYY) (invalid Case) ***************************

	//case 2---- where every tag is included and is populated with a correct value except the below given field.   ClientBirthDate :"28122018" (Incorrect format DDMMYYYY)

	@Test
	public void TC88388_OpenEVV_ClientBirthDate_incorrectformat_DDMMYYYY() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88388_OpenEVV_ClientBirthDate_incorrectformat_DDMMYYYY"); 
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientBirthDate", "28122018");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientBirthDate format is incorrect. The record should satisfy the date format [\\u0027MMddyyyy\\u0027]"));

	}


	//**************************    ClientBirthDate :"20180618" (Incorrect format YYYYMMDD) (invalid Case) ***************************

	//case 3---- where every tag is included and is populated with a correct value except the below given field.   ClientBirthDate :"20180618" (Incorrect format YYYYMMDD) 

	@Test
	public void TC88388_OpenEVV_ClientBirthDate_incorrectformat_YYYYMMDD() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88388_OpenEVV_ClientBirthDate_incorrectformat_YYYYMMDD"); 
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientBirthDate", "20180618");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		
		//assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientBirthDate format is incorrect. The record should satisfy the date format [\\u0027MMddyyyy\\u0027]"));

	}


	//**************************    ClientBirthDate :"0628201" (Incorrect format MMDDYYY)  (invalid Case) ***************************

	//case 4---- where every tag is included and is populated with a correct value except the below given field.   ClientBirthDate :"0628201" (Incorrect format MMDDYYY) 

	@Test
	public void TC88388_OpenEVV_ClientBirthDate_incorrectformat_MMDDYYY() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88388_OpenEVV_ClientBirthDate_incorrectformat_MMDDYYY");  
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientBirthDate", "20180618");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		//assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientBirthDate format is incorrect. The record should satisfy the date format [\\u0027MMddyyyy\\u0027]"));

	}
}