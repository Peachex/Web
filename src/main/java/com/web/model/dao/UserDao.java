package com.web.model.dao;

import com.web.exception.DaoException;
import com.web.model.entity.User;

import java.util.List;

public interface UserDao {
    boolean containsLogin(String login) throws DaoException;

    boolean checkPassword(String login, String password) throws DaoException;

    List<User> getAllLogins() throws DaoException;

    void add(User user, String encryptedPassword) throws DaoException;
}
