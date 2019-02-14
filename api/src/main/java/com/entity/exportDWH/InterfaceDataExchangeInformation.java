package com.entity.exportDWH;

public class InterfaceDataExchangeInformation {
    public String fileNamePattern;
    public String timestamp;
    public String writeHeader;
    public String delimiter;
    public String quote;
    public String recordSeparator;
    public String quoteMode;
    public String pgpPublicKey;

    public String getFileNamePattern() {
        return fileNamePattern;
    }

    public void setFileNamePattern(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getWriteHeader() {
        return writeHeader;
    }

    public void setWriteHeader(String writeHeader) {
        this.writeHeader = writeHeader;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getRecordSeparator() {
        return recordSeparator;
    }

    public void setRecordSeparator(String recordSeparator) {
        this.recordSeparator = recordSeparator;
    }

    public String getQuoteMode() {
        return quoteMode;
    }

    public void setQuoteMode(String quoteMode) {
        this.quoteMode = quoteMode;
    }

    public String getPgpPublicKey() {
        return pgpPublicKey;
    }

    public void setPgpPublicKey(String pgpPublicKey) {
        this.pgpPublicKey = pgpPublicKey;
    }
}
