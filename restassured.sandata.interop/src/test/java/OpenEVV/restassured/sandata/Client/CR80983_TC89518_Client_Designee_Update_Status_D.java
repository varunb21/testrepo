package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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

public class CR80983_TC89518_Client_Designee_Update_Status_D extends BaseTest
{		

	String val = "client_ssn", val1 = "username",val2 = "E_MAIL";
	String clientdesigneeEmail = CommonMethods.generateEmailAddress_string(5);
	String clientEmail = CommonMethods.generateEmailAddress_string(5);
	String clientssn;
	Date todaydate = new Date();

	//To validate the updation of Client Designee when status D is sent
	@Test
	public void R80983_TC89518_OpenEVV_Client_Designee_Update() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("R80983_TC89518_OpenEVV_Client_Designee_Update"); 

		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		JSONArray jsonArray= GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jSONObject = (JSONObject) jsonArray.get(0);

		jSONObject.put(globalVariables.clientDesigneeEmail, clientdesigneeEmail);
		clientssn = jSONObject.get(globalVariables.ClientSSN).toString();
		jSONObject.put(globalVariables.clientEmailAddress,clientEmail);


		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient(bodyAsString, jSONObject);	

	}

	@Test(priority=2)
	public void R80983_TC89518_OpenEVV_Client_Designee_Update_DB() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("R80983_TC89518_OpenEVV_Client_Designee_Update_DB"); 

		// Send request again with status= D, dischargeDate = valid value
		JSONArray jsonArray= GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonobject = (JSONObject) jsonArray.get(0);
		jsonobject.put(globalVariables.jsonStatus, "D");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertsuccess4value_STXAPPUSER(bodyAsString, 
				globalVariables.ClientlasTName_stxuser, jsonobject.get(globalVariables.ClientLastName).toString(), 
				globalVariables.ClientFirstName_stxuser, jsonobject.get(globalVariables.ClientFirstName).toString());


	}
}