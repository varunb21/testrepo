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

public class SEVV_2154_TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier extends BaseTest {
	

	//To validate the valid EmployeeQualifier valid cases
			@Test 
			public void TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
			{
				logger = extent.startTest("TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier");  // adding method name info via logger
				 String[] EmployeQualifier= {"EmployeeSSN", "EmployeeRegID", "EmployeeCustomID", "EmployeePIN"};
				//Using Reusable method to load client json
				 
				 for(int i=0;i<EmployeQualifier.length;i++)
				 {
				 JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
					
					JSONObject jsonobject = (JSONObject) jsonarray.get(0);
					
					jsonobject.put("EmployeeQualifier",EmployeQualifier[i] );
					jsonobject.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5) );
				
				//Using Assert to validate the expected result
					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
					Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
				 }
				
			
			}

			

}
