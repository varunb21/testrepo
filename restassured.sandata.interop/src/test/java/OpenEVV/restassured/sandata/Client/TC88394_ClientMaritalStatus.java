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

//Test Case 88394:Open EVV: Verify error messages on uploading client with invalid input to 'ClientMaritalStatus'


public class TC88394_ClientMaritalStatus extends BaseTest
{



	//**************************  ClientMaritalStatus- "MS" (>1 length) (invalid Case) ***************************

	//case 1---- where every tag is included and is populated with a correct value except the below given field. ClientMaritalStatus- "MS" (>1 length)

	@Test
	public void TC88394_OpenEVV_ClientMaritalStatus_max_invalid_case() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88394_OpenEVV_ClientMaritalStatus_max_invalid_case"); 
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMaritalStatus", "MS");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientMaritalStatus length is invalid. The length should be between 0 and 1."));


	}

	//**************************  ClientMaritalStatus- "P" (Other than allowable values) (invalid Case) ***************************

	//case 2---- where every tag is included and is populated with a correct value except the below given field. ClientMaritalStatus- "P" (Other than allowable values)

	@Test
	public void TC88394_OpenEVV_ClientMaritalStatus_Other_than_allowable_values_invalid_case() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88394_OpenEVV_ClientMaritalStatus_Other_than_allowable_values_invalid_case"); 
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMaritalStatus", "p");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
 

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientMaritalStatus format is incorrect. The record should satisfy this regular expression [\\u0027M|S|W|O\\u0027]"));


	}
	//**************************  ClientMaritalStatus- "1" (Numeric value) (invalid Case) ***************************

	//case 2---- where every tag is included and is populated with a correct value except the below given field. ClientMaritalStatus- "1" (Numeric value) 

	@Test
	public void TC88394_OpenEVV_ClientMaritalStatus_Numeric_invalid_case() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88394_OpenEVV_ClientMaritalStatus_Numeric_invalid_case"); 
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMaritalStatus", "1");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));


		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientMaritalStatus format is incorrect. The record should satisfy this regular expression [\\u0027M|S|W|O\\u0027]"));


	}
}