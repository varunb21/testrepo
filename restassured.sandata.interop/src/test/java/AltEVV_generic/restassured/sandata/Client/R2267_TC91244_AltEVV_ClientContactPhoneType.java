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

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

public class R2267_TC91244_AltEVV_ClientContactPhoneType extends BaseTest {


	// Validating valid altEVV  ClientContactphonetype having list Business"
	@Test (priority=0)
	public void R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Business_asValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Business_asValue"); 
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphonetype having list Business\""); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhoneType, "Business");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	


	}

	// Validating valid altEVV  ClientContactphonetype having list  Home"
	@Test (priority=0)
	public void R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Home_asValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Home_asValue"); 
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphonetype having list  Home"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhoneType,"Home");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	


	}

	// Validating valid altEVV  ClientContactphonetype having  Mobile"
	@Test (priority=0)
	public void R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Mobile_asValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Mobile_asValue"); 
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphonetype having  Mobile"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhoneType, "Mobile");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	


	}

	// Validating valid altEVV  ClientContactphonetype having  Other"
	@Test (priority=0)
	public void R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Other_asValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Other_asValue"); 
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphonetype having  Other"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhoneType, "Other");

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClientContact(bodyAsString, jsonObject, jsonObject1);	


	}

	// Validating invalid altEVV  ClientContactphonetype having other than assigned value"
	@Test (priority=0)
	public void R2267_TC91244_AltEVV_ClientContactPhoneType_inValid__otherThanassignedValue() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC91244_AltEVV_ClientContactPhoneType_inValid__otherThanassignedValue"); 
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphonetype having other than assigned value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhoneType, CommonMethods.generateRandomStringOfFixLength(12));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,globalVariables.ClientContactPhoneTypeFormatError);

	}

}