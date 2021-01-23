package com.web.model.dao.impl;

import com.web.exception.DaoException;
import com.web.model.creator.ConnectionCreator;
import com.web.model.dao.UserDao;
import com.web.model.entity.User;
import com.web.util.Encryptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final static String IS_LOGIN_AVAILABLE_QUERY = "SELECT login FROM web.users WHERE login = ?;";
    private final static String CHECK_PASSWORD_QUERY = "SELECT password FROM web.users WHERE login = ?;";
    private final static String SELECT_ALL_LOGINS_QUERY = "SELECT login FROM web.users;";
    private final static String ADD_USER_SQL_QUERY = "INSERT INTO users (login, password) VALUES (?,?);";

    @Override
    public boolean containsLogin(String login) throws DaoException {
        boolean result = false;
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement statement = connection.prepareStatement(IS_LOGIN_AVAILABLE_QUERY)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = true;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public boolean checkPassword(String login, String password) throws DaoException {
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement statement = connection.prepareStatement(CHECK_PASSWORD_QUERY)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String passwordFromDatabase = resultSet.getString(1);
                return Encryptor.check(password, passwordFromDatabase);
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> getAllLogins() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionCreator.createConnection();
             Statement statement = connection.createStatement()) {
            statement.executeQuery(SELECT_ALL_LOGINS_QUERY);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                String login = resultSet.getString(1);
                users.add(new User(login));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return users;
    }

    @Override
    public void add(User user, String encryptedPassword) throws DaoException {
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_USER_SQL_QUERY)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, encryptedPassword);
            if (statement.executeUpdate() != 1) {
                throw new DaoException("Row wasn't inserted");
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
