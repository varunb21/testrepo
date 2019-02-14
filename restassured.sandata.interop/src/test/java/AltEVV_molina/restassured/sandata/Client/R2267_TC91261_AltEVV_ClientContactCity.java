package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91261: OpenEVV-altEVV- Client- ClientContactCity field formats/values

public class R2267_TC91261_AltEVV_ClientContactCity extends BaseTest {

	//To validate the valid ClientContactCity
	@Test
	public void TC91261_AltEVV_ClientContactCity_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91261_AltEVV_ClientContactCity_valid"); 

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArr, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonOb, jsonOb1);	

	}

	//To validate the ClientContactCity invalid length
	@Test
	public void TC91261_AltEVV_ClientContactCity_invalid_length() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91261_AltEVV_ClientContactCity_invalid_length"); 

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArr, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,  globalVariables.ClientContactCityLengthError_alt);

	}

	//To validate the ClientContactCity with whitespace
	@Test
	public void TC91261_AltEVV_ClientContactCity_whitespace() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91261_AltEVV_ClientContactCity_invalid_length"); 

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(8) + " " + CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArr, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonOb, jsonOb1);	
	}

	//To validate the ClientContactCity with leading space
	@Test
	public void TC91261_AltEVV_ClientContactCity_leading_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91261_AltEVV_ClientContactCity_leading_space"); 

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", " " + CommonMethods.generateRandomStringOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArr, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonOb, jsonOb1);	
	}

	//To validate the ClientContactCity with trailing space
	@Test
	public void TC91261_AltEVV_ClientContactCity_trailing_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91261_AltEVV_ClientContactCity_trailing_space"); 

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(8) + " ");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArr, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonOb,jsonOb1);	
	}

	//To validate the ClientContactCity with special char
	@Test
	public void TC91261_AltEVV_ClientContactCity_spcl_char() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91261_AltEVV_ClientContactCity_trailing_space"); 

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArr, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,  globalVariables.ClientContactCityFormatError_alt);
	}

}