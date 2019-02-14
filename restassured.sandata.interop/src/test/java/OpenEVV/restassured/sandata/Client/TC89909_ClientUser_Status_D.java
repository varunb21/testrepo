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
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Client;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 89909:Open EVV - Clients - Verify the Client User just after sending the Status 'D'

public class TC89909_ClientUser_Status_D extends BaseTest
{

	//To validate the valid Clientjson with status as D in STX app user
	@Test(priority=1)
	public void TC89909_OpenEVV_Client_valid_json_create_then_sent_with_Status_D__STXAPPUSER() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException{
		
		logger = extent.startTest("TC89909_OpenEVV_Client_valid_json_create_then_sent_with_Status_D__STXAPPUSER"); 

		JSONArray jsonarray=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader("clients"));

		String bodyasget=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("Client_get"));
		
		jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("Status", "D");

		bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader("clients"));

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", jsonobject.get(globalVariables.ClientID).toString(),
				"f_name",jsonobject.get(globalVariables.ClientFirstName).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.DeleteFlag_inClient,"1");
		}


}
