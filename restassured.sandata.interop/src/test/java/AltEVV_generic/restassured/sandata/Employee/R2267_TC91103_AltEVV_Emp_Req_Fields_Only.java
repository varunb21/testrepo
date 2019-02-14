package AltEVV_generic.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Emp;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 91103: Alt EVV-Worker-Load-Required Fields Only

public class R2267_TC91103_AltEVV_Emp_Req_Fields_Only extends BaseTest{

	@Test
	public void R2267_TC91103_AltEVV_Employee_Req_Fields_Validation() throws IOException, ParseException, SQLException, java.text.ParseException

	{
		logger = extent.startTest("R2267_TC91103_AltEVV_Employee_Req_Fields_Validation ");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.remove("EmployeeOtherID").toString();
		jsonObject.remove("EmployeeManagerEmail").toString();
		jsonObject.remove("EmployeeAPI").toString();
		jsonObject.remove("EmployeePosition").toString();

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		DataBaseVerifier_Emp.DataBaseVerificationEmp("WORKER_VERSION_NUMBER", jsonObject.get("SequenceID").toString(),
				"L_Name",jsonObject.get(globalVariables.EmployeeLastName).toString() );
		
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpAPI_inworker,null);
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpDisc_inworker,null);
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Emp.EmpMgrEmail_inworker,null);


		
		
		
}


}