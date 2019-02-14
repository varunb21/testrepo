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
 * @author Anupam
 *
 */

//Test Case 96872: Open EVV Client- Validate the client Json for invalid case of ClientContactPhoneType (Refer the steps for scenario)

	public class R2154_TC96872_OpenEVV_ClientContactPhoneType_invalid extends BaseTest {

	@Test
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_Numeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_Numeric"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", CommonMethods.generateRandomNumberOfFixLength(13));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}
	
	@Test
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_Alphanumeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_Alphanumeric"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", CommonMethods.generateRandomAlphaNumeric(13));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}
	
	@Test
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_NULL() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_NULL"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", "NULL");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}
	@Test
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_specialchars() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_specialchars"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", CommonMethods.generateSpecialChar(13));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypelength);
	}
	@Test
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_null_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_null_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", "null");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}
	
	@Test
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_otherthan_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_otherthan_valid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", "Homee");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}
	
	@Test
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_with_spaceinvalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_with_spaceinvalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", "Hom ee");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}
	
}