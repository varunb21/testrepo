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
public class Bug3577_TC94754_ClientAddressLine1_ClientAddressline2_underscore_hyphen_dot extends BaseTest
{
	//To validate valid ClientAddressLine1_ClientAddressline2_underscore_hyphen_dot 
	@Test(priority=0)
	public void Bug3577_TC94754_ClientAddressLine1_ClientAddressline2_underscore_hyphen_dot_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{

		logger = extent.startTest("Bug3577_TC94754_ClientAddressLine1_ClientAddressline2_underscore_hyphen_dot_valid"); 
	
		logger.log(LogStatus.INFO, "To validate valid ClientAddressLine1_ClientAddressline2_hash_dot_hyphen");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		js.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(5)
				+ "#" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "." + CommonMethods.generateRandomNumberOfFixLength(2)
				+ "-" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "_" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "/" + CommonMethods.generateRandomNumberOfFixLength(2)

					);
		js.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomStringOfFixLength(5)
				+ "#" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "." + CommonMethods.generateRandomStringOfFixLength(3)
				+ "-" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "_" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "/" + CommonMethods.generateRandomStringOfFixLength(2)

				);
		
		js.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));


		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		Assertion_DbVerifier.jsonAssert_InboxClients(bodyAsString, js);	

	}

	//To validate valid ClientAddressLine1_ClientAddressline2_hash_dot_hyphen
	@Test(priority=1)
	public void Bug3577_TC94754_ClientAddressLine1_ClientAddressline2_Except_underscore_hyphen_dot_invalid() throws IOException, ParseException, ConfigurationException, SQLException
	{

		logger = extent.startTest("Bug3577_TC94752_ClientAddressLine1_ClientAddressline2_Except_hash_dot_hyphen_invalid"); 
	
		logger.log(LogStatus.INFO, "To validate valid ClientAddressLine1_ClientAddressline2_Except_hash_dot_hyphen_invalid");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		js.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(5)
				+ "#" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "&%@" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "&" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "%");
		js.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomStringOfFixLength(5)
				+ "%" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "&%@" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "&" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "%");
		
		js.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));


		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
	  CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.specialcharadd1_add2FormatError);
	}
}
