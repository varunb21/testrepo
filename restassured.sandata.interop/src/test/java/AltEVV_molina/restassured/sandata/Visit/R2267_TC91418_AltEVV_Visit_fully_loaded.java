package AltEVV_molina.restassured.sandata.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- VisitOtherID field formats/values

*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91418_AltEVV_Visit_fully_loaded extends BaseTest{
	
	public void R2267_TC991418_AltEVV_Visit_fully_loaded_Valid() throws FileNotFoundException, IOException, ParseException, SQLException{
	
		logger = extent.startTest("R2267_TC991418_AltEVV_Visit_fully_loaded_Valid");  

		logger.log(LogStatus.INFO, "Validating R2267_TC991418_AltEVV_Visit_fully_loaded_Valid"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitOtherIDjson,CommonMethods.generateRandomNumberOfFixLength(10));
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
		
	
		
	}

}
