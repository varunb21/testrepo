/**
 * 
 */
package AltEVV_generic.restassured.sandata.Visit;

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
          

           
       	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
    	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			String sequenceid = CommonMethods.generateRandomNumberOfFixLength(8);
			
			jsonObjectVisit.put("ClientID",client_Detail);
			
			jsonObjectVisit.put("ClientIdentifier",client_Detail);
			
			jsonObjectVisit.put("SequenceID",sequenceid);
			
			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader("altevv_visit"));
			String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("altevv_visit_get"));
			CommonMethods.Assert_Visit_FailCase(bodyAsStringGet, "Client not found");

			
          }
			
		}

