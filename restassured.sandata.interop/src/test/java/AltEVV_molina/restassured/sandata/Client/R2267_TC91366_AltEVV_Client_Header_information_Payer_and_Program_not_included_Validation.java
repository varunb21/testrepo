/**
 * 
 */
package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
//OpenEVV-altEVV- Client:  Validate (mix) - Validate if the Header information for the payer and program is not included in each transmission for client
/**
 * @author Anupam
 *
 */
public class R2267_TC91366_AltEVV_Client_Header_information_Payer_and_Program_not_included_Validation extends BaseTest{

	@Test(groups = { "Databasetest"})
	public void TC91366_AltEVV_CreateClient_without_Header_information_for_Payer_and_Program() throws IOException, ParseException, ConfigurationException, SQLException

	{   
		logger = extent.startTest("TC91366_AltEVV_CreateClient_without_Header_information_for_Payer_and_Program");
		logger.log(LogStatus.INFO, "Validating ClientJson passing without_Header_information_for_Payer_and_Program"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonObject2 = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);

		jsonObject3.remove(globalVariables.PayerProgram);
		jsonObject3.remove(globalVariables.PayerID);
		jsonObject3.remove(globalVariables.ProcedureCode);

		String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ProcedureCode cannot be null.");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The PayerProgram cannot be null or empty.");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The PayerID cannot be null.");

	}

	@Test(groups = { "Databasetest"})
	public void TC91366_AltEVV_CreateClient_without_Header_information_for_Procedurecode() throws IOException, ParseException, ConfigurationException, SQLException

	{   
		logger = extent.startTest("TC91366_AltEVV_CreateClient_without_Header_information_for_Payer_and_Program");
		logger.log(LogStatus.INFO, "Validating ClientJson passing without_Header_information_for_Payer_and_Program"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonObject2 = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);

		jsonObject3.remove(globalVariables.ProcedureCode);

		String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ProcedureCode cannot be null.");

	}

	@Test(groups = { "Databasetest"})
	public void TC91366_AltEVV_CreateClient_without_Header_information_for_Payerid() throws IOException, ParseException, ConfigurationException, SQLException

	{   
		logger = extent.startTest("TC91366_AltEVV_CreateClient_without_Header_information_for_Payer_and_Program");
		logger.log(LogStatus.INFO, "Validating ClientJson passing without_Header_information_for_Payer_and_Program"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonObject2 = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);

		jsonObject3.remove(globalVariables.PayerID);

		String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The PayerID cannot be null.");

	}

	@Test(groups = { "Databasetest"})
	public void TC91366_AltEVV_CreateClient_without_Header_information_for_PayerProgram() throws IOException, ParseException, ConfigurationException, SQLException
	{ 

		logger = extent.startTest("TC91366_AltEVV_CreateClient_without_Header_information_for_PayerProgram");
		logger.log(LogStatus.INFO, "Validating ClientJson passed with TC91366_AltEVV_CreateClient_without_Header_information_for_PayerProgram"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.remove("PayerProgram");


		String bodyAsString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The PayerProgram cannot be null or empty.");

	}
}

