package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 92219: Open EVV-altEVV-Client - Required Fields Blank

public class R2267_TC92219_AltEVV_Client_Req_Fields_Blank extends BaseTest {

	//Validating AltEVV Client Creation with Req fields blank
	@Test
	public void R2267_TC92219_AltEVV_Client_Req_Fields_Blank_Validation() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC92219_AltEVV_Client_Req_Fields_Blank_Validation"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake_req_blank);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The Provider cannot be null.");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine1 format is incorrect. The record should satisfy this regular expression");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState value is incorrect. The length should be between 2 and 2.");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientQualifier format is incorrect. The record should satisfy this regular expression");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientPhone cannot be null.|ERROR: The SequenceID value is incorrect. The length should be between 1 and 16");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientTimeZone value is invalid.");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLongitude cannot be null.");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState format is incorrect. The record should satisfy this regular expression."); 
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientTimezone value is incorrect. The length should be between 1 and 64.");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientCity format is incorrect. The record should satisfy this regular expression");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine1 value is incorrect. The length should be between 1 and 30");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientZip value is incorrect. The length should be between 1 and 9");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientCity value is incorrect. The length should be between 1 and 30");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressIsPrimary format is incorrect. The record should satisfy this regular expression");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientQualifier value is incorrect. The length should be between 1 and 20.");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressIsPrimary value is incorrect. The length should be between 1 and 5");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressType format is incorrect. The record should satisfy this regular expression");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientTimezone format is incorrect. The record should satisfy this regular expression");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLatitude cannot be null.");
//		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientZip format is incorrect. The record should satisfy this regular expression");
	}
}

