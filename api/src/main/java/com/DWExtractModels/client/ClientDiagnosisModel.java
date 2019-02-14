package com.DWExtractModels.client;

import com.mapper.CsvHeader;

public class ClientDiagnosisModel {
    @CsvHeader("PayerID")
    private String payerID;

    @CsvHeader("ProviderID")
    private String providerID;

    @CsvHeader("ClientID")
    private String clientID;

    @CsvHeader("IsPrimary")
    private String isPrimary;

    @CsvHeader("DiagnosisCode")
    private String diagnosisCode;

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

    public String getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    @Override
    public String toString() {
        String toString = "ClientDiagnosisModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "isPrimary='" + isPrimary + '\'' +
                "diagnosisCode='" + diagnosisCode + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
