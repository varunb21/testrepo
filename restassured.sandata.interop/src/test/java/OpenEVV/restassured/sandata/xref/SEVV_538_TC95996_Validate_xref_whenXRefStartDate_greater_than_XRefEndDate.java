package OpenEVV.restassured.sandata.xref;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_538_TC95996_Validate_xref_whenXRefStartDate_greater_than_XRefEndDate extends BaseTest {
	
	//To validate the invalid Xref start date can not be greater than end date.
			@Test 
			public void TC95996_Validate_xref_whenXRefStartDate_greater_than_XRefEndDate() throws IOException, ParseException, ConfigurationException
			{
				logger = extent.startTest("TC95996_Validate_xref_whenXRefStartDate_greater_than_XRefEndDate");  // adding method name info via logger
				 
				//Using Reusable method to load client json
				JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

				//Making json values dynamic

				JSONObject js = (JSONObject) j.get(0);
				js.put("XRefStartDate","06122019");
				js.put("XRefEndDate", "12292018");

				String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

				//Using Assert to validate the expected result
				
				Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
				Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
				Assert.assertTrue(bodyAsString.contains("ERROR: The XRefStartDate cannot be greater than XRefEndDate."));
			}

			//To validate the invalid Xref start date can not be greater than end date in past date .
			@Test 
			public void TC95996_Validate_xref_whenXRefStartDate_greater_than_XRefEndDate_in_past_date() throws IOException, ParseException, ConfigurationException
			{
				logger = extent.startTest("TC95996_Validate_xref_whenXRefStartDate_greater_than_XRefEndDate_in_past_date");  // adding method name info via logger
				 
				//Using Reusable method to load client json
				JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

				//Making json values dynamic

				JSONObject js = (JSONObject) j.get(0);
				js.put("XRefStartDate","06122018");
				js.put("XRefEndDate", "04122018");

				String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

				//Using Assert to validate the expected result
				
				CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The XRefStartDate cannot be greater than XRefEndDate.");
				}
			
			//To validate the invalid Xref start date can not be greater than end date in past date .
			@Test 
			public void TC95996_Validate_xref_XRefEndDate_greater_than_startdate() throws IOException, ParseException, ConfigurationException
			{
				logger = extent.startTest("TC95996_Validate_xref_XRefEndDate_greater_than_startdate");  // adding method name info via logger
				 
				//Using Reusable method to load client json
				JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

				//Making json values dynamic

				JSONObject js = (JSONObject) j.get(0);
				js.put("XRefStartDate","06122018");
				js.put("XRefEndDate", "10122018");
				
				String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

				//Using Assert to validate the expected result
				
				Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
				Assert.assertTrue(bodyAsString.contains("Transaction Received."));
			}
			
}
