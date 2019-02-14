package com.ws;

import com.config.Environment;
import com.config.TestData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Author: @Loc Nguyen
 */
public class WebServicesBase {

    private static final Logger LOGGER = Logger.getLogger(WebServicesBase.class);

    public WebServicesBase(){

    }

    public Response sendPOSTRequest(String requestUrl, String jsonString, String ws_username, String ws_password){
        Response response = given().
                auth().
                preemptive().
                basic(ws_username, ws_password). //read from excel
                contentType(ContentType.JSON).
                body(jsonString).
                when().
                post(requestUrl).
                then().
                statusCode(200).
                assertThat().body("status", equalTo("SUCCESS")).
        contentType(ContentType.JSON).extract().response();
        LOGGER.info(response.body().asString());
        return response;

    }

    public Response sendGETRequest(String requestUrl){
        Response response = given().
                relaxedHTTPSValidation().
                auth().
                preemptive().
                basic("admin", "admin").
                when().
                get(requestUrl).
                then().
                statusCode(200).
                contentType(ContentType.JSON).extract().response();
        LOGGER.info(response.body().asString());
        return response;
    }


    public String readJsonFromFile(String fileName) throws IOException {
        return convertInputStreamToString(new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\DWHExport\\" +fileName)));
    }

    private String convertInputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        String string = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return string;
    }

    public int getNumberOfObjectInJsonString(String jsonString){
        JsonParser jsonParser = new JsonParser();
        JsonArray arrayFromString = jsonParser.parse(jsonString).getAsJsonArray();
        return arrayFromString.size();
    }

    public boolean isResponseSuccess(Response response) {
        if (Objects.isNull(response) || response.getStatusCode() < 200 || response.getStatusCode() > 299) {
            return false;
        }
        try {
            return isResponseSuccessWithoutWarning(response.asString());
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isResponseSuccessWithWarning(Response response) {
        if (Objects.isNull(response) || response.getStatusCode() < 200 || response.getStatusCode() > 299) {
            return false;
        }
        try {
            return isResponseSuccessWithWarning(response.asString());
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean isResponseSuccessWithoutWarning(String body) {
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(body, JsonObject.class);
        JsonObject data = json.get("data").getAsJsonObject();
        return "SUCCESS".equalsIgnoreCase(json.get("status").getAsString()) && data.get("erroneousRecordCount").getAsInt() == 0 && data.get("erroneousRecords").getAsJsonObject().keySet().size() == 0;

    }

    private boolean isResponseSuccessWithWarning(String body) {
        return StringUtils.isNotEmpty(getResponseErrorMessage(body));
    }

    public String getResponseErrorMessage(String body) {
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(body, JsonObject.class);
        JsonObject data = json.get("data").getAsJsonObject();
        String erroneousRecord = null;
        if ("SUCCESS".equalsIgnoreCase(json.get("status").getAsString()) && data.get("erroneousRecords").getAsJsonObject().keySet().size() != 0){
            erroneousRecord = data.get("erroneousRecords").getAsJsonObject().get("0").getAsJsonObject().get("message").getAsString();
        }

        return erroneousRecord;
    }

    public String getImportResultSummaryMessage(String body) {
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(body, JsonObject.class);
        JsonObject data = json.get("data").getAsJsonObject();
        return data.get("importResultSummary").getAsString();
    }

    public String getStatus(String body) {
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(body, JsonObject.class);
        return json.get("status").getAsString();
    }

    public int getSuccessfulRecordCount(String body) {
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(body, JsonObject.class);
        JsonObject data = json.get("data").getAsJsonObject();
        return data.get("successfulRecordCount").getAsInt();
    }

    public int getErroneousRecordCount(String body) {
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(body, JsonObject.class);
        JsonObject data = json.get("data").getAsJsonObject();
        return data.get("erroneousRecordCount").getAsInt();
    }


    public <T> T toJsonModel(String jsonFileName, Class<T> clazz) throws IOException {
        String jsonStr = readJsonFromFile(jsonFileName);
        LOGGER.debug("JSON String: " + jsonStr);
        return  new Gson().fromJson(jsonStr, clazz);
    }

    public Response sendPOSTRequestWithoutSSL(String requestUrl, String jsonString, String ws_username, String ws_password){
        Response response = given().
                relaxedHTTPSValidation().
                auth().
                preemptive().
                basic(ws_username, ws_password). //read from excel
                contentType(ContentType.JSON).
                body(jsonString).
                when().
                post(requestUrl).
                then().
                statusCode(200).
                extract().response();
        LOGGER.info(response.body().asString());
        return response;
    }

    public Response sendGETRequestWithourSSL(String requestUrl, String ws_username, String ws_password){
        Response response = given().
                relaxedHTTPSValidation().
                auth().
                preemptive().
                basic(ws_username, ws_password).
                when().
                get(requestUrl).
                then().
                statusCode(200).
                extract().response();
        LOGGER.info(response.asString());
        return response;
    }

    public Response sendPOSTClient(String requestUrl, JSONArray altEVVJsonArray, Environment environment, TestData testData){
        String altEvvUser = environment.getAlt_evv_user();
        String altEvvPass = environment.getAlt_evv_pass();
        String acc = testData.getAcc();
        String accountId = testData.getAccId();
        Response response = given().
                relaxedHTTPSValidation().
                body(altEVVJsonArray.toJSONString()).header("Content-Type","application/json").
                auth().preemptive().
                basic(altEvvUser, altEvvPass).
                header(acc, accountId).log().all().
                when().post(requestUrl).
                then().assertThat().statusCode(200).and().extract().response();

        LOGGER.info("BODY: " + response.body().asString());
        return response;
    }

    public Response sendPOSTEmployeeEVV(String requestUrl, JSONArray altEVVJsonArray, Environment environment, TestData testData){
        String openEvvUser = environment.getMolina_UserName();
        String openEvvPass = environment.getMolina_Password();
        String acc = testData.getAcc();
        String accountId = testData.getAccId();
        Response response = given().
                relaxedHTTPSValidation().
                body(altEVVJsonArray.toJSONString()).header("Content-Type","application/json").
                auth().preemptive().
                basic(openEvvUser, openEvvPass).
                header(acc, accountId).log().all().
                when().post(requestUrl).
                then().assertThat().statusCode(200).and().extract().response();

        LOGGER.info("BODY: " + response.body().asString());
        return response;
    }

    public Response sendPOSTEmployeeAtlEVV(String requestUrl, JSONArray altEVVJsonArray, Environment environment, TestData testData, String accountId){
        String altEvvUser = environment.getAlt_evv_user();
        String altEvvPass = environment.getAlt_evv_pass();
        String acc = testData.getAcc();
        Response response = given().
                relaxedHTTPSValidation().
                body(altEVVJsonArray.toJSONString()).header("Content-Type","application/json").
                auth().preemptive().
                basic(altEvvUser, altEvvPass).
                header(acc, accountId).log().all().
                when().post(requestUrl).
                then().assertThat().statusCode(200).and().extract().response();

        LOGGER.info("BODY: " + response.body().asString());
        return response;
    }

    public Response sendPOSTWithAccountInHeader(String requestUrl, String altEVVJsonArray, String username, String password, String accountId){
        Response response = given().
                relaxedHTTPSValidation().
                body(altEVVJsonArray).header("Content-Type","application/json").
                auth().preemptive().
                basic(username, password).
                header("Account", accountId).log().all().
                when().post(requestUrl).
                then().assertThat().statusCode(200).and().extract().response();

        LOGGER.info("BODY: " + response.body().asString());
        return response;
    }
}