/**
 * 
 */
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
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar

 *
 */

//Test Case 88273:Open EVV - Client - Only Required Filed

public class TC88273_Client_OnlyRequiredField  extends BaseTest
{

	public static String val1, val2= "F_NAME";

	//To validate the -Client-Load-Required Field with valid json
	@Test
	public void TC88273_OpenEVV_Client_RequiredField_valid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88273_OpenEVV_Client_RequiredField_valid");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("Client_RequireField");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(20));
		val1=  js.get("ClientFirstName").toString();
		System.out.println(val1);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//To validate the -Client-Load-Minimum Value with valid json into DB
	@Test
	public void TC88273_OpenEVV_Client_RequiredField_valid_inbox_DB_Verify() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88273_OpenEVV_Client_RequiredField_valid_inbox_DB_Verify");
		// To make the values in JSON dynamic
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("Client_RequireField");
		JSONObject js = (JSONObject) j.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);
	}
}


