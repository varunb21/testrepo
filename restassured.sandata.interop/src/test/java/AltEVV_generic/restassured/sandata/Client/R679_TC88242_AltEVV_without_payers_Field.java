package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91096:OpenEVV-altEVV- Client Payer: Validate (mix) - PayerID field formats/values

public class R679_TC88242_AltEVV_without_payers_Field extends BaseTest {


	//validating valid altEVV client  having PayerID_valid of Max Length i.e 64 char
	@Test (priority=0)
	public void R2267_TC91096_AltEVV_without_PayerID_info() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91096_AltEVV_without_PayerID_info"); 
		logger.log(LogStatus.INFO, "R2267_TC91096_AltEVV_without_PayerID_info");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.remove(globalVariables.PayerProgram);
		jsonObject1.remove(globalVariables.PayerID);
		jsonObject1.remove(globalVariables.ClientPayerID);
		
		JSONObject jsonObject2 = (JSONObject) jsonArray1.get(0);
		jsonObject1.remove(globalVariables.PayerProgram);
		jsonObject1.remove(globalVariables.PayerID);
		jsonObject1.remove(globalVariables.ClientPayerID);
				
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerProgramNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDNullError);


	}
	
	@Test (priority=0)
	public void R2267_TC91096_AltEVV_without_payerinfo_details() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91096_AltEVV_without_payerinfo_details"); 
		logger.log(LogStatus.INFO, "R2267_TC91096_AltEVV_without_payerinfo_details"); 
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.remove(globalVariables.Client_Payer_Information);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Client_Payer_Informationemptyerror);

	}
}