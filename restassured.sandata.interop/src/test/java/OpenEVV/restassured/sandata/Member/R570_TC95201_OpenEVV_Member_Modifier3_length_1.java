package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//OpenEVV Member: Verify that Modifier3 field is accepting value with length 1

public class R570_TC95201_OpenEVV_Member_Modifier3_length_1 extends BaseTest {

	@Test
	public void R570_TC95201_OpenEVV_Member_Modifier3_length_1_numeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R570_TC95201_OpenEVV_Member_Modifier3_length_1_numeric"); 
		
		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		
		jsonObjectProg.put("Modifier3", CommonMethods.generateRandomNumberOfFixLength(1));
		jsonObjectProg.put("PayerService", CommonMethods.generateRandomNumberOfFixLength(5));
		
		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject, jsonObjectProg);

	}

	@Test
	public void R570_TC95201_OpenEVV_Member_Modifier3_length_1_letter() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R570_TC95201_OpenEVV_Member_Modifier3_length_1_letter"); 
		
		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		
		jsonObjectProg.put("Modifier3", CommonMethods.generateRandomStringOfFixLength(1));
		jsonObjectProg.put("PayerService", CommonMethods.generateRandomNumberOfFixLength(5));
		
		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject, jsonObjectProg);

	}

}