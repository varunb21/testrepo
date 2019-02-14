package com.config;

import com.google.gson.JsonObject;

public class TestData {
    JsonObject defaultVariables;
    JsonObject variables;


    public TestData() {
    }

    public String[] getSubGeneratedFiles()
    {
        try {
            String stringList = this.variables.get("ListNameFiles").getAsString();
            return stringList.split("\\|");

        } catch (NullPointerException var2) {
            return null;
        }
    }

    public int getExportMode()
    {
        try {
            return this.variables.get("ExportMode").getAsInt();
        } catch (NullPointerException var2) {
            return -1;
        }
    }

    public String getUsername()
    {
        try {
            return this.variables.get("Username").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getSpv()
    {
        try {
            return this.variables.get("Spv").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getContract()
    {
        try {
            return this.variables.get("Contract").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getGroupKey()
    {
        try {
            return this.variables.get("GroupKey").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getEndDate()
    {
        try {
            return this.variables.get("EndDate").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getStartDate()
    {
        try {
            return this.variables.get("StartDate").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getAcc()
    {
        try {
            return this.variables.get("Acc").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getAccId()
    {
        try {
            return this.variables.get("AccId").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getAcc28000()
    {
        try {
            return this.variables.get("Acc28000").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getLocalDir()
    {
        try {
            return this.variables.get("LocalDir").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getContainText()
    {
        try {
            return this.variables.get("ContainText").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getJsonFileName()
    {
        try {
            return this.variables.get("Client_intake").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getProviderId()
    {
        try {
            return this.variables.get("ProviderId").getAsString();
        } catch (NullPointerException var2) {
            return null;
        }
    }

    public String getRunningEnvID() {
        try {
            return this.variables.get("ENVID").getAsString();
        } catch (NullPointerException var2) {
            return this.defaultVariables.get("DefaultENVID").getAsString();
        }
    }

    public String getDefaultVariable(String variableName) {
        try {
            return this.defaultVariables.get(variableName).getAsString();
        } catch (NullPointerException var4) {
            String message = String.format("There is no Default variable [%s] defined in the Test Data", variableName);
            return null;
        }
    }

    public String getValue(String variableName) {
        try {
            return this.variables.get(variableName).getAsString();
        } catch (NullPointerException var3) {
            return this.defaultVariables.get(variableName).getAsString();
        }
    }

    public JsonObject getDefaultVariables() {
        return this.defaultVariables;
    }

    public void setDefaultVariables(JsonObject defaultVariables) {
        this.defaultVariables = defaultVariables;
    }

    public JsonObject getVariables() {
        return this.variables;
    }

    public void setVariables(JsonObject variables) {
        this.variables = variables;
    }

    public String getDefaultValue(String variableName) {
        try {
            return this.defaultVariables.get(variableName).getAsString();
        } catch (NullPointerException var4) {
            return "";
        }
    }
}
