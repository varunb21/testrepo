package com.DWExtractModels.client;

import com.mapper.Column;
import com.mapper.CsvHeader;
import com.utilities.CompareUtil;
import org.testng.Assert;

import java.util.List;

public class ClientAddressModel {
    @CsvHeader("PayerID")
    @Column("PayerID")
    private String payerID;

    @CsvHeader("ProviderID")
    @Column("ProviderID")
    private String providerID;

    @CsvHeader("ClientID")
    @Column("ClientID")
    private String clientID;

    @CsvHeader("ClientAddressType")
    @Column("ClientAddressType")
    private String clientAddressType;

    @CsvHeader("ClientAddressLine1")
    @Column("ClientAddressLine1")
    private String clientAddressLine1;

    @CsvHeader("ClientAddressLine2")
    @Column("ClientAddressLine2")
    private String clientAddressLine2;

    @CsvHeader("ClientCounty")
    @Column("ClientCounty")
    private String clientCounty;

    @CsvHeader("ClientCity")
    @Column("ClientCity")
    private String clientCity;

    @CsvHeader("ClientState")
    @Column("ClientState")
    private String clientState;

    @CsvHeader("ClientZip")
    @Column("ClientZip")
    private String clientZip;

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

    public String getClientAddressType() {
        return clientAddressType;
    }

    public void setClientAddressType(String clientAddressType) {
        this.clientAddressType = clientAddressType;
    }

    public String getClientAddressLine1() {
        return clientAddressLine1;
    }

    public void setClientAddressLine1(String clientAddressLine1) {
        this.clientAddressLine1 = clientAddressLine1;
    }

    public String getClientAddressLine2() {
        return clientAddressLine2;
    }

    public void setClientAddressLine2(String clientAddressLine2) {
        this.clientAddressLine2 = clientAddressLine2;
    }

    public String getClientCounty() {
        return clientCounty;
    }

    public void setClientCounty(String clientCounty) {
        this.clientCounty = clientCounty;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientState() {
        return clientState;
    }

    public void setClientState(String clientState) {
        this.clientState = clientState;
    }

    public String getClientZip() {
        return clientZip;
    }

    public void setClientZip(String clientZip) {
        this.clientZip = clientZip;
    }

    @Override
    public String toString() {
        String toString = "ClientAddressModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "clientAddressType='" + clientAddressType + '\'' +
                "clientAddressLine1='" + clientAddressLine1 + '\'' +
                "clientAddressLine2='" + clientAddressLine2 + '\'' +
                "clientCounty='" + clientCounty + '\'' +
                "clientCity='" + clientCity + '\'' +
                "clientState='" + clientState + '\'' +
                "clientZip='" + clientZip + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public void verifyFormatField(String fieldValue, String regex, String errorMessage) {
        if(!fieldValue.equals(null) && !fieldValue.equals(""))
            Assert.assertTrue(fieldValue.matches(regex), errorMessage);
    }

    public void verifyFormatFields() {
        String errorMessage1 = "Length of field %s is not correctly";
        this.verifyFormatField(this.payerID, "^\\w{0,64}$", String.format(errorMessage1, "payerID"));
        this.verifyFormatField(this.providerID, "^\\w{0,50}$", String.format(errorMessage1, "providerID"));
        this.verifyFormatField(this.clientID, "^\\w{0,10}$", String.format(errorMessage1, "clientID"));
        this.verifyFormatField(this.clientAddressType, "^(?:Business|Home|Other)$",String.format(errorMessage1, "providerID"));
        this.verifyFormatField(this.clientAddressLine1, "^\\w{0,30}$",String.format(errorMessage1, "clientAddressLine1"));
        this.verifyFormatField(this.clientAddressLine2, "^\\w{0,30}$",String.format(errorMessage1, "clientAddressLine2"));
        this.verifyFormatField(this.clientCounty, "^\\w{0,25}$",String.format(errorMessage1, "clientCounty"));
        this.verifyFormatField(this.clientCity, "^\\w{0,30}$",String.format(errorMessage1, "clientCity"));
        this.verifyFormatField(this.clientState, "^\\w{0,2}$",String.format(errorMessage1, "clientState"));
        this.verifyFormatField(this.clientZip, "^\\w{0,9}$",String.format(errorMessage1, "clientZip"));
    }

    public static void verifyDataInDbAndCsvCorrectly(List<ClientAddressModel> recordsCsv){
        for (ClientAddressModel recordCsv: recordsCsv){
            recordCsv.verifyFormatFields();
        }
    }

    public static void verifyRandomRecordsFieldNotNull(List<ClientAddressModel> dataList, List<String> definedField) throws IllegalAccessException {
        if(dataList.size() > 5){
            for(int i = 0; i < 5; i++) {
                Assert.assertFalse(CompareUtil.isSpecificFieldsNull(dataList.get(i), definedField));
            }
        }else{
            for(int i = 0; i < dataList.size(); i++) {
                Assert.assertFalse(CompareUtil.isSpecificFieldsNull(dataList.get(i), definedField));
            }
        }
    }
}
