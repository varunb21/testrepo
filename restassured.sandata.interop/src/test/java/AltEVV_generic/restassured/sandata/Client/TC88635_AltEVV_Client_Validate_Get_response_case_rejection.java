package AltEVV_generic.restassured.sandata.Client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;

import Utills_ExtentReport_Log4j.BaseTest;

public class TC88635_AltEVV_Client_Validate_Get_response_case_rejection extends BaseTest {
	
	@Test
	public void TC88635_AltEVV_Client_Validate_Get_response_case_of_rejection() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("TC88635_AltEVV_Client_Validate_Get_response_case_rejection");  

		//Using Reusable method to load employee json
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));
		//Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonobject);
		

			
		String bodyNewAString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));
		
		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyNewAString, CommonMethods.propertyfileReader("altevv_clients_get"));
		
		CommonMethods.Assert_Visit_FailCase(bodyAsStringGet, "Version number is duplicated or older than current");
			
	}
	
	
	

}
