package com.mapper;

import com.config.Environment;
import com.utilities.DbUtilsCon;
import org.apache.commons.lang3.StringUtils;
import org.testng.log4testng.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ColumnAnnotationMapper<T> {

    private final Class<T> clazz;
    private final List<Field> fields;
    private static final Logger LOGGER = Logger.getLogger(ColumnAnnotationMapper.class);

    public ColumnAnnotationMapper(Class<T> clazz) {
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

    public List<T> map(ResultSet resultSet) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
            T rs = null;
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
                System.out.println("mapping" + mapping.value());
                String mappingValue = mapping.value().isEmpty() ? StringUtils.capitalize(f.getName()) : mapping.value();
                Object rsValue = resultSet.getObject(mappingValue);
                f.setAccessible(true);
                f.set(rs, rsValue);
            }
            result.add(rs);
        }
        return result;
    }

    public List<Field> getColumns(){
        List<Field> myFields = this.fields;
        for(Field field: myFields){
            LOGGER.info("field = " + field.getName());
        }
        return myFields;
    }

    public static <T> List <T> mapDataToModel(Class<T> clazz, String query, String connectionString, Environment environment) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        List<T> listRecords;
        try(Connection connection = DbUtilsCon.createConnection(connectionString, environment);
            ResultSet resultSetFromQuery = DbUtilsCon.getResultSetFromQuery(connection, query)
        ){
            ColumnAnnotationMapper<T> mapperDb = new ColumnAnnotationMapper<>(clazz);
            listRecords = mapperDb.map(resultSetFromQuery);
        }
        return listRecords;
    }

    public List<String> mapDbToDelimiterString(ResultSet resultSet) throws SQLException {
        List<String> result = new ArrayList<>();
        while (resultSet.next()) {
            String temp = "";
            for (Field f : fields) {
                Column mapping = f.getAnnotation(Column.class);
                if (Objects.isNull(mapping)) {
                    continue;
                }
                System.out.println("mapping" + mapping.value());
                String mappingValue = mapping.value().isEmpty() ? StringUtils.capitalize(f.getName()) : mapping.value();
                Object rsValue = resultSet.getObject(mappingValue);
                if(rsValue != null)
                    temp += "\"" + rsValue + "\"" + "|";
                else temp += "\"" + "\"" + "|";
            }
            temp = temp.substring(0, temp.length() - 1);
            result.add(temp);
        }
        return result;
    }


//    public <T> List<String> parseDbToDelimiterString(List<T> lstObject) throws IllegalAccessException {
//        List<Field> myFields = this.fields;
//        List<String> result = new ArrayList<>();
//        for (T object : lstObject) {
//            String temp = "";
//            for(int i = 0; i < myFields.size() - 1; i++){
//                if(myFields.get(i).get(object) != null)
//                temp += "\"" + myFields.get(i).get(object) + "\"" + "|";
//            }
//            temp += "\"" + myFields.get(myFields.size() - 1).get(object) + "\"";
//            result.add(temp);
//        }
//        return result;
//    }

//    public static <T> List <T> mapDataToModel(Class<T> clazz, String query, String connectionString, DatabaseResources databaseResources) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
//
//        Connection connection = DbUtilsCon.createConnection(connectionString);
//        ResultSet resultSetFromQuery = DbUtilsCon.getResultSetFromQuery(connection, query);
//        ColumnAnnotationMapper<T> mapperDb = new ColumnAnnotationMapper<>(clazz);
//
//        // keep track connection to close later
//        databaseResources.getConnections().add(connection);
//        databaseResources.getResultSets().add(resultSetFromQuery);
//        return mapperDb.map(resultSetFromQuery);
//    }
}
