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
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */
public class TC88822_Load_maximum_Client_PayerId_Coordinator extends BaseTest
{

	@Test(priority=0)
	public void TC88822_Load_maximum_Client_PayerId_Coordinator_Valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88822_Load_maximum_Client_PayerId_Coordinator_Valid"); 
	
		logger.log(LogStatus.INFO, "To validate valid TC88822_Load_maximum_Client_PayerId_Coordinator_Valid");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		JSONObject js = (JSONObject) j.get(0);
		js.put(globalVariables.PayerID, CommonMethods.generateRandomNumberOfFixLength(64));
		js.put(globalVariables.coordinator, CommonMethods.generateRandomStringOfFixLength(3));

	
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	

	}

}
