/**
 * 
 */
package AltEVV_generic.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
// Test Case 92998:Alt EVV -Alt EVV - Employee -SequenceID - Prior Values, previously received-With Same or Different Data Set

public class TC92998_ALTEVV_Employee_SequenceID_previousvalue_with_same_dataset extends BaseTest {

	public void TC92998_ALTEVV_Employee_SequenceID_previousvalue_with_same_dataset_validation() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("TC92998_ALTEVV_Employee_SequenceID_previousvalue_with_same_dataset"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");

		JSONObject jsobject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_clients"));

		String bodyNewAString=CommonMethods.captureResponseAltEVV(jsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		JSONArray jsonArr1=GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);

		String bodyAsStringGet=CommonMethods.captureResponseAltEVVGetWithUID(bodyNewAString, CommonMethods.propertyfileReader("altevv_clients_get"));

		CommonMethods.Assert_Visit_FailCase(bodyAsStringGet, "Version number is duplicated or older than current");

	}

}
