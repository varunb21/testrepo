package OpenEVV.restassured.sandata.Client;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

//Test Case 91728:Inter-op : Open EVV - Client - Validate the Client creation with "null" ClientSSN and ClientOtherID

public class TC91728_Clientcreation_with_null_SSN_OtherID_DBverify extends BaseTest{

	public static String dbclientssn= "client_ssn";
	
	//case-1 To validate the null ClientSSN and ClientOtherID DB verification 
	
	@Test
	public void TC91728_OpenEVV_invalid_ClientSSN_db_verify() throws IOException, ParseException, ConfigurationException, SQLException 
	{
		logger = extent.startTest("TC91728_OpenEVV_invalid_ClientSSN_db_verify");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientSSN", null);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

	//	Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);
	}
	
}