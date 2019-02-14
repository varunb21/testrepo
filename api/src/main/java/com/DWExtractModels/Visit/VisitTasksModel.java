package com.DWExtractModels.Visit;

import com.mapper.CsvHeader;

public class VisitTasksModel {
    @CsvHeader("VisitKey")
    private String visitKey;

    @CsvHeader("TaskID")
    private String taskID;

    @CsvHeader("TaskReading")
    private String taskReading;

    @CsvHeader("TaskRefused")
    private String taskRefused;

    @CsvHeader("TaskUnit")
    private String taskUnit;

    @CsvHeader("CallKey")
    private String callKey;

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

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskReading() {
        return taskReading;
    }

    public void setTaskReading(String taskReading) {
        this.taskReading = taskReading;
    }

    public String getTaskRefused() {
        return taskRefused;
    }

    public void setTaskRefused(String taskRefused) {
        this.taskRefused = taskRefused;
    }

    public String getTaskUnit() {
        return taskUnit;
    }

    public void setTaskUnit(String taskUnit) {
        this.taskUnit = taskUnit;
    }

    public String getCallKey() {
        return callKey;
    }

    public void setCallKey(String callKey) {
        this.callKey = callKey;
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
        String toString = "VisitTasksModel{" +
                "visitKey='" + visitKey + '\'' +
                "taskID='" + taskID + '\'' +
                "taskReading='" + taskReading + '\'' +
                "taskRefused='" + taskRefused + '\'' +
                "taskUnit='" + taskUnit + '\'' +
                "callKey='" + callKey + '\'' +
                "recordUpdatedBy='" + recordUpdatedBy + '\'' +
                "recordUpdateDateTime='" + recordUpdateDateTime + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
