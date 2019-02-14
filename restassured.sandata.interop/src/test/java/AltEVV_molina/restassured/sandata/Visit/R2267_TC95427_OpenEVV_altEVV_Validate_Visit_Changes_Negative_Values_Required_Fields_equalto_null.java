package AltEVV_molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

/*Ravi Ranjan*/

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC95427_OpenEVV_altEVV_Validate_Visit_Changes_Negative_Values_Required_Fields_equalto_null extends BaseTest {
	

		@Test
		public void R2267_TC95305_AltEVV_ClientIdentifierOnCall_blank_sequenceid() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95305_ClientIdentifierOnCall_blank_sequenceid");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.SequenceIDjson,"");

			String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorSequenseIDminLength);

		}
		
		@Test
		public void R2267_TC95305_AltEVV_ClientIdentifierOnCall_blank_changedatetime() throws FileNotFoundException, IOException, ParseException, SQLException{
			logger = extent.startTest("R2267_TC95305_ClientIdentifierOnCall_blank_changedatetime");  

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.ChangeDateTimejson,"");

			@SuppressWarnings("unused")
			String bodyAsString = CommonMethods.captureResponseAltEVV_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));


		}
		


}
