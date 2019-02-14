package AltEVV_generic.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91221_AltEVV_ClientZip extends BaseTest {

	String clntid,clintid_db="LOC";

	//validating valid altEVV ClientZip validation field formats/values with 5 digit
	@Test (priority=0)
	public void R2267_TC91221_AltEVV_ClientZip_valid_5Digit() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_valid_5Digit"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientZip"); 
		String clientzip=CommonMethods.generateRandomNumberOfFixLength(9);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, clientzip);

		JSONObject jsonObject1_add = (JSONObject) jsonArray1.get(1);
		jsonObject1_add.put(globalVariables.ClientZip, clientzip);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObject1_add);
	}

	//validating valid altEVV ClientZip validation field formats/values with 5 digit with appending 0000
	@Test (priority=1)
	public void R2267_TC91221_AltEVV_ClientZip_valid_5Digit_append_0000() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_valid"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientZip"); 
		String clientzip=CommonMethods.generateRandomNumberOfFixLength(5) +"0000";

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, clientzip);

		JSONObject jsonObject1_add = (JSONObject) jsonArray1.get(1);
		jsonObject1_add.put(globalVariables.ClientZip, clientzip);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObject1_add);
	}

	//validating valid altEVV ClientZip validation field formats/values with 5 digit with appending 4digit
	@Test (priority=2)
	public void R2267_TC91221_AltEVV_ClientZip_valid_5Digit_append_4digit() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_valid"); 
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientZip"); 
		String clientzip=CommonMethods.generateRandomNumberOfFixLength(5) + CommonMethods.generateRandomNumberOfFixLength(4);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, clientzip);

		JSONObject jsonObject1_add = (JSONObject) jsonArray1.get(1);
		jsonObject1_add.put(globalVariables.ClientZip, clientzip);
		
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress(bodyAsString, jsonObject, jsonObject1_add);
	}

	//validating invalid altEVV ClientZip_invalid_Leading_space
	@Test (priority=3)
	public void R2267_TC91221_AltEVV_ClientZip_invalid_Leading_space() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_invalid_Leading_space"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV ClientZip_invalid_Leading_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, " " +CommonMethods.generateRandomNumberOfFixLength(4));


		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipFormatError);

	}

	//validating ClientZip_invalid_trailing_space
	@Test (priority=4)
	public void R2267_TC91221_AltEVV_ClientZip_invalid_trailing_space() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_invalid_trailing_space"); 
		logger.log(LogStatus.INFO, "validating ClientZip_invalid_trailing_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, CommonMethods.generateRandomNumberOfFixLength(4) + " ");

		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipFormatError);

	}

	//validating invalid altEVV ClientZip_invalid_Mid_space
	@Test (priority=5)
	public void R2267_TC91221_AltEVV_ClientZip_invalid_Mid_space() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_invalid_Mid_space"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV ClientZip_invalid_Mid_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, CommonMethods.generateRandomNumberOfFixLength(2) + " " +CommonMethods.generateRandomNumberOfFixLength(3));

		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipFormatError);

	}

	//validating invalid altEVV ClientZip_invalid_leading_trailing_space
	@Test (priority=6)
	public void R2267_TC91221_AltEVV_ClientZip_invalid_leading_trailing_space() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_invalid_leading_trailing_space"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV ClientZip_invalid_leading_trailing_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, " " + CommonMethods.generateRandomNumberOfFixLength(4) + " ");

		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipFormatError);

	}

	//validating invalid altEVV clientzip invalid_SpecialChar
	@Test (priority=7)
	public void R2267_TC91221_AltEVV_ClientZip_invalid_SpecialChar() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_invalid_SpecialChar"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV clientzip invalid_SpecialChar"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, CommonMethods.generateSpecialChar(5));

		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipFormatError);

	}

	//validating invalid altEVV client ClientZip_invalid_null_asvalue
	@Test (priority=7)
	public void R2267_TC91221_AltEVV_ClientZip_invalid_null_asvalue() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_invalid_null_asvalue"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV client ClientZip_invalid_null_asvalue"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, "null");

		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipFormatError);

	}

	//validating invalid altEVV ClientZip_invalid_nulll
	@Test (priority=8)
	public void R2267_TC91221_AltEVV_ClientZip_invalid_null() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_invalid_null"); 
		logger.log(LogStatus.INFO, "validating invalid altEVV ClientZip_invalid_nulll"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, null);

		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipNullError);

	}

	//validating invalid AltEVV_ClientZip_invalid_blank
	@Test (priority=9)
	public void R2267_TC91221_AltEVV_ClientZip_invalid_blank() throws IOException, ParseException
	{
		logger = extent.startTest("R2267_TC91221_AltEVV_ClientZip_invalid_blank"); 
		logger.log(LogStatus.INFO, "validating invalid AltEVV_ClientZip_invalid_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientZip, CommonMethods.generateRandomNumberOfFixLength(0));

		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientZip format is incorrect. The record should satisfy this regular expression");

	}
}