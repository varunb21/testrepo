/**
 * 
 */
package AltEVV_generic.restassured.sandata.Client;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91264_AltEVV_ProviderQualifier extends BaseTest{

	//validating valid altEVV client validation for providerQualifier field having value SandataID, 
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_valid_SandataID_asvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91263_AltEVV_ClientContactZip_valid_5Digit"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientZip"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ProviderQualifier (Client) format is incorrect. The record should satisfy this regular expression");
		}

	//validating valid altEVV client validation for providerQualifier field having value  NPI
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_valid_NPI_asvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91264_AltEVV_ProviderQualifier_valid_NPI_asvalue"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value  NPI"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("NPI"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//validating valid altEVV client validation for providerQualifier field having value API
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_valid_API_asvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91264_AltEVV_ProviderQualifier_valid_API_asvalue"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value API"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("API"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//validating valid altEVV client validation for providerQualifier field having value MedicaidID
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_valid_MedicaidID_asvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91264_AltEVV_ProviderQualifier_valid_MedicaidID_asvalue"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value MedicaidID"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("MedicaidID"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		}

	//validating valid altEVV client validation for providerQualifier field having value TaxID
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_valid_TaxID_asvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91264_AltEVV_ProviderQualifier_valid_TaxID_asvalue"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value TaxID"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("SandataID"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		}

	//validating valid altEVV client validation for providerQualifier field having value Taxonomy
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_valid_Taxonomy_asvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91264_AltEVV_ProviderQualifier_valid_Taxonomy_asvalue"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value Taxonomy"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("SandataID"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//validating valid altEVV client validation for providerQualifier field having value Legacy
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_valid_Legacy_asvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91264_AltEVV_ProviderQualifier_valid_Legacy_asvalue"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value Legacy"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("Legacy"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//validating valid altEVV client validation for providerQualifier field having value Other
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_valid_Other_asvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91264_AltEVV_ProviderQualifier_valid_Other_asvalue"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value Other"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("Other"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//validating invalid altEVV client validation for providerQualifier field other than the assigned value
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91264_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV client validation for providerQualifier field other than the assigned value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("wewqeqwe"));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The ProviderQualifier (Client) format is incorrect.");

	}

	//validating invalid altEVV client validation for providerQualifier field other than the assigned value but alphanumeric
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue_alphanumeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91264_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue_alphanumeric"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV client validation for providerQualifier field other than the assigned value but alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", CommonMethods.generateRandomAlphaNumeric(20));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ProviderQualifier (Client) format is incorrect. The record should satisfy this regular expression");
	}

	//validating invalid altEVV client validation for providerQualifier field other than the assigned value but null
	@Test (priority=0)
	public void R78152_TC91264_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R78152_TC91264_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue_null"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV client validation for providerQualifier field other than the assigned value but null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", CommonMethods.generateRandomAlphaNumeric(20));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ProviderQualifier (Client) format is incorrect. The record should satisfy this regular expression");
	}

}

