package com.web.model.dao.impl;

import com.web.exception.ConnectionPoolException;
import com.web.exception.DaoException;
import com.web.model.dao.BaseDao;
import com.web.model.dao.UserDao;
import com.web.model.entity.User;
import com.web.model.pool.ConnectionPool;
import com.web.util.Encryptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao, BaseDao {
    private static final ConnectionPool pool = ConnectionPool.POOL;
    private final static String IS_LOGIN_AVAILABLE_QUERY = "SELECT login FROM web.users WHERE login = ?;";
    private final static String CHECK_PASSWORD_QUERY = "SELECT password FROM web.users WHERE login = ?;";
    private final static String SELECT_ALL_LOGINS_QUERY = "SELECT login FROM web.users;";
    private final static String ADD_USER_SQL_QUERY = "INSERT INTO users (login, password) VALUES (?,?);";

    @Override
    public boolean containsLogin(String login) throws DaoException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.takeConnection();
            statement = connection.prepareStatement(IS_LOGIN_AVAILABLE_QUERY);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = true;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return result;
    }

    @Override
    public boolean checkPassword(String login, String password) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.takeConnection();
            statement = connection.prepareStatement(CHECK_PASSWORD_QUERY);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String passwordFromDatabase = resultSet.getString(1);
                return Encryptor.check(password, passwordFromDatabase);
            } else {
                return false;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public List<User> getAllLogins() throws DaoException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = pool.takeConnection();
            statement = connection.createStatement();
            statement.executeQuery(SELECT_ALL_LOGINS_QUERY);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                String login = resultSet.getString(1);
                users.add(new User(login));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return users;
    }

    @Override
    public void add(User user, String encryptedPassword) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.takeConnection();
            statement = connection.prepareStatement(ADD_USER_SQL_QUERY);
            statement.setString(1, user.getLogin());
            statement.setString(2, encryptedPassword);
            if (statement.executeUpdate() != 1) {
                throw new DaoException("Row wasn't inserted");
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
    }
}
