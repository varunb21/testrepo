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

public class SEVV_1556_TC97513_Validate_GetResponse extends BaseTest{
	
	//validating AltEVV with no value of MissingMedicaidID
			@Test
			public void TC97513_Validate_GetResponse_with_multiple_valueof_ResponsibleParty() throws IOException, ParseException, SQLException
			{
				logger = extent.startTest("TC97513_Validate_GetResponse_with_multiple_valueof_ResponsibleParty"); 
				logger.log(LogStatus.INFO, "TC97513_Validate_GetResponse_with_multiple_valueof_ResponsibleParty"); 

				JSONArray jsonArray = GenerateUniqueParam.patient_AltEVV("patientIntake");
				JSONObject jsonObject = (JSONObject) jsonArray.get(0);
				
				JSONArray jsonArrPay = (JSONArray) jsonObject.get("ResponsibleParty");
				JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
				jsonObjectnew.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(8));
				jsonObjectnew.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(8));
			
				
				JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("ResponsibleParty");
				JSONObject jsonObjectPay = 	(JSONObject) jsonArrPaynew.get(1);
				jsonObjectPay.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(8));
				jsonObjectPay.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(8));
			
				String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("AltEVV_patient"));

				String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("AltEVV_patient_get"));

				Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
			}

}
