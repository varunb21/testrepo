package com.DWExtractModels.Visit;

import com.mapper.CsvHeader;

public class VisitChanges {
    @CsvHeader("VisitKey")
    private String visitKey;

    @CsvHeader("ChangeID")
    private String changeID;

    @CsvHeader("ChangeType")
    private String changeType;

    @CsvHeader("GroupCode")
    private String groupCode;

    @CsvHeader("SequenceID")
    private String sequenceID;

    @CsvHeader("VisitChangeExternalID")
    private String visitChangeExternalID;

    @CsvHeader("ChangeMadeByEmail")
    private String changeMadeByEmail;

    @CsvHeader("ChangeDateTime")
    private String changeDateTime;

    @CsvHeader("RecordUpdateDateTime")
    private String recordUpdateDateTime;

    @CsvHeader("ReasonCode")
    private String reasonCode;

    @CsvHeader("ChangeReasonMemo")
    private String changeReasonMemo;

    @CsvHeader("ResolutionCode")
    private String resolutionCode;

    @CsvHeader("VisitChangeLogDetails")
    private String visitChangeLogDetails;

    public String getVisitKey() {
        return visitKey;
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public String getChangeID() {
        return changeID;
    }

    public void setChangeID(String changeID) {
        this.changeID = changeID;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getSequenceID() {
        return sequenceID;
    }

    public void setSequenceID(String sequenceID) {
        this.sequenceID = sequenceID;
    }

    public String getVisitChangeExternalID() {
        return visitChangeExternalID;
    }

    public void setVisitChangeExternalID(String visitChangeExternalID) {
        this.visitChangeExternalID = visitChangeExternalID;
    }

    public String getChangeMadeByEmail() {
        return changeMadeByEmail;
    }

    public void setChangeMadeByEmail(String changeMadeByEmail) {
        this.changeMadeByEmail = changeMadeByEmail;
    }

    public String getChangeDateTime() {
        return changeDateTime;
    }

    public void setChangeDateTime(String changeDateTime) {
        this.changeDateTime = changeDateTime;
    }

    public String getRecordUpdateDateTime() {
        return recordUpdateDateTime;
    }

    public void setRecordUpdateDateTime(String recordUpdateDateTime) {
        this.recordUpdateDateTime = recordUpdateDateTime;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getChangeReasonMemo() {
        return changeReasonMemo;
    }

    public void setChangeReasonMemo(String changeReasonMemo) {
        this.changeReasonMemo = changeReasonMemo;
    }

    public String getResolutionCode() {
        return resolutionCode;
    }

    public void setResolutionCode(String resolutionCode) {
        this.resolutionCode = resolutionCode;
    }

    public String getVisitChangeLogDetails() {
        return visitChangeLogDetails;
    }

    public void setVisitChangeLogDetails(String visitChangeLogDetails) {
        this.visitChangeLogDetails = visitChangeLogDetails;
    }

    @Override
    public String toString() {
        String toString = "VisitCallsModel{" +
                "visitKey='" + visitKey + '\'' +
                "changeID='" + changeID + '\'' +
                "changeType='" + changeType + '\'' +
                "groupCode='" + groupCode + '\'' +
                "sequenceID='" + sequenceID + '\'' +
                "visitChangeExternalID='" + visitChangeExternalID + '\'' +
                "changeMadeByEmail='" + changeMadeByEmail + '\'' +
                "changeDateTime='" + changeDateTime + '\'' +
                "recordUpdateDateTime='" + recordUpdateDateTime + '\'' +
                "reasonCode='" + reasonCode + '\'' +
                "changeReasonMemo='" + changeReasonMemo + '\'' +
                "resolutionCode='" + resolutionCode + '\'' +
                "visitChangeLogDetails='" + visitChangeLogDetails + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
