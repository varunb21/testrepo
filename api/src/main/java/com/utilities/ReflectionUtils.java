package com.utilities;

import com.mapper.CsvHeader;
import com.mapper.DateFormat;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by lannguyen on 8/8/2018.
 */
//Get field of extends Obj, if not found, will get from supper class
/**/
public class ReflectionUtils {

    private ReflectionUtils(){}

    private static Field getField(Object instance, String fieldName) {

        Class currentClass = instance.getClass();
        do {
            for (Field field : currentClass.getDeclaredFields()) {
                if (field.getName().equals(fieldName)) {
                    return field;
                }
            }
            currentClass = currentClass.getSuperclass();
        } while (currentClass != null);

        return null;
    }

    /*Get value of each fieldname*/
    public static String getFieldValue(Object instance, String fieldName) throws IllegalAccessException {
        Field field = getField(instance, fieldName); // yyyy-MM-dd HH-mm

        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        Object value = field.get(instance);
        String valueAsString = null;
        // convert
        if (value instanceof Date) {
            DateFormat dateFormat = field.getAnnotation(DateFormat.class);
            if (dateFormat != null) {
                String sdf = dateFormat.value();
                SimpleDateFormat df = new SimpleDateFormat(sdf);
                valueAsString = df.format(value);
            }
        } else if (value instanceof BigDecimal) {
            valueAsString = ((BigDecimal) value).intValue() + "";
        } else {
            valueAsString = value != null ? String.valueOf(value) : null;
        }

        return valueAsString;
    }

    public static String getAnnotationValue(Object instance, String fieldName){
        Field field = getField(instance, fieldName);
        assert field != null;
        CsvHeader header = field.getAnnotation(CsvHeader.class);
        return header.value();
    }

    public static List<Field> getAllFields(Class clazz) {

        List<Field> myFields = new ArrayList<>();
        Class currentClass = clazz;
        do {
            myFields.addAll(Arrays.asList(currentClass.getDeclaredFields()));
            currentClass = currentClass.getSuperclass();
        } while (currentClass != null);

        return myFields;
    }
}
