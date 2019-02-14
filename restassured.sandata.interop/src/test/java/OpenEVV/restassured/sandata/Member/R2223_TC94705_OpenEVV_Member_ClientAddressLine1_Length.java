/**
 * 
 */
package OpenEVV.restassured.sandata.Member;

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
import Utills_ExtentReport_Log4j.BaseTest;

// OpenEVV Member: Validate maximum length for ClientAddressLine1 (MemberAddressLine1)(30)

public class R2223_TC94705_OpenEVV_Member_ClientAddressLine1_Length extends BaseTest{

	//Case-1: Validate ClientAddressLine1 length MemberAddressLine1(30) and type String

	@Test(groups = { "Databasetest"})
	public void R2223_TC94705_OpenEVV_Member_ClientAddressLine1_MaxLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94705_OpenEVV_Member_ClientAddressLine1_MaxLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(6) +" " +CommonMethods.generateRandomStringOfFixLength(10) +" " +CommonMethods.generateRandomAlphaNumeric(12));	

		JSONObject jsonObjectProg_add = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg_add.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(6) +" " +CommonMethods.generateRandomStringOfFixLength(10) +" " +CommonMethods.generateRandomAlphaNumeric(12));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
		Assertion_DbVerifier.jsonAssert_InboxClientAddress_Member(bodyAsString, jsonObject, jsonObjectProg_add);
	}

	//Case-2: Validate ClientAddressLine1 Max length exceeds MemberAddressLine1(35)  and type String
	@Test 
	public void R2223_TC94705_OpenEVV_Member_ClientAddressLine1_MaxLengthExceeds() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94705_OpenEVV_Member_ClientAddressLine1_MaxLengthExceeds"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(6) +" " +CommonMethods.generateRandomStringOfFixLength(10) +" " +CommonMethods.generateRandomAlphaNumeric(20));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1LengthError);
	}

	//Case-3: Validate ClientAddressLine1 <30 length MemberAddressLine1 and type String		
	@Test
	public void R2223_TC94705_OpenEVV_Member_ClientAddressLine1_validLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94705_OpenEVV_Member_ClientAddressLine1_validLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(4) +" " +CommonMethods.generateRandomStringOfFixLength(7) +" " +CommonMethods.generateRandomAlphaNumeric(4));	

		JSONObject jsonObjectProg_add = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg_add.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(4) +" " +CommonMethods.generateRandomStringOfFixLength(7) +" " +CommonMethods.generateRandomAlphaNumeric(4));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientAddress_Member(bodyAsString, jsonObject, jsonObjectProg_add);
	}

}
