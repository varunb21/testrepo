package com.DWExtractModels.Visit;

import com.mapper.CsvHeader;

public class VisitGeneralModel {
    @CsvHeader("PayerID")
    private String payerID;

    @CsvHeader("ProviderID")
    private String providerID;

    @CsvHeader("ClientID")
    private String clientID;

    @CsvHeader("EmployeeID")
    private String employeeID;

    @CsvHeader("GroupCode")
    private String groupCode;

    @CsvHeader("VisitKey")
    private String visitKey;

    @CsvHeader("VisitOtherID")
    private String visitOtherID;

    @CsvHeader("VisitCancelledIndicator")
    private String visitCancelledIndicator;

    @CsvHeader("PayerProgram")
    private String payerProgram;

    @CsvHeader("ProcedureCode")
    private String procedureCode;

    @CsvHeader("Timezone")
    private String timezone;

    @CsvHeader("CallInDateTime")
    private String callInDateTime;

    @CsvHeader("CallOutDateTime")
    private String callOutDateTime;

    @CsvHeader("ActDuration")
    private String actDuration;

    @CsvHeader("AdjBeginningDateTime")
    private String adjBeginningDateTime;

    @CsvHeader("AdjEndDateTime")
    private String adjEndDateTime;

    @CsvHeader("AdjDuration")
    private String adjDuration;

    @CsvHeader("BillVisit")
    private String billVisit;

    @CsvHeader("BillTime")
    private String billTime;

    @CsvHeader("PayTime")
    private String payTime;

    @CsvHeader("Memo")
    private String memo;

    @CsvHeader("EmpVoiceVerification")
    private String empVoiceVerification;

    @CsvHeader("ClientVerifiedTimes")
    private String clientVerifiedTimes;

    @CsvHeader("ClientVerifiedService")
    private String clientVerifiedService;

    @CsvHeader("ClientVerifiedTasks")
    private String clientVerifiedTasks;

    @CsvHeader("ClientSignatureAvailable")
    private String clientSignatureAvailable;

    @CsvHeader("ClientVoiceRecording")
    private String clientVoiceRecording;

    @CsvHeader("ClientVoiceVerification")
    private String clientVoiceVerification;

    @CsvHeader("Modifier1")
    private String modifier1;

    @CsvHeader("Modifier2")
    private String modifier2;

    @CsvHeader("Modifier3")
    private String modifier3;

    @CsvHeader("Modifier4")
    private String modifier4;

