package OpenEVV.restassured.sandata.xref;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

// Test Case 96867: Open EVV Xref- Validate the client Json for invalid case of XRefEndDate (Refer the steps for scenario)

public class SEVV_2154_TC96867_Xref_XRefEndDate_Invalid  extends BaseTest{

	//Case1: XRefEndDate= mmddyyyy	(Invalid -format)

	@Test 
	public void TC96867_Validate_XRef_XRefEndDate_invalid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96867_Validate_XRef_XRefEndDate_invalid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("XRefEndDate", 16302018);

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.XRefEndDateformaterror);
	}
	// Case2:  XRefEndDate= ddmmyyyy  	(E.g 23052018 Invalid -format)
	@Test 
	public void TC96867_Validate_XRef_XRefEndDate_invalid_ddmmyyyy() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96867_Validate_XRef_XRefEndDate_invalid_ddmmyyyy");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("XRefEndDate", 29122018);

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.XRefEndDateformaterror);
	}

	// Case3:  XRefEndDate= mmyyyydd  	(E.g 09201730 Invalid -format)
	@Test 
	public void TC96867_Validate_XRef_XRefEndDate_invalid_yyyyddmm() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96867_Validate_XRef_XRefEndDate_invalid_yyyyddmm");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("XRefEndDate", 12200018);

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.XRefEndDateformat);
	}

}
