package com.web.model.dao;

import com.web.exception.ConnectionPoolException;
import com.web.model.pool.ConnectionPool;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface CloseableDao {
    Logger logger = LogManager.getLogger();

    default void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.log(Level.ERROR, e);
            }
        }
    }

    default void close(Connection connection) {
        if (connection != null) {
            try {
                ConnectionPool.POOL.releaseConnection(connection);
            } catch (ConnectionPoolException e) {
                logger.log(Level.ERROR, e);
            }
        }
    }
}
