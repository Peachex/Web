package com.Web.command.impl;

import com.Web.command.ActionCommand;
import com.Web.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.SIGN_IN;
        request.getSession().invalidate();
        return page;
    }
}
