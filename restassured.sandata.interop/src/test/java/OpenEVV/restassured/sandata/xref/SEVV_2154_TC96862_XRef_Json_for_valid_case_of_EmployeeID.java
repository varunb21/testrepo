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

public class SEVV_2154_TC96862_XRef_Json_for_valid_case_of_EmployeeID extends BaseTest{
	
	//To validate the valid ClientIDQualifier valid cases
	@Test 
	public void SEVV_2154_TC96862_XRef_Json_for_valid_case_of_EmployeeID_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("SEVV_2154_TC96862_XRef_Json_for_valid_case_of_EmployeeID_valid");  // adding method name info via logger
		 
		//Using Reusable method to load client json
	
		   JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
			
			JSONObject jsonobject = (JSONObject) jsonarray.get(0);
			
			jsonobject.put("EmployeeID",CommonMethods.generateRandomNumberOfFixLength(5) );
		
		//Using Assert to validate the expected result
			String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
		 }
		
	
	}
	


