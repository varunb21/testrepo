package com.utilities;

import com.DWExtractModels.client.ClientGeneralModel;
import com.config.Environment;
import com.mapper.ColumnAnnotationMapper;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtilsCon {
    private static final Logger LOGGER = Logger.getLogger(DbUtilsCon.class);
    private static boolean isExisted;
    private static Connection conn;
    private static ResultSet resultSet;

    public static Connection createConnection(String url, Environment environment) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String username = environment.getDwh_oracle_user();
        String pass = environment.getDwh_oracle_pass();
        Connection con = DriverManager.getConnection(url, username,pass);
        return con;
    }

    @SuppressWarnings({"squid:S2095", "squid:S2259"})
    public static ResultSet getResultSetFromQuery(Connection conn, String query) {
        Statement statement;
        resultSet = null;
        try {
            statement = conn.createStatement();
            LOGGER.info(query);
            statement.execute(query);
            MultiResultSetStatementIterator multiResultSetStatementIterator = new MultiResultSetStatementIterator(statement, conn);
            resultSet = multiResultSetStatementIterator.loadNextResultSet();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return resultSet;
    }

    public static <T> List<T> getListForASpecificName(String fName, String lName, List<T> lstObject) {
        List<T> objects = new ArrayList<>();
        for (T object : lstObject) {
            if (object.toString().contains(fName) && object.toString().contains(lName)) {
                objects.add(object);
            }
        }
        return objects;
    }

    public static <T> List<T> getListForASpecificClientPhone( String clientPhone, List<T> lstObject) {
        List<T> objects = new ArrayList<>();
        for (T object : lstObject) {
            if (object.toString().contains(clientPhone)) {
                objects.add(object);
            }
        }
        return objects;
    }

    public static <T> List<T> getListForASpecificClientProg(String payerId, String providerId,
                                                            String clientId, String payerProgram,
                                                            List<T> lstObject) {
        List<T> objects = new ArrayList<>();
        for (T object : lstObject) {
            if (object.toString().contains(payerId) && object.toString().contains(providerId)
            && object.toString().contains(clientId) && object.toString().contains(payerProgram)) {
                objects.add(object);
            }
        }
        return objects;
    }

    public static <T> List<T> getListForASpecificClientAddr( String address1, List<T> lstObject) {
        List<T> objects = new ArrayList<>();
        for (T object : lstObject) {
            if (object.toString().contains(address1)) {
                objects.add(object);
            }
        }
        return objects;
    }

    public static <T> List<T> getListForASpecificUniqueKey( String keyValue, List<T> lstObject) {
        List<T> objects = new ArrayList<>();
        for (T object : lstObject) {
            if (object.toString().contains(keyValue)) {
                objects.add(object);
            }
        }
        return objects;
    }
}
