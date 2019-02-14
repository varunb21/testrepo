package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//TC95157: OpenEVV-AltEVV: Correct error should be shown in response IF value of ClientSSN is passed wrong in Json

public class Bug125_TC95157_AltEVV_ClientSSN_Incorrect_Err_Msg extends BaseTest {
	//Case1: ClientSSN passed with less then 9chars(Valid case as per latest req doc ALTEVV_5.8)
	
	String ClientSSN;
	@Test
	public void TC95157_AltEVV_ClientSSN_with_6char_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC95157_AltEVV_ClientSSN_with_6char_length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	

	}
	
	//Case2: ClientSSN passed with max 9chars(Valid case as per latest req doc ALTEVV_5.8)
	@Test
	public void TC95157_AltEVV_ClientSSN_with_maxlength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC95157_AltEVV_ClientSSN_with_maxlength"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	

	}
	
	//Case3: ClientSSN passed wrong in Json(Valid case as per latest req doc ALTEVV_5.8)
	@Test
	public void TC95157_AltEVV_ClientSSN_with_invalidvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC95157_AltEVV_ClientSSN_with_invalidvalue"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomAlphaNumeric(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSSNFormatError);


	}
}