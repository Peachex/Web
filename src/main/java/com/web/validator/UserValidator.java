package com.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private static final String LOGIN_PATTERN = "^[A-Za-zА-яа-я0-9_]{2,20}$";
    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9_]{4,20}$";

    public static boolean isLoginValid(String login) {
        Pattern pattern = Pattern.compile(LOGIN_PATTERN);
        Matcher matcher = pattern.matcher(login);
        boolean result = matcher.matches();
        return result;
    }

    public static boolean isPasswordValid(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        boolean result = matcher.matches();
        return result;
    }
}
