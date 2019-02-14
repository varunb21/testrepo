package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 88375:Open EVV: Verify error message on uploading client with invalid value in 'ClientMedicalRecordNumber'
public class TC88375_ClientMedicalRecordNumber extends BaseTest
{	

		
	//case 1---- - ClientMedicalRecordNumber - 12j@dkdkdjhy12(With special characters)  (invalid Case)
	@Test
	public void TC88375_OpenEVV_ClientMedicalRecordNumber_invalid_specialchar() throws IOException, ParseException, ConfigurationException
	{
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
		logger = extent.startTest("TC88375_OpenEVV_ClientMedicalRecordNumber_invalid_specialchar");  
		
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ClientMedicalRecordNumber", "12j@dkdkdjhy12");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
Assert.assertTrue(bodyAsString.contains( "The ClientMedicalRecordNumber length is invalid. The length should be between 0 and 12."));
		
	}
	
	
}