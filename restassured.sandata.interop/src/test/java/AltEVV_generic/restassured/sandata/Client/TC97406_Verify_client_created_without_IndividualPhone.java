package AltEVV_generic.restassured.sandata.Client;

import java.io.FileNotFoundException;
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
import io.restassured.path.json.JsonPath;

public class TC97406_Verify_client_created_without_IndividualPhone extends BaseTest {
	
	@Test
	public void TC97406_Verify_client_created_without_IndividualPhone_pass() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC97406_Verify_client_created_without_IndividualPhone"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.remove("ClientPhone");
	
	//	jsonObject.put(globalVariables.ClientContactType, DataGeneratorClient.clientContactType("Family"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);

	}

}
