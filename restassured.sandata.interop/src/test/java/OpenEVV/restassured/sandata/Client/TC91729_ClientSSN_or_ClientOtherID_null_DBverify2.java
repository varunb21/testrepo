package OpenEVV.restassured.sandata.Client;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

 

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

//Test Case 91728:Inter-op : Open EVV - Client - Validate the Client creation with "null" ClientSSN and ClientOtherID

public class TC91729_ClientSSN_or_ClientOtherID_null_DBverify2 extends BaseTest {
	
	public static String val,val3,val1= "client_ssn", val2="client_id_custom2";
	
	//case-1 To validate the null ClientSSN and ClientOtherID DB verification 
	
	@Test
	public void TC91729_OpenEVV_invalid_ClientSSN_db_verify() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91729_OpenEVV_invalid_ClientSSN_db_verify");

		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		//js.put("ClientSSN", DataGeneratorClient_OpenEVV.generateClientSSN(5));
		val2=null;
		js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
		val1=  js.get("ClientSSN").toString();
		System.out.println(val1);
		js.put("ClientOtherID", val2);
		
		System.out.println(val2);
	
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		
		logger.log(LogStatus.INFO, "Validating DB response ");

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	


	}
	
}