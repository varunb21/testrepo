package OpenEVV.restassured.sandata.Client;

/**
 * @author RRohiteshwar
 *
 */

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

public class TC88272_Client_MinValueAllField extends BaseTest{

	//To validate the -Client-Load-Minimum Value with valid json
	@Test
	public void TC88272_OpenEVV_Client_Minvalue_allField_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC88272_OpenEVV_Client_Minvalue_allField_valid"); 

		JSONArray j=CommonMethods.LoadJSON_OpenEVV("Client_MinValue");
		JSONObject js = (JSONObject) j.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, js);	


	}
}

