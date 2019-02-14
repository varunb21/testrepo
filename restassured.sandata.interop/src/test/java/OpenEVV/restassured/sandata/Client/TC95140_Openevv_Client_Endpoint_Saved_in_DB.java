package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class TC95140_Openevv_Client_Endpoint_Saved_in_DB extends BaseTest{
	

	//To validate the -Client-Load-Maximum Value with valid json
	@Test
	public void TC95140_Validate_Openevv_Client_data_with_endpoint_Saved_in_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95140_Validate_Openevv_Client_data_with_endpoint_Saved_in_DB");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);	

	}

}
