package com.utilities;

import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {

    /**
     * Get current time from a format
     * @param format: The patent format, example: "yyyy-MM-dd'T'HH:mm:ss";
     * @return  The string format example: 2018-12-27 12:45:33
     */
    public  String getCurrentTimeWithFormat(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Date date = new Date();
        System.out.println("Current time: " + dateFormat.format(date));
        return dateFormat.format(date);
    }

    /**
     * Add the days in to the string date
     * Example: 2018-12-27 12:45:33  add amount = 1 to result: 2018-13-27 12:45:33
     * @param stringDate : the string date
     * @param dateFormat: the format date
     * @param amount: number of date
     * @return The string date after add a number of days.
     * @throws ParseException
     */
    public String addDaysToStringDate(String stringDate, String dateFormat, int amount) throws ParseException {
        Date newDate = DateUtils.addDays(new SimpleDateFormat(dateFormat).parse(stringDate), amount);
        return new SimpleDateFormat(dateFormat).format(newDate);
    }

    /**
     * Format the days in to new format string date
     * Example: 2018-12-27 format date from yyyy-MM-dd to ddMMYYYY result: 27122018
     * @param value : the string date
     * @param currentFormat: the current format date
     * @param newFormat: the new format date
     * @return The string date after apply new date format.
     * @throws ParseException
     */
    public String formatStringDate(String value, String currentFormat, String newFormat) throws ParseException {
        return new SimpleDateFormat(newFormat).format(new SimpleDateFormat(currentFormat).parse(value));
    }
}
