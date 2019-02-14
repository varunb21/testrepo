package AltEVV_molina.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;

//Test Case 90983: ALTEVV-altEVV- Client:  Validate If the client Json does not include a ClientQualifier

public class R2267_TC90983_AltEVV_ClientQualifier_not_included extends BaseTest {


	//Case-1 OpenEVV-altEVV- Client:  Validate If the client Json does not include a ClientQualifier

	@Test 
	public void TC90983_ALTEVV_ClientQualifier_validvalue() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90983_ALTEVV_CreateClient_without_ClientQualifier"); // adding method name info via logger

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); //loading the Json dynamically with unique value set to check how its working go to the load json and understand the concept
		JSONObject js = (JSONObject) j.get(0);
		js.remove("ClientQualifier");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientQualifier cannot be null.");
	}

}
