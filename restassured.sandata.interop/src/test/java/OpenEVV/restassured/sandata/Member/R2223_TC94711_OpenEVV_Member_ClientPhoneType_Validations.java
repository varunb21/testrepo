package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 94711:OpenEVV Member: Validate ClientPhoneType for Multiple Values

public class R2223_TC94711_OpenEVV_Member_ClientPhoneType_Validations extends BaseTest{

	//Case-1: Validate  ClientPhoneType for Multiple Values(Home)

	@Test(groups = { "Databasetest"})
	public void R2223_TC94711_OpenEVV_Member_ClientPhoneType() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94711_OpenEVV_Member_ClientPhoneType"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPhone");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientPhoneType, DataGeneratorClient.clientPhoneType());	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

	}

	//Case-2: Validate  ClientPhoneType for Multiple Values(Invalid)
	@Test 
	public void R2223_TC94711_OpenEVV_Member_ClientPhoneType_Invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2223_TC94711_OpenEVV_Member_ClientPhoneType_Invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPhone");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientPhoneType, CommonMethods.generateRandomStringOfFixLength(5));	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientPhoneType_Error);

	}

}
