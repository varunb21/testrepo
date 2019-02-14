package Production;

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

/**
 * @author MayankM
 *
 */
public class Bug5660_TC95298_AltEVV_Lat_Long_same extends BaseTest {

	@Test
	public void Bug5660_TC95298_AltEVV_Lat_Long_same_validation() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException
	{
		logger = extent.startTest("Bug5660_TC95298_AltEVV_Lat_Long_same_validation"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientLatitude",CommonMethods.generateRandomNumberOfFixLength(2));
		jsonObjectAdd.put("ClientLongitude",CommonMethods.generateRandomNumberOfFixLength(2));

		String bodyAsString = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClients(bodyAsString,jsonObject);
		
		Assertion_DbVerifier.jsonAssert_STXClient_Supp(bodyAsString,jsonObject, jsonObjectAdd);
		
		//Sending request again after updating SequenceID
		jsonObject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(16));
		
		String bodyAsStringRe = CommonMethods.captureResponseAltEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Assertion_DbVerifier.jsonAssert_InboxClients(bodyAsStringRe,jsonObject);

		Assertion_DbVerifier.jsonAssert_STXClient_Supp(bodyAsString,jsonObject, jsonObjectAdd);
		
	}

}
