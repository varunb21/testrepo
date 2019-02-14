package OpenEVV.restassured.sandata.Client;

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

// Test Case 91584:Inter-op - Open EVV - CLient - Validate Client creation with Same SSN

public class TC91584_ExistingSSN_DBverify extends BaseTest{

	public static String val1, val2= "client_ssn";

	//case-1 To validate the invalid ClientSSN in database error code should be 0
	@Test
	public void TC91584_OpenEVV_ClientSSN_new_dberrorcode() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91584_OpenEVV_ClientSSN_new_dberrorcode");

		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
		// js.put("ClientSSN", "992723210");
		val1=  js.get("ClientSSN").toString();
		System.out.println(val1);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	

	}

	//Case-2 To validate the Client ssn if duplicate the in database error code should be -1043
	@Test
	public void TC91584_OpenEVV_Client_ssn_duplicate_dberrorcode() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91584_OpenEVV_Client_ssn_duplicate_dberrorcode");

		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		//js.put("ClientSSN", DataGeneratorClient_OpenEVV.generateClientSSN(5));
		js.put("ClientSSN", val1);

		//val=  js.get("ClientSSN").toString();
		System.out.println(val1);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("ClIENT_SSN", val1,
				"f_name", js.get(globalVariables.ClientFirstName).toString());

		Assert.assertEquals(DataBaseVerifier_Client.ncode_inClient, "-1053");

	}

}