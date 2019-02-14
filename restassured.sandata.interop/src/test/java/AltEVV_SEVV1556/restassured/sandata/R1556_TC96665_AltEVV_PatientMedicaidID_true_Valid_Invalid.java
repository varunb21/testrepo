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

public class R1556_TC96665_AltEVV_PatientMedicaidID_true_Valid_Invalid extends BaseTest {

	
	@Test
	public void R1556_TC96664_AltEVV_PatientMedicaidID_true() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96664_AltEVV_PatientMedicaidID_true"); 
		logger.log(LogStatus.INFO, "R1556_TC96664_AltEVV_PatientMedicaidID_true"); 

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
	public void R1556_TC96664_AltEVV_PatientMedicaidID_false() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R1556_TC96664_AltEVV_PatientMedicaidID_false"); 
		logger.log(LogStatus.INFO, "R1556_TC96664_AltEVV_PatientMedicaidID_false"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(15));
		jsonObject.put("IsPatientNewborn", false);

		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientmedicatidlengtherror);
	
	}
	
}