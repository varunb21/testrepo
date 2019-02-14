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

//Test Case 92219: Open EVV-altEVV-Client - Required Fields missing

public class R2267_TC92220_AltEVV_Client_Req_Fields_Missing extends BaseTest {

	//Validating AltEVV Client Creation with Req fields missing
	@Test
	public void R2267_TC92220_AltEVV_Client_Req_Fields_missing_Validation() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC92219_AltEVV_Client_Req_Fields_mising_Validation"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake_req_missing);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The Provider cannot be null. The record is being rejected.");
	}


}