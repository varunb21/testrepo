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

public class R2223_TC94890_OpenEVV_Member_ClientContactPhoneType_invalid extends BaseTest {
	
		
		@Test
		public void TC94890_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhoneType_otherthan_allowed() throws IOException, ParseException, SQLException
		{
			logger = extent.startTest("TC94890_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhoneType_otherthan_allowed"); 

			JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
			//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

			jsonObject.put("ClientContactPhoneType", "TEST");	

			String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeFormatError_mem);

		}

		@Test
		public void TC94890_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhoneType_numeric() throws IOException, ParseException, SQLException
		{
			logger = extent.startTest("TC94890_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhoneType_numeric"); 

			JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
			//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

			jsonObject.put("ClientContactPhoneType", "12345");	

			String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeFormatError_mem);

		}
		
		@Test
		public void TC94890_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhoneType_withleading_space() throws IOException, ParseException, SQLException
		{
			logger = extent.startTest("TC94890_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhoneType_withleading_space"); 

			JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
			//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

			jsonObject.put("ClientContactPhoneType", " Other");	

			String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeFormatError_mem);

		}
		
		@Test
		public void TC94890_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhoneType_withtrealing_space() throws IOException, ParseException, SQLException
		{
			logger = extent.startTest("TC94890_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhoneType_withtrealing_space"); 

			JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
			//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

			jsonObject.put("ClientContactPhoneType", "Other ");	

			String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeFormatError_mem);

		}
		

		

	}

