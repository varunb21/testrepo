/**
 * 
 */
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
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;
/**
 * @author Anupam
 * 
 *  *
 */
public class TC90249_OpenEVV_XRefStartDate_futuredate_cases extends BaseTest {

	// Case1: XRefStartDate> current date
	
	@Test(groups = {"Database"})
	public void TC90249_OpenEVV_XRefStartDate_with_futuredate() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC90249_OpenEVV_XRefStartDate_with_futuredate");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC90249_OpenEVV_XRefStartDate_with_futuredate"); // adding what you are verifying details

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsobject = (JSONObject) jsonarray.get(0);

		jsobject.put(globalVariables.XRefStartDate, CommonMethods.generateFutureDate_MM_DD_YYYY());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService_xref(bodyAsString, jsobject);
	}

	@Test(groups = {"Database"})
	public void TC90249_OpenEVV_XRefStartDate_with_todaydate() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC90249_OpenEVV_XRefStartDate_with_todaydate");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC90249_OpenEVV_XRefStartDate_with_todaydate"); // adding what you are verifying details

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsobject = (JSONObject) jsonarray.get(0);

		jsobject.put(globalVariables.XRefStartDate, CommonMethods.generateTodayDate_MMddyyyy());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService_xref(bodyAsString, jsobject);
	}
		
	@Test(groups = {"Database"})
	public void TC90249_OpenEVV_XRefStartDate_with_Pastdate() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC90249_OpenEVV_XRefStartDate_with_Pastdate");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC90249_OpenEVV_XRefStartDate_with_Pastdate"); // adding what you are verifying details

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsobject = (JSONObject) jsonarray.get(0);

		jsobject.put(globalVariables.XRefStartDate, CommonMethods.generatePastDate_MMddYYYY());
		jsobject.get("");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Assertion_DbVerifier.jsonAssert_XrefService_xref(bodyAsString, jsobject);
	}

}
