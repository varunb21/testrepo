package Production;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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

public class Bug_5182_TC97693_Logs_IODATA_Emp_Reject_Post extends BaseTest {

	@Test
	public void Bug5182_TC97693_Logs_IODATA_Emp_Reject_Post_validation() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("Bug5182_TC97693_Logs_IODATA_Emp_Reject_Post_validation"); 

		JSONArray jsonarray=GenerateUniqueParam.EmpParams_3P(globalVariables.worker_3P_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("BusinessEntityMedicaidIdentifier",CommonMethods.generateRandomNumberOfFixLength(7));

		String bodyAsString = CommonMethods.captureResponse_ohio(jsonarray, CommonMethods.propertyfileReader(globalVariables.ohio_worker_url));
	
		Assert.assertTrue(bodyAsString.contains("\"status\": \"BAD_REQUEST\""));
	
		String bodyAsStringget=CommonMethods.captureGetResponse3PGetWithUID(bodyAsString, CommonMethods.propertyfileReader("3PPatient_get"));
	
		Assertion_DbVerifier.jsonAssert_iodata_ohio(bodyAsStringget, CommonMethods.capturegetIDonly(bodyAsStringget));
	}
	
}
