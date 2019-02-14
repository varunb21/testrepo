package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import junit.framework.Assert;

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

public class R2267_TC91285_AltEVV_ClientAddressLongitude extends BaseTest {


	// Validating valid altEVV condition Send All Addresses when individual changed
	@Test (priority=0)
	public void R2267_TC92228_AltEVV_AllAddresses_individual_changed_valid_Family_chars() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC92228_AltEVV_AllAddresses_individual_changed_valid_Family_chars"); 
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientContact type with Family as value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	//	jsonObject.put(globalVariables.ClientContactType, DataGeneratorClient.clientContactType("Family"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);

	}

	
}