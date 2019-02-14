package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Open EVV Client- Validate the client Json for invalid case of ClientSuffix (Refer the steps for scenario)

public class R2154_TC96845_OpenEVV_ClientSuffix_invalid extends BaseTest {

	@Test
	public void R2154_TC96845_OpenEVV_ClientSuffix_Length_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96845_OpenEVV_ClientSuffix_Length_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSuffix", CommonMethods.generateRandomStringOfFixLength(5));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSuffixLengthError);

	}

	@Test
	public void R2154_TC96845_OpenEVV_ClientSuffix_Length_spcl_char() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96845_OpenEVV_ClientSuffix_Length_spcl_char"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSuffix", CommonMethods.generateSpecialChar(4));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSuffixFormatError);

	}


}