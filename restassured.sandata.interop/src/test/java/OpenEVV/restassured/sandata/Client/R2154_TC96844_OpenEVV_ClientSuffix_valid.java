package OpenEVV.restassured.sandata.Client;

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

//Open EVV Client- Validate the client Json for valid case of ClientSuffix (Refer the steps for scenario)

public class R2154_TC96844_OpenEVV_ClientSuffix_valid extends BaseTest {

	@Test
	public void R2154_TC96844_OpenEVV_ClientSuffix_Length_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96844_OpenEVV_ClientSuffix_Length_max"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSuffix", CommonMethods.generateRandomStringOfFixLength(4));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);

	}
	
	@Test
	public void R2154_TC96844_OpenEVV_ClientSuffix_Length_min() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96844_OpenEVV_ClientSuffix_Length_min"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSuffix", CommonMethods.generateRandomStringOfFixLength(1));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);

	}
	
	@Test
	public void R2154_TC96844_OpenEVV_ClientSuffix_Jr() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96844_OpenEVV_ClientSuffix_Length_min"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSuffix", "Jr");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);

	}
	
	@Test
	public void R2154_TC96844_OpenEVV_ClientSuffix_Sr() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96844_OpenEVV_ClientSuffix_Length_min"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSuffix", "Sr");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);

	}
	
	@Test
	public void R2154_TC96844_OpenEVV_ClientSuffix_IV() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96844_OpenEVV_ClientSuffix_Length_min"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSuffix", "IV");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);

	}
	
}