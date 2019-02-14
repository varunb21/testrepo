package AltEVV_molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */
//Test Case 91542:Open EVV - Alt EVV - Worker - Verify the Unique employeeotherid

public class R2267_TC91542_AltEVV_Emp_unique_EmployeeOtherID extends BaseTest{

	String  empotherid, field = "worker_ssn",empssn, field2="worker_id_custom1";

	//Validating valid  Unique employee employeeotherid
	@Test (priority=0)
	public void R2267_TC91542_AltEVV_Emp_unique_EmployeeOtherID_json_DB_Validation() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91542_AltEVV_Emp_unique_EmployeeOtherID_json_DB_Validation");  
		logger.log(LogStatus.INFO, "Validating valid  Unique employee employeeotherid"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		this.empssn=jsonObject.get("EmployeeSSN").toString();
		this.empotherid=jsonObject.get("EmployeeFirstName").toString();
		System.out.println(empotherid + " " + empssn);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_emp"));
		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	

		logger.log(LogStatus.INFO, "Validating that Db does not create 2 workers for the same EmployeeOtherID"); 
	
		bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_emp"));
		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
	
	}

}