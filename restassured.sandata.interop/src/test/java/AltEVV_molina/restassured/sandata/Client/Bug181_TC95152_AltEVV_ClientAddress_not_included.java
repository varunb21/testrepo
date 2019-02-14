package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Open EVV-Client-Validate - Client Address - Verify negative response is received with negative values in ClientAddress segment

public class Bug181_TC95152_AltEVV_ClientAddress_not_included extends BaseTest {

	@Test
	public void Bug181_TC95152_AltEVV_ClientAddress_not_present() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("Bug181_TC95152_OpenEVV_ClientAddress_not_present"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove(globalVariables.addressArrayjson);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressEmptyError);
	}

	@Test
	public void Bug181_TC95152_AltEVV_ClientAddress_fields_not_present() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("Bug181_TC95152_OpenEVV_ClientAddress_not_present"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayAdd = (JSONArray) jsonObject.get(globalVariables.addressArrayjson);
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(0);
		jsonObjectAdd.remove("ClientAddressType"); 

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressTypeNullError);
	}


}