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
import org.testng.annotations.Test;
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
public class TC88955_Xref_Validate_Emp_Client_Service extends BaseTest
{
	//To validate valid ClientAddressLine1_ClientAddressline2 accepts dash
	
	@Test
	public void TC88955_Xref_Validate_Emp_Client_Service_Valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{

		logger = extent.startTest("TC88955_Xref_Validate_Emp_Client_Service_Valid"); 
	
		logger.log(LogStatus.INFO, "To validate valid TC88955_Xref_Validate_Emp_Client_Service_Valid");
		
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
	
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		Assertion_DbVerifier.jsonAssert_XrefService(bodyAsString, jsonobject);
	

	}

}
	
