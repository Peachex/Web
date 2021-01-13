package com.Web.command.impl;

import com.Web.command.ActionCommand;
import com.Web.command.Message;
import com.Web.command.PagePath;
import com.Web.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;
import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements ActionCommand {
    private static final Logger logger = LogManager.getLogger();
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        UserServiceImpl service = new UserServiceImpl();
        if (service.checkLogin(login, pass)) {
            request.setAttribute("user", login);
            page = PagePath.MAIN;
        } else {
            logger.log(Level.ERROR, Message.LOGIN_ERROR);
            request.setAttribute("errorLoginPassMessage", Message.LOGIN_ERROR);
            page = PagePath.SIGN_IN;
        }
        return page;
    }
}
