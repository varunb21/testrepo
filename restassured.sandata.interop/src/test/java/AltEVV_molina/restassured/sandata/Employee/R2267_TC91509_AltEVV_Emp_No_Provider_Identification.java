package AltEVV_molina.restassured.sandata.Employee;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

/**
 * @author RRohiteshwar
 *
 */
//Test Case 91404:OpenEVV-altEVV- Employee - EmployeeEmail validation field formats/values.

public class R2267_TC91509_AltEVV_Emp_No_Provider_Identification extends BaseTest{
	SoftAssert softAssert = new SoftAssert();

	//Validate the invalid without provider id
	@Test(priority=0, groups = {"functest"})
	public void R2267_TC91509_AltEVV_Emp_Values_No_ProviderID() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91509_AltEVV_Emp_Values_ProviderID");  

		logger.log(LogStatus.INFO, "//Validate the invalid without provider id"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");		
		JSONObject js = (JSONObject) j.get(0);
		
		JSONObject jsonObjectPay =  (JSONObject) js.get("ProviderIdentification");
		jsonObjectPay.remove("ProviderID");

		String resp = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(resp.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(resp.contains("ERROR: The ProviderID cannot be NULL."));

	}

	//Validate the invalid without provider id
	@Test(priority=0, groups = {"functest"})
	public void R2267_TC91509_AltEVV_Emp_Values_No_ProviderQualifier() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91509_AltEVV_Emp_Values_ProviderQualifier");  

		logger.log(LogStatus.INFO, "//Validate the invalid without provider id"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");		
		JSONObject js = (JSONObject) j.get(0);
		JSONObject jsonObjectPay =  (JSONObject) js.get("ProviderIdentification");
		jsonObjectPay.remove("ProviderQualifier");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ProviderQualifier cannot be NULL."));

	}

	//Validate the invalid without provider id
	@Test(priority=0, groups = {"functest"})
	public void R2267_TC91509_AltEVV_Emp_Values_No_ProviderQualifier_providerid() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91509_AltEVV_Emp_Values_ProviderQualifier_providerid");  

		logger.log(LogStatus.INFO, "//Validate the invalid without provider id"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");		
		JSONObject js = (JSONObject) j.get(0);
		JSONObject jsonObjectPay =  (JSONObject) js.get("ProviderIdentification");
		jsonObjectPay.remove("ProviderQualifier");
		jsonObjectPay.remove("ProviderID");

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ProviderID cannot be NULL."));

	}

}