package OpenEVV.sandata.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95433_Verify_ClientDiagnosisCode_field_for_Invalid extends BaseTest{
	
	@Test
	public void TC95433_Verify_ClientDiagnosisCode_field_for_Invalid_value() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{

		logger = extent.startTest("TC95433_Verify_ClientDiagnosisCode_field_for_Invalid_value"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientDiagnosisCode", CommonMethods.generateRandomAlphaNumeric(4));
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientDiagnosisCodeformaterror);
}

	@Test
	public void TC95433_Verify_ClientDiagnosisCode_field_for_Invalid_value_morethan_allowed_length() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95433_Verify_ClientDiagnosisCode_field_for_Invalid_value_morethan_allowed_length"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		
		
        jsonObject.put("ClientDiagnosisCode", CommonMethods.generateRandomStringOfFixLength(11));
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientDiagnosisCodeformaterror);
		

}
	
	@Test
	public void TC95433_Verify_ClientDiagnosisCode_field_for_valid_null() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95433_Verify_ClientDiagnosisCode_field_for_valid_null"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientDiagnosisCode", null);
		
		
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		

}
	

}
