package OpenEVV.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 88259:Open EVV -Worker-Load-Maximum Values

public class Bug_88400_TC88789_Emp_MaxValues_Type_Disc_Dept extends BaseTest {

	//To validate the Employee with fields populated with maximum length values
	@Test
	public void Bug_88400_TC88789_OpenEVV_Emp_Populated_with_Max_values() throws IOException, ParseException, ConfigurationException, SQLException, Exception 
	{
		logger = extent.startTest("Bug_88400_TC88789_OpenEVV_Emp_Populated_with_Max_values"); 
		 
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.openevv_emp_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("Discipline", CommonMethods.generateRandomStringOfFixLength(17));
		jsonObject.put("Department", CommonMethods.generateRandomStringOfFixLength(3));
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		Assertion_DbVerifier.jsonAssert_InboxWorker(bodyAsString, jsonObject);	

	}


}



