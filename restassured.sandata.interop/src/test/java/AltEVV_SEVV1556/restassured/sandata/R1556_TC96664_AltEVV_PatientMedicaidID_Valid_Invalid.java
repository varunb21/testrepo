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

public class R1556_TC96664_AltEVV_PatientMedicaidID_Valid_Invalid extends BaseTest {

	
	@Test
	public void R1556_TC96664_AltEVV_PatientMedicaidID_Valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96664_AltEVV_PatientMedicaidID_Valid"); 
		logger.log(LogStatus.INFO, "R1556_TC96664_AltEVV_PatientMedicaidID_Valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test
	public void R1556_TC96664_AltEVV_PatientMedicaidID_Valid_maxminus1() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96664_AltEVV_PatientMedicaidID_Valid_max"); 
		logger.log(LogStatus.INFO, "R1556_TC96664_AltEVV_PatientMedicaidID_Valid_max"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(11));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));
		
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatiderrorcode_incaseless_more_than12);
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatiderrormessage_incaseless_more_than12);
	}
	
	@Test
	public void R1556_TC96664_AltEVV_PatientMedicaidID_invalid_maxmplus1() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96664_AltEVV_PatientMedicaidID_invalid_maxmplus1"); 
		logger.log(LogStatus.INFO, "R1556_TC96664_AltEVV_PatientMedicaidID_invalid_maxmplus1"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(13));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));
		
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatiderrorcode_incaseless_more_than12);
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatiderrormessage_incaseless_more_than12);
	}
	
	@Test
	public void R1556_TC96664_AltEVV_PatientMedicaidID_inValid_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96664_AltEVV_PatientMedicaidID_inValid_morethan64"); 
		logger.log(LogStatus.INFO, "R1556_TC96664_AltEVV_PatientMedicaidID_inValid_morethan64"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", null);
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatiderrorcode_incaseless_more_than12);
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatiderrormessage_incaseless_more_than12);
		Assert.assertTrue(bodyAsStringget.contains(globalVariables.patientmedicatiderror));

	}
	
	@Test
	public void R1556_TC96664_AltEVV_PatientMedicaidID_inValid_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96664_AltEVV_PatientMedicaidID_inValid_morethan64"); 
		logger.log(LogStatus.INFO, "R1556_TC96664_AltEVV_PatientMedicaidID_inValid_morethan64"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", "");
	
		CommonMethods.captureResponse3P_500(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
	
	}
	
	@Test
	public void R1556_TC96664_AltEVV_PatientMedicaidID_inValid_specialchar() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96664_AltEVV_PatientMedicaidID_inValid_morethan64"); 
		logger.log(LogStatus.INFO, "R1556_TC96664_AltEVV_PatientMedicaidID_inValid_morethan64"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateSpecialChar(24));
	
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatiderrorcode_incaseless_more_than12);
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatiderrormessage_incaseless_more_than12);
	}
}