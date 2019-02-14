package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

public class R2267_TC91130_AltEVV_ClientContactType extends BaseTest {


	// Validating valid altEVV ClientContact type with Family as value
	@Test (priority=0)
	public void R2267_TC91130_AltEVV_ClientContactType_valid_Family_chars() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91130_AltEVV_ClientContactType_valid_Family_chars"); 
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientContact type with Family as value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactType, DataGeneratorClient.clientContactType_altevv());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	

	}

	// Validating invalid altEVV ClientContact type other than specified value :Family|Friend|Other|Parent|Sibling|Spouse"
	@Test (priority=12)
	public void R2267_TC91130_AltEVV_ClientContactType_invalid_other_than_spcified_value() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91130_AltEVV_ClientContactType_invalid_other_than_spcified_value"); 
		logger.log(LogStatus.INFO, "Validating invalid altEVV ClientContact type other than specified value :Family|Friend|Other|Parent|Sibling|Spouse\""); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactType, CommonMethods.generateRandomStringOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactTypeFormatError);
	}

}