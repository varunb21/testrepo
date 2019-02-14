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


 
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Client;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */
public class TC95801_Xref_ClientStatus_delete extends BaseTest
{
	//To validate valid ClientAddressLine1_ClientAddressline2 accepts dash
	@SuppressWarnings("unused")
	@Test(priority=0)
	public void TC95796_Xref_EmployeeQual_Employepin_and_ClientQual_ClientID_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{

		logger = extent.startTest("TC95796_Xref_EmployeeQual_Employepin_and_ClientQual_ClientID_valid"); 

		logger.log(LogStatus.INFO, "To validate valid TC95796_Xref_EmployeeQual_Employepin_and_ClientQual_ClientID_valid");

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("ClientStatus", "01");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
		Assert.assertEquals(DataBaseVerifier_Client.DeleteFlag_inboxXref, "0" );

		jsonobject.put("ClientStatus", "04");

		bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
		
		Assert.assertEquals(DataBaseVerifier_Client.DeleteFlag_inboxXref, "1");

	}

}

