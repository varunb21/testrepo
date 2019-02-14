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

//OpenEVV Member: Validate maximum length for ClientMedicalRecordNumber(12)

public class R2223_TC94482_OpenEVV_Member_MemberMedicalRecordNum_MaxLength extends BaseTest {

	@Test
	public void R2223_TC94482_OpenEVV_Member_MemberMedicalRecordNum_MaxLength_valid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94482_OpenEVV_Member_MemberMedicalRecordNum_MaxLength_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ClientMedicalRecordNumber, CommonMethods.generateRandomStringOfFixLength(12));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member
																		(jsonArray, 
																		CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	
	}

	@Test
	public void R2223_TC94482_OpenEVV_Member_MemberMedicalRecordNum_MaxLength_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94482_OpenEVV_Member_MemberMedicalRecordNum_MaxLength_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ClientMedicalRecordNumber, CommonMethods.generateRandomStringOfFixLength(13));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member
																		(jsonArray, 
																		CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMedicalRecordNumberLengthError);
	}
}