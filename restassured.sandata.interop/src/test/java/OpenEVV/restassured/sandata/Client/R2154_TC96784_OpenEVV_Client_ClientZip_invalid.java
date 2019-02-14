package OpenEVV.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 96784:Open EVV Client- Validate the client Json for invalid case of ClientZip (Refer the steps for scenario)

	public class R2154_TC96784_OpenEVV_Client_ClientZip_invalid extends BaseTest {
	
	//Case1: Less than 5 numeric
	@Test
	public void R2154_TC96784_OpenEVV_ClientZip_length_invalid() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96784_OpenEVV_ClientZip_length_invalid"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(1));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipformatError);

	}
	//Case2: With Length 6 (E.g "231234")
	@Test
	public void R2154_TC96784_OpenEVV_ClientZip_length_numeric() throws IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2154_TC96784_OpenEVV_ClientZip_length_numeric"); 

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(6));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipformatError);

	}

	//Case3: With trailing spaces (E.g " 231234 ")
		@Test
	public void R2154_TC96784_OpenEVV_ClientZip_trailingspaces() throws IOException, ParseException, SQLException
		{
			logger = extent.startTest("R2154_TC96784_OpenEVV_ClientZip_trailingspaces"); 

			JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("ClientZip", " " +CommonMethods.generateRandomNumberOfFixLength(6));	

			String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipformatError);


		}

	//Case4: With leading spaces (E.g "231234 ")
				@Test
	public void R2154_TC96784_OpenEVV_ClientZip_leadingspaces() throws IOException, ParseException, SQLException
				{
					logger = extent.startTest("R2154_TC96784_OpenEVV_ClientZip_leadingspaces"); 

					JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
					JSONObject jsonObject = (JSONObject) jsonArray.get(0);

					jsonObject.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(6) + " ");	

					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipformatError);


				}
				
	//Case5: With null (E.g "null")
	@Test
	public void R2154_TC96784_OpenEVV_ClientZip_null() throws IOException, ParseException, SQLException
				{
					logger = extent.startTest("R2154_TC96784_OpenEVV_ClientZip_null"); 

					JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
					JSONObject jsonObject = (JSONObject) jsonArray.get(0);

					jsonObject.put("ClientZip", null);	

					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipnullError);


				}	
				
	//Case5: With 9chars numeric (E.g "24344355")
	@Test
	public void R2154_TC96784_OpenEVV_ClientZip_numeric() throws IOException, ParseException, SQLException
				{
					logger = extent.startTest("R2154_TC96784_OpenEVV_ClientZip_numeric"); 

					JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
					JSONObject jsonObject = (JSONObject) jsonArray.get(0);

					jsonObject.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(10));	

					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipformatError);


				}	
				
	//Case6: With special chars (E.g "#4545")
				@Test
	public void R2154_TC96784_OpenEVV_ClientZip_specialchars() throws IOException, ParseException, SQLException
				{
					logger = extent.startTest("R2154_TC96784_OpenEVV_ClientZip_specialchars"); 

					JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
					JSONObject jsonObject = (JSONObject) jsonArray.get(0);

					jsonObject.put("ClientZip", CommonMethods.generateSpecialChar(6));	

					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader("clients"));

					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipformatError);


				}		
}