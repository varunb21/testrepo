package com.config;

import java.util.TimeZone;

public class Configuration {
    boolean headless;
    boolean reuse;
    String browser;
    int polling;
    int timeout;
    String dateFormat;
    String timeFormat;
    String timeZone;
    String datetimeFormat;

    public Configuration() {
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getTimeFormat() {
        return this.timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getDatetimeFormat() {
        return this.datetimeFormat;
    }

    public void setDatetimeFormat(String datetimeFormat) {
        this.datetimeFormat = datetimeFormat;
    }

    public boolean isHeadless() {
        return this.headless;
    }

    public void setHeadless(boolean headless) {
        this.headless = headless;
    }

    public String getBrowser() {
        return this.browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public int getPolling() {
        return this.polling;
    }

    public void setPolling(int polling) {
        this.polling = polling;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public TimeZone getTimeZone() {
        return TimeZone.getTimeZone(this.timeZone);
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isReuse() {
        return this.reuse;
    }

    public void setReuse(boolean reuse) {
        this.reuse = reuse;
    }
}