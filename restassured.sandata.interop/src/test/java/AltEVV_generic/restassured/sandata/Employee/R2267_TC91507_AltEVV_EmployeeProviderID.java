package AltEVV_generic.restassured.sandata.Employee;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

/**
 * @author MayankM
 *
 */
//Test Case 91507: Open EVV - Alt EVV - Worker - ProviderId field validation

public class R2267_TC91507_AltEVV_EmployeeProviderID extends BaseTest{

	//To validate the valid ProviderId 
	@Test
	public void R2267_TC91507_AltEVV_EmployeeProviderID_valid() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeProviderID");  

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObPr = (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObPr.put("ProviderID", CommonMethods.generateRandomStringOfFixLength(10));
		
		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the invalid ProviderId 
	@Test
	public void R2267_TC91507_AltEVV_EmployeeProviderID_valid_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91507_AltEVV_EmployeeProviderID_valid_max");  

		//Using Reusable method to load employee json
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		JSONObject Jsob = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) Jsob.get("ProviderIdentification");
		jsonObjectPay.put("ProviderID", CommonMethods.generateRandomNumberOfFixLength(50));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid ProviderId length
	@Test
	public void R2267_TC91507_AltEVV_EmployeeProviderID_invalid_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_EmployeeProviderID_invalid_length");  

		//Using Reusable method to load employee json
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		JSONObject Jsob = (JSONObject) jsonArray.get(0);
		Jsob.put("ProviderID", CommonMethods.generateRandomNumberOfFixLength(55));


		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
		
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

}