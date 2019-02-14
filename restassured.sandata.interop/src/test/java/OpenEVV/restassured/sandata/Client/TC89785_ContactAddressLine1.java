package OpenEVV.restassured.sandata.Client;
import static io.restassured.RestAssured.given;
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
import io.restassured.response.Response;

//Test Case 89785:Open EVV-Client-Validate (mix) - ContactAddressLine1 field formats/values

public class TC89785_ContactAddressLine1 extends BaseTest
{	


	//case 1---- - - ContactAddressLine1= "TestAddress"   (valid Case)
	@Test
	public void TC89785_OpenEVV_Client_ContactAddressLine1_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89785_OpenEVV_Client_ContactAddressLine1_valid");  
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put(globalVariables.ContactAddressLine1, "TestAddress");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));
		// assert validation to verify the outcome
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	
	}

	//case 2--leading spaces: ContactAddressLine1= "  TestAddress"    (valid Case)
	@Test
	public void TC89785_OpenEVV_Client_ContactAddressLine1_headingspace() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89785_OpenEVV_Client_ContactAddressLine1_headingspace");  
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put(globalVariables.ContactAddressLine1, "  TestAddress");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		// assert validation to verify the outcome
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	
	}

	//case 3--Trailing spaces: ContactAddressLine1= "TestAddress "    (valid Case)
	@Test
	public void TC89785_OpenEVV_Client_ContactAddressLine1_leadingspace() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89785_OpenEVV_Client_ContactAddressLine1_leadingspace");  
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put(globalVariables.ContactAddressLine1, " TestAddress  ");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		// assert validation to verify the outcome
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	
	}

	//case 4--valid value and format with multiple space:- ContactAddressLine1= "Test Address qwerty piou abc"  less than 30 (valid Case)
	@Test
	public void TC89785_OpenEVV_Client_ContactAddressLine1_with_space_alphabet() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89785_OpenEVV_Client_ContactAddressLine1_with_space_alphabet");  
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put(globalVariables.ContactAddressLine1, "Test Address qwerty piou abc");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		// assert validation to verify the outcome
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	
	}

	//case 5--valid value and format but more then 30:- ContactAddressLine1= "Test Address qwerty piou abceqweqeqw"  more than 30 (invalid Case)
	@Test
	public void TC89785_OpenEVV_Client_ContactAddressLine1_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89785_OpenEVV_Client_ContactAddressLine1_invalid");  
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put(globalVariables.ContactAddressLine1, "Test Address qwerty piou abceqweqeqw");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));
		// assert validation to verify the outcome
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ContactAddressLine1LengthError);
	}

	//case 6--valid value and format but more then 30:- ContactAddressLine1= "TestAddressqwertypiouaqweqwewqebceqweqeqw"  more than 30 (invalid Case)
	@Test
	public void TC89785_OpenEVV_Client_ContactAddressLine1_without_space_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89785_OpenEVV_Client_ContactAddressLine1_without_space_invalid");  
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put(globalVariables.ContactAddressLine1, "TestAddressqwertypiouaqweqwewqebceqweqeqw");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		// assert validation to verify the outcome
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ContactAddressLine1LengthError);
	}		

	//case 7--valid value and format:-valid value and format:- ContactAddressLine1= "##Test Address qwerty piou a"   (invalid Case)
	@Test
	public void TC89785_OpenEVV_Client_ContactAddressLine1_specialchar() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89785_OpenEVV_Client_ContactAddressLine1_specialchar");  
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put(globalVariables.ContactAddressLine1, CommonMethods.generateSpecialChar(20));

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		// assert validation to verify the outcome
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ContactAddressLine1FormatError);
	}
}