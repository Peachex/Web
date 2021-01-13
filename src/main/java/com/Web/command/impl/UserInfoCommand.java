package com.Web.command.impl;

import com.Web.command.ActionCommand;
import com.Web.command.PagePath;
import com.Web.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserInfoCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        UserServiceImpl service = new UserServiceImpl();
        List<String> names = service.getNames();
        request.setAttribute("users", names);
        String page = PagePath.INFO;
        return page;
    }
}
