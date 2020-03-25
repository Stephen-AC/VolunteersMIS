package edu.gdut.gytw.volunteerMIS.entity;

public class User {
    private int account;
    private String password;
    private String role;

    public User() {
        account = -1;
        password = null;
    }

    public User(int account, String password) {
        this.account = account;
        this.password = password;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
