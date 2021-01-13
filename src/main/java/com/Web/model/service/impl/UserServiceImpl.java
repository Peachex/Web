package com.Web.model.service.impl;

import com.Web.command.Message;
import com.Web.exception.DaoException;
import com.Web.exception.ServiceException;
import com.Web.model.dao.UserDao;
import com.Web.model.dao.impl.UserDaoImpl;
import com.Web.model.entity.User;
import com.Web.model.service.UserService;
import com.Web.util.Encryptor;
import com.Web.validator.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(String login, String password, String passwordRepeat) throws ServiceException {
        boolean result = false;
        try {
            if (UserValidator.isLoginValid(login) && UserValidator.isPasswordValid(password)) {
                if (password.equals(passwordRepeat)) {
                    if (!userDao.containsLogin(login)) {
                        String encryptedPassword = Encryptor.encrypt(password);
                        User user = new User(login);
                        userDao.add(user, encryptedPassword);
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
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean isLoginNameAvailable(String login) throws ServiceException {
        boolean result;
        try {
            result = userDao.containsLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean checkLogin(String enterLogin, String enterPassword) throws ServiceException {
        boolean result = false;
        try {
            if (!isLoginNameAvailable(enterLogin)) {
                result = userDao.checkPassword(enterLogin, enterPassword);
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return result;
    }

    @Override
    public List<User> getNames() throws ServiceException {
        List<User> users;
        try {
            users = new ArrayList<>(userDao.getAllLogins());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return users;
    }
}
