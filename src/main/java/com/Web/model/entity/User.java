package com.Web.model.entity;

public class User {
    private String login;

    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        User anotherUser = (User) o;
        return this.login.equals(anotherUser.login);
    }

    @Override
    public int hashCode() {
        int result = 31 + (this.login != null ? this.login.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.login);
        sb.append("\n");
        return sb.toString();
    }
}
