package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 95165:Validate if ClientQualifier is "ClientCustomID", ClientCustomID will be overwritten by ClientIdentifier.

public class Bug155_TC95165_AltEVV_ClientCustomID_Overwritten_by_ClientIdentifier extends BaseTest {

	//Case1: Validate if ClientQualifier is "ClientCustomID", ClientCustomID will be overwritten by ClientIdentifier.
	
	String ClientIdentifier;
	@Test
	public void TC95165_AltEVV_ClientQualifier_with_ClientCustomID() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC95165_AltEVV_ClientQualifier_with_ClientCustomID"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", "ClientCustomID");
		jsonObject.put("ClientIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	
		
	}
}