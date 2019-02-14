package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2223_TC94721_OpenEVV_Member_Validate_maximum_length_for_ClientStatus extends BaseTest{
	
	@Test
	public void R2223_TC94721_OpenEVV_Member_Validate_maximum_length_for_ClientStatus_morethanallowedlenghth() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94721_OpenEVV_Member_Validate_maximum_length_for_ClientStatus_morethanallowedlenghth"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("ClientStatus", CommonMethods.generateRandomNumberOfFixLength(3));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatuserror);
	}
	
	

}
