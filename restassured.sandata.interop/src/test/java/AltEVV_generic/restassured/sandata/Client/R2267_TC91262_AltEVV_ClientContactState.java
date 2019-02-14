package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91261: OpenEVV-altEVV- Client- ClientContactState field formats/values

public class R2267_TC91262_AltEVV_ClientContactState extends BaseTest {

	//To validate the valid ClientContactState
	@Test
	public void TC91262_AltEVV_ClientContactState_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91262_AltEVV_ClientContactState_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", DataGeneratorClient.generateClientState());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonOb, jsonOb1);	

	}

	//To validate the ClientContactState invalid length
	@Test
	public void TC91262_AltEVV_ClientContactState_invalid_length() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91262_AltEVV_ClientContactState_invalid_length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", CommonMethods.getSaltString(3));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,  globalVariables.ClientStateLengthError_alt);

	}

	//To validate the ClientContactState with whitespace
	@Test
	public void TC91262_AltEVV_ClientContactState_whitespace() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91262_AltEVV_ClientContactState_whitespace"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState",CommonMethods.getSaltString(1)+ " " + CommonMethods.getSaltString(1));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateFormatError_alt);


	}

	//To validate the ClientContactState with leading space
	@Test
	public void TC91262_AltEVV_ClientContactState_leading_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91262_AltEVV_ClientContactState_leading_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", " " + DataGeneratorClient.generateClientState());

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateLengthError_alt);

	}

	//To validate the ClientContactState with trailing space
	@Test
	public void TC91262_AltEVV_ClientContactState_trailing_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91262_AltEVV_ClientContactState_trailing_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", DataGeneratorClient.generateClientState() + " ");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateLengthError_alt);


	}

	//To validate the ClientContactState with special char
	@Test
	public void TC91262_AltEVV_ClientContactState_spcl_char() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91262_AltEVV_ClientContactState_trailing_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", CommonMethods.generateSpecialChar(2));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,  globalVariables.ClientStateFormatError_alt);
	}

}