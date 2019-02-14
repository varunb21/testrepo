package com.config;

import com.google.gson.JsonObject;

public class ObjectRepository {
    JsonObject locators;

    public ObjectRepository() {
    }

    public void setLocators(JsonObject locators) {
        this.locators = locators;
    }

    public JsonObject getLocator(String locatorName) {
        return this.locators.getAsJsonObject(locatorName);
    }
}