    @CsvHeader("VisitStatus")
    private String visitStatus;

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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getVisitKey() {
        return visitKey;
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public String getVisitOtherID() {
        return visitOtherID;
    }

    public void setVisitOtherID(String visitOtherID) {
        this.visitOtherID = visitOtherID;
    }

    public String getVisitCancelledIndicator() {
        return visitCancelledIndicator;
    }

    public void setVisitCancelledIndicator(String visitCancelledIndicator) {
        this.visitCancelledIndicator = visitCancelledIndicator;
    }

    public String getPayerProgram() {
        return payerProgram;
    }

    public void setPayerProgram(String payerProgram) {
        this.payerProgram = payerProgram;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCallInDateTime() {
        return callInDateTime;
    }

    public void setCallInDateTime(String callInDateTime) {
        this.callInDateTime = callInDateTime;
    }

    public String getCallOutDateTime() {
        return callOutDateTime;
    }

    public void setCallOutDateTime(String callOutDateTime) {
        this.callOutDateTime = callOutDateTime;
    }

    public String getActDuration() {
        return actDuration;
    }

    public void setActDuration(String actDuration) {
        this.actDuration = actDuration;
    }

    public String getAdjBeginningDateTime() {
        return adjBeginningDateTime;
    }

    public void setAdjBeginningDateTime(String adjBeginningDateTime) {
        this.adjBeginningDateTime = adjBeginningDateTime;
    }

    public String getAdjEndDateTime() {
        return adjEndDateTime;
    }

    public void setAdjEndDateTime(String adjEndDateTime) {
        this.adjEndDateTime = adjEndDateTime;
    }

    public String getAdjDuration() {
        return adjDuration;
    }

    public void setAdjDuration(String adjDuration) {
        this.adjDuration = adjDuration;
    }

    public String getBillVisit() {
        return billVisit;
    }

    public void setBillVisit(String billVisit) {
        this.billVisit = billVisit;
    }

    public String getBillTime() {
        return billTime;
    }

    public void setBillTime(String billTime) {
        this.billTime = billTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getEmpVoiceVerification() {
        return empVoiceVerification;
    }

    public void setEmpVoiceVerification(String empVoiceVerification) {
        this.empVoiceVerification = empVoiceVerification;
    }

    public String getClientVerifiedTimes() {
        return clientVerifiedTimes;
    }

    public void setClientVerifiedTimes(String clientVerifiedTimes) {
        this.clientVerifiedTimes = clientVerifiedTimes;
    }

    public String getClientVerifiedService() {
        return clientVerifiedService;
    }

    public void setClientVerifiedService(String clientVerifiedService) {
        this.clientVerifiedService = clientVerifiedService;
    }

    public String getClientVerifiedTasks() {
        return clientVerifiedTasks;
    }

    public void setClientVerifiedTasks(String clientVerifiedTasks) {
        this.clientVerifiedTasks = clientVerifiedTasks;
    }

    public String getClientSignatureAvailable() {
        return clientSignatureAvailable;
    }

    public void setClientSignatureAvailable(String clientSignatureAvailable) {
        this.clientSignatureAvailable = clientSignatureAvailable;
    }

    public String getClientVoiceRecording() {
        return clientVoiceRecording;
    }

    public void setClientVoiceRecording(String clientVoiceRecording) {
        this.clientVoiceRecording = clientVoiceRecording;
    }

    public String getClientVoiceVerification() {
        return clientVoiceVerification;
    }

    public void setClientVoiceVerification(String clientVoiceVerification) {
        this.clientVoiceVerification = clientVoiceVerification;
    }

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

    public String getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(String visitStatus) {
        this.visitStatus = visitStatus;
    }

    @Override
    public String toString() {
        String toString = "VisitGeneralModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "employeeID='" + employeeID + '\'' +
                "groupCode='" + groupCode + '\'' +
                "visitKey='" + visitKey + '\'' +
                "visitOtherID='" + visitOtherID + '\'' +
                "visitCancelledIndicator='" + visitCancelledIndicator + '\'' +
                "payerProgram='" + payerProgram + '\'' +
                "procedureCode='" + procedureCode + '\'' +
                "timezone='" + timezone + '\'' +
                "callInDateTime='" + callInDateTime + '\'' +
                "callOutDateTime='" + callOutDateTime + '\'' +
                "actDuration='" + actDuration + '\'' +
                "adjBeginningDateTime='" + adjBeginningDateTime + '\'' +
                "adjEndDateTime='" + adjEndDateTime + '\'' +
                "adjDuration='" + adjDuration + '\'' +
                "billVisit='" + billVisit + '\'' +
                "billTime='" + billTime + '\'' +
                "payTime='" + payTime + '\'' +
                "memo='" + memo + '\'' +
                "empVoiceVerification='" + empVoiceVerification + '\'' +
                "clientVerifiedTimes='" + clientVerifiedTimes + '\'' +
                "clientVerifiedService='" + clientVerifiedService + '\'' +
                "clientVerifiedTasks='" + clientVerifiedTasks + '\'' +
                "clientSignatureAvailable='" + clientSignatureAvailable + '\'' +
                "clientVoiceRecording='" + clientVoiceRecording + '\'' +
                "clientVoiceVerification='" + clientVoiceVerification + '\'' +
                "modifier1='" + modifier1 + '\'' +
                "modifier2='" + modifier2 + '\'' +
                "modifier3='" + modifier3 + '\'' +
                "modifier4='" + modifier4 + '\'' +
                "visitStatus='" + visitStatus + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
