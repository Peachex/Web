package com.Web.command.impl;

import com.Web.command.ActionCommand;
import com.Web.command.PagePath;
import com.Web.exception.CommandException;
import com.Web.exception.ServiceException;
import com.Web.model.entity.User;
import com.Web.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class UserInfoCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        UserServiceImpl service = new UserServiceImpl();
        List<User> names;
        try {
            names = new ArrayList<>(service.getNames());
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
        request.setAttribute("users", names);
        String page = PagePath.INFO;
        return page;
    }
}
