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

/**
 * @author MayankM
 *
 */
// Test Case 94703:OpenEVV Member: Validate maximum length for ClientContactZip (MemberContactZip)(9)

public class R2223_TC94703_OpenEVV_Member_ClientContactZip_Length extends BaseTest{

	
	@Test
	public void R2223_TC94703_OpenEVV_Member_ClientContactZip_MaxLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94703_OpenEVV_Member_ClientContactZip_MaxLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(9));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClientContact_Member(bodyAsString, jsonObject);
	}


	@Test
	public void R2223_TC94703_OpenEVV_Member_ClientContactZip_validLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94703_OpenEVV_Member_ClientContactZip_validLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(1));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError);
	}

		
	@Test
	public void R2223_TC94703_OpenEVV_Member_ClientContactZip_invalidLength() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94703_OpenEVV_Member_ClientContactZip_invalidLength"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(10));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipLengthError);
	}

}
