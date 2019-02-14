package com.DWExtractModels.client;

import com.mapper.CsvHeader;

public class ClientSchedule {
    @CsvHeader("PayerID")
    private String payerID;

    @CsvHeader("ProviderID")
    private String providerID;

    @CsvHeader("ClientID")
    private String clientID;

    @CsvHeader("EmployeeID")
    private String employeeID;

    @CsvHeader("ScheduleID")
    private String scheduleID;

    @CsvHeader("ScheduleStartDate")
    private String scheduleStartDate;

    @CsvHeader("ScheduleStartTime")
    private String scheduleStartTime;

    @CsvHeader("ScheduleEndTime")
    private String scheduleEndTime;

    @CsvHeader("ScheduleDuration")
    private String scheduleDuration;

    @CsvHeader("PayRate")
    private String payRate;

    @CsvHeader("BillRate")
    private String billRate;

    @CsvHeader("ClusterCaseFlag")
    private String clusterCaseFlag;

    @CsvHeader("Discipline")
    private String discipline;

    @CsvHeader("PayerProgram")
    private String payerProgram;

    @CsvHeader("PayerService")
    private String payerService;

    @CsvHeader("VisitType")
    private String visitType;

    @CsvHeader("LiveInCase")
    private String liveInCase;

    @CsvHeader("ScheduleTimeZone")
    private String scheduleTimeZone;

    @CsvHeader("ProcCodeQualifier")
    private String procCodeQualifier;

    @CsvHeader("Modifier1")
    private String modifier1;

    @CsvHeader("Modifier2")
    private String modifier2;

    @CsvHeader("Modifier3")
    private String modifier3;

    @CsvHeader("Modifier4")
    private String modifier4;

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

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getScheduleStartDate() {
        return scheduleStartDate;
    }

    public void setScheduleStartDate(String scheduleStartDate) {
        this.scheduleStartDate = scheduleStartDate;
    }

    public String getScheduleStartTime() {
        return scheduleStartTime;
    }

    public void setScheduleStartTime(String scheduleStartTime) {
        this.scheduleStartTime = scheduleStartTime;
    }

    public String getScheduleEndTime() {
        return scheduleEndTime;
    }

    public void setScheduleEndTime(String scheduleEndTime) {
        this.scheduleEndTime = scheduleEndTime;
    }

    public String getScheduleDuration() {
        return scheduleDuration;
    }

    public void setScheduleDuration(String scheduleDuration) {
        this.scheduleDuration = scheduleDuration;
    }

    public String getPayRate() {
        return payRate;
    }

    public void setPayRate(String payRate) {
        this.payRate = payRate;
    }

    public String getBillRate() {
        return billRate;
    }

    public void setBillRate(String billRate) {
        this.billRate = billRate;
    }

    public String getClusterCaseFlag() {
        return clusterCaseFlag;
    }

    public void setClusterCaseFlag(String clusterCaseFlag) {
        this.clusterCaseFlag = clusterCaseFlag;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
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

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getLiveInCase() {
        return liveInCase;
    }

    public void setLiveInCase(String liveInCase) {
        this.liveInCase = liveInCase;
    }

    public String getScheduleTimeZone() {
        return scheduleTimeZone;
    }

    public void setScheduleTimeZone(String scheduleTimeZone) {
        this.scheduleTimeZone = scheduleTimeZone;
    }

    public String getProcCodeQualifier() {
        return procCodeQualifier;
    }

    public void setProcCodeQualifier(String procCodeQualifier) {
        this.procCodeQualifier = procCodeQualifier;
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

    @Override
    public String toString() {
        String toString = "ClientSchedule{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "employeeID='" + employeeID + '\'' +
                "scheduleID='" + scheduleID + '\'' +
                "scheduleStartDate='" + scheduleStartDate + '\'' +
                "scheduleStartTime='" + scheduleStartTime + '\'' +
                "scheduleEndTime='" + scheduleEndTime + '\'' +
                "scheduleDuration='" + scheduleDuration + '\'' +
                "payRate='" + payRate + '\'' +
                "billRate='" + billRate + '\'' +
                "clusterCaseFlag='" + clusterCaseFlag + '\'' +
                "discipline='" + discipline + '\'' +
                "payerProgram='" + payerProgram + '\'' +
                "payerService='" + payerService + '\'' +
                "visitType='" + visitType + '\'' +
                "liveInCase='" + liveInCase + '\'' +
                "scheduleTimeZone='" + scheduleTimeZone + '\'' +
                "procCodeQualifier='" + procCodeQualifier + '\'' +
                "modifier1='" + modifier1 + '\'' +
                "modifier2='" + modifier2 + '\'' +
                "modifier3='" + modifier3 + '\'' +
                "modifier4='" + modifier4 + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
