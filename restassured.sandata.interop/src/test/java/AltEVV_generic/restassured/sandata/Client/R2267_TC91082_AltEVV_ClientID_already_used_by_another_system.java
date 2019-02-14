/**
 * 
 */
package AltEVV_generic.restassured.sandata.Client;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

/**
 * @author Anupam
 *
 */

//Test Case 91082: OpenEVV-altEVV- Client:  Validate (mix) - Validate if the ClientID is already used by another system
public class R2267_TC91082_AltEVV_ClientID_already_used_by_another_system extends BaseTest {

	public static String Phnum, Phonenumber= "ani", id="LOC", val1;
	
	 //Case-1 Testing with ClientPhone: >12 characters 
	@Test 
	public void TC91082_AltEVV_CreateClient_ClientID_already_used_by_another_system	() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91082_AltEVV_CreateClient_ClientID_already_used_by_another_system"); 
		
		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson ClientID Already used"); 
		
		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject js = (JSONObject) j.get(0);
			
		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}
}
