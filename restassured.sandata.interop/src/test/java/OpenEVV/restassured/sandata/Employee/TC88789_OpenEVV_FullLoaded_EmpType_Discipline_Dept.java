//package OpenEVV.restassured.sandata.Employee;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import org.apache.commons.configuration.ConfigurationException;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.ParseException;
//import org.testng.annotations.Test;
//
//import com.globalMethods.core.*;
//import com.employee.core.DataGeneratorEmployee_3P;
//import com.globalMethods.core.CommonMethods;
//import com.globalMethods.core.GenerateUniqueParam;
//import com.globalMethods.core.globalVariables;
//import Utills_ExtentReport_Log4j.BaseTest;
//
///**
// * @author MayankM
// *
// */
//
//// TC94744 : Inter-Op: Verifies if EmployeeAddress, EmployeeAddress2 & EmployeeCity fields are accepting values with space
//
//public class TC88789_OpenEVV_FullLoaded_EmpType_Discipline_Dept extends BaseTest
//{
//
//	@Test
//	public void TC88789_OpenEVV_fullloaded_EmpType_Discipline_Dept_valid() throws IOException, ParseException, ConfigurationException, SQLException
//	{
//
//		logger = extent.startTest("TC94743_EmpAdd_Add2_City_Space_validation"); 
//
//		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
//
//		JSONObject js = (JSONObject) jsonArr.get(0);
//		js.put("Department", DataGeneratorEmployee.generateEmpDept(3));
//		js.put("EmployeeType", DataGeneratorEmployee.generateEmpDept(3));
//		js.put("Discipline", DataGeneratorEmployee.generateEmpDept(3));
//	
//		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));
//
//		CommonMethods.verifyjsonassertsuccess6value_inboxEmp(
//				bodyAsString, 
//				globalVariables.dbEmpAddressLine1, js.get(globalVariables.EmployeeAddress1).toString(), 
//				globalVariables.dbEmpAddressLine2, js.get(globalVariables.EmployeeAddress2).toString(),
//				globalVariables.dbEmpCity, js.get(globalVariables.EmployeeCity).toString());
//	}
//
//}
