package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */
//Test Case 91080:Inter-op - Open EVV - Client - Validate ClientID field in address and ClientPhone Segment

public class TC91080_ClientID_ClientPhone  extends BaseTest
{

	// Case-1 Testing with invalid null ClientID field
	@Test
	public void TC91080_OpenEVV_invalid_ClientID_field_different_all3_place() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC91080_OpenEVV_invalid_ClientID_field_different_all3_place");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(6));

		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(6));
		
		js2 = (JSONArray) js.get("ClientAddress");
		js3 = (JSONObject) js2.get(0);
		js3.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);

	}

}
