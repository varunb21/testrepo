package AltEVV_generic.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;

/**
 * @author MayankM
 *
 */

//Test Case 93652: Alt EVV - Employee- Validate get Response for created Emloyee

public class R2201_TC96647_AltEVV_Emp_GetResponse_validation extends BaseTest{

	//To validate get Response for created Emloyee
	@Test
	public void R2201_TC96647_AltEVV_Emp_GetResponse_validation_valid() throws IOException, ParseException, SQLException
	{
		//Validating the Post Request 
		logger = extent.startTest("R2201_TC96647_AltEVV_Emp_GetResponse_validation_valid");  

		logger.log(LogStatus.INFO, "R2201_TC96647_AltEVV_Emp_GetResponse_validation_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String resp = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(resp, jsonObject);
		
		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(resp, CommonMethods.propertyfileReader("altevv_emp_get"));

		Assert.assertTrue(bodyAsStringGet.contains("messageSummary\": \"All records updated successfully."));  


	}


}