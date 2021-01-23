package com.web.command.impl;

import com.web.command.ActionCommand;
import com.web.command.Locale;
import com.web.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class ChangeLanguageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getSession().getAttribute("currentLocale") == null) {
            request.getSession().setAttribute("currentLocale", Locale.DEFAULT_LOCALE);
        }
        if (request.getSession().getAttribute("currentLocale").equals(Locale.RUSSIAN_LOCALE)) {
            request.getSession().setAttribute("currentLocale", Locale.DEFAULT_LOCALE);

        } else {
            request.getSession().setAttribute("currentLocale", Locale.RUSSIAN_LOCALE);
        }
        String page = PagePath.SIGN_IN;
        return page;
    }
}
