package com.web.command.impl;

import com.web.command.ActionCommand;
import com.web.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.SIGN_IN;
        request.getSession().invalidate();
        return page;
    }
}
