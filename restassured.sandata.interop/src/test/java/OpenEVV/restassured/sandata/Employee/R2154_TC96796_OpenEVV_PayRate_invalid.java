/**
 * 
 */
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
 * @author Anupam
 *
 */

// Test Case 96796: OpenEVV Employee- Validate PayRate field for Invalid values

public class R2154_TC96796_OpenEVV_PayRate_invalid extends BaseTest {

	// Case1: PayRate- abchdh (String)

	@Test
	public void TC96796_OpenEVV_PayRate_invalid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96796_OpenEVV_PayRate_invalid"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseOPENEVV_400(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase_400(bodyAsString, globalVariables.Errormesssage);

	}

	// Case2: PayRate- 123.45- Exceeding length

	@Test
	public void TC96796_OpenEVV_PayRate_decimal_lengthexceed() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96796_OpenEVV_PayRate_decimal_lengthexceed"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomNumberOfFixLength(3) + "." + CommonMethods.generateRandomNumberOfFixLength(2));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayRatelengthError);	
	}

	// Case3: PayRate- 12.3 5 (with spaces)

	@Test
	public void TC96796_OpenEVV_PayRate_decimal_with_spaces() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96796_OpenEVV_PayRate_decimal_with_spaces"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomNumberOfFixLength(2) +"." +CommonMethods.generateRandomNumberOfFixLength(1) +" ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV_400(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase_400(bodyAsString, globalVariables.Errormesssage);
	}

	// Case4: PayRate- 12.3@5 (with special chars)

	@Test
	public void TC96796_OpenEVV_PayRate_with_specialchars() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96796_OpenEVV_PayRate_with_specialchars"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomNumberOfFixLength(2) + "." + CommonMethods.generateRandomNumberOfFixLength(2) +CommonMethods.generateSpecialChar(1));

		String bodyAsString = CommonMethods.captureResponseOPENEVV_400(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		CommonMethods.verifyjsonassertFailcase_400(bodyAsString, globalVariables.Errormesssage);
	}

}
