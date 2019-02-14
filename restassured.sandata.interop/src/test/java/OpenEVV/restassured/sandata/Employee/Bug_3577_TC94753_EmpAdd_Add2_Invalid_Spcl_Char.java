package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
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

// TC94753 : Inter-Op: Verifies if EmployeeAddressLine1 & EmployeeAddressLine2  fields are not accepting special characters other than # ' . , - /

public class Bug_3577_TC94753_EmpAdd_Add2_Invalid_Spcl_Char extends BaseTest
{

	@Test
	public void TC94753_EmpAdd_Add2_Invalid_Spcl_Char() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC94753_EmpAdd_Add2_Invalid_Spcl_Char"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);

		js.put(globalVariables.EmployeeAddress1, CommonMethods.generateRandomAlphaNumeric(15) +"@" + "$" + "!" + "%" + "&" + "*");
		js.put(globalVariables.EmployeeAddress2, CommonMethods.generateRandomAlphaNumeric(15) +"@" + "$" + "!" + "%" + "&" + "*");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpAdd1FormatError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpAdd2FormatError);
		
	}

}
