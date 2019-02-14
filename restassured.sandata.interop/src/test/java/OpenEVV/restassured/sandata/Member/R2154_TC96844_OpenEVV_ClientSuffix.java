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

//Open EVV Client- Validate the client Json for valid case of ClientSuffix (Refer the steps for scenario)

public class R2154_TC96844_OpenEVV_ClientSuffix extends BaseTest {

	@Test
	public void R2223_TC94486_OpenEVV_Member_ClientSuffix_Length_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94486_OpenEVV_Member_ClientSuffix_Length_max"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSuffix", CommonMethods.generateRandomStringOfFixLength(4));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);

	}

	@Test
	public void R2223_TC94486_OpenEVV_Member_ClientSuffix_Length_min() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94486_OpenEVV_Member_ClientSuffix_Length_min"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientSuffix", CommonMethods.generateRandomStringOfFixLength(1));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);



	}



}