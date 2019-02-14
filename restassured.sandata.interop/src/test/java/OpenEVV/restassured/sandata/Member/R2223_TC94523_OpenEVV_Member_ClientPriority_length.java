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

//OpenEVV Member: Validate maximum length for ClientPriority(2)

public class R2223_TC94523_OpenEVV_Member_ClientPriority_length extends BaseTest {

	@Test
	public void R2223_TC94523_OpenEVV_Member_ClientPriority_max_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94523_OpenEVV_Member_ClientPriority_max_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientPriority", CommonMethods.generateRandomNumberOfFixLength(2));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}

	@Test
	public void R2223_TC94523_OpenEVV_Member_ClientPriority_min_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94523_OpenEVV_Member_ClientPriority_min_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientPriority", CommonMethods.generateRandomNumberOfFixLength(1));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}

	@Test
	public void R2223_TC94523_OpenEVV_Member_ClientPriority_invalid_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94523_OpenEVV_Member_ClientPriority_invalid_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientPriority", CommonMethods.generateRandomStringOfFixLength(3));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientPriorityLengthError);
	}

	public void R2223_TC94523_OpenEVV_Member_ClientPriority_blank() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94523_OpenEVV_Member_ClientPriority_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientPriority", "");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}

	public void R2223_TC94523_OpenEVV_Member_ClientPriority_null() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94523_OpenEVV_Member_ClientPriority_null"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientPriority", null);	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	}



}

