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
//Test Case 91411: OpenEVV-altEVV- Employee - SequenceID validation field formats/values

public class R2267_TC91411_AltEVV_EmpSequenceID extends BaseTest{


	//To validate the valid SequenceID
	@Test
	public void R2267_TC91411_AltEVV_SequenceID_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_SequenceID_valid");  

		logger.log(LogStatus.INFO, "To validate the valid  SequenceID "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(1));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, js);

	}

	//To validate the invalid SequenceID
	@Test
	public void R2267_TC91411_AltEVV_SequenceID_invalid() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_SequenceID_invalid");  

		logger.log(LogStatus.INFO, "To validate the invalid SequenceID "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(17));

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The SequenceID value cannot be greater than 9999999999999999."));

	}

	//To validate the invalid SequenceID format
	@Test
	public void R2267_TC91411_AltEVV_SequenceID_invalid_format() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_SequenceID_invalid_format");  

		logger.log(LogStatus.INFO, "To validate the invalid SequenceID format "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "");

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		CommonMethods.captureResponseAltEVV_400(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));


	}

	//To validate the null SequenceID 
	@Test
	public void R2267_TC91411_AltEVV_SequenceID_null() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91406_AltEVV_SequenceID_null");  

		logger.log(LogStatus.INFO, "To validate the null SequenceID "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", null);

		String bodyAsString = 
				CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The SequenceID cannot be NULL."));

	}

}