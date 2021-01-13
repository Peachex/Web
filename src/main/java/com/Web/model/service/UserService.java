package com.Web.model.service;

import java.util.List;

public interface UserService {
    boolean register(String login, String password, String passwordRepeat);

    boolean isLoginNameAvailable(String login);

    boolean checkLogin(String enterLogin, String enterPassword);

    List<String> getNames();
}
