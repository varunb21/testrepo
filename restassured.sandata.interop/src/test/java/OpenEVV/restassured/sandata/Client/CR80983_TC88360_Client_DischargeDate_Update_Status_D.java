package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 88630:Inter-Op-Open EVV- Client- Update the discharge date when status=D is sent

public class CR80983_TC88360_Client_DischargeDate_Update_Status_D extends BaseTest
{	

	@Test
	public void R80983_TC88360_OpenEVV_Client_DischargeDate() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R80983_TC88360_OpenEVV_Client_DischargeDate");

		JSONArray jsonArray= GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonobject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jsonobject);	

		//Sending request again with status D and discharge date
		jsonobject.put(globalVariables.jsonStatus, "D");
		jsonobject.put(globalVariables.dischargeDate, CommonMethods.generatePastDate_MMddYYYY());

		String bodyAsStringRe = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClients(bodyAsStringRe, jsonobject);	
		
		CommonMethods.AssertEqualsAndPrintValues(DataBaseVerifier_Client.DischargeDate_inClient, CommonMethods.dateToDateTimeFormat(jsonobject.get(globalVariables.dischargeDate).toString()));


	}

}