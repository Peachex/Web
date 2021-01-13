package com.Web.model.dao;

import com.Web.model.creator.ConnectionCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private final static String IS_LOGIN_AVAILABLE_STATEMENT = "SELECT login FROM web.users WHERE login = ?;";

    @Override
    public boolean containsLogin(String login) {
        boolean result = false;
        try (Connection connection = ConnectionCreator.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(IS_LOGIN_AVAILABLE_STATEMENT);
            statement.setString(1, login);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                result = true;
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
