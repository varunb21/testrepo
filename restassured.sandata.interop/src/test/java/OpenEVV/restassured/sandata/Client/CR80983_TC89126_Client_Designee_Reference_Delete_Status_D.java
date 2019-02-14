package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;

/**
 * @author MayankM
 *
 */

//Test Case 88630:Inter-Op-Open EVV- Client- Update the discharge date when status=D is sent

public class CR80983_TC89126_Client_Designee_Reference_Delete_Status_D extends BaseTest
{


	String clientssn=CommonMethods.generateRandomNumberOfFixLength(9);;
	String disDate = CommonMethods.generatePastDate_MMddYYYY();
	String clientfname = CommonMethods.generateRandomStringOfFixLength(5);



	//To validate the updation of Discharge date when status D is sent
	@Test(priority=1)
	public void CR80983_TC89126_OpenEVV_Client_DischargeDate() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("R80983_TC88360_OpenEVV_Client_DischargeDate"); 
		clientssn = CommonMethods.generateRandomNumberOfFixLength(9);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject jsonobject = (JSONObject) jsonArray.get(0);

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonobject);	

		clientssn = CommonMethods.generateRandomNumberOfFixLength(9);
		// Send request again with status= D, dischargeDate = valid value
		
		 jsonArray= GenerateUniqueParam.ClientParams_OpenEVV("client");
		 jsonobject = (JSONObject) jsonArray.get(0);

		jsonobject.put(globalVariables.jsonStatus, "D");
		jsonobject.put(globalVariables.ClientSSN, clientssn);
		jsonobject.put(globalVariables.dischargeDate, disDate);

		 bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClients(bodyAsString, jsonobject);

	}
}