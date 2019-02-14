package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

//Test Case 96777:Open EVV Client- Validate the client Json for invalid case of ClientMedicaidID (Refer the steps for scenario)

	public class R2154_TC96777_OpenEVV_ClientMedicaidID_invalid extends BaseTest {
	//Case1: ClientMedicaidID= mm-dd-yyyy  ex :-- 10-29-2018
	@Test
	public void TC96777_OpenEVV_ClientMedicaidID_invalid_specialchars() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("TC96777_OpenEVV_ClientMedicaidID_invalid_specialchars"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMedicaidID", CommonMethods.generateSpecialChar(7));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMedicaidIDformaterror);

	}
	//Case2: ClientMedicaidID= INBETWEEN SPACE
	@Test
	public void R2154_TC96777_OpenEVV_ClientMedicaidID_Space_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96777_OpenEVV_ClientMedicaidID_Space_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMedicaidID", CommonMethods.generateRandomAlphaNumeric(3) +" " +CommonMethods.generateRandomNumberOfFixLength(2));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMedicaidIDformaterror);

	}
	//Case3:ClientMedicaidID= String Combination with dashes
	@Test
	public void R2154_TC96777_OpenEVV_ClientMedicaidID_dashes_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96777_OpenEVV_ClientMedicaidID_dashes_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMedicaidID", CommonMethods.generateRandomAlphaNumeric(2) +"-" +CommonMethods.generateRandomNumberOfFixLength(2));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMedicaidIDformaterror);

	}
	
}