package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 94526: OpenEVV Member: Validate maximum length for ClientContactFirstName (MemberContactFirstName)(30)

    public class R2223_TC94526_OpenEVV_Member_ClientContactFirstName_Length extends BaseTest {
    
    //Case1: Validate maximum length for ClientContactFirstName (MemberContactFirstName)(30)
	@Test
	public void R2223_TC94526_OpenEVV_Member_ClientContactFirstName_MaxLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94526_OpenEVV_Member_ClientContactFirstName_MaxLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactFirstName", CommonMethods.getSaltString(14));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientContact_Member(bodyAsString, jsonObject);	
		
	}
	
	//Case2: Validate Min length for ClientContactFirstName (MemberContactFirstName)(1)
	@Test
	public void R2223_TC94526_OpenEVV_Member_ClientContactFirstName_MinLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94526_OpenEVV_Member_ClientContactFirstName_MinLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactFirstName", CommonMethods.generateRandomStringOfFixLength(1));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
		
	Assertion_DbVerifier.jsonAssert_InboxClientContact_Member(bodyAsString, jsonObject);	
	}
	
	//Case3: Validate maximum length exceeds for ClientContactFirstName (MemberContactFirstName)(31)
	
	@Test
	public void R2223_TC94526_OpenEVV_Member_ClientContactFirstName_Length_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94526_OpenEVV_Member_ClientContactFirstName_Length_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactFirstName", CommonMethods.generateRandomStringOfFixLength(31));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactFirstName_error);;

	}
	

}