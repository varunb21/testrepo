package AltEVV_molina.restassured.sandata.Client;

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

		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

}
}