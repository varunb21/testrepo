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

//OpenEVV Member: Validate maximum length for PayerID(64)

public class R2223_TC94488_OpenEVV_Member_PayerID_Length extends BaseTest {

	@Test
	public void R2223_TC94488_OpenEVV_Member_PayerID_Length_max() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94488_OpenEVV_Member_PayerID_Length_max"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("PayerID", CommonMethods.generateRandomNumberOfFixLength(64));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertsuccess4value_inbox_authorizations(bodyAsString, globalVariables.dbClientID, jsonObject.get("ClientID").toString());
	}

	@Test
	public void R2223_TC94488_OpenEVV_Member_PayerID_Length_min() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94488_OpenEVV_Member_PayerID_Length_min"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("PayerID", CommonMethods.generateRandomStringOfFixLength(1));

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertsuccess4value_inbox_authorizations(bodyAsString, globalVariables.dbClientID, jsonObject.get("ClientID").toString());

	}

	@Test
	public void R2223_TC94488_OpenEVV_Member_PayerID_Length_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94488_OpenEVV_Member_PayerID_Length_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("PayerID", CommonMethods.generateRandomStringOfFixLength(65));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDLengthError);;

	}

}