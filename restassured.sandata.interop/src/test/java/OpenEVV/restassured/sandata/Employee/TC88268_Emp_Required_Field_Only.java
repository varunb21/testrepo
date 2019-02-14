package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author MayankM
 *
 */

//Test Case 88268:Open EVV - Employee - Only Required Field

public class TC88268_Emp_Required_Field_Only extends BaseTest {

	@Test
	public void TC88268_OpenEVV_Employee_Required_Field_Validation() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException 
	{
		logger = extent.startTest("TC88268_OpenEVV_Employee_Required_Field_Validation"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.openevv_emp_req_json);

		JSONObject jsobject = (JSONObject) jsonArr.get(0);
		
		jsobject.put("EmployeePhone", null);

		jsobject.put("EmployeeAltPhone",null);

		jsobject.put("EmployeeAltPhone2", null);

		jsobject.put("EmployeeID", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));	

	}

}


