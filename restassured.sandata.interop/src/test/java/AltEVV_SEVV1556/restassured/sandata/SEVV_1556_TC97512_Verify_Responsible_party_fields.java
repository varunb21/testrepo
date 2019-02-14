package AltEVV_SEVV1556.restassured.sandata;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_1556_TC97512_Verify_Responsible_party_fields extends BaseTest{
	
	//validating AltEVV with no value of MissingMedicaidID
			@Test
			public void TC56669_GeneralInformation_PatientFirstName_field_formats() throws IOException, ParseException, SQLException
			{
				logger = extent.startTest("TC56669_GeneralInformation_PatientFirstName_field_formats"); 
				logger.log(LogStatus.INFO, "TC56669_GeneralInformation_PatientFirstName_field_formats"); 

				JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
				JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			
				String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

				String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

				Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
			}

}
