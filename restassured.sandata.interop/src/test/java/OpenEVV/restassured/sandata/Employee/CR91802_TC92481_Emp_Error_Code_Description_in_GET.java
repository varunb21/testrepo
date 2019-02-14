package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;

/**
 * @author MayankM
 *
 */

//Test Case 92481: Inter-op -Open EVV - Employee - Validate the Error Code and Description in GET Response

public class CR91802_TC92481_Emp_Error_Code_Description_in_GET extends BaseTest
{	
	//To validate the failed record for same Employee ID 
	@Test
	public void CR91802_TC92481_Emp_Creation_Success() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("CR91802_TC92481_Emp_Creation_Success"); 
	
		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsonObject);
		
		//As per the changes in SEVV-6041, DUplicate entry with same SSN is acceptable in inox schema
		String bodyAsStringRe = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));
		
		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsStringRe, jsonObject);
	}

}
