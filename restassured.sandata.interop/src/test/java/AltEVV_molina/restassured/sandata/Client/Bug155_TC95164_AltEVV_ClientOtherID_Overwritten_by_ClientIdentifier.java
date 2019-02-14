package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 95164:Validate if ClientQualifier is "ClientOtherID", ClientOtherID will be overwritten by ClientIdentifier

public class Bug155_TC95164_AltEVV_ClientOtherID_Overwritten_by_ClientIdentifier extends BaseTest {

	//Case1: Validate if ClientQualifier is "ClientOtherID", ClientOtherID will be overwritten by ClientIdentifier
	
	String ClientIdentifier;
	@Test
	public void TC95164_AltEVV_ClientQualifier_with_ClientOtherID() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC95164_AltEVV_ClientQualifier_with_ClientOtherID"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", "ClientOtherID");
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	
		
	}
}