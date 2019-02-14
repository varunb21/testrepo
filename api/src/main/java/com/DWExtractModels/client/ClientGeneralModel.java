package com.DWExtractModels.client;

import com.mapper.Column;
import com.mapper.CsvHeader;
import com.mapper.DateFormat;
import com.utilities.CompareUtil;
import org.testng.Assert;

import java.util.List;

public class ClientGeneralModel {
    @CsvHeader("PayerID")
    @Column("CONTRACT")
    private String payerID;

    @Column("PROVIDER_ID")
    @CsvHeader("ProviderID")
    private String providerID;

    @CsvHeader("ClientID")
    @Column("LOC")
    private String clientID;

    @CsvHeader("ClientPayerID")
    private String clientPayerID;

    @CsvHeader("ClientFirstName")
    @Column("F_NAME")
    private String clientFirstName;

    @CsvHeader("ClientMiddleName")
    @Column("M_NAME")
    private String clientMiddleName;

    @CsvHeader("ClientLastName")
    @Column("L_NAME")
    private String clientLastName;

    @CsvHeader("MissingMedicaidID")
    private String missingMedicaidID;

    @CsvHeader("ClientSSN")
    @Column("CLIENT_SSN")
    private String clientSSN;

    @CsvHeader("ClientMedicalRecordNum")
    @Column("AR_NO")
    private String clientMedicalRecordNum;

    @CsvHeader("ClientMedicaidID")
    @Column("MEDICAID_ID")
    private String clientMedicaidID;

    @CsvHeader("ClientCustomID")
    @Column("ClientCustomID")
    private String clientCustomID;

    @CsvHeader("ClientOtherID")
    @Column("ClientOtherID")
    private String clientOtherID;

    @CsvHeader("ClientSuffix")
    @Column("NAME_SUFFIX")
    private String clientSuffix;

    @CsvHeader("CaseManager")
    @Column("CASE_MANAGER")
    private String caseManager;

    @CsvHeader("ClientCaseManagerEmail")
    @Column("CASE_MANAGER_E_MAIL")
    private String clientCaseManagerEmail;

    @CsvHeader("Coordinator")
    @Column("SPV")
    private String coordinator;

    @CsvHeader("ClientCoordinatorEmail")
    @Column("SPV_E_MAIL")
    private String clientCoordinatorEmail;

    @CsvHeader("ClientLanguage")
    @Column("LANGUAGE")
    private String clientLanguage;

    @CsvHeader("ClientGender")
    @Column("SEX")
    private String clientGender;

    @CsvHeader("ClientMaritalStatus")
    @Column("MARITAL_STATUS_CODE")
    private String clientMaritalStatus;

    @CsvHeader("ClientBirthDate")
    @Column("DOB")
    @DateFormat("YYYY-MM-DD")
    private String clientBirthDate;

    @CsvHeader("ClientEmail")
    @Column("E_MAIL")
    private String clientEmail;

    @CsvHeader("ClientPriority")
    @Column("CLIENT_PRIORITY")
    private String clientPriority;

    @CsvHeader("ClientTimeZone")
    @Column("TZNAME")
    private String clientTimeZone;

    @CsvHeader("ClientDesigneeFirstName")
    @Column("user_f_name")
    private String clientDesigneeFirstName;

    @CsvHeader("ClientDesigneeLastName")
    @Column("user_l_name")
    private String clientDesigneeLastName;

    @CsvHeader("ClientDesigneeEmail")
    @Column("username")
    private String clientDesigneeEmail;

    @CsvHeader("ClientDesigneeStatus")
    @Column("account_status")
    private String clientDesigneeStatus;

    @CsvHeader("ClientDesigneeStartDate")
    @Column("created")
    private String clientDesigneeStartDate;

    @CsvHeader("ClientDesigneeEndDate")
    @Column("ClientDesigneeEndDate")
    private String clientDesigneeEndDate;

    @CsvHeader("ClientContactType")
    @Column("CONTACT_RELATIONSHIP")
    private String clientContactType;

    @CsvHeader("ClientContactFirstName")
    @Column("ClientContactFirstName")
    private String clientContactFirstName;

    @CsvHeader("ClientContactLastName")
    @Column("ClientContactLastName")
    private String clientContactLastName;

