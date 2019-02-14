package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 94712: OpenEVV Member: Validate maximum length for ClientPhone (MemberPhone)(10)

public class R2223_TC94712_OpenEVV_Member_ClientPhone_lengthValidations extends BaseTest{

	//Case-1: Validate  ClientPhone with max length(10)

	@Test(groups = { "Databasetest"})
	public void R2223_TC94712_OpenEVV_Member_ClientPhone_Max_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94712_OpenEVV_Member_ClientPhone_Max_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPhone");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(10));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));


	}

	//Case-2: Validate  ClientPhone with invalid length(7)

	@Test 
	public void R2223_TC94712_OpenEVV_Member_ClientPhone_invalid_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94712_OpenEVV_Member_ClientPhone_invalid_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPhone");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(7));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientPhone_format);



	}
	//Case-3: Validate  ClientPhone Exceed Max length(12)

	@Test 
	public void R2223_TC94712_OpenEVV_Member_ClientPhone_exceed_Max_length() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94712_OpenEVV_Member_ClientPhone_exceed_Max_length"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPhone");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(12));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientPhone_length);
	

	}
}
