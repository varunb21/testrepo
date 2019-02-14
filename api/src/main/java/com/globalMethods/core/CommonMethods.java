package com.globalMethods.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import com.utilities.CompareUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonMethods extends BaseTest{

	public final static String ENVIORNMENT = null;

	public static Map<String, String> parameters;

	InputStream input = null;


	// ******************************************* File Reader ************************************//
	
	public static String getEnv() {
		File file = new File(System.getProperty("user.dir") + File.separator+ "configQA.properties");
		

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("Enviornment");
	}
	
	public static String propertyfileReader(String propertyname) {
		String environment = System.getProperty("test.env");
		System.out.println(environment);
		File file;
		
		if (environment.equalsIgnoreCase("THISISDEV")){
			file = new File(System.getProperty("user.dir") + File.separator+ "configDEV.properties");
		}
		
		else if (environment.equalsIgnoreCase("THISISQA")){
			file = new File(System.getProperty("user.dir") + File.separator+ "configQA.properties");
		}
		
		else {
			throw new InputMismatchException("Incorrect environment provided. Further execution will be terminated");
		}
		
		
		System.out.println("Executing on "+environment+" env");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(propertyname);
	}
	
	
	
	

	public static void writePropertiesFile(String key, String value,String key1, String value1) {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("claimFiles.properties");
			prop.setProperty(key, value);
			prop.setProperty(key1, value1);
			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void writeProviderPropertiesFile(String key, String value,String key1, String value1,String key2,String value2)
	{	
		Properties prop = new Properties();
		OutputStream output = null;

		try {


			prop.setProperty(key, value);
			prop.setProperty(key1, value1);
			prop.setProperty(key2, value2);
			// save properties to project root folder
			output = new FileOutputStream("claimFiles.properties");
			prop.store(output, "jmeter file");

		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	public void writePropertiesFile(Map<String, String> map,String Filename) throws IOException {
		Properties prop = new Properties();
		FileInputStream Input = new FileInputStream(Filename);

		prop.load(Input);
		Input.close();
		System.out.println(FileSystems.getDefault());
		OutputStream output = new FileOutputStream(Filename);

		try {
			Set<String> keys = map.keySet();
			for(String key: keys){
				prop.setProperty(key, map.get(key));
			}


			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	// ******************************************* Load JSON ************************************//

	public static JSONArray LoadVisitJSON(String jsonnamevisit) throws FileNotFoundException, IOException, ParseException {

		JSONArray jsonArr=CommonMethods.LoadJSON_AltEVV(jsonnamevisit);

		@SuppressWarnings("unused")
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		return jsonArr;

	}
	
	public static JSONArray LoadVisitJSON_3P(String jsonnamevisit) throws FileNotFoundException, IOException, ParseException {

		JSONArray jsonArr=CommonMethods.LoadJSON_ThreeP(jsonnamevisit);

		@SuppressWarnings("unused")
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		return jsonArr;

	}

	public static JSONArray LoadJSON_OpenEVV(String jsonname) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		JSONArray jsonarr = null;

		jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator +"src" + File.separator + "main"+ File.separator
				+ "java" +File.separator+ "Resources"+ File.separator+ "OpenEVV" +File.separator +jsonname+ ".json"));

		return jsonarr;

	}

	public static JSONArray LoadJSON_ThreeP(String jsonname) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		JSONArray jsonarr = null;

		jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator +"src" + File.separator + "main"+ File.separator
				+ "java" +File.separator+ "Resources"+ File.separator+ "ThreeP" +File.separator +jsonname+ ".json"));

		return jsonarr;

	}
	
	public static JSONArray LoadJSON_auth(String jsonname) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		JSONArray jsonarr = null;

		jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator +"src" + File.separator + "main"+ File.separator
				+ "java" +File.separator+ "Resources"+ File.separator+ "ThreeP" + File.separator +jsonname+".json"));

		return jsonarr;

	}

	public static JSONArray LoadJSON_AltEVV(String jsonname) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		JSONArray jsonarr = null;

		jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator +"src" + File.separator + "main"+ File.separator
				+ "java" +File.separator+ "Resources"+ File.separator+ "AltEVV"+File.separator +jsonname+".json"));
		return jsonarr;

	}

	// ******************************************* Common Method ************************************//

	public void holdOn(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static String getSaltString(int max) {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < max) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static long getRandomLong(long min, long max)
	{

		try
		{
			Random  random  = new Random();

			long    result  = min + (long) (random.nextDouble() * (max - min));
			return  result;
		}
		catch (Throwable t) {t.printStackTrace();}
		return 0L;
	}

	public static int getRandomInt(int min, int max) {
		try {
			int result = min + (int)(Math.random() * max); 
			return result;
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return 0;
	}

	public static String jsonObject(int digCount) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(digCount);
		for (int i = 0; i < digCount; i++)
			sb.append((char) ('1' + rnd.nextInt(8)));
		return sb.toString();
	}

	public static String generateRandomAlphaNumeric(int count) {
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}	

	public static String generateRandomStringOfFixLength(int diCount)
	{
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < diCount; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String RandomString = sb.toString();
		return RandomString;

	}

	public static String generateRandomNumberOfFixLength(int digCount) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(digCount);
		for (int i = 0; i < digCount; i++)
			sb.append((char) ('1' + rnd.nextInt(8)));
		return sb.toString();
	}
	
	public static String generateSpecialChar(int i)
	{
		String characters = "~`!@#$%^&*()_=+[{]}\\|;:\'\",<.>/?";
		String spclChar = RandomStringUtils.random( i, characters );
		return spclChar;
	}

	public static String DateGenerator(String pattern) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now); 
	}

	public static double getRandomDoubleBetweenRange(double min, double max)
	{
		double x = (Math.random()*((max-min)+1))+min;
		x =Double.parseDouble(new DecimalFormat("#.##").format(x));
		return x;
	}
	
	public static double getRandomDouble_Two_Decimal(double min, double max)
	{
		double x = (Math.random()*((max-min)+1))+min;
		x =Double.parseDouble(new DecimalFormat("##.##").format(x));
		return x;
	}

	public static List<String> getMemberErrorMessageForMissingRequiredField(){
		List<String> Errormessage = new ArrayList<String>();
		Errormessage.add(globalVariables.memberActionNullError);
		Errormessage.add(globalVariables.memberClientCityNullError);
		Errormessage.add(globalVariables.memberClientEligibilityDateBeginNullError);
		Errormessage.add(globalVariables.memberClientStateNullError);
		Errormessage.add(globalVariables.memberClientZipNullError);
		Errormessage.add(globalVariables.memberClientCustomIDNullError);
		Errormessage.add(globalVariables.memberClientOtherIDNullError);
		Errormessage.add(globalVariables.memberClientSSNNullError);
		Errormessage.add(globalVariables.memberClientFirstNameNullError);
		Errormessage.add(globalVariables.memberClientLastNameNullError);
		Errormessage.add(globalVariables.memberClientEligibilityDateBeginFormatError);
		return Errormessage;
	}

	public static String dateToDateTimeFormat(String dateToFormat) throws ParseException, java.text.ParseException
	{

		Date dateConverted=new SimpleDateFormat("MMddyyyy").parse(dateToFormat);

		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dt =simpleDateFormat.format(dateConverted);
		return (dt+".0");
	}

	public static String generateEmailAddress_string(int i)
	{
		String domain="@mailinator.com";
		String ClientEmailAddress = CommonMethods.generateRandomStringOfFixLength(i);
		return ClientEmailAddress.concat(domain);
	}

	public static String generateEmailAddress_alpha(int i)
	{
		String domain="@mailinator.com";
		String ClientDesigneeEmail = CommonMethods.generateRandomAlphaNumeric(i);
		return ClientDesigneeEmail.concat(domain);
	}

	public static String generateEmailAddress_num(int i)
	{
		String domain="@mailinator.com";
		String ClientEmailAddress = CommonMethods.generateRandomNumberOfFixLength(i);
		return ClientEmailAddress.concat(domain);
	}

	public static String generateTodayDate_YYYY_MM_dd()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String empenddate = dateFormat.format(date);
		return empenddate;
	}

	public static String generateTodayDate_MMddyyyy()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String empenddate = dateFormat.format(date);
		return empenddate;
	}

	public static String generateFutureDate_YYYY_MM_dd()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String empfuturedate = dateFormat.format(tomorrow);
		return empfuturedate;
	}

	public static String generateFutureDate_YYYY_MM_dd_Time()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss aa");
		String empfuturedate = dateFormat.format(tomorrow);
		return empfuturedate;
	}
	public static String generateFutureDate_MMddyyyy()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String empfuturedate = dateFormat.format(tomorrow);
		return empfuturedate;
	}
	
	public static String generateFutureDate_MM_DD_YYYY()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String empfuturedate = dateFormat.format(tomorrow);
		return empfuturedate;
	}

	public static String generatePastDate_YYYY_MM_dd()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -5);
		Date yesterday = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String emppastdate = dateFormat.format(yesterday);
		return emppastdate;
	}

	public static String generatePastDate_MMddYYYY()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -5);
		Date yesterday = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String empdischargedate = dateFormat.format(yesterday);
		return empdischargedate;
	}
	public static String generatePastDate_MMddYYYY_slash()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -5);
		Date yesterday = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String empdischargedate = dateFormat.format(yesterday);
		return empdischargedate;
	}

	// ******************************************* Capture response GET ************************************//

	public static String captureResponseAltEVVGetWithUID(String bodyAsString, String Url){

		JsonPath jsonPath = new JsonPath(bodyAsString);
		String UID = jsonPath.get("id");
		System.out.println(UID);

		RestAssured.useRelaxedHTTPSValidation();

		Response getResp = given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user"),CommonMethods.propertyfileReader("altevv_pass")).
				header(CommonMethods.propertyfileReader("acc"), CommonMethods.propertyfileReader("altevv_accId")).log().all().
				when().get(Url+  '?' + "uuid" + '=' + UID).
				then().assertThat().statusCode(200).and().extract().response();
		
		String resstring = getResp.asString();
		
		System.out.println(resstring);

		logger.log(LogStatus.INFO, "response body extracted is " +resstring);

		return resstring;

	}

	public static String captureResponseOpenEVVGetWithUID(String bodyAsString,String Url){

		JsonPath jsonPath = new JsonPath(bodyAsString);
		String UID = jsonPath.get("id");
		System.out.println(UID);
		RestAssured.useRelaxedHTTPSValidation();

		Response getResp = given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("OpenEvv_user"),CommonMethods.propertyfileReader("OpenEvv_pass")).
				header(CommonMethods.propertyfileReader("OpenEvv_acc"), CommonMethods.propertyfileReader("OpenEvv_AccId")).log().all().
				when().get(Url+  '?' + "uuid" + '=' + UID).
				then().assertThat().statusCode(200).and().extract().response();

		String resAsString = getResp.asString();

		System.out.println("Response Body is: " + resAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +resAsString);

		return resAsString;

	}

	public static String capturegetIDonly(String bodyAsString) {
		JsonPath jp = new JsonPath(bodyAsString);
		String UID = jp.get("id");
		return UID;
	
	}
	
	public static String captureGetResponse3PGetWithUID(String bodyAsString, String URL){

		JsonPath jp = new JsonPath(bodyAsString);
		String UID = jp.get("id");
		RestAssured.useRelaxedHTTPSValidation();

		Response getResp = given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("3P_user"),CommonMethods.propertyfileReader("3P_pass")).
				header(CommonMethods.propertyfileReader("3P_acc"), CommonMethods.propertyfileReader("3P_AccId"))
				.log().all().
				when().get(URL+  '?' + "uuid" + '=' + UID).
				then().assertThat().statusCode(200).and().extract().response();

		String getresponse = getResp.asString();
		System.out.println("Response Body is: " + getresponse);
		System.out.println(URL+ UID);
		return getresponse;

	}

	public static String captureGetResponse3P_fail(String bodyAsString, String Url){

		JsonPath jp = new JsonPath(bodyAsString);
		String uuid = jp.get("id");
		
		RestAssured.useRelaxedHTTPSValidation();

		Response getResp = given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("3P_user"),CommonMethods.propertyfileReader("3P_pass")).
				header(CommonMethods.propertyfileReader("3P_acc"), CommonMethods.propertyfileReader("3P_AccId"))
				.log().all().
				when().get(Url+  '?' + "uuid" + '=' + uuid).
				then().assertThat().statusCode(200).and().extract().response();

		String getresponse = getResp.asString();
		System.out.println("Response Body is: " + getresponse);
		System.out.println(Url+ uuid);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);

		logger.log(LogStatus.INFO, "Validating JSON response ");

		return getresponse;

	}

	public static String captureResponseAuthrizationGetWithUID(String bodyAsString, String Url){

		JsonPath jsonPath = new JsonPath(bodyAsString);
		String UID = jsonPath.get("id");
		System.out.println(UID);

		RestAssured.useRelaxedHTTPSValidation();

		Response getResp = given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("Auth_user"),CommonMethods.propertyfileReader("Auth_pass")).
				header(CommonMethods.propertyfileReader("Auth_acc"), CommonMethods.propertyfileReader("Auth_AccId")).log().all().
				when().get(Url+  '?' + "uuid" + '=' + UID).
				then().assertThat().statusCode(200).and().extract().response();
		
		String resstring = getResp.asString();
		
		System.out.println(resstring);

		logger.log(LogStatus.INFO, "response body extracted is " +resstring);

		return resstring;

	}

	// ******************************************* Capture response POST ************************************//

	public static String captureResponseAltEVV(JSONArray altEVVJsonArray,String Url){

		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(altEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user"),CommonMethods.propertyfileReader("altevv_pass")).
				header(CommonMethods.propertyfileReader("acc"), CommonMethods.propertyfileReader("altevv_accId")).log().all().
				when().post(Url).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		

		return bodyAsString;

	}

	public static String captureResponseAltEVV_400(JSONArray altEVVJsonArray,String Url){

		logger.log(LogStatus.INFO, "request body generated is " +altEVVJsonArray.toJSONString()); 

		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(altEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user"),CommonMethods.propertyfileReader("altevv_pass")).
				header(CommonMethods.propertyfileReader("acc"), CommonMethods.propertyfileReader("altevv_accId")).log().all().
				when().post(Url).
				then().assertThat().statusCode(400).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);

		return bodyAsString;


	}

	public static String captureResponseAltEVV_500(JSONArray altEVVJsonArray,String Url){

		logger.log(LogStatus.INFO, "request body generated is " +altEVVJsonArray.toJSONString()); 
		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(altEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user"),CommonMethods.propertyfileReader("altevv_pass")).
				header(CommonMethods.propertyfileReader("acc"), CommonMethods.propertyfileReader("altevv_accId")).log().all().
				when().post(Url).
				then().assertThat().statusCode(500).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);

		return bodyAsString;


	}

	public static String captureResponseOPENEVV(JSONArray OpenEVVJsonArray,String Url){


		logger.log(LogStatus.INFO, "request body generated is " +OpenEVVJsonArray.toJSONString()); 

		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("OpenEvv_user"),CommonMethods.propertyfileReader("OpenEvv_pass")).
				header(CommonMethods.propertyfileReader("OpenEvv_acc"), CommonMethods.propertyfileReader("OpenEvv_AccId")).log().all().
				when().post(Url).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);

		return bodyAsString;

	}

	public static String captureResponse_ohio(JSONArray OhioJsonArray,String Url){


		logger.log(LogStatus.INFO, "request body generated is " +OhioJsonArray.toJSONString()); 
		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(OhioJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("ohio_user"),CommonMethods.propertyfileReader("ohio_pass")).
				header(CommonMethods.propertyfileReader("OpenEvv_acc"), CommonMethods.propertyfileReader("ohio_accid")).log().all().
				when().post(Url).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);

		return bodyAsString;

	}

	public static String captureResponse3P(JSONArray threePJsonArray,String Url){


		logger.log(LogStatus.INFO, "request body generated is " +threePJsonArray.toJSONString()); 
	
		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(threePJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("3P_user"),CommonMethods.propertyfileReader("3P_pass")).
				header(CommonMethods.propertyfileReader("3P_acc"), CommonMethods.propertyfileReader("3P_AccId")).log().all().
				when().post(Url).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);

		return bodyAsString;

	}
	
	public static String captureResponse3P_500(JSONArray threePJsonArray,String Url){


		logger.log(LogStatus.INFO, "request body generated is " +threePJsonArray.toJSONString()); 
	
		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(threePJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("3P_user"),CommonMethods.propertyfileReader("3P_pass")).
				header(CommonMethods.propertyfileReader("3P_acc"), CommonMethods.propertyfileReader("3P_AccId")).log().all().
				when().post(Url).
				then().assertThat().statusCode(500).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);

		return bodyAsString;

	}

	public static String captureResponseOpenEVV_Member(JSONArray OpenEVVJsonArray,String Url){


		logger.log(LogStatus.INFO, "request body generated is " +OpenEVVJsonArray.toJSONString()); 
		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("member_user"),CommonMethods.propertyfileReader("member_pass")).
				header(CommonMethods.propertyfileReader("acc"), CommonMethods.propertyfileReader("member_accId")).log().all().
				when().post(Url).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);

		return bodyAsString;

	}

	public static String captureResponseOPENEVV_400(JSONArray OpenEVVJsonArray,String Url){


		logger.log(LogStatus.INFO, "request body generated is " +OpenEVVJsonArray.toJSONString()); 

		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("OpenEvv_user"),CommonMethods.propertyfileReader("OpenEvv_pass")).
				header(CommonMethods.propertyfileReader("OpenEvv_acc"), CommonMethods.propertyfileReader("OpenEvv_AccId")).log().all().
				when().post(Url).
				then().assertThat().statusCode(400).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);

		return bodyAsString;

	}

	public static String captureResponsePostAuthrization(JSONArray altEVVJsonArray,String Url){

		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(altEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("Auth_user"),CommonMethods.propertyfileReader("Auth_pass")).
				header(CommonMethods.propertyfileReader("Auth_acc"), CommonMethods.propertyfileReader("Auth_AccId")).log().all().
				when().post(Url).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		

		return bodyAsString;

	}


	// ******************************************* Capture json assert Success ************************************//

	public static  void verifyjsonassertsuccess4value_inbox_authorizations(String bodyAsString, String DBfield1, String value1) throws SQLException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		logger.log(LogStatus.INFO, "Validating DB response ");
		DataBaseVerifier_Client.DataBaseVerificationClient_inbox_authorizations(DBfield1, value1);
	}

	public static  void verifyjsonassertsuccess4value_STXAPPUSER(String bodyAsString, String DBfield1, String value1,String DBfield2, String value2) throws SQLException
	{

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		DataBaseVerifier_Client.DataBaseVerificationClient_STX_App_User(DBfield1, value1, DBfield2, value2);
	}

	public static  void verifyjsonassertsuccessforcalls(String bodyAsString, String DBfield1, String value1) throws SQLException
	{

		logger.log(LogStatus.INFO, "Validating JSON response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		logger.log(LogStatus.INFO, "Validating DB response ");

		DataBaseVerifier_Emp.DataBaseVerificationcalls(DBfield1, value1);
	}

	// ******************************************* Capture json assert FAIL ************************************//

	public static  void verifyjsonassertFailcase(String bodyAsString, String Errormesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));

		Assert.assertTrue(bodyAsString.contains(Errormesssage));
	}
	
	public static  void verifyjsonassertFailcaseinget(String bodyAsString, String Errormesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

		Assert.assertTrue(bodyAsString.contains("\"status\": null,"));

		Assert.assertTrue(bodyAsString.contains(Errormesssage));
	}
	public static  void Assert_Visit_FailCase(String bodyAsString, String Errormesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

		Assert.assertTrue(bodyAsString.contains(Errormesssage));
	}
	
	public static  void Assert_nullstatus_FailCase(String bodyAsString, String Errormesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

		Assert.assertTrue(bodyAsString.contains("\"status\": null,"));

		Assert.assertTrue(bodyAsString.contains(Errormesssage));
	}

	public static  void verifyjsonassertFailcase_400(String bodyAsString, String Errormesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

		Assert.assertTrue(bodyAsString.contains("\"status\": 400"));
		Assert.assertTrue(bodyAsString.contains("\"error\": \"Bad Request\""));

		Assert.assertTrue(bodyAsString.contains(Errormesssage));
	}

	public static void verifylistassertion(String bodyAsString, ArrayList<String> arraylistverify )
	{
		logger.log(LogStatus.INFO, "Validating  response body type");

		JsonPath jp = new JsonPath(bodyAsString);
		ArrayList<String> arraylist=new ArrayList<String>();
		arraylist.add((String) jp.get("id"));
		arraylist.add((String) jp.get("AgencyIdentifier"));
		arraylist.add((String) jp.get("ProviderID"));
		arraylist.add((String) jp.get("RecordType"));
		arraylist.add((String) jp.get("RecordOtherID"));
		arraylist.add((String) jp.get("reason"));

		System.out.println(arraylist);

		for(String list:arraylistverify)
		{
			Assert.assertTrue(bodyAsString.contains(list));
		}
	}

	// ******************************************* Assert and print value ************************************//

	public static void AssertEqualsAndPrintValues(String Expected,String Actual)
	{

		System.out.println("Verifying the value of Expected in Db : " + "'"+ Expected + "'" + "  with the Actual: " +  "'" + Actual + "'");

		Assert.assertEquals(Expected, Actual);
	}

	public static void AssertEqualsAndPrintValuesString(String Expected,String Actual,String VerifyText )
	{
		System.out.println("Verifying :"+VerifyText+" Expected: "+Expected +" Actual: "+Actual);
		Assert.assertEquals(Expected, Actual);
	}
	public static void AssertEqualsAndPrintValuesInteger(int Expected,int Actual,String VerifyText )
	{
		System.out.println("Verifying :"+VerifyText+" Expected: "+Expected +" Actual: "+Actual);
		Assert.assertEquals(Expected, Actual);
	}

	public static <T> void verifyObjectFieldsNotNull(List<T> dataList, List<String> definedField) throws IllegalAccessException {
		if (definedField.size() > 0) {
			for(int i = 0; i < dataList.size(); i++) {
				Assert.assertFalse(CompareUtil.isSpecificFieldsNull(dataList.get(i), definedField));
			}
		}
	}
}
