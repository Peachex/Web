package com.Web.model.service.impl;

import com.Web.command.Message;
import com.Web.model.service.UserService;
import com.Web.util.Encryptor;
import com.Web.validator.UserValidator;
import com.Web.warehouse.UserWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();
    private UserWarehouse warehouse = UserWarehouse.getWarehouse();

    @Override
    public boolean register(String login, String password, String passwordRepeat) {
        boolean result = false;
        if (UserValidator.isLoginValid(login) && UserValidator.isPasswordValid(password)) {
            if (password.equals(passwordRepeat)) {
                if (!isLoginNameAvailable(login)) {
                    String encryptedPassword = Encryptor.encrypt(password);
                    warehouse.addUser(login, encryptedPassword);
                    result = true;
                } else {
                    logger.log(Level.ERROR, Message.PASSWORD_REPEAT_ERROR);
                }
            } else {
                logger.log(Level.ERROR, Message.LOGIN_NAME_ERROR);
            }
        } else {
            logger.log(Level.ERROR, Message.LOGIN_ERROR);
        }
        return result;
    }

    @Override
    public boolean isLoginNameAvailable(String login) {
        return warehouse.containsName(login);
    }

    @Override
    public boolean checkLogin(String enterLogin, String enterPassword) {
        boolean result = warehouse.containsName(enterLogin) && warehouse.containsPassword(enterLogin, enterPassword);
        return result;
    }

    @Override
    public List<String> getNames() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < warehouse.size(); i++) {
            result.add(warehouse.getUserName(i));
        }
        return result;
    }
}
