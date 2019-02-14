package AltEVV_generic.restassured.sandata.Client;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;


	public class R2267_TC92350_AltEVV_Clients_Validate_the_Response_json extends BaseTest{
	    
	    //Case-1 Testing without ClientOtherID field
		@Test 
		public void TC92350_Open_EVV_alt_EVV_Clients_Validate_the_Response_json() throws IOException, ParseException, ConfigurationException, SQLException
		{   
			// adding method name info via logger
			logger = extent.startTest("TC92350_Open_EVV_alt_EVV_Clients_Validate_the_Response_json"); 
			
			// adding what you are verifying
			logger.log(LogStatus.INFO, "Validating ClientJson response with valid data "); 
			
			//loading the Json dynamically with unique value set 
			JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 
			JSONObject jsonObject=(JSONObject) j.get(0);

			  logger.log(LogStatus.INFO, "Passing all parameters with valid data");
		      logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());
			
			// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		      String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		      Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);
		}


}
