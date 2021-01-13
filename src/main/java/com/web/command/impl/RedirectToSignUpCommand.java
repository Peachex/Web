package com.web.command.impl;

import com.web.command.ActionCommand;
import com.web.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class RedirectToSignUpCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.SIGN_UP;
        return page;
    }
}
