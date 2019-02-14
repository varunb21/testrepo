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

public class SEVV_2154_TC96859_XRef_Json_for_valid_case_of_ClientIDQualifier extends BaseTest{
	
	

	//To validate the valid ClientIDQualifier valid cases
			@Test 
			public void TC96859_Validate_the_XRef_valid_case_of_ClientIDQualifier() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
			{
				logger = extent.startTest("TC96859_Validate_the_XRef_valid_case_of_ClientIDQualifier");  // adding method name info via logger
				 String[] ClientQualifier= {"ClientID","ClientSSN","ClientOtherID","ClientCustomID"};
				 
				 for(int i=0;i<ClientQualifier.length;i++)
				 {
				 JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
					
					JSONObject jsonobject = (JSONObject) jsonarray.get(0);
					
					jsonobject.put("ClientIDQualifier",ClientQualifier[i] );
					jsonobject.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5) );
				
					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
					Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
				 }
				
			
			}


}
