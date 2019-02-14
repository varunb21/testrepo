package com.utilities;

import com.config.Configuration;
import com.config.Environment;
import com.config.ObjectRepository;
import com.config.TestData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JsonReader {
    private static String defaultFolder = System.getProperty("user.dir");
    private static String testDataFolder = "TestData";
    private static final String jsonExt = ".json";

    public JsonReader() {

    }

    public ObjectRepository loadObjectRepositories() {
        File testcaseFolder = new File(defaultFolder + File.separator + testDataFolder + File.separator + "Locators");
        ObjectRepository repository = new ObjectRepository();
        String[] var2 = testcaseFolder.list();
        int var3 = var2.length;
        byte var4 = 0;
        if (var4 < var3) {
            String filePath = var2[var4];
            JsonObject locators = loadJsonFile(testDataFolder + File.separator + "Locators" + File.separator + filePath);
            repository = new ObjectRepository();
            repository.setLocators(locators);
            return repository;
        } else {
            return repository;
        }
    }

    public Configuration loadConfiguration() {
        try {
            String filePath = testDataFolder + File.separator + "Environment.json";
            JsonObject configuration = loadJsonFile(filePath);
            Gson gson = new Gson();
            JsonElement configuration1 = configuration.get("Configuration");
            return (Configuration)gson.fromJson(configuration1, Configuration.class);
        } catch (NullPointerException var4) {
            return null;
        }
    }

    public Environment loadEnvironment(String envType, String envID) {
        try {
            String filePath = testDataFolder + File.separator + envType + ".json";
            JsonObject configuration = loadJsonFile(filePath);
            Gson gson = new Gson();
            JsonElement environment1 = configuration.getAsJsonObject("Environment").get(envID);
            if (environment1 == null) {
                return null;
            } else {
                Environment environment = (Environment)gson.fromJson(environment1, Environment.class);
                environment.setEnvironments((Map)gson.fromJson(environment1, Map.class));
                return environment;
            }
        } catch (Exception var7) {
            return null;
        }
    }

    private JsonObject loadJsonFile(String filePath) {
        JsonParser parser = new JsonParser();

        try {
            JsonObject jsonObject = parser.parse(new FileReader(System.getProperty("user.dir") + File.separator + filePath)).getAsJsonObject();
            return jsonObject;
        } catch (FileNotFoundException var4) {
            Assert.fail(String.format("Cannot load Json File at %s", filePath));
            return null;
        }
    }

    public TestData loadTestCaseData(String testcaseID) {
        String folderPath = defaultFolder + File.separator + testDataFolder + File.separator;
        String tcJsonPath = folderPath + File.separator + testcaseID + ".json";
        String dataJsonPath = testDataFolder + File.separator +  File.separator + "TestData.json";
        TestData testData = new TestData();

        try {
            JsonObject defaultData = loadJsonFile(dataJsonPath);
            testData.setDefaultVariables(defaultData);
            JsonObject data;
            if ((new File(tcJsonPath)).exists()) {
                data = loadJsonFile(testcaseID + ".json");
                testData.setVariables(data);
            } else {
                data = loadJsonFile(dataJsonPath).getAsJsonObject(testDataFolder).getAsJsonObject(testcaseID);
                testData.setVariables(data);
            }
        } catch (NullPointerException var6) {

        }

        return testData;
    }
}
