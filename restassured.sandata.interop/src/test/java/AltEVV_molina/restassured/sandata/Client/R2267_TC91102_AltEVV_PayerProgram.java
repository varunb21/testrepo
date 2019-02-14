package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91102:OpenEVV-altEVV- Client : Validate PayerProgram field/format values


public class R2267_TC91102_AltEVV_PayerProgram extends BaseTest {

	String clntid;

	//validating valid altEVV client  having payer program of Max Length i.e 9 char
	@Test (priority=0)
	public void R2267_TC91102_AltEVV_PayerProgram_valid_Max_Length_string() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91102_AltEVV_PayerProgram_valid_Max_Length_string"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having payer program of Max Length i.e 9 char"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerProgram, CommonMethods.generateRandomStringOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_Authlimits_altevv(bodyAsString, jsonObject, jsonObject1);
	}

	//validating invalid altEVV client  having payer program of Max Length i.e 9 c but having specialchar
	@Test (priority=1)
	public void R2267_TC91102_AltEVV_PayerProgram_invalid_Max_Length_specialchar() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91102_AltEVV_PayerProgram_invalid_Max_Length_specialchar"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having payer program of Max Length i.e 9 char"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerProgram, CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The PayerProgram value is incorrect. The length should be between 1 and 9");
	}

	//validating invalid altEVV client  having payer program of Max Length  ie 10 char
	@Test (priority=1)
	public void R2267_TC91102_AltEVV_PayerProgram_invalid_Max_plus_one_Length_String() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91102_AltEVV_PayerProgram_valid_Max_Length"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having payer program of Max Length i.e 9 char"); 
		String payerprogrm=CommonMethods.generateRandomStringOfFixLength(10);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerProgram, payerprogrm);
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.payerProgramSizeError);
	}
}