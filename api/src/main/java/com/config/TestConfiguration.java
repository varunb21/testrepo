package com.config;

import com.utilities.JsonReader;

public class TestConfiguration {
    private Configuration configuration;
    private Environment environment;
    private TestData testData;
    private ObjectRepository objectRepository;
    private JsonReader jsonReader;
    private   String testcaseID;

    public TestConfiguration() {
        jsonReader = new JsonReader();
        testData = new TestData();
        setObjectRepository(jsonReader.loadObjectRepositories());
        setConfiguration(jsonReader.loadConfiguration());
    }

    public void setTestCaseID(String id){
        testcaseID = id;
    }

    public Boolean isNullOfTestData()
    {
        if (testData == null)
            return true;
        return false;
    }

    public void loadTestCaseData() {
        this.testData = jsonReader.loadTestCaseData(testcaseID);
    }

    public boolean testDataIsNotFound()
    {
        if(this.testData.variables == null)
            return true;
        return false;
    }

    public void loadEnvironment(String envType) {
        this.environment = jsonReader.loadEnvironment(envType, this.testData.getRunningEnvID());
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Environment getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public TestData getTestData() {
        return this.testData;
    }

    public ObjectRepository getObjectRepository() {
        return this.objectRepository;
    }

    public void setObjectRepository(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

}
