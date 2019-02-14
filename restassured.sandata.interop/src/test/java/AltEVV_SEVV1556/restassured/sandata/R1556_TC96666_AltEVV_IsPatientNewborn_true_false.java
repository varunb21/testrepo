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

public class R1556_TC96666_AltEVV_IsPatientNewborn_true_false extends BaseTest {

	
	@Test
	public void R1556_TC96666_AltEVV_PatientMedicaidID_true() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96666_AltEVV_PatientMedicaidID_true"); 
		logger.log(LogStatus.INFO, "R1556_TC96666_AltEVV_PatientMedicaidID_true"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(15));
		jsonObject.put("IsPatientNewborn", true);

		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatiderrorcode_incaseless_more_than12);
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatiderrormessage_incaseless_more_than12);
	
	}
	
	@Test
	public void R1556_TC96666_AltEVV_PatientMedicaidID_true_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96666_AltEVV_PatientMedicaidID_true_valid"); 
		logger.log(LogStatus.INFO, "R1556_TC96666_AltEVV_PatientMedicaidID_true_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
		jsonObject.put("IsPatientNewborn", true);

		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);

	}
	
	@Test
	public void R1556_TC96666_AltEVV_PatientMedicaidID_false() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96666_AltEVV_PatientMedicaidID_false"); 
		logger.log(LogStatus.INFO, "R1556_TC96666_AltEVV_PatientMedicaidID_false"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(15));
		jsonObject.put("IsPatientNewborn", false);

		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatidlengtherror);
	
	}
	
	@Test
	public void R1556_TC96666_AltEVV_PatientMedicaidID_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96666_AltEVV_PatientMedicaidID_null"); 
		logger.log(LogStatus.INFO, "R1556_TC96666_AltEVV_PatientMedicaidID_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(15));
		jsonObject.put("IsPatientNewborn", null);

		CommonMethods.captureResponse3P_500(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

			
	}
}