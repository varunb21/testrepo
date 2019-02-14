package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;

/**
 * @author Neeraj
 *
 */

// Inter-Op : verify that error 1137 is not getting raised from Backend when sending STATUS [GET] request

public class Bug_88193_TC88419_Error1137_Sending_Status_Get extends BaseTest
{

	@Test
	public void Bug_88193_TC88419_Error1137_Sending_Status_GET() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("Bug_88193_TC88419_Error1137_Sending_Status_Get"); 

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader("create_employee"));

		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader("Emp_get"));
		
		Assert.assertTrue(bodyAsStringGet.contains("messageSummary\": \"All records updated successfully."));  

	}

}
