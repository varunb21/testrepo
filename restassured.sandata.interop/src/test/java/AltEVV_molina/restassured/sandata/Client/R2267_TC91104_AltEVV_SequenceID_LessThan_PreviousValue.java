package AltEVV_molina.restassured.sandata.Client;

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
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Kumar Rahul
 *
 */

//Testcase 91104 :OpenEVV-altEVV- Client: Validate If the latest SequenceID is less than the value previously received, and the record has not yet been processed
public class R2267_TC91104_AltEVV_SequenceID_LessThan_PreviousValue extends BaseTest {

	@Test
	public void R71852_TC91104_AltEVV_SequenceID_LessthanPreviosSequenceId() throws FileNotFoundException, IOException, ParseException, SQLException {

		logger = extent.startTest("R71852_TC91104_AltEVV_SequenceID_LessthanPreviosSequenceId");  

		//Using Reusable method to load employee json
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV("client_intake");

		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(5));
		String sequenceId =jsonobject.get("SequenceID").toString();

		String bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonobject);	



		//Making json values dynamic
		jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("SequenceID", String.valueOf((Integer.parseInt(sequenceId)-2)));

		String clientID =jsonobject.get("ClientID").toString();

		bodyAsString=CommonMethods.captureResponseAltEVV(altEVVJsonArray,CommonMethods.propertyfileReader("altevv_clients"));

		Assertion_DbVerifier.jsonAssert_InboxClient_AltEVV(bodyAsString, jsonobject);	


	}


}
