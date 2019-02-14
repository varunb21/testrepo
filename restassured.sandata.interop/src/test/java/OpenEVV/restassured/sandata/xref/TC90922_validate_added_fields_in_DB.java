package OpenEVV.restassured.sandata.xref;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import com.globalMethods.core.*;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

public class TC90922_validate_added_fields_in_DB extends BaseTest{

	String val1, val3, val4,val2;


	//To validate the valid Account number in between 4 to 10
	@Test(groups = { "Databasetest"})
	public void TC90922_Open_EVV_Xref_Validate_the_new_Added_Fields_in_Inbox_Schema() throws IOException, ParseException, ConfigurationException, SQLException

	{
		logger = extent.startTest("TC90922_Open_EVV_Xref_Validate_the_new_Added_Fields_in_Inbox_Schema");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the valid Account number in between 4 to 10"); // adding what you are verifing




		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("XRefEndDate", CommonMethods.generateTodayDate_MMddyyyy());
		val2= js.get("XRefEndDate").toString();
		val3= js.get("EmployeePIN").toString();
		val1= "stx_id";

		logger.log(LogStatus.INFO, "Passing valid acc no between 4 to 10 ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		DataBaseVerifier_xref.DataBaseVerificationxref_inbox( val1, val3);

		//assigning db value to local variables.

		String workeridqlf =DataBaseVerifier_xref.workeridqlf;
		String clientidqlf =DataBaseVerifier_xref.clientidqlf;
		String clientid =DataBaseVerifier_xref.clientid;
		String workerid =DataBaseVerifier_xref.workerid;


		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);

		logger.log(LogStatus.INFO, "Validating Json response ");


		// assert validation of start date in both schema to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		logger.log(LogStatus.INFO, "Validating DB response ");
		Assert.assertEquals(DataBaseVerifier_xref.workeridqlf,workeridqlf );
		Assert.assertEquals(DataBaseVerifier_xref.clientidqlf,clientidqlf );
		Assert.assertEquals(DataBaseVerifier_xref.clientid,clientid );
		Assert.assertEquals(DataBaseVerifier_xref.workerid,workerid );

	}

}
