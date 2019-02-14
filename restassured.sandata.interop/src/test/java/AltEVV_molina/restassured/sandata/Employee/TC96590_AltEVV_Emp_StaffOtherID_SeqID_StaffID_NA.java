package AltEVV_molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */
public class TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_NA extends BaseTest {

	@Test
	public void TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_blank");  

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_Intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID","");
		js.put("SequenceID","");
		js.put("EmployeeIdentifier","");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffOtherIDFormatError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDFormatError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffIDFormatError);
	}

	@Test
	public void TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_null");  

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_Intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID",null);
		js.put("SequenceID",null);
		js.put("EmployeeIdentifier",null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSequenceIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffIDNullError);
	}

	@Test
	public void TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_Not_Present() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_Not_Present");  

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_Intake");
		JSONObject js = (JSONObject) j.get(0);
		js.remove("EmployeeOtherID");
		js.remove("SequenceID");
		js.remove("EmployeeIdentifier");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSequenceIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffIDNullError);
	}

}
