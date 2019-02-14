package AltEVV_molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91095_AltEVV_Client_SequenceID extends BaseTest {

	@Test 
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_blank() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_Blank"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence Blank"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The SequenceID value is incorrect. The length should be between 1 and 16.");
	
	}

	@Test 
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_null() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_null"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence id as null"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains( "ERROR: The SequenceID cannot be null."));


	}

	@Test 
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_NULL() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_NULL"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID NULL"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "NULL");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains( "ERROR: The SequenceID format is incorrect."));

	}

	@Test 
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_morethan_50Characters() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_morethan_50Characters"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID more than 50 characters"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(51));

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The SequenceID value is incorrect. The length should be between 1 and 16.");

	}

	@Test 
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_invalid_formate() throws IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_invalid_formate"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID as Invalid formate"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "-1234567890");

		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains( "ERROR: The SequenceID format is incorrect."));

	}

	@Test 
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		logger = extent.startTest("TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_valid"); 

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID as Valid one"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV("client_intake"); 

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "9089888833333333");


		String bodyAsString = CommonMethods.captureResponseAltEVV(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, js);	


	}
}


