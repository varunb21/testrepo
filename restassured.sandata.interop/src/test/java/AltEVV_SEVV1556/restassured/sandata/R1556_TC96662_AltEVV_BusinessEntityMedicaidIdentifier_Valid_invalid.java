package AltEVV_SEVV1556.restassured.sandata;

import static org.testng.Assert.assertTrue;

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

public class R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_Valid_invalid extends BaseTest {

	
	@Test
	public void R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_Valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_Valid_invalid"); 
		logger.log(LogStatus.INFO, "R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_Valid_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", 10010);
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}

	@Test
	public void R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_morethan10() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_morethan10"); 
		logger.log(LogStatus.INFO, "R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_morethan10"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", CommonMethods.generateRandomNumberOfFixLength(11));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentitybadrequesterror));
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentityformaterror));
		
	}
	
	@Test
	public void R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_null"); 
		logger.log(LogStatus.INFO, "R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", null);
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentitybadrequesterror));
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessmedicatednullerror));
		
	}

	@Test
	public void R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_blank"); 
		logger.log(LogStatus.INFO, "R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", "");
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentitybadrequesterror));
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessmedicatednullerror));
		
	}
	
	@Test
	public void R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_alphanum() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_alphanum"); 
		logger.log(LogStatus.INFO, "R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_alphanum"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", CommonMethods.generateRandomAlphaNumeric(9));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentitybadrequesterror));
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentityformaterror));
		
	}
	
	@Test
	public void R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_special() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_special"); 
		logger.log(LogStatus.INFO, "R1556_TC96662_AltEVV_BusinessEntityMedicaidIdentifier_inValid_special"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", CommonMethods.generateSpecialChar(9));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentitybadrequesterror));
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentityformaterror));
		
	}

}