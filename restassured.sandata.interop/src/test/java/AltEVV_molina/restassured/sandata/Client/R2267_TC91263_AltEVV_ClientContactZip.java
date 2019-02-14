/**
 * 
 */
package AltEVV_molina.restassured.sandata.Client;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


 
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Client;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
/**
 * @author RRohiteshwar
 *
 */

public class R2267_TC91263_AltEVV_ClientContactZip extends BaseTest{


	//validating valid altEVV ClientContactZip validation field formats/values with 5 digit
	@Test (priority=0)
	public void R2267_TC91263_AltEVV_ClientContactZip_valid_5Digit() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_valid_5Digit"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  havingClientContactZip "); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject,jsonObject1);	
		
	}

	
	//validating valid altEVV ClientContactZip validation field formats/values with 5 digit with appending 0000
	@Test (priority=1)
	public void R2267_TC91263_AltEVV_ClientContactZip_valid_5Digit_append_0000() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_valid"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  havingClientContactZip "); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(5) +"0000");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject,jsonObject1);	
	}

	//validating valid altEVV ClientContactZip validation field formats/values with 5 digit with appending 4digit
	@Test (priority=2)
	public void R2267_TC91263_AltEVV_ClientContactZip_valid_5Digit_append_4digit() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_valid"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  havingClientContactZip "); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(5) + CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject,jsonObject1);	
		
	}

	//validating invalid altEVVClientContactZip _invalid_Leading_space
	@Test (priority=3)
	public void R2267_TC91263_AltEVV_ClientContactZip_invalid_Leading_space() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_invalid_Leading_space"); 
		logger.log(LogStatus.INFO, "validating invalid altEVVClientContactZip _invalid_Leading_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, " " +CommonMethods.generateRandomNumberOfFixLength(4));


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validatingClientContactZip _invalid_trailing_space
	@Test (priority=4)
	public void R2267_TC91263_AltEVV_ClientContactZip_invalid_trailing_space() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_invalid_trailing_space"); 
		logger.log(LogStatus.INFO, "validatingClientContactZip _invalid_trailing_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(4) + " ");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validating invalid altEVVClientContactZip _invalid_Mid_space
	@Test (priority=5)
	public void R2267_TC91263_AltEVV_ClientContactZip_invalid_Mid_space() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_invalid_Mid_space"); 
		logger.log(LogStatus.INFO, "validating invalid altEVVClientContactZip _invalid_Mid_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(2) + " " +CommonMethods.generateRandomNumberOfFixLength(3));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validating invalid altEVVClientContactZip _invalid_leading_trailing_space
	@Test (priority=6)
	public void R2267_TC91263_AltEVV_ClientContactZip_invalid_leading_trailing_space() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_invalid_leading_trailing_space"); 
		logger.log(LogStatus.INFO, "validating invalid altEVVClientContactZip _invalid_leading_trailing_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, " " + CommonMethods.generateRandomNumberOfFixLength(4) + " ");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validating invalid altEVV ClientContactZip invalid_SpecialChar
	@Test (priority=7)
	public void R2267_TC91263_AltEVV_ClientContactZip_invalid_SpecialChar() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_invalid_SpecialChar"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV ClientContactZip invalid_SpecialChar"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validating invalid altEVV clientClientContactZip _invalid_null_asvalue
	@Test (priority=7)
	public void R2267_TC91263_AltEVV_ClientContactZip_invalid_null_asvalue() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_invalid_null_asvalue"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV clientClientContactZip _invalid_null_asvalue"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, "null");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validating invalid altEVVClientContactZip _invalid_nulll
	@Test (priority=8)
	public void R2267_TC91263_AltEVV_ClientContactZip_invalid_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_invalid_null"); 
		logger.log(LogStatus.INFO, "validating invalid altEVVClientContactZip _invalid_nulll"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		DataBaseVerifier_Client.DataBaseVerification_InboxClientContact("LOC", jsonObject.get(globalVariables.ClientID).toString(),
				"F_NAME", jsonObject1.get(globalVariables.ClientContactFirstName).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.lastname_ClientContact, jsonObject1.get(globalVariables.ClientContactLastName).toString());
		
	}

	//validating invalid AltEVV_ClientContactZip_invalid_blank
	@Test (priority=9)
	public void R2267_TC91263_AltEVV_ClientContactZip_invalid_blank() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91263_AltEVV_ClientContactZip_invalid_blank"); 
		logger.log(LogStatus.INFO, "validating invalid AltEVV_ClientContactZip_invalid_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(0));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipLengthError_alt);

	}
}

