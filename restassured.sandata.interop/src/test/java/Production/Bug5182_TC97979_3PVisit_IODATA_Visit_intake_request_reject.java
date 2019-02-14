package Production;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;

/**
 * @author rahul Rohit
 *
 */
public class Bug5182_TC97979_3PVisit_IODATA_Visit_intake_request_reject extends BaseTest {

	@Test
	public void Bug5182_TC97979_3PVisit_IODATA_Visit_intake_request_reject_invalid_get() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		logger = extent.startTest("Bug5182_TC97979_3PVisit_IODATA_Visit_intake_request_success"); 

		JSONArray jsonArr=GenerateUniqueParam.VisitParam_3P(globalVariables.ThreeP_visit_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);
		js.put("StaffOtherID", null);

		String bodyAsString = CommonMethods.captureResponse3P(jsonArr, CommonMethods.propertyfileReader("3P_Visit"));

		JsonPath jp = new JsonPath(bodyAsString);
		String uuid = jp.get("id");
	
		String bodyAsStringget=CommonMethods.captureGetResponse3P_fail(bodyAsString, CommonMethods.propertyfileReader("3P_Staff_get"));
				
		Assert.assertTrue(bodyAsStringget.contains("\"ErrorCode\": \"-782\","));
		
		Assertion_DbVerifier.jsonAssert_iodata_ohio(bodyAsStringget, CommonMethods.capturegetIDonly(bodyAsStringget));
		
	}

}
