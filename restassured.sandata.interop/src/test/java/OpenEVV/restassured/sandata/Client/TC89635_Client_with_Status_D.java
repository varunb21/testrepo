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
//Test Case 89635:Open EVV - Client - Client with Status 'D'

public class TC89635_Client_with_Status_D extends BaseTest
{

	@Test
	public void TC89635_OpenEVV_Client_Status_D() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC89635_OpenEVV_Client_Status_D");  

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", "D");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", js.get(globalVariables.ClientID).toString(),
				"f_name",js.get(globalVariables.ClientFirstName).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.DeleteFlag_inClient,"1");
	

	}

}
