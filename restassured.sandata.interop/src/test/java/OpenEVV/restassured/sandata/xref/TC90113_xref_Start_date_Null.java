package OpenEVV.restassured.sandata.xref;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import com.globalMethods.core.*;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;

public class TC90113_xref_Start_date_Null extends BaseTest{
	
	String val1, val3, val4,val2,emp1,cln1;
	

	//To validate the null xref start date
	@Test 
	public void TC90113_OpenEVV_xref_null_XRefStartDate() throws IOException, ParseException, ConfigurationException, SQLException
	{
		logger = extent.startTest("TC90113_OpenEVV_xref_null_XRefStartDate");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the null xref start date"); // adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("xref");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN",CommonMethods.generateRandomNumberOfFixLength(9));
		js.put( "ClientID", CommonMethods.generateRandomNumberOfFixLength(5));
		
		emp1=js.get("EmployeePIN").toString();
		cln1=js.get("ClientID").toString();
		
		val1= "stx_id";
		logger.log(LogStatus.INFO, "Passing EmployeePIN as "+emp1+" and ClientID as "+ cln1);
   
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		

		DataBaseVerifier_xref.DataBaseVerificationxref( val1, emp1);
		logger.log(LogStatus.INFO, "Validating Json response ");
		// assert validation of start date in both schema to verify the outcome
	    Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	    logger.log(LogStatus.INFO, "Validating DB response ");
	    Assert.assertEquals(DataBaseVerifier_xref.employee_pin,emp1 );
	    Assert.assertEquals(DataBaseVerifier_xref.id,cln1);
	    //Assert.assertEquals(DataBaseVerifier_xref.start_date, CommonMethods.generateTodayDate_MMddyyyy());
	   
		
	}


}
