package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 88271:Open EVV -Client-Load-Maximum Values

public class TC88271_Client_Load_Maxvalue extends  BaseTest
{	

	//To validate the -Client-Load-Maximum Value with valid json
	@Test
	public void TC88271_OpenEVV_Client_LoadMaximumValues_valid_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88271_OpenEVV_Client_LoadMaximumValues_valid_DB");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js=(JSONObject) j.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);

	}
}