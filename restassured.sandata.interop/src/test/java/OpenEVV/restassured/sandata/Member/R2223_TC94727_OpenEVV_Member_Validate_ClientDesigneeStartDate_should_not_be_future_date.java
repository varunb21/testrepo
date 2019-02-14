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

public class R2223_TC94727_OpenEVV_Member_Validate_ClientDesigneeStartDate_should_not_be_future_date extends BaseTest{
	
	@Test
	public void R2223_TC94727_OpenEVV_Member_Validate_maximum_length_for_ClientDesigneeStartDate_should_not_be_future_date() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94727_OpenEVV_Member_Validate__for_ClientDesigneeStartDate_should_not_be_future_date"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		//JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientEligibility");
		//JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObject.put("ClientDesigneeStartDate", "2019-04-24T16:02:26Z");
		jsonObject.put("ClientDesigneeStatus", null);
		
		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientDesigneeStartDate_futuredateerror);
	}

}
