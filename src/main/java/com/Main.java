package com;

import com.Web.model.dao.UserDao;
import com.Web.model.dao.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.containsLogin("admin"));
        System.out.println(userDao.containsLogin("admindad"));
    }
}
