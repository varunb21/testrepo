package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */

//Test Case 88635:Open EVV-Worker-Validate (mix) - PayRate field formats/values

public class TC88635_EmpPayRate extends BaseTest
{

	//To validate the valid PayRate length min 4
	@Test
	public void TC88635_OpenEVV_Emp_valid_PayRate_length_4_2afterdeci() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88635_OpenEVV_Emp_valid_PayRate_length_4_2afterdeci");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("PayRate", CommonMethods.getRandomDoubleBetweenRange(1, 9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		String bodyAsStringget = CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("Emp_get"));

		Assert.assertTrue(bodyAsStringget.contains("messageSummary\": \"All records updated successfully."));  
	}

	//To validate the valid PayRate length min 4
	@Test
	public void TC88635_OpenEVV_Emp_valid_PayRate_length_4_2beforedeci() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88635_OpenEVV_Emp_valid_PayRate_length_4_2beforedeci");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("PayRate", CommonMethods.getRandomDouble_Two_Decimal(11, 15));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		String bodyAsStringget = CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("Emp_get"));

		Assert.assertTrue(bodyAsStringget.contains("messageSummary\": \"All records updated successfully."));  
	}

	//To validate the valid PayRate length min 4
	@Test
	public void TC88635_OpenEVV_Emp_valid_PayRate_length_4_2beforedeci_2afterdeci() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88635_OpenEVV_Emp_valid_PayRate_length_4_2beforedeci_2afterdeci");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("PayRate", "54.23");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

		String bodyAsStringget = CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("Emp_get"));

		Assert.assertTrue(bodyAsStringget.contains("messageSummary\": \"All records updated successfully."));  

		//	Assertion_DbVerifier.jsonAssert_STXSchedule(bodyAsString, js);
	}

	//To validate the invalid PayRate with leading space
	@Test
	public void TC88635_OpenEVV_Emp_invalid_PayRate_leadingSpace() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88635_OpenEVV_Emp_invalid_PayRate_leadingSpace");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic
		JSONObject jsonObject = (JSONObject) j.get(0);
		jsonObject.put("PayRate", " " + CommonMethods.getRandomDoubleBetweenRange(0, 4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV_400(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));


	}

	@Test
	public void TC88635_OpenEVV_Emp_invalid_PayRate_Alpha_only() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC88635_OpenEVV_Emp_invalid_PayRate_Alpha_only");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("PayRate", CommonMethods.generateRandomStringOfFixLength(1)+ "." + CommonMethods.generateRandomStringOfFixLength(1));

		String bodyAsString = CommonMethods.captureResponseOPENEVV_400(j, CommonMethods.propertyfileReader(globalVariables.create_employee_URL));

	}
}
