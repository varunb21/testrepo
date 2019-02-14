/**
 * 
 */
package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


 
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier_Client;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
import junit.framework.Assert;

/**
 * @author Neeraj
 *
 */
public class TS89206_TC90995_ClientID_ClientIdQualifier_EmployeeID_EmployeeQualifier_DB extends BaseTest
{
	
	@Test(priority=0)
	public void TS89206_TC90995_ClientID_ClientIdQualifier_EmployeeID_EmployeeQualifier_Db() throws IOException, ParseException, ConfigurationException, SQLException
	{
		
		logger = extent.startTest("TS89206_TC90995_ClientID_ClientIdQualifier_EmployeeID_EmployeeQualifier_Db"); 

		logger.log(LogStatus.INFO, "To validate valid TS89206_TC90995_ClientID_ClientIdQualifier_EmployeeID_EmployeeQualifier_Db");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));
		CommonMethods.verifyjsonassertsuccess4value_inbox_authorizations
		( bodyAsString, 
				globalVariables.dbclientid, js.get(globalVariables.ClientID).toString());
		
		Assert.assertEquals(DataBaseVerifier_Client.client_id_auth, null);
		Assert.assertEquals(DataBaseVerifier_Client.client_id_QLFR_auth, null);
		Assert.assertEquals(DataBaseVerifier_Client.worker_id_auth, null);
		Assert.assertEquals(DataBaseVerifier_Client.worker_id_qlfr_auth, null);

	}
}

	