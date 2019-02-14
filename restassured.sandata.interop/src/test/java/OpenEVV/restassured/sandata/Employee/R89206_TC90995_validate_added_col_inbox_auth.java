package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

public class R89206_TC90995_validate_added_col_inbox_auth extends BaseTest {

	String val1= "account";
	
	//To validate the added fields in DB
	@Test(groups = {"Databasetest"})
	public void TC89206_OpenEVV_Emp_Validate_new_col_Inbox_Auth() throws IOException, ParseException, ConfigurationException, SQLException
	{
	
		logger = extent.startTest("TC89206_OpenEVV_Emp_Validate_new_col_Inbox_Auth"); 
		 
		logger.log(LogStatus.INFO, "To validate the added fields in DB");// adding what you are verifing


		
		DataBaseVerifier_Emp.DataBaseVerificationEmp_inbox_auth( val1, "14420");
		
		//assigning db value to local variables.
	    
	    String workeridqlf =DataBaseVerifier_xref.workeridqlf;
	    String clientidqlf =DataBaseVerifier_xref.clientidqlf;
	    String clientid =DataBaseVerifier_xref.clientid;
	    String workerid =DataBaseVerifier_xref.workerid;
	    logger.log(LogStatus.INFO, "Validating DB response ");
	    //Asserting the DB column names with actual values
	    
	    Assert.assertEquals(DataBaseVerifier_xref.workeridqlf,workeridqlf );
	    Assert.assertEquals(DataBaseVerifier_xref.clientidqlf,clientidqlf );
	    Assert.assertEquals(DataBaseVerifier_xref.clientid,clientid );
	    Assert.assertEquals(DataBaseVerifier_xref.workerid,workerid );
		
	}

}
