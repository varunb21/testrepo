package com.DWExtractModels.client;

import com.mapper.Column;
import com.mapper.CsvHeader;
import org.testng.Assert;

import java.util.List;

public class ClientProgModel extends ClientProgMolinaModel {
    @CsvHeader("Modifier1")
    @Column("Modifier1")
    private String modifier1;

    @CsvHeader("Modifier2")
    @Column("Modifier2")
    private String modifier2;

    @CsvHeader("Modifier3")
    @Column("Modifier3")
    private String modifier3;

    @CsvHeader("Modifier4")
    @Column("Modifier4")
    private String modifier4;

    public String getModifier1() {
        return modifier1;
    }

    public void setModifier1(String modifier1) {
        this.modifier1 = modifier1;
    }

    public String getModifier2() {
        return modifier2;
    }

    public void setModifier2(String modifier2) {
        this.modifier2 = modifier2;
    }

    public String getModifier3() {
        return modifier3;
    }

    public void setModifier3(String modifier3) {
        this.modifier3 = modifier3;
    }

    public String getModifier4() {
        return modifier4;
    }

    public void setModifier4(String modifier4) {
        this.modifier4 = modifier4;
    }

    @Override
    public String toString() {
        String toString = "ClientProgModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "payerProgram='" + payerProgram + '\'' +
                "payerService='" + payerService + '\'' +
                "modifier1='" + modifier1 + '\'' +
                "modifier2='" + modifier2 + '\'' +
                "modifier3='" + modifier3 + '\'' +
                "modifier4='" + modifier4 + '\'' +
                "payerRegion='" + payerRegion + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public void verifyFormatField(String fieldValue, String regex, String errorMessage) {
        if(!fieldValue.equals("null"))
            Assert.assertTrue(fieldValue.matches(regex), errorMessage);
    }

    public void verifyFormatFields() {
        String errorMessage1 = "Length of field %s is not correctly";
        String errorMessage2 = "Format of field %s is not correctly yyyy-MM-dd";
        String errorMessage3 = "Format of field %s is not correctly";
        String regexDateTime = "(^$)|(^[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-2][0-9]:[0-6][0-9]$)";

        this.verifyFormatField(this.payerID, "^\\w{0,64}$", String.format(errorMessage1, "payerID"));
        this.verifyFormatField(this.providerID, "^\\w{0,50}$", String.format(errorMessage1, "providerID"));
        this.verifyFormatField(this.clientID, "^\\w{0,10}$", String.format(errorMessage1, "clientID"));
        this.verifyFormatField(this.payerProgram, "^.{0,64}$", String.format(errorMessage1, "payerProgram"));
        this.verifyFormatField(this.payerService, "^.{0,5}$", String.format(errorMessage1, "payerService"));
        this.verifyFormatField(this.payerRegion, "^.{0,2}$", String.format(errorMessage1, "payerRegion"));
        this.verifyFormatField(this.modifier1, "^.{0,2}$", String.format(errorMessage1, "modifier1"));
        this.verifyFormatField(this.modifier2, "^.{0,2}$", String.format(errorMessage1, "modifier2"));
        this.verifyFormatField(this.modifier3, "^.{0,2}$", String.format(errorMessage1, "modifier3"));
        this.verifyFormatField(this.modifier4, "^.{0,2}$", String.format(errorMessage1, "modifier4"));
    }

    public static void verifyFormatFieldOfData(List<ClientProgModel> clientProgList) {
        for (ClientProgModel recordCsv: clientProgList){
            recordCsv.verifyFormatFields();
        }
    }
}
