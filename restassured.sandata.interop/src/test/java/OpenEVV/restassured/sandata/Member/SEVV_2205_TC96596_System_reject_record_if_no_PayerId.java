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

/**
 * @author rranjan
 *
 */

public class SEVV_2205_TC96596_System_reject_record_if_no_PayerId extends BaseTest{
	
	@Test
	public void SEVV_2205_TC96596_System_reject_record_if_no_PayerId_pass_in_API() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("SEVV_2205_TC96596_System_reject_record_if_no_PayerId_pass_in_API"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("PayerID", null);	
		

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Payeridnullerror);


}
}
