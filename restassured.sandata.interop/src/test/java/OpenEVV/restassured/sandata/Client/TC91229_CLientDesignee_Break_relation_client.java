/**
 * 
 */
package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */
public class TC91229_CLientDesignee_Break_relation_client extends BaseTest
{

	public static String val,StatusVerify= "DELETE",val1="user_f_name";
	public static String clientid = CommonMethods.generateRandomNumberOfFixLength(5);
	public static String clientfname = CommonMethods.generateRandomStringOfFixLength(10);
	public static String clientssn =CommonMethods.generateRandomNumberOfFixLength(9);

	//To validate the invalid ClientDesigneeEndDate today Date
	@Test(priority=1)
	public void TC91229_OpenEVV_Client_valid_json_without_CLientDesigneeDetails() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91229_OpenEVV_Client_valid_json_without_CLientDesigneeDetails");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js= (JSONObject) j.get(0);
		js.remove("ClientDesigneeFirstName");
		js.remove("ClientDesigneeLastName");
		js.remove("ClientDesigneeEmail");
		js.remove("ClientDesigneeStatus");
		js.remove("ClientDesigneeStartDate");
		js.remove("ClientDesigneeEndDate");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);

	}

	@Test(priority=1)
	public void TC91229_OpenEVV_Client_valid_json_with_CLientDesigneeDetails() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC91229_OpenEVV_Client_valid_json_with_CLientDesigneeDetails");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js= (JSONObject) j.get(0);
		js.put("ClientDesigneeFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientDesigneeLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientDesigneeEmail", CommonMethods.generateEmailAddress_string(10));
		js.put("ClientDesigneeStatus", "02");

		//		js.put("ClientDesigneeStartDate", CommonMethods.dateToDateTimeFormat(CommonMethods.generatePastDate_YYYY_MM_dd()));
		//		js.put("ClientDesigneeEndDate", CommonMethods.dateToDateTimeFormat(CommonMethods.generateTodayDate_YYYY_MM_dd()));
		//			
		js.put("ClientDesigneeStartDate",null);
		js.put("ClientDesigneeEndDate", null);
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);

		js= (JSONObject) j.get(0);
		js.put("Status", "D");
		js.put("ClientFirstName", clientfname );

		bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		DataBaseVerifier_Client.DataBaseVerification_InboxClient("LOC", js.get(globalVariables.ClientID).toString(),
				"f_name",js.get(globalVariables.ClientFirstName).toString());

		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.DeleteFlag_inClient,"1");
	
	}

}