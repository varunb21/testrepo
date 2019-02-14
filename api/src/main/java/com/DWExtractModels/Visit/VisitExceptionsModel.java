package com.DWExtractModels.Visit;

import com.mapper.CsvHeader;

public class VisitExceptionsModel {
    @CsvHeader("VisitKey")
    private String visitKey;

    @CsvHeader("ExceptionID")
    private String exceptionID;

    @CsvHeader("ExceptionAcknowledged")
    private String exceptionAcknowledged;

    public String getVisitKey() {
        return visitKey;
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public String getExceptionID() {
        return exceptionID;
    }

    public void setExceptionID(String exceptionID) {
        this.exceptionID = exceptionID;
    }

    public String getExceptionAcknowledged() {
        return exceptionAcknowledged;
    }

    public void setExceptionAcknowledged(String exceptionAcknowledged) {
        this.exceptionAcknowledged = exceptionAcknowledged;
    }

    @Override
    public String toString() {
        String toString = "VisitExceptionsModel{" +
                "visitKey='" + visitKey + '\'' +
                "callKey='" + exceptionID + '\'' +
                "callDateTime='" + exceptionAcknowledged + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
