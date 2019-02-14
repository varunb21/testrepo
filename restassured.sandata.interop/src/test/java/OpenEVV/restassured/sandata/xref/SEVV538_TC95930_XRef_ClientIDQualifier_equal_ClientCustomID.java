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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV538_TC95930_XRef_ClientIDQualifier_equal_ClientCustomID extends BaseTest{

	// Case1 Validate ClientIDQualifier_equals_ClientCustomID
	
	@Test(groups = {"Database"})
	   public void TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientCustomID() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientCustomID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientCustomID"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonarray.get(0);

		jsobject.put(globalVariables.ClientIDQualifier, "ClientCustomID");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsobject);

	}
	
	// Case2 Validate ClientIDQualifier_equals_ClientcustomID (Invalid)
	
		@Test 
	   public void TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientcustomID() throws IOException, ParseException, ConfigurationException, SQLException
		{
			logger = extent.startTest("TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientcustomID");  // adding method name info via logger

			logger.log(LogStatus.INFO, "TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientcustomID"); // adding what you are verifying details

			//Using Reusable method to load client json
			JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) jsonarray.get(0);
			
			js.put(globalVariables.ClientIDQualifier, "ClientcustomID");
		
			String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
		}
	// Case3 Validate ClientIDQualifier_equals_clientCustomID (Invalid)
		
			@Test 
	   public void TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientCustomID() throws IOException, ParseException, ConfigurationException, SQLException
			{
				logger = extent.startTest("TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientCustomID");  // adding method name info via logger

				logger.log(LogStatus.INFO, "TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientCustomID"); // adding what you are verifying details

				//Using Reusable method to load client json
				JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

				//Making json values dynamic

				JSONObject js = (JSONObject) jsonarray.get(0);
			
				js.put(globalVariables.ClientIDQualifier, "clientCustomID");
				//assigning db value to local variables.

				String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
				
				CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
			}
			
	// Case4 Validate ClientIDQualifier_equals_clientcustomid (Invalid)
			
				@Test 
	   public void TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientcustomid() throws IOException, ParseException, ConfigurationException, SQLException
				{
					logger = extent.startTest("TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientcustomid");  // adding method name info via logger

					logger.log(LogStatus.INFO, "TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientcustomid"); // adding what you are verifying details

					//Using Reusable method to load client json
					JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

					//Making json values dynamic

					JSONObject js = (JSONObject) jsonarray.get(0);
				
					js.put(globalVariables.ClientIDQualifier, "clientcustomid");
					
					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
					
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
				}
				
   // Case5 Validate ClientIDQualifier_Randomvalue
				
				@Test 
	   public void TC95930_OpenEVV_XRef_ClientIDQualifier_Randomvalue() throws IOException, ParseException, ConfigurationException, SQLException
				{
					logger = extent.startTest("TC95930_OpenEVV_XRef_ClientIDQualifier_Randomvalue");  // adding method name info via logger

					logger.log(LogStatus.INFO, "TC95930_OpenEVV_XRef_ClientIDQualifier_Randomvalue"); // adding what you are verifying details

					//Using Reusable method to load client json
					JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

					//Making json values dynamic

					JSONObject js = (JSONObject) jsonarray.get(0);
					
					js.put(globalVariables.ClientIDQualifier, CommonMethods.generateRandomNumberOfFixLength(5));

					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
					
				}
}
