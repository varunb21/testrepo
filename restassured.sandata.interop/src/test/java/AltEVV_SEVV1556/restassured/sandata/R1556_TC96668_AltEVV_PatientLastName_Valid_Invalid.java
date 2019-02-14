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

public class R1556_TC96668_AltEVV_PatientLastName_Valid_Invalid extends BaseTest {

	
	@Test
	public void R1556_TC96668_AltEVV_PatientLastName_Valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96668_AltEVV_PatientLastName_Valid"); 
		logger.log(LogStatus.INFO, "R1556_TC96668_AltEVV_PatientLastName_Valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(30));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test
	public void R1556_TC96668_AltEVV_PatientLastName_Valid_maxminus1() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96668_AltEVV_PatientLastName_Valid_max"); 
		logger.log(LogStatus.INFO, "R1556_TC96668_AltEVV_PatientLastName_Valid_max"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(29));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));
		
		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test
	public void R1556_TC96668_AltEVV_PatientLastName_invalid_maxmplus1() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96668_AltEVV_PatientLastName_invalid_maxmplus1"); 
		logger.log(LogStatus.INFO, "R1556_TC96668_AltEVV_PatientLastName_invalid_maxmplus1"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", CommonMethods.generateRandomNumberOfFixLength(31));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));
		
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.PatientLastNamelengtherror);
	}
	
	@Test
	public void R1556_TC96668_AltEVV_PatientLastName_Valid_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96668_AltEVV_PatientLastName_Valid_null"); 
		logger.log(LogStatus.INFO, "R1556_TC96668_AltEVV_PatientLastName_Valid_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", null);
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.PatientLastNamenullerror);

	}
	
	@Test
	public void R1556_TC96668_AltEVV_PatientLastName_inValid_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96668_AltEVV_PatientLastName_inValid_blank"); 
		logger.log(LogStatus.INFO, "R1556_TC96668_AltEVV_PatientLastName_inValid_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", "");
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
		
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));
		
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.PatientLastNamelengtherror);

	}
	
	@Test
	public void R1556_TC96668_AltEVV_PatientLastName_inValid_specialchar() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96668_AltEVV_PatientLastName_inValid_morethan64"); 
		logger.log(LogStatus.INFO, "R1556_TC96668_AltEVV_PatientLastName_inValid_morethan64"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", CommonMethods.generateSpecialChar(24));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.PatientLastNameformaterror);
	}

	@Test
	public void R1556_TC96668_AltEVV_PatientLastName_inValid_Alphanum() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96668_AltEVV_PatientLastName_inValid_Alphanum"); 
		logger.log(LogStatus.INFO, "R1556_TC96668_AltEVV_PatientLastName_inValid_Alphanum"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", CommonMethods.generateRandomAlphaNumeric(24));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.PatientLastNameformaterror);
	}

}