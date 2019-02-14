package OpenEVV.restassured.sandata.xref;

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
import Utills_ExtentReport_Log4j.BaseTest;

public class TC90570_XrefEndDate_should_reflect_correctly_in_STX_and_Inbox_DB extends BaseTest{
	String val1, val3, val4,val2;


	//To validate the valid end date
	@Test(groups = { "Databasetest"})
	public void TC90570_Open_EVV_xref_Validate_enddate_in_inbox_and_stx_DB() throws IOException, ParseException, ConfigurationException, java.text.ParseException, SQLException
	{
		logger = extent.startTest("TC90570_Open_EVV_xref_Validate_enddate_in_inbox_and_stx_DB"); // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the valid Account number in between 4 to 10"); // adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);

		js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("XRefEndDate", CommonMethods.generateTodayDate_MMddyyyy());
		val2= js.get("XRefEndDate").toString();


		//js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(5));
		js.put("XRefStartDate", CommonMethods.generateTodayDate_MMddyyyy());
		val2= js.get("XRefStartDate").toString();


		val3= js.get("EmployeePIN").toString();
		val1= "stx_id";
		System.out.println(val2);

		String formatedDate =CommonMethods.dateToDateTimeFormat(val2);
		logger.log(LogStatus.INFO, "Passing Account as between 4 to 10 ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


		DataBaseVerifier_xref.DataBaseVerificationxref( val1, val3);
		DataBaseVerifier_xref.DataBaseVerificationxref_inbox( val1, val3);

		// Date date1 =new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse(sDate1); 2018-08-29 00:00:00.0

		// assert validation of start date in both schema to verify the outcome
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		logger.log(LogStatus.INFO, "Validating DB response ");

		Assert.assertEquals(DataBaseVerifier_xref.end_date, formatedDate);
		Assert.assertEquals(DataBaseVerifier_xref.end_date1, formatedDate);
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

}