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

public class R679_TC96606_AltEVV_ClientEligibilityDate_Start_invalid extends BaseTest {

	
	@Test (priority=0)
	public void R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_mmddyyyy() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_mmddyyyy"); 
		logger.log(LogStatus.INFO, "R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_mmddyyyy");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientStatus", null);
		jsonObject1.put("ClientEligibilityDateBegin", CommonMethods.generatePastDate_MMddYYYY());
		jsonObject1.put("ClientEligibilityDateEnd", CommonMethods.generateTodayDate_YYYY_MM_dd());

		JSONObject jsonObject2= (JSONObject) jsonArray1.get(1);
		jsonObject2.put("ClientStatus", null);
		jsonObject2.put("ClientEligibilityDateBegin", CommonMethods.generatePastDate_MMddYYYY());
		jsonObject2.put("ClientEligibilityDateEnd",  CommonMethods.generateTodayDate_YYYY_MM_dd());

		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateBeginerror);
	
	}
	
	@Test (priority=0)
	public void R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_random() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_random"); 
		logger.log(LogStatus.INFO, "R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_random");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientStatus", null);
		jsonObject1.put("ClientEligibilityDateBegin", CommonMethods.generateRandomNumberOfFixLength(8));
		jsonObject1.put("ClientEligibilityDateEnd", CommonMethods.generateTodayDate_YYYY_MM_dd());
	
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateBeginerror);
	
	}
	
	@Test (priority=0)
	public void R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_firstsement() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_firstsement"); 
		logger.log(LogStatus.INFO, "R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_firstsement");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientStatus", null);
		jsonObject1.put("ClientEligibilityDateBegin", CommonMethods.generatePastDate_MMddYYYY());
		jsonObject1.put("ClientEligibilityDateEnd", CommonMethods.generateTodayDate_YYYY_MM_dd());
	
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateBeginerror);
	
	}
	
	@Test (priority=0)
	public void R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_secondsement() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_secondsement"); 
		logger.log(LogStatus.INFO, "R679_TC96606_AltEVV_ClientEligibilityDate_Start_End_invalid_secondsement");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(1);
		jsonObject1.put("ClientStatus", null);
		jsonObject1.put("ClientEligibilityDateBegin", CommonMethods.generatePastDate_MMddYYYY());
		jsonObject1.put("ClientEligibilityDateEnd", CommonMethods.generateTodayDate_YYYY_MM_dd());
	
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateBeginerror);
	
	}
	
}