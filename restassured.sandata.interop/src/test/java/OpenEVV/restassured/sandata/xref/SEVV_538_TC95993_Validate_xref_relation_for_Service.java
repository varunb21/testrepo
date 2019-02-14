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
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_538_TC95993_Validate_xref_relation_for_Service extends BaseTest{

	//To validate the valid service code
	@Test
	public void TC95993_Validate_xref_relation_when_Service_is_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC95993_Validate_xref_relation_when_Service_is_valid");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", DataGeneratorClient.servicecodeList());

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
	}

	//To validate the invalid service code
	@Test 
	public void TC95993_Invalid_xref_relation_when_Service_is_null() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_null");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service cannot be null.");
	}

	//To validate the invalid service code
	@Test 
	public void TC95993_Invalid_xref_relation_when_Service_is_NULL() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_NULL");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", "NULL");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);


	}

	//To validate the invalid service code
	@Test 
	public void TC95993_Invalid_xref_relation_when_Service_is_Blank() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_Blank");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", "");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service format is incorrect. The record should satisfy this regular expression");

	}

	//To validate the invalid service code
	@Test 
	public void TC95993_Invalid_xref_relation_when_Service_is_greaterthan_allowed_length() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_greaterthan_allowed_length");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", CommonMethods.generateRandomStringOfFixLength(13));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service format is incorrect. The record should satisfy this regular expression");


	}

	//To validate the invalid service code
	@Test 
	public void TC95993_Invalid_xref_relation_when_Service_is_special_character() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_special_character");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service format is incorrect. The record should satisfy this regular expression");


	}

	//To validate the invalid service code
	@Test 
	public void TC95993_Invalid_xref_relation_when_Service_is_with_space() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_with_space");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", CommonMethods.generateRandomAlphaNumeric(3) + " " +CommonMethods.generateRandomStringOfFixLength(1));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service format is incorrect. The record should satisfy this regular expression");


	}

	//To validate the invalid service code
	@Test 
	public void TC95993_validate_xref_relation_when_Service_is_invalid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC95993_validate_xref_relation_when_Service_is_invalid(");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", CommonMethods.generateRandomAlphaNumeric(13));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service length is invalid. The length should be between 0 and 12");


	}


}
