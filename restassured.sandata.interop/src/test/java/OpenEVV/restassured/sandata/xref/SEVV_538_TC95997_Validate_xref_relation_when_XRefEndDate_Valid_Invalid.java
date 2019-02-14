package OpenEVV.restassured.sandata.xref;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_538_TC95997_Validate_xref_relation_when_XRefEndDate_Valid_Invalid extends BaseTest {
	String val1, val3, val4,val2;

	//To validate the invalid Xref end date with invalid date (2018-07-23)
		@Test 
		public void TC95997_Validate_xref_relation_when_XRefEndDate_Invalid_2018_07_23() throws IOException, ParseException, ConfigurationException
		{
			logger = extent.startTest("TC95997_Validate_xref_relation_when_XRefEndDate_Invalid_2018_07_23");  // adding method name info via logger
			 
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("XRefStartDate",CommonMethods.generateTodayDate_MMddyyyy());
			js.put("XRefEndDate", "2018-07-23");
		

			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			//Using Assert to validate the expected result
			
		
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The XRefEndDate format is incorrect."));
		}

		//To validate the invalid Xref end date with invalid format ("07/23/2018")
		@Test 
		public void TC95997_Validate_xref_relation_when_XRefEndDate_Invalid_case2() throws IOException, ParseException, ConfigurationException
		{
			logger = extent.startTest("TC95997_Validate_xref_relation_when_XRefEndDate_Invalid_format_07/23/2018");  // adding method name info via logger
			 

			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("XRefStartDate",CommonMethods.generateTodayDate_MMddyyyy() );
			js.put("XRefEndDate", "07/23/2018");
		
			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The XRefEndDate format is incorrect."));
		}

		//To validate the invalid Xref end date with invalid format "07-23-2018" 
		@Test 
		public void TC95997_Validate_xref_relation_when_XRefEndDate_Invalid_format_case3() throws IOException, ParseException, ConfigurationException
		{
			logger = extent.startTest("TC95997_Validate_xref_relation_when_XRefEndDate_Invalid_format_07-23-2018");  // adding method name info via logger
			 

			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("XRefStartDate", CommonMethods.generateTodayDate_MMddyyyy());
			js.put("XRefEndDate", "07-23-2018");
			logger.log(LogStatus.INFO, "Passing XRefStartDate as Random and XRefEndDate as 07-23-2018  ");
			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The XRefEndDate format is incorrect."));
		}
		
		//To validate the valid end date
		@Test(groups = { "Databasetest"})
		public void TC95997_Validate_xref_relation_when_XRefEndDate_valid_in_inbox_and_stx_DB() throws IOException, ParseException, ConfigurationException, java.text.ParseException, SQLException
		{
			logger = extent.startTest("TC95997_Validate_xref_relation_when_XRefEndDate_valid_inbox_and_stx_DB"); // adding method name info via logger

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
		

			String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


			DataBaseVerifier_xref.DataBaseVerificationxref( val1, val3);
			DataBaseVerifier_xref.DataBaseVerificationxref_inbox( val1, val3);

			// Date date1 =new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse(sDate1); 2018-08-29 00:00:00.0

			// assert validation of start date in both schema to verify the outcome
			Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			logger.log(LogStatus.INFO, "Validating DB response ");

			Assert.assertEquals(DataBaseVerifier_xref.end_date, formatedDate);
			Assert.assertEquals(DataBaseVerifier_xref.end_date1, formatedDate);
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}

}
