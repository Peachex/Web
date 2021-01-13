package com.Web.model.dao.impl;

import com.Web.exception.DaoException;
import com.Web.model.creator.ConnectionCreator;
import com.Web.model.dao.UserDao;
import com.Web.model.entity.User;
import com.Web.util.Encryptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final static String IS_LOGIN_AVAILABLE_STATEMENT = "SELECT login FROM web.users WHERE login = ?;";
    private final static String CHECK_PASSWORD_STATEMENT = "SELECT password FROM web.users WHERE login = ?;";
    private final static String SELECT_ALL_LOGINS_STATEMENT = "SELECT login FROM web.users;";
    private final static String ADD_USER_STATEMENT = "SELECT login, password FROM web.users;";

    @Override
    public boolean containsLogin(String login) throws DaoException {
        boolean result = false;
        try (Connection connection = ConnectionCreator.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(IS_LOGIN_AVAILABLE_STATEMENT);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = true;
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean checkPassword(String login, String password) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionCreator.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(CHECK_PASSWORD_STATEMENT);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            String passwordFromDatabase = resultSet.getString(1);
            result = Encryptor.check(password, passwordFromDatabase);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return result;
    }

    @Override
    public List<User> getAllLogins() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionCreator.createConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery(SELECT_ALL_LOGINS_STATEMENT);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                String login = resultSet.getString(1);
                users.add(new User(login));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return users;
    }

    @Override
    public void add(User user, String encryptedPassword) throws DaoException {
        try (Connection connection = ConnectionCreator.createConnection()) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(ADD_USER_STATEMENT);
            resultSet.moveToInsertRow();
            resultSet.updateString(1, user.getLogin());
            resultSet.updateString(2, encryptedPassword);
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
