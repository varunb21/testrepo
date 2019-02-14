package com.mapper;

import org.testng.log4testng.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TextUtil<T> {
    private final Class<T> clazz;
    private final List<Field> fields;
    private static final Logger LOGGER = Logger.getLogger(TextUtil.class);

    public TextUtil(Class<T> clazz) {
        this.clazz = clazz;
        fields = getAllFields(clazz);
    }

    private List<Field> getAllFields(Class clazz) {

        List<Field> myFields = new ArrayList<>();
        Class currentClass = clazz;
        do {
            myFields.addAll(Arrays.asList(currentClass.getDeclaredFields()));
            currentClass = currentClass.getSuperclass();
        } while (currentClass != null);

        return myFields;
    }

    public static List<String> readTextFileRecords(String fileName) {
        List<String> records = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
            String nextRecord;
            while((nextRecord = reader.readLine())!= null){
                records.add(nextRecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public List<T> mapTxtToModel(List<String> lstObject) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        List<T> result = new ArrayList<>();
        for (String object : lstObject) {
            T rs = null;
            String[] objectValue = object.split("\\|");
            int i = 0;
            try {
                rs = clazz.getDeclaredConstructor().newInstance();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            for (Field f : fields) {
                Column mapping = f.getAnnotation(Column.class);
                if (Objects.isNull(mapping)) {
                    continue;
                }
//                System.out.println("mapping " + mapping.value());
                Object rsValue = objectValue[i].substring(1, objectValue[i].length() - 1);
                f.setAccessible(true);
                f.set(rs, rsValue);
                i++;
            }
            result.add(rs);
        }
        return result;
    }

}
