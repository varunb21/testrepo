package OpenEVV.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;
import java.sql.SQLException;

// Bug- 88401_Test Case 88862: OpenEVV: Validate ClientSuffix is storing in DB.

public class Bug_88401_TC88862_ClientSuffix_DB extends BaseTest{

	// case-1 Validate ClientSuffix is storing in DB
	public static String val, val1= "name_suffix";

	@Test
	public void Bug_88401_TC88862_OpenEVV_ClientSuffix_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{
		// adding method name info via logger
		logger = extent.startTest("Bug_88401_TC88862_OpenEVV_ClientSuffix_DB");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating the valid ClientSuffix value"); 

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSuffix", "Mr");
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		
		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	
	

	}
}