package com.DWExtractModels.Provider;

import com.mapper.CsvHeader;

public class ProviderGeneralModel {
    @CsvHeader("ProviderQualifier")
    private String providerQualifier;

    @CsvHeader("ProviderID")
    private String providerID;

    @CsvHeader("ProviderName")
    private String providerName;

    @CsvHeader("ProviderDoingBusinessAs")
    private String providerDoingBusinessAs;

    @CsvHeader("AddressLine1")
    private String addressLine1;

    @CsvHeader("AddressLine2")
    private String addressLine2;

    @CsvHeader("AddressCity")
    private String addressCity;

    @CsvHeader("AddressState")
    private String addressState;

    @CsvHeader("AddressZip")
    private String addressZip;

    @CsvHeader("County")
    private String county;

    @CsvHeader("AgencyPhone")
    private String agencyPhone;

    @CsvHeader("AgencyEmail")
    private String agencyEmail;

    @CsvHeader("PrimaryContactLastName")
    private String primaryContactLastName;

    @CsvHeader("PrimaryContactFirstName")
    private String primaryContactFirstName;

    @CsvHeader("ProviderFax")
    private String providerFax;

    @CsvHeader("ProviderNPI")
    private String providerNPI;

    @CsvHeader("ProviderAPI")
    private String providerAPI;

    @CsvHeader("ProviderMedicaidID")
    private String providerMedicaidID;

    @CsvHeader("SSN")
    private String sSN;

    @CsvHeader("TaxID")
    private String taxID;

    @CsvHeader("ProviderTaxonomy")
    private String providerTaxonomy;

    @CsvHeader("ProviderRequireAuth")
    private String providerRequireAuth;

    @CsvHeader("ProviderTimeZone")
    private String providerTimeZone;

    @CsvHeader("ProviderDateBegin")
    private String providerDateBegin;

    @CsvHeader("ProviderDateEnd")
    private String providerDateEnd;

    public String getProviderQualifier() {
        return providerQualifier;
    }

    public void setProviderQualifier(String providerQualifier) {
        this.providerQualifier = providerQualifier;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderDoingBusinessAs() {
        return providerDoingBusinessAs;
    }

    public void setProviderDoingBusinessAs(String providerDoingBusinessAs) {
        this.providerDoingBusinessAs = providerDoingBusinessAs;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAgencyPhone() {
        return agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    public String getAgencyEmail() {
        return agencyEmail;
    }

    public void setAgencyEmail(String agencyEmail) {
        this.agencyEmail = agencyEmail;
    }

    public String getPrimaryContactLastName() {
        return primaryContactLastName;
    }

    public void setPrimaryContactLastName(String primaryContactLastName) {
        this.primaryContactLastName = primaryContactLastName;
    }

    public String getPrimaryContactFirstName() {
        return primaryContactFirstName;
    }

    public void setPrimaryContactFirstName(String primaryContactFirstName) {
        this.primaryContactFirstName = primaryContactFirstName;
    }

    public String getProviderFax() {
        return providerFax;
    }

    public void setProviderFax(String providerFax) {
        this.providerFax = providerFax;
    }

    public String getProviderNPI() {
        return providerNPI;
    }

    public void setProviderNPI(String providerNPI) {
        this.providerNPI = providerNPI;
    }

    public String getProviderAPI() {
        return providerAPI;
    }

    public void setProviderAPI(String providerAPI) {
        this.providerAPI = providerAPI;
    }

    public String getProviderMedicaidID() {
        return providerMedicaidID;
    }

    public void setProviderMedicaidID(String providerMedicaidID) {
        this.providerMedicaidID = providerMedicaidID;
    }

    public String getsSN() {
        return sSN;
    }

    public void setsSN(String sSN) {
        this.sSN = sSN;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public String getProviderTaxonomy() {
        return providerTaxonomy;
    }

    public void setProviderTaxonomy(String providerTaxonomy) {
        this.providerTaxonomy = providerTaxonomy;
    }

    public String getProviderRequireAuth() {
        return providerRequireAuth;
    }

    public void setProviderRequireAuth(String providerRequireAuth) {
        this.providerRequireAuth = providerRequireAuth;
    }

    public String getProviderTimeZone() {
        return providerTimeZone;
    }

    public void setProviderTimeZone(String providerTimeZone) {
        this.providerTimeZone = providerTimeZone;
    }

    public String getProviderDateBegin() {
        return providerDateBegin;
    }

    public void setProviderDateBegin(String providerDateBegin) {
        this.providerDateBegin = providerDateBegin;
    }

    public String getProviderDateEnd() {
        return providerDateEnd;
    }

    public void setProviderDateEnd(String providerDateEnd) {
        this.providerDateEnd = providerDateEnd;
    }

    @Override
    public String toString() {
        String toString = "ProviderGeneralModel{" +
                "providerQualifier='" + providerQualifier + '\'' +
                "providerID='" + providerID + '\'' +
                "providerName='" + providerName + '\'' +
                "providerDoingBusinessAs='" + providerDoingBusinessAs + '\'' +
                "addressLine1='" + addressLine1 + '\'' +
                "addressLine2='" + addressLine2 + '\'' +
                "addressCity='" + addressCity + '\'' +
                "addressState='" + addressState + '\'' +
                "addressZip='" + addressZip + '\'' +
                "county='" + county + '\'' +
                "agencyPhone='" + agencyPhone + '\'' +
                "agencyEmail='" + agencyEmail + '\'' +
                "primaryContactLastName='" + primaryContactLastName + '\'' +
                "primaryContactFirstName='" + primaryContactFirstName + '\'' +
                "providerFax='" + providerFax + '\'' +
                "providerNPI='" + providerNPI + '\'' +
                "providerAPI='" + providerAPI + '\'' +
                "providerMedicaidID='" + providerMedicaidID + '\'' +
                "sSN='" + sSN + '\'' +
                "taxID='" + taxID + '\'' +
                "providerTaxonomy='" + providerTaxonomy + '\'' +
                "providerRequireAuth='" + providerRequireAuth + '\'' +
                "providerTimeZone='" + providerTimeZone + '\'' +
                "providerDateBegin='" + providerDateBegin + '\'' +
                "providerDateEnd='" + providerDateEnd + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
