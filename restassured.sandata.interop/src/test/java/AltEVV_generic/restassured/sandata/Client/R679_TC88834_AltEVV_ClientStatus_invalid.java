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

public class R679_TC88834_AltEVV_ClientStatus_invalid extends BaseTest {


	//validating valid altEVV client  having PayerID_valid of Max Length i.e 64 char
	@Test (priority=0)
	public void R679_TC88827_AltEVV_ClientStatus_null_invalid_fixed() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC88827_AltEVV_ClientStatus_null_invalid_fixed"); 
		logger.log(LogStatus.INFO, "R679_TC88827_AltEVV_ClientStatus_null_invalid_fixed");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientStatus", "05");
		jsonObject1.put("ClientEligibilityDateBegin", CommonMethods.generatePastDate_YYYY_MM_dd());
		jsonObject1.put("ClientEligibilityDateEnd", CommonMethods.generateTodayDate_YYYY_MM_dd());

		JSONObject jsonObject2= (JSONObject) jsonArray1.get(1);
		jsonObject2.put("ClientStatus", "05");
		jsonObject2.put("ClientEligibilityDateBegin", CommonMethods.generatePastDate_YYYY_MM_dd());
		jsonObject2.put("ClientEligibilityDateEnd", CommonMethods.generateTodayDate_YYYY_MM_dd());

		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatus_error_format);
	
	}
	
	@Test (priority=0)
	public void R679_TC88827_AltEVV_ClientStatus_null_invalid_randoml() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC88827_AltEVV_ClientStatus_null_invalid_randoml"); 
		logger.log(LogStatus.INFO, "R679_TC88827_AltEVV_ClientStatus_null_invalid_randoml");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientStatus", CommonMethods.generateRandomNumberOfFixLength(2));
		jsonObject1.put("ClientEligibilityDateBegin", CommonMethods.generatePastDate_YYYY_MM_dd());
		jsonObject1.put("ClientEligibilityDateEnd", CommonMethods.generateTodayDate_YYYY_MM_dd());

		JSONObject jsonObject2= (JSONObject) jsonArray1.get(1);
		jsonObject2.put("ClientStatus", CommonMethods.generateRandomNumberOfFixLength(2));
		jsonObject2.put("ClientEligibilityDateBegin", CommonMethods.generatePastDate_YYYY_MM_dd());
		jsonObject2.put("ClientEligibilityDateEnd", CommonMethods.generateTodayDate_YYYY_MM_dd());

		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatus_error_format);
	
	}
	
	
}