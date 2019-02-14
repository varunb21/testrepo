package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author MayankM
 *
 */

//Test Case 88419:Inter-Op : verify that error 1137 is not getting raised from Backend when sending STATUS [GET] request

public class Bug88193_TC88921_Emp_GetResponse_DB_Validation extends BaseTest {

	@Test
	public void TC88921_OpenEVV_Emp_GetResponse_Validation() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException 
	{
		logger = extent.startTest("TC88921_OpenEVV_Emp_GetResponse_Validation"); 

		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) j.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader("create_employee"));
		
		String bodyAsStringget = CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("Emp_get"));
		
		Assert.assertTrue(bodyAsStringget.contains("messageSummary\": \"All records updated successfully."));  
	}

}