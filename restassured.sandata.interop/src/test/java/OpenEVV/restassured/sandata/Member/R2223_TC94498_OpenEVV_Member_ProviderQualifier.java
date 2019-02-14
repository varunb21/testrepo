package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2223_TC94498_OpenEVV_Member_ProviderQualifier extends BaseTest {

	@Test
	public void R2223_TC94498_OpenEVV_Member_Validate_invalid_value_for_ProviderQualifier() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC94498_OpenEVV_Member_Validate_invalid_value_for_ProviderQualifier"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Providerqualifiererror);
	}

}

