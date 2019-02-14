package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

//Test Case 96277:Open EVV- Verify record is getting uploaded successfully with ClientID of 5 digits

public class SEVV2313_TC96281_OpenEVV_Sending_Same_ClientID extends BaseTest {

	@Test
	public void TC96281_OpenEVV_ClientID_Valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96281_OpenEVV_ClientID_Valid");  // adding method name info via logger

		JSONArray jsonObject=GenerateUniqueParam.ClientParams_OpenEVV("client");

		String clientID = CommonMethods.generateRandomNumberOfFixLength(5);
		
		JSONObject js = (JSONObject) jsonObject.get(0);
		js.put("ClientID", clientID);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", clientID);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", clientID);
		
		JSONObject js4 = (JSONObject) j3.get(1);
		js4.put("ClientID", clientID);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonObject, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);

		String bodyAsStringRe = CommonMethods.captureResponseOPENEVV(jsonObject, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsStringRe, js);
	}
}
