package com.web.model.pool;

import com.web.exception.ConnectionPoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {
    POOL;
    public static final int POOL_SIZE = 5;
    private final BlockingQueue<Connection> freeConnections;
    private final Queue<Connection> givenConnections;
    private final Logger logger = LogManager.getLogger(); //fixme (non-static logger)

    ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>();
        givenConnections = new ArrayDeque<>();
        try {
            for (int i = 0; i < POOL_SIZE; i++) {
                //todo (proxy connection)
                Connection connection = ConnectionCreator.createConnection();
                freeConnections.add(connection);
            }
        } catch (SQLException e) {
            logger.log(Level.FATAL, e);
            throw new RuntimeException(e);
        }
    }

    public Connection takeConnection() throws ConnectionPoolException {
        Connection connection;
        try {
            connection = freeConnections.take();
            givenConnections.offer(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException(e);
        }
        return connection;
    }

    public void releaseConnection(Connection connection) throws ConnectionPoolException {
        if (givenConnections.remove(connection)) {
            freeConnections.offer(connection);
        } else {
            throw new ConnectionPoolException("Couldn't release connection!");
        }
    }

    public void destroyPool() throws ConnectionPoolException {
        try {
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection connection = freeConnections.take();
                connection.close();
            }
        } catch (InterruptedException | SQLException e) {
            throw new ConnectionPoolException(e);
        } finally {
            deregisterDrivers();
        }
    }

    private void deregisterDrivers() throws ConnectionPoolException {
        try {
            while (DriverManager.getDrivers().hasMoreElements()) {
                Driver driver = DriverManager.getDrivers().nextElement();
                DriverManager.deregisterDriver(driver);
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException(e);
        }
    }
}
