package com.utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MultiResultSetStatementIterator {
    private final Statement statement;
    private final Connection connection;

    private boolean isFirstLoop;

    public MultiResultSetStatementIterator(Statement statement, Connection connection) {
        this.statement = statement;
        this.connection = connection;
        isFirstLoop = true;
    }

    @SuppressWarnings("squid:S2589")
    public ResultSet loadNextResultSet() throws SQLException {
        ResultSet resultSet;
        try {
            if (isFirstLoop) {
                isFirstLoop = false;
                resultSet = statement.getResultSet();
                if (resultSet != null) {
                    return resultSet;
                }
            }
            do {
                if (statement.getMoreResults()) {
                    resultSet = statement.getResultSet();
                    return resultSet;
                } else if (statement.getUpdateCount() == -1) {
                    return null;
                }
            } while (true);
        } catch (SQLException e) {
            throw new SQLException("Error when execute hasNext method in StatementIterator", e);
        }
    }
}
