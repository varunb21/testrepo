package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Open EVV-Client-Validate - Client Address - Verify Positive response is received with Positive values in ClientAddress segment

public class Bug181_TC95153_AltEVV_ClientAddress_included extends BaseTest {

	@Test
	public void Bug181_TC95153_AltEVV_ClientAddress_included_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("Bug181_TC95153_AltEVV_ClientAddress_included_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAdd = 	(JSONArray) jsonObject.get(globalVariables.addressArrayjson);
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(0);
		
		jsonObjectAdd.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomStringOfFixLength(10));
		jsonObjectAdd.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(5));
		
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrayAdd.get(1);
		
		jsonObjectAdd1.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomStringOfFixLength(10));
		jsonObjectAdd1.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(5));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString,jsonObject, jsonObjectAdd1);
	}


}