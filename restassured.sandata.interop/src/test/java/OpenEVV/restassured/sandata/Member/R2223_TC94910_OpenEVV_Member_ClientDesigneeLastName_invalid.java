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
//validation of ClientDesigneeLastName format.

public class R2223_TC94910_OpenEVV_Member_ClientDesigneeLastName_invalid extends BaseTest{
	
	@Test
	public void R2223_TC94910_Validate_invalid_value_for_ClientDesigneeLastName() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94910_Validate_invalid_value_for_ClientDesigneeLastName_withspecialcharacter"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	
		jsonObject.put("ClientDesigneeLastName", CommonMethods.generateSpecialChar(10));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientdesigneeLastNameerror);

	}
	
	@Test
	public void R2223_TC94910_Validate_invalid_value_for_ClientDesigneeLastName1() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94910_Validate_invalid_value_for_ClientDesigneeLastName_withalphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientDesigneeLastName", CommonMethods.generateRandomAlphaNumeric(5));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientdesigneeLastNameerror);

	}
	
}
