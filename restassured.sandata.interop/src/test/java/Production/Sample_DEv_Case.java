package Production;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.net.ssl.SSLContext;

// Bug- 88400_Test Case 88822: Open EVV: Client- Load maximum Values in Client-PayerId & Coordinator

public class Sample_DEv_Case extends BaseTest {


	public static String payerid = CommonMethods.generateRandomNumberOfFixLength(64);
	public static String coordinator =  CommonMethods.generateRandomStringOfFixLength(3);

	@Test
	public void Sample_DEv_Case_valid() throws IOException, ParseException, ConfigurationException, SQLException
	{

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		//		Response resp = given().body(j.toJSONString()).header("Content-Type","application/json").
		//				auth().preemptive().
		//				basic(("stuffu3"),("stuffpwd3")).
		//				header(("Account"),("14420")).log().all().trustStore(trustStore).
		//				when().post("https://dev-api.sandata.com/interfaces/intake/employees/rest/api/v1/evv")
		//				then().assertThat().statusCode(200).and().extract().response();
		//	}

		System.out.println("...................");
		
		RestAssured.useRelaxedHTTPSValidation();
		
		Response response = RestAssured.given().body(j.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation()))
				.header("Content-Type","application/json").auth().preemptive().
				basic(("TrdCar!"),("800Hg51!")).
				header(("Account"),("14420")).log().all().
				when().post("https://qa-api.sandata.com/interfaces/intake/clients/rest/api/v1/evv").
				then().assertThat().statusCode(200).and().extract().response();

		System.out.println("Response:"+response.getBody().asString());

		System.out.println("Status:"+response.statusCode());

	}

}

