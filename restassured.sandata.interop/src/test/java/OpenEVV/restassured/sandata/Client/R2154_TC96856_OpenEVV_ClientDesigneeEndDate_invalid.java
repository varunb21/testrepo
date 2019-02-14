package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

//Test Case 96854:Open EVV Client- Validate the client Json for invalid case of ClientDesigneeStartDate (Refer the steps for scenario)

	public class R2154_TC96856_OpenEVV_ClientDesigneeEndDate_invalid extends BaseTest {
	//Case1: ClientDesigneeStartDate= mm-dd-yyyy  ex :-- 10-29-2018
	@Test
	public void TC96854_OpenEVV_ClientDesigneeStartDate_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96854_OpenEVV_ClientDesigneeStartDate_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientDesigneeStartDate", 10-29-2018);	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientDesigneeStartDateformaterror);

	}
	//Case2: ClientDesigneeStartDate= dd-mm-yyyy  ex :-- 10-05-2018
	@Test
	public void R2154_TC96854_OpenEVV_ClientDesigneeStartDate_ddmmyyyy_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96854_OpenEVV_ClientDesigneeStartDate_ddmmyyyy_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientDesigneeStartDate", 10-05-2018);	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientDesigneeStartDateformaterror);

	}
	//Case3:ClientDesigneeStartDate= dd-yyyy-mm  ex :-- 05-2018-10
	@Test
	public void R2154_TC96854_OpenEVV_ClientDesigneeStartDate_ddyyyymm_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96854_OpenEVV_ClientDesigneeStartDate_ddyyyymm_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientDesigneeStartDate", 05-2018-10);	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientDesigneeStartDateformaterror);

	}
	
}