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

/**
 * @author MayankM
 *
 */

//Test Case 91399: Open EVV -Alt EVV-Worker-Field Mapping-Schema:INBOX - Fully Populated

public class R2267_TC91399_AltEVV_Emp_Fully_Populated_Inbox extends BaseTest{

	//To validate the DB for fully populated employee
	@Test
	public void R2267_TC91399_AltEVV_Employee_Fully_Populated_Inbox() throws IOException, ParseException, SQLException
	{
		//Validating the Post Request 
		String field = "worker_ssn";

		logger = extent.startTest("R2267_TC91399_AltEVV_Employee_Fully_Populated_Inbox");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		String resp = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_emp"));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(resp, jsonObject);	

	}


}