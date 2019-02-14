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

public class R1556_TC96663_AltEVV_PatientOtherID_Valid_Invalid extends BaseTest {

	
	@Test
	public void R1556_TC96663_AltEVV_PatientOtherID_Valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96663_AltEVV_PatientOtherID_Valid"); 
		logger.log(LogStatus.INFO, "R1556_TC96663_AltEVV_PatientOtherID_Valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(63));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test
	public void R1556_TC96663_AltEVV_PatientOtherID_Valid_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96663_AltEVV_PatientOtherID_Valid_max"); 
		logger.log(LogStatus.INFO, "R1556_TC96663_AltEVV_PatientOtherID_Valid_max"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(64));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}

	@Test
	public void R1556_TC96663_AltEVV_PatientOtherID_inValid_morethan64() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96663_AltEVV_PatientOtherID_inValid_morethan64"); 
		logger.log(LogStatus.INFO, "R1556_TC96663_AltEVV_PatientOtherID_inValid_morethan64"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(65));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientotherlengtherror);
		
	}
	
	@Test
	public void R1556_TC96663_AltEVV_PatientOtherID_inValid_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96663_AltEVV_PatientOtherID_inValid_morethan64"); 
		logger.log(LogStatus.INFO, "R1556_TC96663_AltEVV_PatientOtherID_inValid_morethan64"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientOtherID", null);
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientothernullerror);
		
	}
	
	@Test
	public void R1556_TC96663_AltEVV_PatientOtherID_inValid_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96663_AltEVV_PatientOtherID_inValid_morethan64"); 
		logger.log(LogStatus.INFO, "R1556_TC96663_AltEVV_PatientOtherID_inValid_morethan64"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientOtherID", "");
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientotherlengtherror);
		
	}
	
	@Test
	public void R1556_TC96663_AltEVV_PatientOtherID_inValid_specialchar() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96663_AltEVV_PatientOtherID_inValid_morethan64"); 
		logger.log(LogStatus.INFO, "R1556_TC96663_AltEVV_PatientOtherID_inValid_morethan64"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientOtherID", CommonMethods.generateSpecialChar(24));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientotherlengtherror);
		
	}
}