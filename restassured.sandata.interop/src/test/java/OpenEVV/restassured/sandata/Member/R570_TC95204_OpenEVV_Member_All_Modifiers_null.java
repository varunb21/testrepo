package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//OpenEVV Member: (Negative case)Verify that Modifier4 field is not accepting invalid values

public class R570_TC95204_OpenEVV_Member_All_Modifiers_null extends BaseTest {

	@Test
	public void R570_TC95204_OpenEVV_Member_All_Modifiers_null_validation() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R570_TC95204_OpenEVV_Member_All_Modifiers_null_validation"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientPayerProgramService");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier1", null);	
		jsonObjectProg.put("Modifier2", null);	
		jsonObjectProg.put("Modifier3", null);	
		jsonObjectProg.put("Modifier4", null);	
		jsonObjectProg.put("PayerService", CommonMethods.generateRandomNumberOfFixLength(5));
		jsonObjectProg.put("PayerProgram", CommonMethods.generateRandomNumberOfFixLength(9));


		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

	}

}