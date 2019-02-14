package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//TC91120: OpenEVV-altEVV- Client Address -ClientAddressLine1 validation field formats/values

public class Bug88434_TC88642_AltEVV_ClientAddLine1_hash extends BaseTest {

	@Test
	public void Bug88434_TC88642_AltEVV_ClientAddLine1_hash_validation() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("Bug88434_TC88642_AltEVV_ClientAddLine1_hash_validation"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(5) + "#" + CommonMethods.generateRandomStringOfFixLength(7));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(5) + "#" + CommonMethods.generateRandomStringOfFixLength(7));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObjectAdd1);
		
	}


}