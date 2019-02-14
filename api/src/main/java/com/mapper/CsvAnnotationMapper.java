package com.mapper;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableInt;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CsvAnnotationMapper<T> {
    private final Class<T> clazz;
    private final List<Field> fields;


    public List<Field> getAllFields(Class clazz) {

        List<Field> myFields = new ArrayList<>();
        Class currentClass = clazz;
        do {
            myFields.addAll(Arrays.asList(currentClass.getDeclaredFields()));
            currentClass = currentClass.getSuperclass();
        } while (currentClass != null);

        return myFields;
    }

    public CsvAnnotationMapper(Class<T> clazz) {
        this.clazz = clazz;
        fields = getAllFields(clazz);
    }

    public List<T> map(CSVParser parser) throws IOException {
        Map<String, Integer> headerMap = parser.getHeaderMap();
        List<T> result = new ArrayList<>();
        MutableInt rowIndex = new MutableInt(1);
        try {
            parser.getRecords().forEach(r -> {
                rowIndex.increment();
                result.add(map(r, headerMap.keySet()));
            });
        } catch (MappingException e) {
            throw new RuntimeException("Fail to parse row index " + rowIndex.getValue(), e);
        }
        return result;
    }

        public T map(CSVRecord record, Set<String> headerMap) throws MappingException {
        try {
            T rs = clazz.getDeclaredConstructor().newInstance();
            for (Field f : fields) {
                CsvHeader mapping = f.getAnnotation(CsvHeader.class);
                if (Objects.nonNull(mapping)) {
                    String mappingValue = mapping.value().isEmpty() ? StringUtils.capitalize(f.getName()) : mapping.value();
                    if (headerMap.contains(mappingValue)) {
                        String csvValue = record.get(mappingValue);
                        f.setAccessible(true);
                        setFieldValue(rs, f, csvValue);
                    }
                }
            }
            return rs;
        } catch (IllegalAccessException | InstantiationException | ParseException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
            throw new MappingException(e);
        }
    }

//    public T map(CSVRecord record, Set<String> headerMap) throws MappingException {
//        try {
//            T rs = clazz.getDeclaredConstructor().newInstance();
//            for (Field f : fields) {
//                CsvHeader mapping = f.getAnnotation(CsvHeader.class);
//                if (Objects.nonNull(mapping)) {
//                    String mappingValue = mapping.value().isEmpty() ? StringUtils.capitalize(f.getName()) : mapping.value();
//                    if (headerMap.contains(mappingValue)) {
//                        String csvValue = record.get(mappingValue);
//                        f.setAccessible(true);
//                        setFieldValue(rs, f, csvValue);
//                    }
//                }
//            }
//            return rs;
//        } catch (IllegalAccessException | InstantiationException | ParseException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
//            throw new MappingException(e);
//        }
//    }

    private void setFieldValue(Object obj, Field field, String rawValue) throws IllegalAccessException, ParseException, InvocationTargetException {
        Class<?> fieldType = field.getType();
        SimpleDateFormat dateFormat = getDateFormat(field);
        if (Objects.equals(fieldType, String.class)) {
            field.set(obj, rawValue);
        } else if (Objects.equals(fieldType, Date.class)) {
            if (StringUtils.isEmpty(rawValue)) {
                field.set(obj, null);
            } else {
                field.set(obj, dateFormat.parse(rawValue));
            }
        } else if (Objects.equals(fieldType, BigDecimal.class)) {
            if (StringUtils.isEmpty(rawValue)) {
                field.set(obj, null);
            } else {
                try {
                    field.set(obj, BigDecimal.valueOf(Double.parseDouble(rawValue)));
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid BigDecimal value");
                    field.set(obj, null);
                }
            }
        } else {
            if (!StringUtils.isEmpty(rawValue)) {
                BeanUtils.setProperty(obj, field.getName(), rawValue);
            }
        }
    }

    public static class MappingException extends RuntimeException {
        public MappingException(Exception cause) {
            super(cause);
        }
    }

    private SimpleDateFormat getDateFormat(Field field) {
        DateFormat dateFormatAnnotation = field.getAnnotation(DateFormat.class);
        if (Objects.isNull(dateFormatAnnotation)) {
            return DateFormat.DEFAULT_DATE_FORMAT;
        } else {
            return new SimpleDateFormat(dateFormatAnnotation.value());
        }
    }

    public static <T> List <T> mapDataToModel(Class<T> clazz, File filename, char delimiter) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String extension = FilenameUtils.getExtension(filename.getName());
        List<T> records = new ArrayList<>();
        if(extension.contains("csv")){
            CSVParser parser = CsvUtil.readCSVRecords(filename, delimiter, false);        //noinspection unchecked
            CsvAnnotationMapper<T> mapperCsv = new CsvAnnotationMapper(clazz);
            records = mapperCsv.map(parser);
            parser.close();
        }
        if(extension.contains("txt")){
            List<String> txtRecords = TextUtil.readTextFileRecords(filename.getPath());
            TextUtil<T> mapperTxt = new TextUtil(clazz);
            records = mapperTxt.mapTxtToModel(txtRecords);
        }
        return records;
    }
}
