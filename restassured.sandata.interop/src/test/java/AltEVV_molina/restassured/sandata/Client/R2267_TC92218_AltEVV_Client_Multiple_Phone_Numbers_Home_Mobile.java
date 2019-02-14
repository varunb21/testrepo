/**
 * 
 */
package AltEVV_molina.restassured.sandata.Client;

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
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
//Test Case 92218: OpenEVV-altEVV- Client - Multiple Phone Numbers
/**
 * @author Anupam
 *
 */
public class R2267_TC92218_AltEVV_Client_Multiple_Phone_Numbers_Home_Mobile extends BaseTest{

	//Case1- Client json with multiple segments for PHONE: 2- Home, Mobile 
	@Test 
	public void TC92218_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		logger = extent.startTest("TC92218_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile");
		logger.log(LogStatus.INFO, "Validating ClientJson passed with Multiple_Phone_Numbers_Home_Mobile"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
        JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		
		jsonObject3.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject3.put(globalVariables.ClientPhoneType, "Home");
		
	    String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		//		Assertion_DbVerifier.jsonAssert_InboxAni(bodyAsString, js, js3);

	}
	
	//Case2- Client json with multiple segments for PHONE: 3- Home, Mobile, Business
 
	@Test(groups = { "Databasetest"})
	public void TC92218_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile_Business() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		 
		logger = extent.startTest("TC92218_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile_Business");
		logger.log(LogStatus.INFO, "Validating ClientJson passed with with_Multiple_Phone_Numbers_Home_Mobile_Business"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
        JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		
		jsonObject3.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject3.put(globalVariables.ClientPhoneType, "Mobile");
	
	    String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		//		Assertion_DbVerifier.jsonAssert_InboxAni(bodyAsString, js, js3);

	}
	
	//Case3- Client json with multiple segments for PHONE: 4- Home, Mobile, Business, Other
	 
	@Test(groups = { "Databasetest"})
	public void TC92218_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile_Business_Other() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		 
		logger = extent.startTest("TC92218_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile_Business_Other");
		logger.log(LogStatus.INFO, "Validating ClientJson passed with with_Multiple_Phone_Numbers_Home_Mobile_Business_Other"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
        JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		
		jsonObject3.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject3.put(globalVariables.ClientPhoneType, "Business");
	
	    String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		//		Assertion_DbVerifier.jsonAssert_InboxAni(bodyAsString, js, js3);

	}
	
	//Case4- Client json with multiple segments for PHONE: 2- Home, Home
	 
		@Test(groups = { "Databasetest"})
		public void TC92218_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Home() throws IOException, ParseException, ConfigurationException, SQLException
		{   
			 
			logger = extent.startTest("TC92218_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Home");
			logger.log(LogStatus.INFO, "Validating ClientJson passed with with_Multiple_Phone_Numbers_Home_Home"); 

			JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
	        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			
	        JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);	
			JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
			
			jsonObject3.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(9));
			jsonObject3.put(globalVariables.ClientPhoneType, "Other");
		

		    String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));
			
			//		Assertion_DbVerifier.jsonAssert_InboxAni(bodyAsString, js, js3);

		}
}

