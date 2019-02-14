package OpenEVV.restassured.sandata.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Client;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2223_TC95648_OpenEVV_Member_API_SameSSN_updated_with_Errorcode extends BaseTest {
	
	public static String SSN;

	@Test
	public void R2223_TC95648_OpenEVV_Member_API_SameSSN_updated_with_Errorcodes() throws FileNotFoundException, IOException, ParseException, SQLException 
	{
		logger = extent.startTest("R2223_TC95648_OpenEVV_Member_API_SameSSN_updated_with_Errorcodes"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ClientSSN,CommonMethods.generateRandomNumberOfFixLength(9));
		SSN= jsonObject.get("ClientSSN").toString();
		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assertion_DbVerifier.jsonAssert_InboxClient_Member(bodyAsString, jsonObject);	
	
		
		JSONArray jsonArrayRe = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);

		JSONObject jsonObjectRe = (JSONObject) jsonArrayRe.get(0);

		jsonObjectRe.put(globalVariables.ClientSSN, SSN);
		jsonObjectRe.put(globalVariables.ClientID, CommonMethods.generateRandomNumberOfFixLength(10));

		@SuppressWarnings("unused")
		String bodyAsStringRe = CommonMethods.captureResponseOpenEVV_Member(jsonArrayRe, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", jsonObjectRe.get(globalVariables.ClientID).toString(),
				"f_name", jsonObjectRe.get(globalVariables.ClientFirstName).toString());
	
		Assert.assertEquals(DataBaseVerifier_Client.ncode_inClient, "-1053");
	
	}

}
