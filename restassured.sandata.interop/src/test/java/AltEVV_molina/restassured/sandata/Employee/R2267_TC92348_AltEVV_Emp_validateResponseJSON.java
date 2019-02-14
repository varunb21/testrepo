package AltEVV_molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;

/**
 * @author RRohiteshwar
 *
 */
//Test Case 92348:Open EVV - alt EVV-Employee- Validate the Response json

public class R2267_TC92348_AltEVV_Emp_validateResponseJSON extends BaseTest{

	String Jsonstring, empssn, field = "worker_ssn",sequncid, field2="worker_version_number";

	
	//Validating valid Emp_ResponseJSON for few objects 
	@Test (priority=0)
	public void R2267_TC92348_AltEVV_Emp_validateResponseJSON_5field() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC92348_AltEVV_Emp_validateResponseJSON_5field");  
		logger.log(LogStatus.INFO, "Validating valid Emp_ResponseJSON for few objects"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		this.empssn=jsonObject.get("EmployeeSSN").toString();
		this.sequncid=jsonObject.get("SequenceID").toString();
		System.out.println(sequncid);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_emp"));
	
		//CommonMethods.verifyjsonassertsuccess4value_inboxemp(bodyAsString, field, empssn, field2, sequncid );

		JsonPath jp = new JsonPath(bodyAsString);
		ArrayList<String> arraylist=new ArrayList<String>();
			
		CommonMethods.verifylistassertion(bodyAsString, arraylist );
		
	}
	
	
}