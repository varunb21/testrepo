package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91088: OpenEVV-altEVV- Client: Validate (mix) - MissingMedicaidID field formats/values

public class R2267_TC91088_AltEVV_MissingMedicaidID extends BaseTest {

	//validating AltEVV with no value of MissingMedicaidID
	@Test
	public void R2267_TC91088_AltEVV_MissingMedicaidID_optional() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_91088_AltEVV_MissingMedicaidID_optional"); 
		logger.log(LogStatus.INFO, "validating altEVV with no value of MissingMedicaidID"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("MissingMedicaidID", "");
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	
	}

	//validating AltEVV with MissingMedicaidID= True
	@Test
	public void R2267_91088_AltEVV_MissingMedicaidID_True() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_91088_AltEVV_MissingMedicaidID_True"); 
		logger.log(LogStatus.INFO, "validating AltEVV with MissingMedicaidID= True"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("MissingMedicaidID", "True");
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	
	}

	//validating AltEVV with MissingMedicaidID= False
	@Test
	public void R2267_91088_AltEVV_MissingMedicaidID_False() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_91088_AltEVV_MissingMedicaidID_False"); 
		logger.log(LogStatus.INFO, "validating AltEVV with MissingMedicaidID= False"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("MissingMedicaidID", "False");
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	
	}

	//validating AltEVV with MissingMedicaidID= null
	@Test
	public void R2267_TC91088_AltEVV_MissingMedicaidID_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91088_AltEVV_MissingMedicaidID_null"); 
		logger.log(LogStatus.INFO, "validating AltEVV with MissingMedicaidID= null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("MissingMedicaidID", null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonObject);	
	}

	//Validating AltEVV with MissingMedicaidID of invalid length
	@Test
	public void R2267_TC91088_AltEVV_MissingMedicaidID_invalid_length() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91088_AltEVV_MissingMedicaidID_invalid_length"); 
		logger.log(LogStatus.INFO, "Validating AltEVV with MissingMedicaidID of invalid length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("MissingMedicaidID", CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));
	}

	//Validating AltEVV with MissingMedicaidID of invalid format
	@Test
	public void R2267_TC91088_AltEVV_MissingMedicaidID_invalid_format() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91088_AltEVV_MissingMedicaidID_invalid_format"); 
		logger.log(LogStatus.INFO, "Validating AltEVV with MissingMedicaidID of invalid format"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("MissingMedicaidID", CommonMethods.generateRandomStringOfFixLength(3));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));
	}

}