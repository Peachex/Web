package com.web.command;

import com.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request) throws CommandException;
}
