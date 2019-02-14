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

import Utills_ExtentReport_Log4j.BaseTest;

// Test Case 96864: Open EVV Xref- Validate the Xref Json for valid case of XRefStartDate (Refer the steps for scenario)

public class SEVV_2154_TC96864_XRefStartDate_valid  extends BaseTest{

	//Case1: XRefStartDate= Present Date	(Today date valid -format)
	@Test 
	public void TC96864_Validate_XRef_XRefStartDate_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96864_Validate_XRef_XRefStartDate_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("XRefStartDate", CommonMethods.generateTodayDate_MMddyyyy());

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
	}

	// Case2:  XRefStartDate= Future Date  	(E.g Future Date valid -format)
	@Test 
	public void TC96864_Validate_XRef_XRefStartDate_futuredate_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96864_Validate_XRef_XRefStartDate_futuredate_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("XRefStartDate", CommonMethods.generateFutureDate_MM_DD_YYYY());

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
	}

	// Case3:  XRefStartDate= mmyyyydd   	(E.g 09202030 valid -format)
	@Test 
	public void TC96864_Validate_XRef_XRefStartDate_valid_yyyyddmm() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96864_Validate_XRef_XRefStartDate_valid_yyyyddmm");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("XRefStartDate", CommonMethods.generateFutureDate_MM_DD_YYYY());

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
	}

	// Case4:  XRefStartDate= mmyyyydd   	(E.g Past Date valid -format)
	@Test 
	public void TC96864_Validate_XRef_XRefStartDate_PastDate_validformat() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC96864_Validate_XRef_XRefStartDate_PastDate_validformat");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("XRefStartDate", CommonMethods.generatePastDate_MMddYYYY());

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
	}
}
