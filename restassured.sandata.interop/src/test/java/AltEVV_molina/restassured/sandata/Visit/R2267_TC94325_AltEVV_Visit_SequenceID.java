package AltEVV_molina.restassured.sandata.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- ProcedureCode field formats/values

 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC94325_AltEVV_Visit_SequenceID extends BaseTest{

	@Test
	public void R2267_TC94325_AltEVV_SequenceID_validValue() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_validValue");  


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomNumberOfFixLength(14));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));


		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);




	}

	@Test

	public void R2267_TC94325_AltEVV_SequenceID_validValue_Visitchanges() throws FileNotFoundException, IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_validValue_Visitchanges");  
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomNumberOfFixLength(14));
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

		Assertion_DbVerifier.jsonAssert_inboxVisitChanges(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);


	}

	@Test
	public void R2267_TC94325_AltEVV_SequenceID_greaterThan_Max() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_greaterThan_Max");  


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,CommonMethods.generateRandomNumberOfFixLength(18));
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDLengthError);

	}
	@Test
	public void R2267_TC94325_AltEVV_SequenceID_greaterThan_Max_VisitChannges() throws FileNotFoundException, IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_greaterThan_Max_VisitChannges"); 
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomNumberOfFixLength(18));
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDLengthError);
	}

	@Test
	public void R2267_TC94325_AltEVV_SequenceID_AlphaNumeric() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_AlphaNumeric");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);



		jsonObjectVisit.put(globalVariables.SequenceIDjson,CommonMethods.generateRandomAlphaNumeric(13));


		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));


	}

	@Test
	public void R2267_TC94325_AltEVV_SequenceID_AlphaNumeric_VisitChanges() throws FileNotFoundException, IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_AlphaNumeric_VisitChanges"); 
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomAlphaNumeric(11));
		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

	}
	@Test
	public void R2267_TC94325_AltEVV_SequenceID_null() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_null");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);



		jsonObjectVisit.put(globalVariables.SequenceIDjson,null);

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorSequenceIdNull);

	}
	@Test
	public void R2267_TC94325_AltEVV_SequenceID_null_VisitChanges() throws FileNotFoundException, IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_null_VisitChanges"); 
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson,null);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorSequenceIdNull);
	}
	@Test
	public void R2267_TC94325_AltEVV_SequenceID_blank() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_blank");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);



		jsonObjectVisit.put(globalVariables.SequenceIDjson,"");

		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

	}
	@Test
	public void R2267_TC94325_AltEVV_SequenceID_blank_VisitChanges() throws FileNotFoundException, IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_blank_VisitChanges"); 
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, "");

		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

	}
	@Test
	public void R2267_TC94325_AltEVV_SequenceID_specailChar() throws FileNotFoundException, IOException, ParseException, SQLException{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_specailChar");  

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);



		jsonObjectVisit.put(globalVariables.SequenceIDjson,CommonMethods.generateSpecialChar(11));


		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

	}
	@Test
	public void R2267_TC94325_AltEVV_SequenceID_specailChar_VisitChanges() throws FileNotFoundException, IOException, ParseException, SQLException
	{
		logger = extent.startTest("R2267_TC94325_AltEVV_SequenceID_specailChar_VisitChanges"); 
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, CommonMethods.generateSpecialChar(11));
		String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

	}
}
