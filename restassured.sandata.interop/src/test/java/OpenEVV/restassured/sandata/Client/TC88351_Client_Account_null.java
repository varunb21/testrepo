package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 88351:Open EVV - Upload Client - "Account" :null

public class TC88351_Client_Account_null extends BaseTest {

	//To validate null account 
	@Test
	public void TC88351_OpenEVV_Client_null_account() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88351_OpenEVV_Client_null_account"); 
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", null);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");
		
		//Using Assert to validate the expected result
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));
	}

}