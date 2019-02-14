package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
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

public class Bug88763_TC89020_client_Contact_Type_Code extends BaseTest
{

	@Test
	public void Bug88763_TC89020_client_Contact_Type_Code_validation() throws IOException, ParseException, ConfigurationException, SQLException 
	{
		
		logger = extent.startTest("Bug88763_TC89020_client_Contact_Type_Code_validation"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

//		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);
//		
//		Assertion_DbVerifier.jsonAssert_STXClientContact(bodyAsString, jsonObject);
//		
		
	}

}
