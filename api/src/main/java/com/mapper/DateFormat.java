package com.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface DateFormat {
    String DATE_FORMAT = "YYYY-MM-DD";

    String value() default DATE_FORMAT ;

    SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
}
