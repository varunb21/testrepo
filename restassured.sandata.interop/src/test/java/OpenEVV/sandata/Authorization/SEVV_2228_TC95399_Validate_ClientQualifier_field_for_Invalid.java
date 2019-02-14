package OpenEVV.sandata.Authorization;

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

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95399_Validate_ClientQualifier_field_for_Invalid extends BaseTest{
	
	@Test
	public void TC95399_Validate_ClientQualifier_field_for_Invalid_null() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95399_Validate_ClientQualifier_field_for_Invalid_null"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", null);
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierNullError);
		
	
	
	}
	
	@Test
	public void TC95399_Validate_ClientQualifier_field_for_Invalid_other_than_valid() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95399_Validate_ClientQualifier_field_for_Invalid_other_than_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", CommonMethods.generateRandomStringOfFixLength(9));
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierFormatError);
		
	
	
	}
	
	@Test
	public void TC95399_Validate_ClientQualifier_field_for_Invalid_blank() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95399_Validate_ClientQualifier_field_for_Invalid_blank"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", "");
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierFormatError);
		
	
	
	}
	
	@Test
	public void TC95399_Validate_ClientQualifier_field_for_Invalid_more_than_allowed_length() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("TC95399_Validate_ClientQualifier_field_for_Invalid_more_than_allowed_length"); 

		JSONArray jsonArray=GenerateUniqueParam.molina_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", CommonMethods.generateRandomStringOfFixLength(21));
		
		
		String bodyAsString = CommonMethods.captureResponsePostAuthrization(jsonArray, CommonMethods.propertyfileReader("molina_auth"));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierFormatError);
		
	
	
	}
	

}
