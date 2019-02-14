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
public class Bug3577_TC94737_ClientAddressLine1_ClientAddressline2_ClientCity_Hash extends BaseTest
{
	//To validate valid ClientAddressLine1_ClientAddressline2_ClientCity accepts LongChar
	@Test(priority=0)
	public void Bug_3577_TC94731_ClientAddressLine1_ClientAddressline2_ClientCity_LongChar_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		
		logger = extent.startTest("Bug_3577_TC94731_ClientAddressLine1_ClientAddressline2_ClientCity_LongChar_valid"); 

		logger.log(LogStatus.INFO, "To validate valid ClientAddressLine1_ClientAddressline2_ClientCity accepts Long char");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		js.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(20));
		js.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomStringOfFixLength(20));
		js.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		Assertion_DbVerifier.jsonAssert_InboxClients(bodyAsString, js);	
	}

	//To validate valid ClientAddressLine1_ClientAddressline2_ClientCity accepts letter
	@Test(priority=1)
	public void Bug_3577_TC94731_ClientAddressLine1_ClientAddressline2_ClientCity_Letter_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("Bug_3577_TC94731_ClientAddressLine1_ClientAddressline2_ClientCity_letter_valid"); 

		logger.log(LogStatus.INFO, "To validate valid ClientAddressLine1_ClientAddressline2_ClientCity accepts letter");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		js.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(5)
				+ "#" + CommonMethods.generateRandomNumberOfFixLength(5)
				);
		js.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomStringOfFixLength(5)
				+ "#" + CommonMethods.generateRandomStringOfFixLength(5)
				);
		js.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		Assertion_DbVerifier.jsonAssert_InboxClients(bodyAsString, js);	
	}

}
