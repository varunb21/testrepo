/**
 * 
 */
package AltEVV_molina.restassured.sandata.Client;
/**
 * @author Anupam
 *
 */
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
import java.io.IOException;
import java.sql.SQLException;

//Test Case 91107: OpenEVV-altEVV- Client: Validate (mix)- ClientPhone field format/values

public class R2267_TC91107_AltEVV_ClientPhone_Validations extends BaseTest{

	public static String Phnum, Phonenumber= "ani", id="LOC", val1;

	//Case-1 Testing with ClientPhone: >12 characters 
	@Test 
	public void TC91098_AltEVV_CreateClient_with_ClientPhone_more_than_10chars() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhone_more_than_10chars"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson ClientPhone with more than 10chars"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", CommonMethods.generateRandomNumberOfFixLength(11));


		logger.log(LogStatus.INFO, "Passing all parameters with ClientPhoneNumber more than 10chars");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientPhone value is incorrect. The length should be between 10 and 10.");
	}

	//Case-2 Testing with ClientPhone: <10 characters 
	@Test 
	public void TC91098_AltEVV_CreateClient_with_ClientPhone_less_than_10chars() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhone_less_than_10chars"); 


		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientPhone value is incorrect. The length should be between 10 and 10.");
	}

	//Case-3 Testing with valid ClientPhone: 10 characters 
	@Test(groups = { "Databasetest"})
	public void TC91098_AltEVV_CreateClient_with_ClientPhone_10chars_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhone_10chars_DB"); 

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader("altevv_clients"));

		//Assertion_DbVerifier.jsonAssert_InboxAni(bodyAsString, js, js3);




	}
}
