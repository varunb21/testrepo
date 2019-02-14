package OpenEVV.restassured.sandata.xref;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2154_TC96863_Validate_XRef_for_invalid_EmployeeID extends BaseTest{


	//To validate the invalid EmployeeID as blank
	@Test 
	public void TC96863_Invalid_xref_relation_when_EmployeeID_blank() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC96863_Invalid_xref_relation_when_EmployeeID_blank");  // adding method name info via logger

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeeID", "");


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDformaterror);


	}
	
	//To validate the invalid EmployeeID more than allowed length
	@Test 
	public void TC96863_Invalid_xref_relation_when_EmployeeID_more_than_allowed_length() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC96863_Invalid_xref_relation_when_EmployeeID_more_than_allowed_length");  // adding method name info via logger

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(8));


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDformaterror);


	}

	//To validate the invalid EmployeeID more than allowed length
	@Test 
	public void TC96863_Invalid_xref_relation_when_EmployeeID_special_character() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC96863_Invalid_xref_relation_when_EmployeeID_special_character(");  // adding method name info via logger

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeeID", CommonMethods.generateSpecialChar(5));


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDformaterror);


	}

	//To validate the invalid EmployeeID more than allowed length
	@Test 
	public void TC96863_Invalid_xref_relation_when_EmployeeI_character() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC96863_Invalid_xref_relation_when_EmployeeI_character");  // adding method name info via logger

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeeID", CommonMethods.generateRandomStringOfFixLength(5));


		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDformaterror);


	}



}
