package com.Web.command;

import com.Web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request) throws CommandException;
}
