package AltEVV_generic.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 95166:Validate if EmployeeQualifier is "EmployeeSSN", EmployeeSSN will be overwritten by EmployeeIdentifier

public class Bug155_TC95166_AltEVV_EmployeeSSN_Overwritten_by_EmployeeIdentifier extends BaseTest {

	//Case1: Validate if EmployeeQualifier is "EmployeeSSN", EmployeeSSN will be overwritten by EmployeeIdentifier
	
	@Test
	public void TC95166_AltEVV_EmployeeQualifier_with_EmployeeSSN() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC95166_AltEVV_EmployeeQualifier_with_EmployeeSSN"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeQualifier", "EmployeeSSN");
		jsonObject.put("EmployeeIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
		
	}
}