package com.DWExtractModels.client;

import com.mapper.CsvHeader;

public class ClientEligibilityModel {
    @CsvHeader("PayerID")
    private String payerID;

    @CsvHeader("ProviderID")
    private String providerID;

    @CsvHeader("ClientID")
    private String clientID;

    @CsvHeader("PayerProgram")
    private String payerProgram;

    @CsvHeader("ClientEligibilityDateBegin")
    private String clientEligibilityDateBegin;

    @CsvHeader("ClientEligibilityDateEnd")
    private String clientEligibilityDateEnd;

    @CsvHeader("ClientStartOfCareDate")
    private String clientStartOfCareDate;

    @CsvHeader("ClientEndOfCareDate")
    private String clientEndOfCareDate;

    @CsvHeader("ClientStatus")
    private String clientStatus;

    @CsvHeader("ClientStatusDate")
    private String clientStatusDate;

    public String getPayerID() {
        return payerID;
    }

    public void setPayerID(String payerID) {
        this.payerID = payerID;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getPayerProgram() {
        return payerProgram;
    }

    public void setPayerProgram(String payerProgram) {
        this.payerProgram = payerProgram;
    }

    public String getClientEligibilityDateBegin() {
        return clientEligibilityDateBegin;
    }

    public void setClientEligibilityDateBegin(String clientEligibilityDateBegin) {
        this.clientEligibilityDateBegin = clientEligibilityDateBegin;
    }

    public String getClientEligibilityDateEnd() {
        return clientEligibilityDateEnd;
    }

    public void setClientEligibilityDateEnd(String clientEligibilityDateEnd) {
        this.clientEligibilityDateEnd = clientEligibilityDateEnd;
    }

    public String getClientStartOfCareDate() {
        return clientStartOfCareDate;
    }

    public void setClientStartOfCareDate(String clientStartOfCareDate) {
        this.clientStartOfCareDate = clientStartOfCareDate;
    }

    public String getClientEndOfCareDate() {
        return clientEndOfCareDate;
    }

    public void setClientEndOfCareDate(String clientEndOfCareDate) {
        this.clientEndOfCareDate = clientEndOfCareDate;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getClientStatusDate() {
        return clientStatusDate;
    }

    public void setClientStatusDate(String clientStatusDate) {
        this.clientStatusDate = clientStatusDate;
    }

    @Override
    public String toString() {
        String toString = "ClientEligibilityModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "payerProgram='" + payerProgram + '\'' +
                "clientEligibilityDateBegin='" + clientEligibilityDateBegin + '\'' +
                "clientEligibilityDateEnd='" + clientEligibilityDateEnd + '\'' +
                "clientStartOfCareDate='" + clientStartOfCareDate + '\'' +
                "clientEndOfCareDate='" + clientEndOfCareDate + '\'' +
                "clientStatus='" + clientStatus + '\'' +
                "clientStatusDate='" + clientStatusDate + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
