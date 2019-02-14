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
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV538_TC95929_XRef_ClientIDQualifier_equals_ClientOtherID extends BaseTest{
	String ClientOtherIDval;

	// Case1 Validate ClientIDQualifier_equals_ClientOtherID

	@Test(groups = {"Database"})
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_equals_ClientOtherID() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_equals_ClientOtherID");  // adding method name info via logger

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "ClientOtherID");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, js);

	}

	// Case2 Validate ClientIDQualifier_equals_ClientotherID (Invalid)

	@Test 
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_equals_ClientotherID() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_equals_ClientotherID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95929_OpenEVV_XRef_ClientIDQualifier_equals_ClientotherID"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "ClientotherID");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}
	// Case3 Validate ClientIDQualifier_equals_clientOtherID (Invalid)

	@Test 
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientOtherID() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientOtherID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientOtherID"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "clientOtherID");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}

	// Case4 Validate ClientIDQualifier_equals_clientotherid (Invalid)

	@Test 
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientotherid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientotherid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientotherid"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "clientotherid");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}

	// Case5 Validate ClientIDQualifier_invalid()

	@Test 
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_invalid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_invalid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95929_OpenEVV_XRef_ClientIDQualifier_invalid"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientOtherID, CommonMethods.generateRandomNumberOfFixLength(5));
		ClientOtherIDval= js.get("ClientOtherID").toString();
		js.put(globalVariables.ClientIDQualifier, ClientOtherIDval);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}
	// Case6 Validate ClientIDQualifier_Randomvalue

	@Test 
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_Randomvalue() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_Randomvalue");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95929_OpenEVV_XRef_ClientIDQualifier_Randomvalue"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);

	}
}
