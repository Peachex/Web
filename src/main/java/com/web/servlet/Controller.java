package com.web.servlet;

import com.web.command.ActionCommand;
import com.web.command.Message;
import com.web.command.PagePath;
import com.web.command.factory.ActionFactory;
import com.web.exception.CommandException;
import com.web.exception.ConnectionPoolException;
import com.web.model.pool.ConnectionPool;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        try {
            page = command.execute(request);
            if (page != null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
                dispatcher.forward(request, response);
            } else {
                logger.log(Level.ERROR, Message.NULL_PAGE);
                page = PagePath.SIGN_IN;
                request.getSession().setAttribute("nullPage", Message.NULL_PAGE);
                response.sendRedirect(request.getContextPath() + page);
            }
        } catch (CommandException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.POOL.destroyPool();
        } catch (ConnectionPoolException e) {
            logger.log(Level.ERROR, e);
        }
    }
}
