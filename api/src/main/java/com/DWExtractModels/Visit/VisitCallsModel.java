package com.DWExtractModels.Visit;

import com.mapper.CsvHeader;

public class VisitCallsModel {
    @CsvHeader("VisitKey")
    private String visitKey;

    @CsvHeader("CallKey")
    private String callKey;

    @CsvHeader("CallDateTime")
    private String callDateTime;

    @CsvHeader("CallAssignment")
    private String callAssignment;

    @CsvHeader("CallType")
    private String callType;

    @CsvHeader("ProcedureCode")
    private String procedureCode;

    @CsvHeader("ClientIdentifierOnCall")
    private String clientIdentifierOnCall;

    @CsvHeader("ServiceEnteredOnCall")
    private String serviceEnteredOnCall;

    @CsvHeader("MobileLogin")
    private String mobileLogin;

    @CsvHeader("VisitLocation")
    private String visitLocation;

    @CsvHeader("VisitNotes")
    private String visitNotes;

    @CsvHeader("CallLatitude")
    private String callLatitude;

    @CsvHeader("CallLongitude")
    private String callLongitude;

    @CsvHeader("TelephonyPIN")
    private String telephonyPIN;

    @CsvHeader("CallTimeZone")
    private String callTimeZone;

    @CsvHeader("OriginatingPhoneNumber")
    private String originatingPhoneNumber;

    @CsvHeader("RecordUpdatedBy")
    private String recordUpdatedBy;

    @CsvHeader("RecordUpdateDateTime")
    private String recordUpdateDateTime;

    public String getVisitKey() {
        return visitKey;
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public String getCallKey() {
        return callKey;
    }

    public void setCallKey(String callKey) {
        this.callKey = callKey;
    }

    public String getCallDateTime() {
        return callDateTime;
    }

    public void setCallDateTime(String callDateTime) {
        this.callDateTime = callDateTime;
    }

    public String getCallAssignment() {
        return callAssignment;
    }

    public void setCallAssignment(String callAssignment) {
        this.callAssignment = callAssignment;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public String getClientIdentifierOnCall() {
        return clientIdentifierOnCall;
    }

    public void setClientIdentifierOnCall(String clientIdentifierOnCall) {
        this.clientIdentifierOnCall = clientIdentifierOnCall;
    }

    public String getServiceEnteredOnCall() {
        return serviceEnteredOnCall;
    }

    public void setServiceEnteredOnCall(String serviceEnteredOnCall) {
        this.serviceEnteredOnCall = serviceEnteredOnCall;
    }

    public String getMobileLogin() {
        return mobileLogin;
    }

    public void setMobileLogin(String mobileLogin) {
        this.mobileLogin = mobileLogin;
    }

    public String getVisitLocation() {
        return visitLocation;
    }

    public void setVisitLocation(String visitLocation) {
        this.visitLocation = visitLocation;
    }

    public String getVisitNotes() {
        return visitNotes;
    }

    public void setVisitNotes(String visitNotes) {
        this.visitNotes = visitNotes;
    }

    public String getCallLatitude() {
        return callLatitude;
    }

    public void setCallLatitude(String callLatitude) {
        this.callLatitude = callLatitude;
    }

    public String getCallLongitude() {
        return callLongitude;
    }

    public void setCallLongitude(String callLongitude) {
        this.callLongitude = callLongitude;
    }

    public String getTelephonyPIN() {
        return telephonyPIN;
    }

    public void setTelephonyPIN(String telephonyPIN) {
        this.telephonyPIN = telephonyPIN;
    }

    public String getCallTimeZone() {
        return callTimeZone;
    }

    public void setCallTimeZone(String callTimeZone) {
        this.callTimeZone = callTimeZone;
    }

    public String getOriginatingPhoneNumber() {
        return originatingPhoneNumber;
    }

    public void setOriginatingPhoneNumber(String originatingPhoneNumber) {
        this.originatingPhoneNumber = originatingPhoneNumber;
    }

    public String getRecordUpdatedBy() {
        return recordUpdatedBy;
    }

    public void setRecordUpdatedBy(String recordUpdatedBy) {
        this.recordUpdatedBy = recordUpdatedBy;
    }

    public String getRecordUpdateDateTime() {
        return recordUpdateDateTime;
    }

    public void setRecordUpdateDateTime(String recordUpdateDateTime) {
        this.recordUpdateDateTime = recordUpdateDateTime;
    }

    @Override
    public String toString() {
        String toString = "VisitCallsModel{" +
                "visitKey='" + visitKey + '\'' +
                "callKey='" + callKey + '\'' +
                "callDateTime='" + callDateTime + '\'' +
                "callAssignment='" + callAssignment + '\'' +
                "callType='" + callType + '\'' +
                "procedureCode='" + procedureCode + '\'' +
                "clientIdentifierOnCall='" + clientIdentifierOnCall + '\'' +
                "serviceEnteredOnCall='" + serviceEnteredOnCall + '\'' +
                "mobileLogin='" + mobileLogin + '\'' +
                "visitLocation='" + visitLocation + '\'' +
                "visitNotes='" + visitNotes + '\'' +
                "callLatitude='" + callLatitude + '\'' +
                "callLongitude='" + callLongitude + '\'' +
                "telephonyPIN='" + telephonyPIN + '\'' +
                "callTimeZone='" + callTimeZone + '\'' +
                "originatingPhoneNumber='" + originatingPhoneNumber + '\'' +
                "recordUpdatedBy='" + recordUpdatedBy + '\'' +
                "recordUpdateDateTime='" + recordUpdateDateTime + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
