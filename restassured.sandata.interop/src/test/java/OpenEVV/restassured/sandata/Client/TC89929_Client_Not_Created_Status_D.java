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
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */
public class TC89929_Client_Not_Created_Status_D extends BaseTest
{
	//To validate the valid Clientjson with status as D in STX app user
	@Test(priority=0)
	public void TC89929_OpenEVV_Client_valid_json_with_Status_D_STXAPPUSER() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89929_OpenEVV_Client_valid_json_with_Status_D_STXAPPUSER"); 

		JSONArray jsonarray=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("Status", "D");

		CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader("clients"));

		DataBaseVerifier_Client.DataBaseVerificationClient_STX_App_User("USERNAME", jsonobject.get(globalVariables.ClientEmailAddress).toString(),
				"user_f_name",jsonobject.get(globalVariables.ClientFirstName).toString());
		Assert.assertEquals(DataBaseVerifier_Client.UserStatus_appuser, "DELETED");


	}

	//To validate the valid Clientjson with status as D STX client user
	@Test(priority=2)
	public void TC89929_OpenEVV_Client_valid_json_with_Status_D_STXCLIENT() throws IOException, ParseException, ConfigurationException, SQLException 
	{
		logger = extent.startTest("TC89929_OpenEVV_Client_valid_json_with_Status_D_STXCLIENT"); 

		JSONArray jsonarray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("Status", "D");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader("clients"));

		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		//	Assert.assertEquals(DataBaseVerifier_Client.UserStatus_appuser, "DELETED");
	}

	//To validate the valid Clientjson with status as D inbox.client
	@Test(priority=3)
	public void TC89929_OpenEVV_Client_valid_json_with_Status_D_inboxclient() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC89929_OpenEVV_Client_valid_json_with_Status_D_inboxclient"); 

		JSONArray jsonarray=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("Status", "D");

		CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader("clients"));

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", jsonobject.get(globalVariables.ClientID).toString(),
				"f_name",jsonobject.get(globalVariables.ClientFirstName).toString());

		Assert.assertEquals(DataBaseVerifier_Client.DeleteFlag_inClient, "1");


	}


}