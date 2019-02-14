/**
 * 
 */
package Production;

import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;


/**
 * @author Anupam
 *
 */

// Test Case 96894:Inter-Op OpenEVV: ClientDesignee user record should be updated if another request with same email is sent

public class Bug4817_TC96894_OpenEVV_ClientDesignee_another_request_same_email extends BaseTest{

	// Case1: Creating ClientDesignee user with unique First name and Last name	
	@Test
	public void TC96894_OpenEVV_ClientDesignee_creation() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC96894_OpenEVV_ClientDesignee_creation"); 

		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		JSONArray jsonArray= GenerateUniqueParam.ClientParams_OpenEVV("client");
		
		JSONObject jSONObject = (JSONObject) jsonArray.get(0);

		jSONObject.put("ClientDesigneeEmail", "prodclienttest@test.com");
		jSONObject.put("ClientDesigneeFirstName", CommonMethods.generateRandomStringOfFixLength(7));
		jSONObject.put("ClientDesigneeLastName", CommonMethods.generateRandomStringOfFixLength(7));

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		Assertion_DbVerifier.jsonAssert_Inbox_STX_AppUser(bodyAsString, jSONObject);	

	}
	
	// Case2: Creating ClientDesignee user with same email and having unique First name and Last name	
		@Test
		public void TC96894_OpenEVV_ClientDesignee_anotherrequest_with_sameemail() throws IOException, ParseException, ConfigurationException, SQLException
		{
			logger = extent.startTest("TC96894_OpenEVV_ClientDesignee_another_request_with_sameemail"); 

			//use method (json_parser) to load the json file
			// To make the values in JSON dynamic
			JSONArray jsonArray= GenerateUniqueParam.ClientParams_OpenEVV("client");
			
			JSONObject jSONObject = (JSONObject) jsonArray.get(0);

			jSONObject.put("ClientDesigneeEmail", "prodclienttest@test.com");
			jSONObject.put("ClientDesigneeFirstName", CommonMethods.generateRandomStringOfFixLength(7));
			jSONObject.put("ClientDesigneeLastName", CommonMethods.generateRandomStringOfFixLength(7));

			// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
			String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

			Assertion_DbVerifier.jsonAssert_Inbox_STX_AppUser(bodyAsString, jSONObject);	

		}

}
