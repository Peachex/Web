package com.web.command.impl;

import com.web.command.ActionCommand;
import com.web.command.PagePath;
import com.web.exception.CommandException;
import com.web.exception.ServiceException;
import com.web.model.entity.User;
import com.web.model.service.impl.UserServiceImpl;

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
