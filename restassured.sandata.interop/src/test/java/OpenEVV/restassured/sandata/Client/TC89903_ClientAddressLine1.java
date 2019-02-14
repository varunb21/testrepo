package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import static io.restassured.RestAssured.given;

public class TC89903_ClientAddressLine1 extends BaseTest {

	public static String ClientAddress, Addr1= "addr1";

	//To validate the valid ClientAddressLine1
	@Test
	public void TC89903_OpenEVV_valid_ClientAddressLine1() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89903_OpenEVV_valid_ClientAddressLine1"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));
	}

	//To validate the invalid ClientAddressLine1 length
	@Test
	public void TC89903_OpenEVV_invalid_ClientAddressLine1_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89903_OpenEVV_invalid_ClientAddressLine1_length"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine1", "PYQUHBIJOEUFQDHPRUDSGORSGIQVOHMANHATTAN");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressLine1 length is invalid. The length should be between 1 and 30."));
	}

	//To validate the ClientAddressLine1 with single space
	@Test
	public void TC89903_OpenEVV_valid_ClientAddressLine1_single_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89903_OpenEVV_valid_ClientAddressLine1_single_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine1", "South Amboy");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the numeric value in ClientAddressLine1
	@Test
	public void TC89903_OpenEVV_numeric_ClientAddressLine1() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89903_OpenEVV_numeric_ClientAddressLine1"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine1", "Man1hattan");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine1 with trailing space
	@Test
	public void TC89903_OpenEVV_ClientAddressLine1_trailing_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89903_OpenEVV_ClientAddressLine1_trailing_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine1", "Manhattan ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine1 with leading space
	@Test
	public void TC89903_OpenEVV_ClientAddressLine1_leading_space() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89903_OpenEVV_ClientAddressLine1_leading_space"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine1", " Manhattan");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine1 with mid space and numeric
	@Test
	public void TC89903_OpenEVV_ClientAddressLine1_multiple_space_numeric() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89903_OpenEVV_ClientAddressLine1_multiple_space_numeric"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine1", "Test Address qwert1 piou abc");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine1 with special char
	@Test
	public void TC89903_OpenEVV_ClientAddressLine1_special_char() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC89903_OpenEVV_ClientAddressLine1_special_char"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine1", "Manhatt@n");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressLine1 format is incorrect."));
	}

	@Test
	public void TC89903_OpenEVV_ClientAddressLine1_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{

		// adding method name info via logger
		logger = extent.startTest("TC89903_OpenEVV_ClientAddressLine1_DB"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientAddressLine1_DB_verify"); 

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(10));
		ClientAddress = js.get("ClientAddressLine1").toString();
		System.out.println(ClientAddress);

		logger.log(LogStatus.INFO, "Passing parameters for ClientAddressLine1 ");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		Response resp = given().body(j.toJSONString()).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("user_name"),CommonMethods.propertyfileReader("user_pass")).
				header(CommonMethods.propertyfileReader("acc"), CommonMethods.propertyfileReader("AccId")).log().all().
				when().post(CommonMethods.propertyfileReader("clients")).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		System.out.println("Response Body is: " + resp.asString());

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	

	}

}
