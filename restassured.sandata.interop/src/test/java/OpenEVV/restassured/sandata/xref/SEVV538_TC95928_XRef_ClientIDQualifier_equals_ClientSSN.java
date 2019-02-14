/**
 * 
 */
package OpenEVV.restassured.sandata.xref;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
//Test Case 95928:Open EVV- Xref: Validate xref relation when ClientIDQualifier = ClientSSN

public class SEVV538_TC95928_XRef_ClientIDQualifier_equals_ClientSSN extends BaseTest{

	// Case1 Validate ClientIDQualifier_equals_ClientSSN

	@Test 
	public void TC95928_OpenEVV_XRef_ClientIDQualifier_equals_ClientSSN() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC95928_OpenEVV_XRef_ClientIDQualifier_equals_ClientSSN");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95928_OpenEVV_XRef_ClientIDQualifier_equals_ClientSSN"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonarray.get(0);

		jsobject.put(globalVariables.ClientIDQualifier, "ClientSSN");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsobject);

	}

	// Case2 Validate ClientIDQualifier_equals_Clientssn (Invalid)

	@Test 
	public void TC95928_OpenEVV_XRef_ClientIDQualifier_equals_Clientssn() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95928_OpenEVV_XRef_ClientIDQualifier_equals_Clientssn");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95928_OpenEVV_XRef_ClientIDQualifier_equals_Clientssn"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "Clientssn");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}

	// Case3 Validate ClientIDQualifier_equals_clientSSN (Invalid)

	@Test 
	public void TC95928_OpenEVV_XRef_ClientIDQualifier_equals_clientSSN() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95928_OpenEVV_XRef_ClientIDQualifier_equals_clientSSN");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95928_OpenEVV_XRef_ClientIDQualifier_equals_clientSSN"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "clientSSN");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}

	// Case4 Validate ClientIDQualifier_equals_clientssn (Invalid)

	@Test 
	public void TC95928_OpenEVV_XRef_ClientIDQualifier_equals_clientssn() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95928_OpenEVV_XRef_ClientIDQualifier_equals_clientssn");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95928_OpenEVV_XRef_ClientIDQualifier_equals_clientssn"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "clientssn");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}

	// Case5 Validate ClientIDQualifier_database validation (ClientOtherID/ClientCustomID/ClientID)

	@Test(groups = {"Database"})
	public void TC95928_OpenEVV_XRef_ClientIDQualifier_Databasevalidation() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC95928_OpenEVV_XRef_ClientIDQualifier_Databasevalidation");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95928_OpenEVV_XRef_ClientIDQualifier_Databasevalidation"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "ClientOtherID");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, js);
	}

	// Case6 Validate ClientIDQualifier_Random value

	@Test(groups = {"functest"})
	public void TC95928_OpenEVV_XRef_ClientIDQualifier_Randomvalue() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95928_OpenEVV_XRef_ClientIDQualifier_Randomvalue");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95928_OpenEVV_XRef_ClientIDQualifier_Randomvalue"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}

}
