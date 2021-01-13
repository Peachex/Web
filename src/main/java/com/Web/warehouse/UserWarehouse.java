package com.Web.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserWarehouse {
    private static UserWarehouse warehouse = new UserWarehouse();
    private List<String> usersNames;
    private Map<String, String> usersPasswords;

    private UserWarehouse() {
        usersNames = new ArrayList<>();
        usersPasswords = new HashMap<>();
        addUser("admin", "Qwe123");
    }

    public static UserWarehouse getWarehouse() {
        return warehouse;
    }

    public void addUser(String name, String password) {
        usersNames.add(name);
        usersPasswords.put(name, password);
    }

    public String getUserName(int index) {
        return this.usersNames.get(index);
    }

    public int size() {
        return this.usersNames.size();
    }

    public boolean containsName(String name) {
        return this.usersNames.contains(name);
    }

    public boolean containsPassword(String name, String password) {
        return this.usersPasswords.get(name).equals(password);
    }
}
