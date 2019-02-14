package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;

//Test Case 91081:INer-op - Open EVV - Client - Validate ClientDesigneeEndDate field for BackDate/Future Value

public class TC91081_ClientDesigneeEndDate_back_future_date extends BaseTest{

	//To validate the invalid ClientDesigneeEndDate today Date
	@Test 
	public void TC91081_OpenEVV_ClientDesigneeEndDate_today_date_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC91081_OpenEVV_ClientDesigneeEndDate_today_date_valid");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		JSONObject jsonobject = (JSONObject) jsonArray.get(0);
		

		jsonobject.put("ClientDesigneeStartDate", CommonMethods.generatePastDate_YYYY_MM_dd()+ "T16:47:57Z");
		jsonobject.put("ClientDesigneeEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T10:47:57Z");

		jsonobject.put("ClientDesigneeFirstName", CommonMethods.generateRandomStringOfFixLength(8));
		jsonobject.put("ClientDesigneeLastName",  CommonMethods.generateRandomStringOfFixLength(8));
		jsonobject.put("ClientDesigneeEmail", CommonMethods.generateEmailAddress_string(8));

		jsonobject.put("ClientDesigneeStatus", null);
		

		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains( "\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid ClientDesigneeEndDate Past Date
	@Test  
	public void TC91081_OpenEVV_ClientDesigneeEndDate_back_date_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC91081_OpenEVV_ClientDesigneeEndDate_back_date_invalid");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		JSONObject jsonobject = (JSONObject) jsonArray.get(0);
		
		jsonobject.put("ClientDesigneeFirstName", CommonMethods.generateRandomStringOfFixLength(8));
		jsonobject.put("ClientDesigneeLastName",  CommonMethods.generateRandomStringOfFixLength(8));
		jsonobject.put("ClientDesigneeEmail", CommonMethods.generateEmailAddress_string(8));
		jsonobject.put("ClientDesigneeStatus", null);
		jsonobject.put("ClientDesigneeStartDate", CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T00:47:57Z");	
		jsonobject.put("ClientDesigneeEndDate", CommonMethods.generatePastDate_YYYY_MM_dd()+ "T00:57:57Z");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientDesigneeStartDate must always be less than the ClientDesigneeEndDate."));
	
	}

	//To validate the invalid ClientDesigneeEndDate Future Date
	@Test(groups = { "Databasetest"})
	public void TC91081_OpenEVV_ClientDesigneeEndDate_Future_date_invalid() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC91081_OpenEVV_ClientDesigneeEndDate_Future_date_invalid");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeFirstName", CommonMethods.generateRandomStringOfFixLength(8));
		js.put("ClientDesigneeLastName",  CommonMethods.generateRandomStringOfFixLength(8));
		js.put("ClientDesigneeEmail", CommonMethods.generateEmailAddress_string(8));
		js.put("ClientDesigneeStatus", null);
		js.put("ClientDesigneeStartDate", CommonMethods.generatePastDate_YYYY_MM_dd()+ "T16:47:57Z");	
		js.put("ClientDesigneeEndDate", CommonMethods.generateFutureDate_YYYY_MM_dd()+ "T06:47:57Z");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		//Using Assert to validate the expected result

		Assert.assertTrue(bodyAsString.contains("The ClientDesigneeEndDate must be today."));
		System.out.println("########### Negative scenario of ClientDesigneeendDate Completed successfully###########");


	}

}