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

public class SEVV2313_TC96277_OpenEVV_ClientID_Validations extends BaseTest {
	
	// Case1 Validate ClientID with valid length =5
	
		@Test(groups = {"Database"})
		   public void TC96277_OpenEVV_ClientID_Validations() throws IOException, ParseException, ConfigurationException, SQLException
		{
			logger = extent.startTest("TC96277_OpenEVV_ClientID_Validations");  // adding method name info via logger

			JSONArray jsonObject=GenerateUniqueParam.ClientParams_OpenEVV("client");
			
			// To make the values in JSON dynamic
			JSONObject js = (JSONObject) jsonObject.get(0);
		
			String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonObject, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
			
			Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);
		}
}
