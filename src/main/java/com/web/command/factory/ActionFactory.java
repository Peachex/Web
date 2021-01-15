package com.web.command.factory;

import com.web.command.ActionCommand;
import com.web.command.Message;
import com.web.command.client.CommandEnum;
import com.web.command.impl.DefaultCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    private static final Logger logger = LogManager.getLogger();

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new DefaultCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            logger.log(Level.ERROR, action + Message.WRONG_ACTION);
            request.setAttribute("wrongAction", action + Message.WRONG_ACTION);
        }
        return current;
    }
}
