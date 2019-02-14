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

//OpenEVV Member: Validate maximum length for ClientSSN (MemberSSN)(9)

public class R2223_TC94481_OpenEVV_Member_ClientSSN_Length extends BaseTest {

	@Test
	public void R2223_TC94481_OpenEVV_Member_ClientSSN_Length_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94481_OpenEVV_Member_ClientSSN_Length_max"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}


	@Test
	public void R2223_TC94481_OpenEVV_Member_ClientSSN_Length_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94481_OpenEVV_Member_ClientSSN_Length_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(11));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSSNLengthError);;

	}

}