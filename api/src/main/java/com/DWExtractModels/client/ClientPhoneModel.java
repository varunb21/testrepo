package com.DWExtractModels.client;

import com.mapper.Column;
import com.mapper.CsvHeader;

public class ClientPhoneModel {
    @CsvHeader("PayerID")
    @Column("CONTRACT")
    private String payerID;

    @CsvHeader("ProviderID")
    @Column("PROVIDER_ID")
    private String providerID;

    @CsvHeader("ClientID")
    @Column("LOC")
    private String clientID;

    @CsvHeader("ClientPhoneType")
    @Column("DESCRIPTION")
    private String clientPhoneType;

    @CsvHeader("ClientPhone")
    @Column("ANI")
    private String clientPhone;

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

    public String getClientPhoneType() {
        return clientPhoneType;
    }

    public void setClientPhoneType(String clientPhoneType) {
        this.clientPhoneType = clientPhoneType;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Override
    public String toString() {
        String toString = "ClientPhoneModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "clientPhoneType='" + clientPhoneType + '\'' +
                "clientPhone='" + clientPhone + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
