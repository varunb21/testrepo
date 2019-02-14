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
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV_2154_TC96870_Xref_ClientStatus_Invalid extends BaseTest{
	
		//Case1: ClientStatus is more than 2  as numeric
	
		@Test 
		public void TC96870_Validate_XRef_ClientStatus_invalid() throws IOException, ParseException, ConfigurationException, SQLException
			{
				logger = extent.startTest("TC96870_Validate_XRef_ClientStatus_invalid");  // adding method name info via logger
				 
				//Using Reusable method to load client json
			
				   JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
					
					JSONObject jsonobject = (JSONObject) jsonarray.get(0);
					
					jsonobject.put("ClientStatus", 5);
				
				//Using Assert to validate the expected result
					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
					
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.XRefClientStatusformaterror);
				}
		
		//Case2: ClientStatus is  other than valid values (01,02,03,04)
		
			@Test 
		public void TC96870_Validate_XRef_ClientStatus_invalidvalues() throws IOException, ParseException, ConfigurationException, SQLException
				{
					logger = extent.startTest("TC96870_Validate_XRef_ClientStatus_invalidvalues");  // adding method name info via logger
					 
					//Using Reusable method to load client json
				
					   JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
						
						JSONObject jsonobject = (JSONObject) jsonarray.get(0);
						
						jsonobject.put("ClientStatus", CommonMethods.generateRandomNumberOfFixLength(2));
					
					//Using Assert to validate the expected result
						String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
						
						CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.XRefClientStatusformaterror);
					 }
			
		//Case3: ClientStatus with space in between (e.g 0 1)
			
			@Test 
		public void TC96870_Validate_XRef_ClientStatus_space_invalid() throws IOException, ParseException, ConfigurationException, SQLException
				{
					logger = extent.startTest("TC96870_Validate_XRef_ClientStatus_space_invalid");  // adding method name info via logger
					 
					//Using Reusable method to load client json
				
					   JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
						
						JSONObject jsonobject = (JSONObject) jsonarray.get(0);
						
						jsonobject.put("ClientStatus", "0 1");
					
					//Using Assert to validate the expected result
						String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
						
						CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.XRefClientStatusformaterror);
						CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.XRefClientStatuslengtherror);
					 }
}
