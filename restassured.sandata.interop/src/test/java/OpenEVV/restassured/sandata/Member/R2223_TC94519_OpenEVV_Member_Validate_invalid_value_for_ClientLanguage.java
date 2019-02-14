package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2223_TC94519_OpenEVV_Member_Validate_invalid_value_for_ClientLanguage extends BaseTest{

	@Test
	public void R2223_TC94519_OpenEVV_Member_Validate_invalid_value_for_ClientLanguage_moretnamaxlength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94519_OpenEVV_Member_Validate_invalid_value_for_ClientLanguage_moretnamaxlength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientLanguage", CommonMethods.getSaltString(34));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientLanguageerror);
	}


}
