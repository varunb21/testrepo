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

public class R2154_TC96779_OpenEVV_ClientEmailAddress_invalid extends BaseTest {

	@Test
	public void R2154_TC96778_OpenEVV_ClientEmailAddress_length_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96778_OpenEVV_ClientEmailAddress_length_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientEmailAddress", CommonMethods.generateEmailAddress_string(40));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEmailAddressLengthError);

	}

	@Test
	public void R2154_TC96778_OpenEVV_ClientEmailAddress_spcl_char() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96778_OpenEVV_ClientEmailAddress_length_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientEmailAddress", CommonMethods.generateSpecialChar(10));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEmailAddressFormatError);

	}



}