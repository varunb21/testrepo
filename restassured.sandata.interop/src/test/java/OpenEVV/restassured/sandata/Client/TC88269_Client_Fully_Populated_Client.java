package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 88269:Open EVV - Fully Populated Client

public class TC88269_Client_Fully_Populated_Client extends BaseTest
{	
	
	//To validate the Fully Populated Client with valid json
	@Test 
	public void TC88269_OpenEVV_Client_Fully_Populated_valid_case_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88269_OpenEVV_Client_Fully_Populated_valid_case_DB"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);	


	}
}