    @CsvHeader("ClientContactPhoneType")
    @Column("ClientContactPhoneType")
    private String clientContactPhoneType;

    @CsvHeader("ClientContactPhone")
    @Column("ClientContactPhone")
    private String clientContactPhone;

    @CsvHeader("ClientContactEmailAddress")
    @Column("ClientContactEmailAddress")
    private String clientContactEmailAddress;

    @CsvHeader("ClientContactAddressLine1")
    @Column("ClientContactAddressLine1")
    private String clientContactAddressLine1;

    @CsvHeader("ClientContactAddressLine2")
    @Column("ClientContactAddressLine2")
    private String clientContactAddressLine2;

    @CsvHeader("ClientContactCity")
    @Column("CITY")
    private String clientContactCity;

    @CsvHeader("ClientContactState")
    @Column("STATE")
    private String clientContactState;

    @CsvHeader("ClientContactZip")
    @Column("ZIP_CODE")
    private String clientContactZip;

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

    public String getClientPayerID() {
        return clientPayerID;
    }

    public void setClientPayerID(String clientPayerID) {
        this.clientPayerID = clientPayerID;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientMiddleName() {
        return clientMiddleName;
    }

    public void setClientMiddleName(String clientMiddleName) {
        this.clientMiddleName = clientMiddleName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getMissingMedicaidID() {
        return missingMedicaidID;
    }

    public void setMissingMedicaidID(String missingMedicaidID) {
        this.missingMedicaidID = missingMedicaidID;
    }

    public String getClientSSN() {
        return clientSSN;
    }

    public void setClientSSN(String clientSSN) {
        this.clientSSN = clientSSN;
    }

    public String getClientMedicalRecordNum() {
        return clientMedicalRecordNum;
    }

    public void setClientMedicalRecordNum(String clientMedicalRecordNum) {
        this.clientMedicalRecordNum = clientMedicalRecordNum;
    }

    public String getClientMedicaidID() {
        return clientMedicaidID;
    }

    public void setClientMedicaidID(String clientMedicaidID) {
        this.clientMedicaidID = clientMedicaidID;
    }

    public String getClientCustomID() {
        return clientCustomID;
    }

    public void setClientCustomID(String clientCustomID) {
        this.clientCustomID = clientCustomID;
    }

    public String getClientOtherID() {
        return clientOtherID;
    }

    public void setClientOtherID(String clientOtherID) {
        this.clientOtherID = clientOtherID;
    }

    public String getClientSuffix() {
        return clientSuffix;
    }

    public void setClientSuffix(String clientSuffix) {
        this.clientSuffix = clientSuffix;
    }

    public String getCaseManager() {
        return caseManager;
    }

    public void setCaseManager(String caseManager) {
        this.caseManager = caseManager;
    }

    public String getClientCaseManagerEmail() {
        return clientCaseManagerEmail;
    }

    public void setClientCaseManagerEmail(String clientCaseManagerEmail) {
        this.clientCaseManagerEmail = clientCaseManagerEmail;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public String getClientCoordinatorEmail() {
        return clientCoordinatorEmail;
    }

    public void setClientCoordinatorEmail(String clientCoordinatorEmail) {
        this.clientCoordinatorEmail = clientCoordinatorEmail;
    }

    public String getClientLanguage() {
        return clientLanguage;
    }

    public void setClientLanguage(String clientLanguage) {
        this.clientLanguage = clientLanguage;
    }

    public String getClientGender() {
        return clientGender;
    }

    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    public String getClientMaritalStatus() {
        return clientMaritalStatus;
    }

    public void setClientMaritalStatus(String clientMaritalStatus) {
        this.clientMaritalStatus = clientMaritalStatus;
    }

    public String getClientBirthDate() {
        return clientBirthDate;
    }

    public void setClientBirthDate(String clientBirthDate) {
        this.clientBirthDate = clientBirthDate;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPriority() {
        return clientPriority;
    }

    public void setClientPriority(String clientPriority) {
        this.clientPriority = clientPriority;
    }

    public String getClientTimeZone() {
        return clientTimeZone;
    }

    public void setClientTimeZone(String clientTimeZone) {
        this.clientTimeZone = clientTimeZone;
    }

    public String getClientDesigneeFirstName() {
        return clientDesigneeFirstName;
    }

    public void setClientDesigneeFirstName(String clientDesigneeFirstName) {
        this.clientDesigneeFirstName = clientDesigneeFirstName;
    }

    public String getClientDesigneeLastName() {
        return clientDesigneeLastName;
    }

    public void setClientDesigneeLastName(String clientDesigneeLastName) {
        this.clientDesigneeLastName = clientDesigneeLastName;
    }

    public String getClientDesigneeEmail() {
        return clientDesigneeEmail;
    }

    public void setClientDesigneeEmail(String clientDesigneeEmail) {
        this.clientDesigneeEmail = clientDesigneeEmail;
    }

    public String getClientDesigneeStatus() {
        return clientDesigneeStatus;
    }

    public void setClientDesigneeStatus(String clientDesigneeStatus) {
        this.clientDesigneeStatus = clientDesigneeStatus;
    }

    public String getClientDesigneeStartDate() {
        return clientDesigneeStartDate;
    }

    public void setClientDesigneeStartDate(String clientDesigneeStartDate) {
        this.clientDesigneeStartDate = clientDesigneeStartDate;
    }

    public String getClientDesigneeEndDate() {
        return clientDesigneeEndDate;
    }

    public void setClientDesigneeEndDate(String clientDesigneeEndDate) {
        this.clientDesigneeEndDate = clientDesigneeEndDate;
    }

    public String getClientContactType() {
        return clientContactType;
    }

    public void setClientContactType(String clientContactType) {
        this.clientContactType = clientContactType;
    }

    public String getClientContactFirstName() {
        return clientContactFirstName;
    }

    public void setClientContactFirstName(String clientContactFirstName) {
        this.clientContactFirstName = clientContactFirstName;
    }

    public String getClientContactLastName() {
        return clientContactLastName;
    }

    public void setClientContactLastName(String clientContactLastName) {
        this.clientContactLastName = clientContactLastName;
    }

    public String getClientContactPhoneType() {
        return clientContactPhoneType;
    }

    public void setClientContactPhoneType(String clientContactPhoneType) {
        this.clientContactPhoneType = clientContactPhoneType;
    }

    public String getClientContactPhone() {
        return clientContactPhone;
    }

    public void setClientContactPhone(String clientContactPhone) {
        this.clientContactPhone = clientContactPhone;
    }

    public String getClientContactEmailAddress() {
        return clientContactEmailAddress;
    }

    public void setClientContactEmailAddress(String clientContactEmailAddress) {
        this.clientContactEmailAddress = clientContactEmailAddress;
    }

    public String getClientContactAddressLine1() {
        return clientContactAddressLine1;
    }

    public void setClientContactAddressLine1(String clientContactAddressLine1) {
        this.clientContactAddressLine1 = clientContactAddressLine1;
    }

    public String getClientContactAddressLine2() {
        return clientContactAddressLine2;
    }

    public void setClientContactAddressLine2(String clientContactAddressLine2) {
        this.clientContactAddressLine2 = clientContactAddressLine2;
    }

    public String getClientContactCity() {
        return clientContactCity;
    }

    public void setClientContactCity(String clientContactCity) {
        this.clientContactCity = clientContactCity;
    }

    public String getClientContactState() {
        return clientContactState;
    }

    public void setClientContactState(String clientContactState) {
        this.clientContactState = clientContactState;
    }

    public String getClientContactZip() {
        return clientContactZip;
    }

    public void setClientContactZip(String clientContactZip) {
        this.clientContactZip = clientContactZip;
    }

    @Override
    public String toString() {
        String toString = "ClientGeneralModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "clientPayerID='" + clientPayerID + '\'' +
                "clientFirstName='" + clientFirstName + '\'' +
                "clientMiddleName='" + clientMiddleName + '\'' +
                "clientLastName='" + clientLastName + '\'' +
                "missingMedicaidID='" + missingMedicaidID + '\'' +
                "clientSSN='" + clientSSN + '\'' +
                "clientMedicalRecordNum='" + clientMedicalRecordNum + '\'' +
                "clientMedicaidID='" + clientMedicaidID + '\'' +
                "clientCustomID='" + clientCustomID + '\'' +
                "clientOtherID='" + clientOtherID + '\'' +
                "clientSuffix='" + clientSuffix + '\'' +
                "caseManager='" + caseManager + '\'' +
                "clientCaseManagerEmail='" + clientCaseManagerEmail + '\'' +
                "coordinator='" + coordinator + '\'' +
                "clientCoordinatorEmail='" + clientCoordinatorEmail + '\'' +
                "clientLanguage='" + clientLanguage + '\'' +
                "clientGender='" + clientGender + '\'' +
                "clientMaritalStatus='" + clientMaritalStatus + '\'' +
                "clientBirthDate='" + clientBirthDate + '\'' +
                "clientEmail='" + clientEmail + '\'' +
                "clientPriority='" + clientPriority + '\'' +
                "clientTimeZone='" + clientTimeZone + '\'' +
                "clientDesigneeFirstName='" + clientDesigneeFirstName + '\'' +
                "clientDesigneeLastName='" + clientDesigneeLastName + '\'' +
                "clientDesigneeEmail='" + clientDesigneeEmail + '\'' +
                "clientDesigneeStatus='" + clientDesigneeStatus + '\'' +
                "clientDesigneeStartDate='" + clientDesigneeStartDate + '\'' +
                "clientDesigneeEndDate='" + clientDesigneeEndDate + '\'' +
                "clientContactType='" + clientContactType + '\'' +
                "clientContactFirstName='" + clientContactFirstName + '\'' +
                "clientContactLastName='" + clientContactLastName + '\'' +
                "clientContactPhoneType='" + clientContactPhoneType + '\'' +
                "clientContactPhone='" + clientContactPhone + '\'' +
                "clientContactEmailAddress='" + clientContactEmailAddress + '\'' +
                "clientContactAddressLine1='" + clientContactAddressLine1 + '\'' +
                "clientContactAddressLine2='" + clientContactAddressLine2 + '\'' +
                "clientContactCity='" + clientContactCity + '\'' +
                "clientContactState='" + clientContactState + '\'' +
                "clientContactZip='" + clientContactZip + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public void verifyFormatField(String fieldValue, String regex, String errorMessage) {
        if(!fieldValue.equals(null) && !fieldValue.equals(""))
            Assert.assertTrue(fieldValue.matches(regex), errorMessage);
    }

    public void verifyFormatFields() {
        String errorMessage1 = "Length of field %s is not correctly";
        String errorMessage2 = "Format of field %s is not correctly yyyy-MM-dd";
        String errorMessage3 = "Format of field %s is not correctly";
        String regexDateTime = "(^$)|(^[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-2][0-9]:[0-6][0-9]$)";
        this.verifyFormatField(this.payerID, "^\\w{0,64}$",String.format(errorMessage1, "payerID"));
        this.verifyFormatField(this.providerID, "^\\w{0,50}$",String.format(errorMessage1, "providerID"));
        this.verifyFormatField(this.clientID, "^\\w{0,10}",String.format(errorMessage1, "clientID"));
        if(this.clientPayerID != null)
            this.verifyFormatField(this.clientPayerID, "^\\w{0,20}$",String.format(errorMessage1, "clientPayerID"));
        this.verifyFormatField(this.clientFirstName, "^\\w{0,30}$",String.format(errorMessage1, "clientFirstName"));
        this.verifyFormatField(this.clientMiddleName, "^\\w{0,1}$",String.format(errorMessage1, "clientMiddleName"));
        this.verifyFormatField(this.clientLastName, "^\\w{0,30}$",String.format(errorMessage1, "clientLastName"));
        if(this.missingMedicaidID != null)
            this.verifyFormatField(this.missingMedicaidID, "^S|^[True|False]$",String.format(errorMessage3, "missingMedicaidID"));
        this.verifyFormatField(this.clientSSN, "^\\w{0,9}",String.format(errorMessage1, "clientSSN"));
        this.verifyFormatField(this.clientMedicalRecordNum, "^\\w{0,12}$",String.format(errorMessage1, "clientMedicalRecordNum"));
        this.verifyFormatField(this.clientMedicaidID, "^.{0,64}$",String.format(errorMessage1, "clientMedicaidID"));
        this.verifyFormatField(this.clientCustomID, "^\\w{0,24}$",String.format(errorMessage1, "clientCustomID"));
        this.verifyFormatField(this.caseManager, "^\\w{0,25}$",String.format(errorMessage1, "caseManager"));
        this.verifyFormatField(this.clientCaseManagerEmail, "^\\w{0,64}$",String.format(errorMessage1, "clientCaseManagerEmail"));
        this.verifyFormatField(this.coordinator, "^\\w{0,25}$",String.format(errorMessage1, "coordinator"));
        this.verifyFormatField(this.clientCoordinatorEmail, "^\\w{0,64}$",String.format(errorMessage1, "clientCoordinatorEmail"));
        this.verifyFormatField(this.clientLanguage, "^\\w{0,32}$",String.format(errorMessage1, "clientLanguage"));
        this.verifyFormatField(this.clientGender, "^[O|M|F]$|^$",String.format(errorMessage3, "clientGender"));
        this.verifyFormatField(this.clientMaritalStatus, "^[M|S|W|O]$|^$",String.format(errorMessage3, "clientMaritalStatus"));
        this.verifyFormatField(this.clientBirthDate, "^\\w{0,10}$",String.format(errorMessage1, "clientBirthDate"));
        this.verifyFormatField(this.clientEmail, "^.{0,64}$",String.format(errorMessage1, "clientEmail"));
        this.verifyFormatField(this.clientPriority, "^\\w{0,2}$",String.format(errorMessage1, "clientPriority"));
        this.verifyFormatField(this.clientTimeZone, "^.{0,64}$",String.format(errorMessage1, "clientTimeZone"));
        this.verifyFormatField(this.clientDesigneeFirstName, "^\\w{0,30}$",String.format(errorMessage3, "clientDesigneeFirstName"));
        this.verifyFormatField(this.clientDesigneeStatus, "^[02|04]$|^$",String.format(errorMessage1, "clientDesigneeStatus"));
        this.verifyFormatField(this.clientDesigneeStartDate, "^\\w{0,10}$",String.format(errorMessage1, "clientDesigneeStartDate"));
        this.verifyFormatField(this.clientDesigneeEndDate, "^\\w{0,10}$",String.format(errorMessage1, "clientDesigneeEndDate"));
        this.verifyFormatField(this.clientContactType, "^\\w{0,12}$",String.format(errorMessage1, "clientContactType"));
        this.verifyFormatField(this.clientContactFirstName, "^\\w{0,30}$",String.format(errorMessage1, "clientContactFirstName"));
        this.verifyFormatField(this.clientContactLastName, "^\\w{0,64}$",String.format(errorMessage1, "clientContactLastName"));
        this.verifyFormatField(this.clientContactPhoneType, "^(?:Business|Home|Mobile|Other)$",String.format(errorMessage3, "clientContactPhoneType"));
        this.verifyFormatField(this.clientContactPhone, "^\\w{0,10}$",String.format(errorMessage1, "clientContactPhone"));
        this.verifyFormatField(this.clientContactEmailAddress, "^.{0,64}$",String.format(errorMessage1, "clientContactEmailAddress"));
        this.verifyFormatField(this.clientContactAddressLine1, "^.{0,30}$",String.format(errorMessage1, "clientContactAddressLine1"));
        this.verifyFormatField(this.clientContactAddressLine2, "^.{0,30}$",String.format(errorMessage1, "clientContactAddressLine2"));
        this.verifyFormatField(this.clientContactCity, "^.{0,30}$",String.format(errorMessage1, "clientContactCity"));
        this.verifyFormatField(this.clientContactState, "^\\w{0,2}$",String.format(errorMessage1, "clientContactState"));
        this.verifyFormatField(this.clientContactZip, "^\\w{0,9}$",String.format(errorMessage1, "clientContactZip"));
    }

    public static void verifyDataInDbAndCsvCorrectly(List<ClientGeneralModel> recordsCsv){
        for (ClientGeneralModel recordCsv: recordsCsv){
            recordCsv.verifyFormatFields();
        }
    }

    public static void verifyRandomRecordsFieldNotNull(List<ClientGeneralModel> dataList, List<String> definedField) throws IllegalAccessException {
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
