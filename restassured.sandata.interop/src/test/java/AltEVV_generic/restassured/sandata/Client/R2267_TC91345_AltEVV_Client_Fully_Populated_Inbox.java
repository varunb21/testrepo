package AltEVV_generic.restassured.sandata.Client;

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

//Test Case 91344: Open EVV-altEVV-Client - Field Mapping-Schema:STX - Fully Populated

public class R2267_TC91345_AltEVV_Client_Fully_Populated_Inbox extends BaseTest {

	//Validating AltEVV Client Creation in Inbox DB 
	@Test
	public void R2267_TC91345_AltEVV_Client_Fully_Populated_Inbox_DB() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91344_AltEVV_Client_Fully_Populated_Inbox_DB"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	}


}