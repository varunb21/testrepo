package com.utilities;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CompareUtil {
    private static final Logger LOGGER = Logger.getLogger(CompareUtil.class);

    public static <T> boolean dataContains(List<T> lstObjectCsv, List<T> lstObjectDb) {
        List<String> lstStringObjectDb = new ArrayList<>();
        boolean isDataCorrect = true;
        for (T ObjectDb: lstObjectCsv){
            lstStringObjectDb.add(ObjectDb.toString());
        }

        for (int i = 0; i< lstObjectDb.size(); i++) {
            if (!lstStringObjectDb.contains(lstObjectDb.get(i).toString())) {
                System.out.println("Row:" + i + '\n');
                System.out.println("From DB : " + lstObjectDb.get(i).toString() + '\n');
                System.out.println("From CSV : " + lstObjectCsv.get(i).toString() + '\n');
                isDataCorrect = false;
                break;
            }
        }
        return isDataCorrect;
    }

    public static boolean isFieldsNull(Object object) throws IllegalAccessException {
        return isFieldsNull(object, Collections.emptyList());
    }

    public static boolean isFieldsNull(Object object, List<String> ignoreFields) throws IllegalAccessException {
        List<Field> allFields = ReflectionUtils.getAllFields(object.getClass());
        for(Field f : allFields) {
            if (ignoreFields.contains(f.getName())) {
                continue;
            }
            f.setAccessible(true);
            if (Objects.nonNull(f.get(object))) {
                LOGGER.info("Found not null field " + f.getName());
                return false;
            }
        }
        return true;
    }

//    public static boolean isSpecificFieldsNull(Object object, List<String> fields) throws IllegalAccessException {
//        List<Field> allFields = ReflectionUtils.getAllFields(object.getClass());
//        for (Field f : allFields) {
//            if (fields.contains(f.getName())) {
//                f.setAccessible(true);
//                if (Objects.nonNull(f.get(object))) {
//                    LOGGER.info("Found not null field " + f.getName());
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public static boolean isSpecificFieldsNull(Object object, List<String> fields) throws IllegalAccessException {
        List<Field> allFields = ReflectionUtils.getAllFields(object.getClass());
        for (Field f : allFields) {
            if (fields.contains(f.getName())) {
                f.setAccessible(true);
                if (Objects.isNull(f.get(object))) {
                    System.out.println("Found null field " + f.getName());
                    return true;
                }
            }
        }
        return false;
    }

    public static <T> boolean dataCompareWithExclusionOfFields(List<T> dataFromDb,
                                                               List<T> dataFromCsv,
                                                               List<String> ignoreFields) {
        boolean isMatched = true;

        List<Field> fields = ReflectionUtils.getAllFields(dataFromDb.get(0).getClass());
        List<String> fieldNames = new ArrayList<>();

        fields.forEach(field -> fieldNames.add(field.getName()));
        ignoreFields.forEach(fieldNames::remove);
        LOGGER.info("Fields are not compare : " + ignoreFields);
        LOGGER.info("Fields to compare : " + fieldNames);
        StringBuilder recordDb = new StringBuilder();
        StringBuilder recordCsv = new StringBuilder();
        try {
            if (dataFromDb.size() != dataFromCsv.size())
                return false;
            for (int i = 0; i < dataFromDb.size(); i++) {
                String strDB = null;
                String strCsv = null;
                for (String fieldName : fieldNames) {
                    String dbValue = ReflectionUtils.getFieldValue(dataFromDb.get(i), fieldName);
                    recordDb.append(String.format("%s = '%s', ", fieldName, dbValue));

                    String csvValue = ReflectionUtils.getFieldValue(dataFromCsv.get(i), fieldName);
                    recordCsv.append(String.format("%s = '%s', ", fieldName, csvValue));

                    strDB = recordDb.toString().replace("null", "").replace("\r\n", "")
                            .replace("-", "").replace(".00", "");
                    strCsv = recordCsv.toString().replace("null", "").replace("\r\n", "")
                            .replace("-", "").replace(".00", "");
                }
                if (!StringUtils.equalsIgnoreCase(strDB, strCsv)) {
                    isMatched = false;
                    LOGGER.info("DB :" + strDB);
                    LOGGER.info("CSV :" + strCsv);
                }
            }
        } catch (Exception e) {
            return false;
        }
        return isMatched;
    }
}
