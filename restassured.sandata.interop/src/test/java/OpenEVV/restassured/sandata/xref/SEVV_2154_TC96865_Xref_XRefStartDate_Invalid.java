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

//Test Case 96865: Open EVV Xref- Validate the Xref Json for invalid case of XRefStartDate (Refer the steps for scenario)
public class SEVV_2154_TC96865_Xref_XRefStartDate_Invalid  extends BaseTest{
	
//Case1: XRefStartDate= mmyyyydd	(Invalid -format)
		@Test 
		public void TC96865_Validate_XRef_XRefStartDate_invalid() throws IOException, ParseException, ConfigurationException, SQLException
		{
			logger = extent.startTest("TC96865_Validate_XRef_XRefStartDate_invalid");  // adding method name info via logger
			 
			//Using Reusable method to load client json
		
			   JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
				
				JSONObject jsonobject = (JSONObject) jsonarray.get(0);
				
				jsonobject.put("XRefStartDate", 11999920);
			
			//Using Assert to validate the expected result
				String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
				
				CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.XRefStartDateformaterror);
			 }
// Case3:  XRefStartDate= ddmmyyyy  	(E.g 23052018 Invalid -format)
			@Test 
		public void TC96865_Validate_XRef_XRefStartDate_invalid_ddmmyyyy() throws IOException, ParseException, ConfigurationException, SQLException
			{
				logger = extent.startTest("TC96865_Validate_XRef_XRefStartDate_invalid_ddmmyyyy");  // adding method name info via logger
				 
				//Using Reusable method to load client json
			
				   JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
					
					JSONObject jsonobject = (JSONObject) jsonarray.get(0);
					
					jsonobject.put("XRefStartDate", 23052018);
				
				//Using Assert to validate the expected result
					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
					
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.XRefStartDateformaterror);
				 }
			
// Case3:  XRefStartDate= yyyyddmm  	(E.g 23052018 Invalid -format)
						@Test 
		public void TC96865_Validate_XRef_XRefStartDate_invalid_yyyyddmm() throws IOException, ParseException, ConfigurationException, SQLException
						{
							logger = extent.startTest("TC96865_Validate_XRef_XRefStartDate_invalid_yyyyddmm");  // adding method name info via logger
							 
							//Using Reusable method to load client json
						
							   JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
								
								JSONObject jsonobject = (JSONObject) jsonarray.get(0);
								
								jsonobject.put("XRefStartDate", 20182012);
							
							//Using Assert to validate the expected result
								String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
								
								CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.XRefStartDateformaterror);
							 }

}
