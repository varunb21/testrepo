/**
 * 
 */
package AltEVV_molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;

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

//Test Case 95626:Verify for ProviderID field should accept max of 50 STRING length for ALTEVV (Client/Employee).

public class BUG_SEVV_72_TC95626_AltEVV_ProviderID_field_Maxlength_validation extends BaseTest{

	//Case1: Verify for ProviderID field should accept max of 50 STRING length for ALTEVV (Employee).
	
	@Test
	public void TC95626_AltEVV_ProviderID_field_Maxlength_validation() throws IOException, ParseException, SQLException
	{
	
	logger = extent.startTest("TC95626_AltEVV_ProviderID_field_Maxlength_validation");  
	logger.log(LogStatus.INFO, "Validating_ProviderID_field_Maxlength_validation"); 
	
	//Using Reusable method to load employee json
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.ProviderID, CommonMethods.generateRandomNumberOfFixLength(50));

	String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));
	
	
	Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
	
}
	//Case2: Verify for ProviderID field should not accept value more than 50 STRING length for ALTEVV (Employee).
	
		@Test
		public void TC95626_AltEVV_ProviderID_field_Invalid_length_validation() throws IOException, ParseException, SQLException
		{
		
		logger = extent.startTest("TC95626_AltEVV_ProviderID_field_Invalid_length_validation");  
		logger.log(LogStatus.INFO, "Validating_Employee_Creation_with_invalid_length"); 
		
        JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		jsonObject.put(globalVariables.ProviderID, CommonMethods.generateRandomNumberOfFixLength(52));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));		
		
		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	

		
	}
	
	
}
