package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Open EVV Client- Validate the client Json for valid case of ClientEmailAddress 

public class R2154_TC96778_OpenEVV_ClientEmailAddress_valid extends BaseTest {

	@Test
	public void R2154_TC96778_OpenEVV_ClientEmailAddress_Length_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96778_OpenEVV_ClientEmailAddress_Length_max"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientEmailAddress", CommonMethods.generateEmailAddress_alpha(35));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);

	}

	@Test
	public void R2154_TC96778_OpenEVV_ClientEmailAddress_numeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96778_OpenEVV_ClientEmailAddress_numeric"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientEmailAddress", CommonMethods.generateEmailAddress_num(10));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);

	}

	@Test
	public void R2154_TC96778_OpenEVV_ClientEmailAddress_alphanumeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96778_OpenEVV_ClientEmailAddress_alphanumeric"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientEmailAddress", CommonMethods.generateEmailAddress_alpha(15));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);

	}



}