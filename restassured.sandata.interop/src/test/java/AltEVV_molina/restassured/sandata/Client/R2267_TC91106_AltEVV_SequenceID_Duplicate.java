package AltEVV_molina.restassured.sandata.Client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

//TestCase 91106 OpenEVV-altEVV- Client: Validate If the Sequence ID is equal to a value previously received
public class R2267_TC91106_AltEVV_SequenceID_Duplicate extends BaseTest{


	@Test
	public void R2267_TC91106_AltEVV_SequenceID_Duplicate1() throws FileNotFoundException, IOException, ParseException, SQLException
	{
		logger = extent.startTest("R71852_TC91106_AltEVV_SequenceID_Duplicate");  

		//Using Reusable method to load employee json
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(5));
		
		String sequenceId =jsonobject.get("SequenceID").toString();

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonobject);	

		jsonobject.put("SequenceID", sequenceId);

		bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "");


	}

}

