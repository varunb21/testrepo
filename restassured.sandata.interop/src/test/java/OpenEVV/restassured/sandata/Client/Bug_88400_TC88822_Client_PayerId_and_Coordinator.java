package OpenEVV.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;
import java.sql.SQLException;

// Bug- 88400_Test Case 88822: Open EVV: Client- Load maximum Values in Client-PayerId & Coordinator

public class Bug_88400_TC88822_Client_PayerId_and_Coordinator extends BaseTest {

	// case-1 Validate ClientSuffix is storing in DB
	public static String val1= "contract", val2="spv";
	public static String payerid = CommonMethods.generateRandomNumberOfFixLength(64);
	public static String coordinator =  CommonMethods.generateRandomStringOfFixLength(3);
	
	@Test
	public void Bug_88400_TC88822_OpenEVV_ClientPayerID_Coordinator() throws IOException, ParseException, ConfigurationException, SQLException
	{
		// adding method name info via logger
		logger = extent.startTest("Bug_88400_TC88822_OpenEVV_ClientPayerID_Coordinator"); 
				
		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson OpenEVV_ClientPayerID_Coordinator"); 
		//Using Reusable method to load client json
	
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		
		js.put("PayerID",payerid);
	    js.put("Coordinator", coordinator);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	
	
			
	}
	@Test
	public void Bug_88400_TC88822_OpenEVV_ClientPayerID_Coordinator_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{
		        // adding method name info via logger
				logger = extent.startTest("Bug_88400_TC88822_OpenEVV_ClientPayerID_Coordinator_DB"); 
						
				// adding what you are verifying
				logger.log(LogStatus.INFO, "Validating ClientJson OpenEVV ClientPayerID Coordinator DB"); 
				//Using Reusable method to load client json
		
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonobject = (JSONObject) j.get(0);
		
		jsonobject.put("PayerID",payerid );
		jsonobject.put("Coordinator", coordinator);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
	
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonobject);	
		
	}
}