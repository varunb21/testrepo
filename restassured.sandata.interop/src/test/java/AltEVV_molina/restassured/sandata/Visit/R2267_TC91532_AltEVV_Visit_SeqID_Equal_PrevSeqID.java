package AltEVV_molina.restassured.sandata.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- SequenceID field formats/values

*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC91532_AltEVV_Visit_SeqID_Equal_PrevSeqID extends BaseTest{
	
	@Test
	public void R2267_TC91532_AltEVV_Visit_SeqID_Equal_PrevSeqID_validation() throws FileNotFoundException, IOException, ParseException, SQLException{
		
		logger = extent.startTest("R2267_TC91532_AltEVV_Visit_SeqID_Equal_PrevSeqID_validation");  

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(50);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceid);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		
		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
		
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceid);
		JSONArray jsonArrayVisitChangesre = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChangesre =  (JSONObject) jsonArrayVisitChangesre.get(0);
		jsonObjectVisitChangesre.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsStringre = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsStringre, globalVariables.SequenceidError);

	}
	

}
