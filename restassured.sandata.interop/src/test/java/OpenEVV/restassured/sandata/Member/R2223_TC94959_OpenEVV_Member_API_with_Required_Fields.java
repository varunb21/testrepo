package OpenEVV.restassured.sandata.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2223_TC94959_OpenEVV_Member_API_with_Required_Fields extends BaseTest {

	@Test(groups = { "Databasetest"})
	public void R2223_TC94959_OpenEVV_Member_API_CreateMember_with_Required_Fields() throws FileNotFoundException, IOException, ParseException, SQLException 
	{
		logger = extent.startTest("R2223_TC94959_OpenEVV_Member_API_CreateMember_with_Required_Fields"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		JSONArray jsonArrayProg1 = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg1 = (JSONObject) jsonArrayProg1.get(0);

		JSONArray jsonArrayProg2 = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg2 = (JSONObject) jsonArrayProg2.get(0);

		JSONObject jsonObjectProg3 = (JSONObject) jsonObject.get("ProviderIdentification");
		
		JSONArray jsonArrayProg4 = (JSONArray) jsonObject.get("ClientPhone");
		JSONObject jsonObjectProg4 = (JSONObject) jsonArrayProg4.get(0);

		jsonObjectProg1.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomStringOfFixLength(10));
		jsonObjectProg1.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(5));
		jsonObjectProg3.put(globalVariables.ProviderID, CommonMethods.generateRandomStringOfFixLength(10));	

		jsonObject.put(globalVariables.ClientID, CommonMethods.generateRandomNumberOfFixLength(10));

		jsonObject.put(globalVariables.ClientFirstName, CommonMethods.generateRandomStringOfFixLength(30));
		jsonObject.put(globalVariables.ClientLastName, CommonMethods.generateRandomStringOfFixLength(30));

		jsonObject.put(globalVariables.Action, "A");
		jsonObjectProg2.put(globalVariables.PayerID, CommonMethods.generateRandomStringOfFixLength(20));
		jsonObject.put(globalVariables.ClientTimeZone, "US/Eastern");
		jsonObject.put(globalVariables.ClientAddressType, DataGeneratorClient.clientAddressType());
		jsonObjectProg1.put(globalVariables.ClientState, DataGeneratorClient.generateClientState());
		jsonObjectProg1.put(globalVariables.ClientZip, CommonMethods.generateRandomNumberOfFixLength(5));
		jsonObjectProg4.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObjectProg.put(globalVariables.ClientStatus, DataGeneratorClient.clientStatus());
		jsonObjectProg.put(globalVariables.PayerID, jsonObjectProg2.get(globalVariables.PayerID));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	

	}
}
