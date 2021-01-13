package com.web.model.service;

import com.web.exception.ServiceException;
import com.web.model.entity.User;

import java.util.List;

public interface UserService {
    boolean register(String login, String password, String passwordRepeat) throws ServiceException;

    boolean isLoginNotAvailable(String login) throws ServiceException;

    boolean checkLogin(String enterLogin, String enterPassword) throws ServiceException;

    List<User> getNames() throws ServiceException;
}
