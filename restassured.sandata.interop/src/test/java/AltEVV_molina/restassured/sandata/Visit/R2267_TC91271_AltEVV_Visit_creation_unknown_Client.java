/**
 * 
 */
package AltEVV_molina.restassured.sandata.Visit;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;

/**
 * @author neeraj
 *
 */
public class R2267_TC91271_AltEVV_Visit_creation_unknown_Client extends BaseTest{
	
	
		@Test
		public void R2267_TC91271_AltEVV_Visit_Creation_Unknown_Client() throws IOException, ParseException, SQLException
		{
			logger = extent.startTest("R2267_TC91271_AltEVV_Visit_Creation_Unknown_Client");  
			logger.log(LogStatus.INFO, "Validating_Visit_Creation_Unknown_Client"); 
			
           String client_Detail =CommonMethods.generateRandomNumberOfFixLength(6);
          

           
			////////////Generating Unique Employee detail from alt EVV employee json//////////////
			JSONArray jsonArrayEmp = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
			JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
			String bodyAsStringEmp = CommonMethods.captureResponseAltEVV(jsonArrayEmp, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

			////////////Generating Unique visit detail from alt EVV visitjson//////////////
			JSONArray jsonArrayVisit = GenerateUniqueParam.VisitParams_AltEVV();

			String sequenceid = CommonMethods.generateRandomNumberOfFixLength(16);
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put("ClientID",client_Detail);
			jsonObjectVisit.put("EmployeeIdentifier",jsonObjectEmp.get("EmployeeSSN").toString());
			jsonObjectVisit.put("ClientOtherID",client_Detail);
			jsonObjectVisit.put("EmployeeIdentifier",jsonObjectEmp.get("EmployeeSSN").toString());
			jsonObjectVisit.put("SequenceID",sequenceid);
			jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			JsonPath jsonPath = new JsonPath(bodyAsString);
			String uuid = jsonPath.get("id");

			String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID("altevv_visit_get",uuid);

			logger.log(LogStatus.INFO, "Validating JSON response failed case");

			Assert.assertTrue(bodyAsStringGet.contains("\"status\": \"SUCCESS\","));
		

			Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

			
          }
			
		}

