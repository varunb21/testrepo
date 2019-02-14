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

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */
public class TC95797_Xref_EmployeeQual_Employessn_and_ClientQual_Clientssn extends BaseTest
{
	//To validate valid ClientAddressLine1_ClientAddressline2 accepts dash
	@SuppressWarnings("unused")
	@Test(priority=0)
	public void TC95797_Xref_EmployeeQual_Employessn_and_ClientQual_Clientssn_Valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{

		logger = extent.startTest("TC95797_Xref_EmployeeQual_Employessn_and_ClientQual_Clientssn_Valid"); 
	
		logger.log(LogStatus.INFO, "To validate valid TC95797_Xref_EmployeeQual_Employessn_and_ClientQual_Clientssn_Valid");
		
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", "EmployeeSSN");
		jsonobject.put("ClientIDQualifier", "ClientSSN");

				
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
		
		
		Assert.assertEquals(DataBaseVerifier_Client.workerIdQualifier_inboxXref,"WORKER_SSN" );
		Assert.assertEquals(DataBaseVerifier_Client.clientIdQualifier_inboxXref,"CLIENT_SSN" );


	}

}
	
