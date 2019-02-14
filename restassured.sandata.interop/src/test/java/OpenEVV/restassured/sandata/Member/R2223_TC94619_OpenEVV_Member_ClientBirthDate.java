package OpenEVV.restassured.sandata.Member;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2223_TC94619_OpenEVV_Member_ClientBirthDate extends BaseTest {

	//**************************   ClientBirthDate :"062820188" (greater than 8 digits) (invalid Case) ***************************

	//case 1---- where every tag is included and is populated with a correct value except the below given field.  ClientBirthDate :"062820188" (greater than 8 digits)

	@Test
	public void R2223_TC94619_OpenEvv_member_ClientBirthDate_filed_validation_Greaterthan_8_digit() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC94619_OpenEvv_member_ClientBirthDate_filed_validation_Greaterthan_8_digit"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientBirthDate", "112320067");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror);




	}


	//**************************    ClientBirthDate :"28122018" (Incorrect format DDMMYYYY) (invalid Case) ***************************

	//case 2---- where every tag is included and is populated with a correct value except the below given field.   ClientBirthDate :"28122018" (Incorrect format DDMMYYYY)

	@Test
	public void TC94619_OpenEvv_member_ClientBirthDate_filed_invalid_DDMMYYYY() throws IOException, ParseException, ConfigurationException
	{

		logger = extent.startTest("TC94619_OpenEvv_member_ClientBirthDate_filed_incorrectformat_DDMMYYYY"); 


		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientBirthDate", "28112006");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror); 
	}


	//**************************    ClientBirthDate :"20180618" (Incorrect format YYYYMMDD) (invalid Case) ***************************

	//case 3---- where every tag is included and is populated with a correct value except the below given field.   ClientBirthDate :"20180618" (Incorrect format YYYYMMDD) 

	@Test
	public void TC94619_OpenEvv_member_ClientBirthDate_filed_incorrectformat_YYYYMMDD() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC94619_OpenEVV_Member_BirthDate_incorrectformat_YYYYMMDD"); 

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientBirthDate", "19821228");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror); 
	}


	//**************************    ClientBirthDate :"0628201" (Incorrect format MMDDYYY)  (invalid Case) ***************************

	//case 4---- where every tag is included and is populated with a correct value except the below given field.   ClientBirthDate :"0628201" (Incorrect format MMDDYYY) 

	@Test
	public void TC94619_OpenEvv_member_ClientBirthDate_filed_incorrectformat_MMDDYYY() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC94619_OpenEVV_Member_BirthDate_incorrectformat_MM-DD-YYYY");  
		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientBirthDate", "12-28-2018");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror); 
	}

	@Test
	public void TC94619_OpenEvv_member_ClientBirthDate_filed_incorrectformat_character() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC94619_OpenEVV_Member_BirthDate_incorrectformat_character");  
		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientBirthDate", "aa-bb-cccc");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror); 
	}

	@Test
	public void TC94619_OpenEvv_member_ClientBirthDate_filed_incorrectformat_hiphen() throws IOException, ParseException, ConfigurationException
	{
		logger = extent.startTest("TC94619_OpenEVV_Member_BirthDate_incorrectformat_hiphen");  
		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientBirthDate", "10/28/2006");	

		String bodyAsString = CommonMethods.captureResponseOpenEVV_Member(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror); 
	}
}
