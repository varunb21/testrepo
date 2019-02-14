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
public class TC95799_Xref_EmployeeQual_EmployeCustomID_and_ClientQual_ClientcustomID extends BaseTest
{
	//To validate valid ClientAddressLine1_ClientAddressline2 accepts dash
	@SuppressWarnings("unused")
	@Test(priority=0)
	public void TC95799_Xref_EmployeeQual_EmployeCustomID_and_ClientQual_ClientcustomID_Valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{

		logger = extent.startTest("TC95799_Xref_EmployeeQual_EmployeCustomID_and_ClientQual_ClientcustomID_Valid"); 
	
		logger.log(LogStatus.INFO, "To validate valid TC95799_Xref_EmployeeQual_EmployeCustomID_and_ClientQual_ClientcustomID_Valid");
		
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", "EmployeeCustomID");
		jsonobject.put("ClientIDQualifier", "ClientCustomID");

				
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
		Assert.assertEquals(DataBaseVerifier_Client.workerIdQualifier_inboxXref,"WORKER_ID_CUSTOM1" );
		Assert.assertEquals(DataBaseVerifier_Client.clientIdQualifier_inboxXref,"CLIENT_ID_CUSTOM1" );


	}

}
	
