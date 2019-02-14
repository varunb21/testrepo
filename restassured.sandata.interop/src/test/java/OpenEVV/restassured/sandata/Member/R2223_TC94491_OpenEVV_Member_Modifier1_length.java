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

//OpenEVV Member: Validate maximum length for Modifier1(2)

public class R2223_TC94491_OpenEVV_Member_Modifier1_length extends BaseTest {

	// Min length and Invalid Scenarios covered under R570

	@Test
	public void R2223_TC94491_OpenEVV_Member_Modifier1_length_max_numeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94491_OpenEVV_Member_Modifier1_length_max_numeric"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier1", CommonMethods.generateRandomNumberOfFixLength(2));
		jsonObjectProg.put("PayerService", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject, jsonObjectProg);

	}

	@Test
	public void R2223_TC94491_OpenEVV_Member_Modifier1_length_max_string() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94491_OpenEVV_Member_Modifier1_length_max_string"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier1", CommonMethods.generateRandomStringOfFixLength(2));
		jsonObjectProg.put("PayerService", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject, jsonObjectProg);

	}

}