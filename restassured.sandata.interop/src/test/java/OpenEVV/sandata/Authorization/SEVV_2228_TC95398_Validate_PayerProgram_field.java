package OpenEVV.sandata.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Client;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95398_Validate_PayerProgram_field extends BaseTest{
	
	@Test
	public void TC95398_Validate_PayerProgram_fielde_for_Invalid_values() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95398_Validate_PayerProgram_fielde_for_Invalid_values"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PayerProgram", null);
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.payerprogramerror_altevv);
		
	
	
	}
	
	@Test
	public void TC95398_Validate_PayerProgram_fielde_for_Invalid_with_specialcharacter() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95398_Validate_PayerProgram_fielde_for_Invalid_with_specialcharacter"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PayerProgram", CommonMethods.generateRandomStringOfFixLength(4)+'@');
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.payerprogramerror_altevv);
		
	
	
	}
	
	@Test
	public void TC95398_Validate_PayerProgram_fielde_for_Invalid_more_than_allowed_length() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95398_Validate_PayerProgram_fielde_for_Invalid_more_than_allowed_length"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PayerProgram", CommonMethods.generateRandomStringOfFixLength(10));
		
		
		String bodyAsString = CommonMethods.captureResponse3P(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.payerprogramerror_altevv);
		
	
	
	}

}
