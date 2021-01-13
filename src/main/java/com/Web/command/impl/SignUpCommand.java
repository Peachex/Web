package com.Web.command.impl;

import com.Web.command.ActionCommand;
import com.Web.command.Message;
import com.Web.command.PagePath;
import com.Web.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_PASSWORD_REPEAT = "rePassword";

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String passwordRepeat = request.getParameter(PARAM_NAME_PASSWORD_REPEAT);
        String page;
        UserServiceImpl service = new UserServiceImpl();
        if (service.register(login, password, passwordRepeat)) {
            request.setAttribute("info", Message.SUCCESSFUL_SIGN_UP);
            page = PagePath.SIGN_UP_INFO;
        } else {
            if (service.isLoginNameAvailable(login)) {
                request.setAttribute("errorLoginName", Message.LOGIN_NAME_ERROR);
            }
            if (!password.equals(passwordRepeat)) {
                request.setAttribute("errorPasswordRepeat", Message.PASSWORD_REPEAT_ERROR);
            }
            page = PagePath.SIGN_UP;
        }
        return page;
    }
}