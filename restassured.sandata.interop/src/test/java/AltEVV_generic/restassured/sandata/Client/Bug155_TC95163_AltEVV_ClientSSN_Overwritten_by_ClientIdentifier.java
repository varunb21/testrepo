package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 95163:Validate if ClientQualifier is "ClientSSN", ClientSSN will be overwritten by ClientIdentifier

public class Bug155_TC95163_AltEVV_ClientSSN_Overwritten_by_ClientIdentifier extends BaseTest {

	//Case1: Validate if ClientQualifier is "ClientSSN", ClientSSN will be overwritten by ClientIdentifier
	@Test
	public void TC95163_AltEVV_ClientQualifier_with_ClientSSN() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC95163_AltEVV_ClientQualifier_with_ClientSSN"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", "ClientSSN");
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	
		
	}
}