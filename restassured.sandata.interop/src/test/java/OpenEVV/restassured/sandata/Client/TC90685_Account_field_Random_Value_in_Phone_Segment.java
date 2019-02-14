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
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 90685:Inter-op - Open EVV- Client - Account field validation for any Random Value in Phone Segment

public class TC90685_Account_field_Random_Value_in_Phone_Segment extends BaseTest 
{

	public static String val, val1= "account";

	// Validating Account field in Main Segment but any random value sin Account field present in Phone segment(Invalid).
	@Test(priority=1)
	public void TC90685_OpenEVV_Client_valid_Account_with_Randomvalue_in_Account_Under_ClientPhone() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90685_OpenEVV_Client_valid_Account_with_Randomvalue_in_Account_Under_ClientPhone");

		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("Account",CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));;

		logger.log(LogStatus.INFO, "Validating DB response ");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "");

	}
}
