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

//OpenEVV Member: (Negative case)Verify that Modifier2 field is not accepting invalid values

public class R570_TC95198_OpenEVV_Member_Modifier2_invalid extends BaseTest {

	@Test
	public void R570_TC95198_OpenEVV_Member_Modifier2_spclchar() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R570_TC95198_OpenEVV_Member_Modifier2_spclchar"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier2", CommonMethods.generateSpecialChar(2));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier2FormatError);

	}

	public void R570_TC95198_OpenEVV_Member_Modifier2_invalid_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R570_TC95198_OpenEVV_Member_Modifier2_invalid_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier2", CommonMethods.generateRandomNumberOfFixLength(3));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier2LengthError);

	}

	public void R570_TC95198_OpenEVV_Member_Modifier2_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R570_TC95198_OpenEVV_Member_Modifier2_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier2", "");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier2LengthError);

	}

	public void R570_TC95198_OpenEVV_Member_Modifier2_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R570_TC95198_OpenEVV_Member_Modifier2_null"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier2", null);	
		jsonObjectProg.put("PayerService", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_Authlimits(bodyAsString, jsonObject, jsonObjectProg);



	}

}