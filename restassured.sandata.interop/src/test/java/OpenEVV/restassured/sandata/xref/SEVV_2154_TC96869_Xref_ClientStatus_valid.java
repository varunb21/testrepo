package OpenEVV.restassured.sandata.xref;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Client;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

// Test Case 96869: Open EVV XRef- Validate the XRef Json for valid case of ClientStatus (Refer the steps for scenario)

public class SEVV_2154_TC96869_Xref_ClientStatus_valid  extends BaseTest{


	@Test 
	public void TC96869_Validate_XRef_ClientStatus_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96869_Validate_XRef_ClientStatus_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", DataGeneratorClient.clientStatus());

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);


	}


	@Test 
	public void TC96869_Validate_XRef_ClientStatus_Active_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96869_Validate_XRef_ClientStatus_Pending_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "02");

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);

	}


	@Test 
	public void TC96869_Validate_XRef_ClientStatus_Hold_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96869_Validate_XRef_ClientStatus_Hold_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "03");

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);

	}

	@Test 
	public void TC96869_Validate_XRef_ClientStatus_inactive_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96869_Validate_XRef_ClientStatus_inactive_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "04");

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		DataBaseVerifier_Client.DataBaseVerificationClient_inbox_XrefService("LOC", jsonobject.get(globalVariables.ClientID).toString(),
				"WORKER_ID", jsonobject.get("EmployeeID").toString());
	
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.ncode_inboxXref, "-1115");

	}

	@Test 
	public void TC96869_Validate_XRef_ClientStatus_pending_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96869_Validate_XRef_ClientStatus_pending_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "01");

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);

	}
}
