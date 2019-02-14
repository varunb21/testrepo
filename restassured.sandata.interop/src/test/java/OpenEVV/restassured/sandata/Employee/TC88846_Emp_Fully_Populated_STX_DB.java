package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.globalMethods.core.*;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


/**
 * @author MayankM
 *
 */

//Test Case 88847:Open EVV-Worker-Field Mapping-Schema:INBOX - Fully Populated

public class TC88846_Emp_Fully_Populated_STX_DB extends BaseTest{
	String val = "f_name";

	//To validate the valid EmployeeLastName length
	@Test
	public void TC88847_OpenEVV_Employee_validation_fully_populated_Inbox_DB() throws IOException, ParseException, ConfigurationException, SQLException 
	{
		logger = extent.startTest("TC88847_OpenEVV_Employee_validation_fully_populated_Inbox_DB");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		String empssn= CommonMethods.generateRandomNumberOfFixLength(9);
		String empfname= CommonMethods.generateRandomStringOfFixLength(9);
		js.put("EmployeeSocialSecurity", empssn);
		js.put("EmployeeFirstName", empfname);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));
		logger.log(LogStatus.INFO, "Validating Json response ");

		DataBaseVerifier_Emp.DataBaseVerificationEmp_stx_worker(val, empfname);

		//Asserting that result.
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertEquals(DataBaseVerifier_Emp.Emp_F_Name_stxworker, empfname);
	}

}
