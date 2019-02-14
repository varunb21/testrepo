package AltEVV_molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */
//Test Case 91511:Open EVV -Alt EVV - Worker -SequenceID - Prior Values, previously received-With Same or Different Data Set

public class R2267_TC91511_AltEVV_Emp_SequenceID extends BaseTest{

	String Jsonstring, empssn, field = "worker_ssn",sequncid, field2="worker_version_number";

	//Validating valid employee SequenceID_json_DB_Positive_case lower sequence id and greater sequence id
	@Test (priority=0)
	public void R2267_TC91511_AltEVV_Emp_SequenceID_DB_with_increament_decrement_case() throws IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("R2267_TC91511_AltEVV_Emp_SequenceID_DB_with_increament_decrement_case");  
		logger.log(LogStatus.INFO, "//Validating valid employee SequenceID_json_DB_Positive_case lower sequence id and greater sequence id"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV("Staff_intake");
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		this.empssn=jsonObject.get("EmployeeSSN").toString();
		this.sequncid=jsonObject.get("SequenceID").toString();
		System.out.println(sequncid);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_emp"));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
		
		logger.log(LogStatus.INFO, "Validating that Db does not get updated if sequence id is sent lowerthan the revious case"); 
		
		jsonObject.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		jsonObject.put("SequenceID", String.valueOf((Integer.parseInt(sequncid)-2)));
	
		bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_emp"));
		
		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	
		
		logger.log(LogStatus.INFO, "Validating that Db does not get updated if sequence id is sent greater the revious case"); 
		
		jsonObject.put("SequenceID", String.valueOf((Integer.parseInt(sequncid)+4)));
		jsonObject.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		this.sequncid=jsonObject.get("SequenceID").toString();


		bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader("altevv_emp"));

		Assertion_DbVerifier.jsonAssert_InboxWorker_AltEVV(bodyAsString, jsonObject);	

	}

}