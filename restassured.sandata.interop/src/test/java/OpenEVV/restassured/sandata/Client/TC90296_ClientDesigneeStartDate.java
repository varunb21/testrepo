package OpenEVV.restassured.sandata.Client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

public class TC90296_ClientDesigneeStartDate extends BaseTest{

	@Test
	public static void TC90296_ClientDesigneeStartDate_valid() throws FileNotFoundException, IOException, ParseException, SQLException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str=dateFormat.format(date);
		
		logger = extent.startTest("TC90296_ClientDesigneeStartDate_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientDesigneeStartDate", null);
		jsonObject.put("ClientDesigneeStartDate", str+"T00:47:57Z");
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);	
		
		

	}
	
	@Test
	public static void TC90296_ClientDesigneeStartDate_null() throws FileNotFoundException, IOException, ParseException, SQLException
	{
		
		logger = extent.startTest("TC90296_ClientDesigneeStartDate_null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		//jsonObject.put("ClientDesigneeStartDate", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonObject);	

	}
	

}