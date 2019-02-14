package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
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

//Test Case 92219: Open EVV-altEVV-Client - Required Fields missing

public class R2267_TC92220_AltEVV_Client_Req_Fields_Missing extends BaseTest {

	//Validating AltEVV Client Creation with Req fields missing
	@Test
	public void R2267_TC92220_AltEVV_Client_Req_Fields_missing_Validation() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC92219_AltEVV_Client_Req_Fields_mising_Validation"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonobject= (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArraysub = (JSONArray) jsonobject.get("ClientPayerInformation");
		JSONObject jsonobjectsub= (JSONObject) jsonArraysub.get(0);
		jsonobjectsub.put("PayerID", null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The PayerID cannot be null.");
	}
	
	@Test
	public void R2267_TC92220_AltEVV_Client_Req_Fields_missing_Validation_2() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC92220_AltEVV_Client_Req_Fields_missing_Validation_2"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonobject= (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArraysub = (JSONArray) jsonobject.get("ClientPayerInformation");
		JSONObject jsonobjectsub= (JSONObject) jsonArraysub.get(1);
		jsonobjectsub.put("PayerID", null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The PayerID cannot be null.");
	}
	
	@Test
	public void R2267_TC92220_AltEVV_Client_Req_Fields_missing_Validation_complete() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC92220_AltEVV_Client_Req_Fields_missing_Validation_2"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonobject= (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArraysub1 = (JSONArray) jsonobject.get("ClientPayerInformation");
		JSONObject jsonobjectsub1= (JSONObject) jsonArraysub1.get(0);
		jsonobjectsub1.put("PayerID", null);
		
		JSONArray jsonArraysub = (JSONArray) jsonobject.get("ClientPayerInformation");
		JSONObject jsonobjectsub= (JSONObject) jsonArraysub.get(1);
		jsonobjectsub.put("PayerID", null);
	
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The PayerID cannot be null.");
	}
	


}