package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 92480: Inter-op -Open EVV - Client - Validate the Error Code and Description in GET Response

public class CR91802_TC92480_Client_Error_Code_Description_in_GET extends BaseTest
{	
	
	@Test
	public void TC92480_openEVV_Client_creation_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC92480_openEVV_Client_creation_valid");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV("client");
	
		String clientssn = CommonMethods.generateRandomNumberOfFixLength(9);
		
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put("ClientSSN", clientssn);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));
		
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);

		js.put("ClientSSN", clientssn);
		String bodyAsStringRe = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));
	
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsStringRe, CommonMethods.propertyfileReader("Client_get"));
		
		Assert.assertTrue(bodyAsStringGet.contains("\"message\": \"All records updated successfully.\","));
		
	}

}