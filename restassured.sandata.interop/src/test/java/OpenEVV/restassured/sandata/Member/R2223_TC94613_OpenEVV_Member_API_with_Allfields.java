package OpenEVV.restassured.sandata.Member;

import java.io.FileNotFoundException;
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

public class R2223_TC94613_OpenEVV_Member_API_with_Allfields extends BaseTest {

	@Test(groups = { "Databasetest"})
	public void R2223_TC94613_OpenEVV_Member_Creation() throws FileNotFoundException, IOException, ParseException, SQLException 
	{
		logger = extent.startTest("R2223_TC94613_OpenEVV_Member_Creation"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put(globalVariables.ClientID, CommonMethods.generateRandomNumberOfFixLength(10));
		
		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
		
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);
				
	}
}
