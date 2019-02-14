package AltEVV_generic.restassured.sandata.Employee;

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

	//Validating valid  Unique employee employeeotherid
	@Test (priority=0)
	public void R2267_TC91542_AltEVV_Emp_unique_EmployeeOtherID_json_DB_Validation() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91542_AltEVV_Emp_unique_EmployeeOtherID_json_DB_Validation");  
		logger.log(LogStatus.INFO, "Validating valid  Unique employee employeeotherid"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", CommonMethods.generateRandomNumberOfFixLength(5));
		String empotherid=jsonObject.get("EmployeeOtherID").toString();
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_emp"));
		String bodystringget=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_emp_get"));

		logger.log(LogStatus.INFO, "Validating that Db does not create 2 workers for the same EmployeeOtherID"); 
	
		JSONArray jsonArray_duplicate = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject  jsonObject_duplicate = (JSONObject) jsonArray_duplicate.get(0);
		jsonObject_duplicate.put("EmployeeOtherID", empotherid);
		
		String bodyAsString_dup = CommonMethods.captureResponseAltEVV(jsonArray_duplicate, CommonMethods.propertyfileReader("altevv_emp"));		
		String bodystringget_dup=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString_dup, CommonMethods.propertyfileReader("altevv_emp_get"));
		
		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
	
	}

}