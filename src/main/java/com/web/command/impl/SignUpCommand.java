package com.web.command.impl;

import com.web.command.ActionCommand;
import com.web.command.Message;
import com.web.command.PagePath;
import com.web.exception.CommandException;
import com.web.exception.ServiceException;
import com.web.model.service.impl.UserServiceImpl;
import com.web.util.mail.MailSender;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password2";
    private static final String PARAM_NAME_PASSWORD_REPEAT = "rePassword";
    private static final String MAIL_RECIPIENT = "klevolex@gmail.com";
    private static final String MAIL_SUBJECT = "New user";
    private static final String MAIL_TEXT = " - new user.";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String passwordRepeat = request.getParameter(PARAM_NAME_PASSWORD_REPEAT);
        String page;
        UserServiceImpl service = new UserServiceImpl();
        try {
            if (service.register(login, password, passwordRepeat)) {
                request.setAttribute("info", Message.SUCCESSFUL_SIGN_UP);
                MailSender sender = new MailSender(MAIL_RECIPIENT, MAIL_SUBJECT, login + MAIL_TEXT);
                sender.send();
                page = PagePath.SIGN_UP_INFO;
            } else {
                if (service.isLoginNotAvailable(login)) {
                    request.setAttribute("errorLoginName", Message.LOGIN_NAME_ERROR);
                }
                if (!password.equals(passwordRepeat)) {
                    request.setAttribute("errorPasswordRepeat", Message.PASSWORD_REPEAT_ERROR);
                }
                page = PagePath.SIGN_UP;
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return page;
    }
}