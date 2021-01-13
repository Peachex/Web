package com.Web.model.service;

import com.Web.exception.ServiceException;
import com.Web.model.entity.User;

import java.util.List;

public interface UserService {
    boolean register(String login, String password, String passwordRepeat) throws ServiceException;

    boolean isLoginNameAvailable(String login) throws ServiceException;

    boolean checkLogin(String enterLogin, String enterPassword) throws ServiceException;

    List<User> getNames() throws ServiceException;
}
