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

//validate ClientDesigneeFirstName filed format.

public class R2223_TC94908_OpenEVV_Member_ClientDesigneeFirstName_invalid extends BaseTest {
	
	@Test
	public void R2223_TC94910_Validate_invalid_value_for_ClientDesigneeFirstName() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94910_Validate_invalid_value_for_ClientDesigneeFirstName_withspecialcharacter"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	
		jsonObject.put("ClientDesigneeFirstName", "abcd@");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientdesigneeFirstNameerror);

	}
	
	@Test
	public void R2223_TC94910_Validate_invalid_value_for_ClientDesigneeFirstName1() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94910_Validate_invalid_value_for_ClientDesigneeFirstName_withalphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObject.put("ClientDesigneeFirstName", "abcd1234");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, 
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientdesigneeFirstNameerror);
		
		

	}

}
