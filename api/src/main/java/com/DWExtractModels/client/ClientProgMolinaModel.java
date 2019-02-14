package com.DWExtractModels.client;

import com.mapper.Column;
import com.mapper.CsvHeader;

public class ClientProgMolinaModel {
    @CsvHeader("PayerID")
    @Column("PayerID")
    protected String payerID;

    @CsvHeader("ProviderID")
    @Column("ProviderID")
    protected String providerID;

    @CsvHeader("ClientID")
    @Column("ClientID")
    protected String clientID;

    @CsvHeader("PayerProgram")
    @Column("PayerProgram")
    protected String payerProgram;

    @CsvHeader("PayerService")
    @Column("PayerService")
    protected String payerService;

    @CsvHeader("PayerRegion")
    @Column("PayerRegion")
    protected String payerRegion;

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

    public String getPayerService() {
        return payerService;
    }

    public void setPayerService(String payerService) {
        this.payerService = payerService;
    }

    public String getPayerRegion() {
        return payerRegion;
    }

    public void setPayerRegion(String payerRegion) {
        this.payerRegion = payerRegion;
    }

    @Override
    public String toString() {
        String toString = "ClientProgModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "payerProgram='" + payerProgram + '\'' +
                "payerService='" + payerService + '\'' +
                "payerRegion='" + payerRegion + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
