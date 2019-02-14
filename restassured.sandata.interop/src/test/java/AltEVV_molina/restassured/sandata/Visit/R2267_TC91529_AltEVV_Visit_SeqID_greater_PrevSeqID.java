package AltEVV_molina.restassured.sandata.Visit;

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

public class R2267_TC91529_AltEVV_Visit_SeqID_greater_PrevSeqID extends BaseTest{

	@Test
	public void R2267_TC91529_AltEVV_Visit_SeqID_greater_PrevSeqID_Valid() throws FileNotFoundException, IOException, ParseException, SQLException  {

		logger = extent.startTest("R2267_TC91529_AltEVV_Visit_SeqID_greater_PrevSeqID");  

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(6);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceid);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);
		
		int sequenceid2=Integer.parseInt(sequenceid)+1;
		System.out.println(sequenceid2);
		String sequenceidfinal=String.valueOf(sequenceid2);
		System.out.println(sequenceidfinal);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceidfinal);
		JSONArray jsonArrayVisitChangesre = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChangesre =  (JSONObject) jsonArrayVisitChangesre.get(0);
		jsonObjectVisitChangesre.put(globalVariables.SequenceIDjson, sequenceid);
		bodyAsString = CommonMethods.captureResponseAltEVV(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.visit_url));

		Assertion_DbVerifier.jsonAssert_inboxVisit(bodyAsString, jsonObjectVisit);

	}


}
