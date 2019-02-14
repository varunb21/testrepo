package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class TC90590_Error_message_future_date_ClientBirthDate extends BaseTest{


	@Test
	public void TC90590_OpenEVV_Client_Error_message_future_date_ClientBirthDate() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC90590_OpenEVV_Client_Error_message_future_date_ClientBirthDate");

		//Calling method to get future date

		System.out.println("**************Started executing future clientBirthDate scenario*************");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		//////Creating values which are should be unique
		js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(5));
		js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
		js.put("ClientBirthDate", CommonMethods.generateFutureDate_YYYY_MM_dd());

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientBirthDate is incorrect. The record should be in the past" ));
		System.out.println("########### Negative scenario with future date in CLientBirthDate Completed successfully###########");

	}


}
