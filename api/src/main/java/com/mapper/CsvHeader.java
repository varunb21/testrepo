package com.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CsvHeader {
    String DEFAULT_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss.SS";

    String value() default "";
    String dateFormat() default DEFAULT_DATE_FORMAT;

    SimpleDateFormat DEFAULT = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
}