package AltEVV_molina.restassured.sandata.Visit;

/*
@MayankM

OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_formats_values

 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC95311_AltEVV_Visit_OriginatingPhoneNumber extends BaseTest {

	//validating valid OriginatingPhoneNumber
	@Test
	public void R2267_TC95311_OpenEVV_AltEVV_Visits_OriginatingPhoneNumber_valid() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_valid");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomNumberOfFixLength(10));


		JSONArray jsonArrayVisitchnge=(JSONArray) jsonObjectVisit.get("");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitchnge.get(0);
	

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitCalls(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

	}

	//validating OriginatingPhoneNumber invalid length
	@Test
	public void R2267_TC95311_OpenEVV_AltEVV_Visits_OriginatingPhoneNumber_invalid_length() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson,CommonMethods.generateRandomNumberOfFixLength(11));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberLengthError);

	}

	//validating OriginatingPhoneNumber with blank value
	@Test
	public void R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_blank() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson,"");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberFormatError);

	}

	//validating OriginatingPhoneNumber with letters
	@Test
	public void R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_letters() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson,CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberFormatError);

	}

	//validating OriginatingPhoneNumber with alphanumeric
	@Test
	public void R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_alphanumeric() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberFormatError);

	}

	//validating OriginatingPhoneNumber with null
	@Test
	public void R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_null() throws FileNotFoundException, IOException, ParseException, SQLException{

		logger = extent.startTest("R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.OriginatingPhoneNumberjson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberNullError);




	}

}



